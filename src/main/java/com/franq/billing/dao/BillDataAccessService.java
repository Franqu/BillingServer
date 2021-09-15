package com.franq.billing.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.franq.billing.model.Bill;
import com.franq.billing.model.EConnectionType;

@Repository("postgre")
public class BillDataAccessService implements IBillDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public BillDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertBill(UUID id, Bill bill) {
		Date date = new Date(System.currentTimeMillis());
		final String sql = "Insert INTO Bill Values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, id, bill.getPhoneNumberCaller(), bill.getPhoneNumberReceiver(), bill.isOngoing(),
				bill.getLenght(), bill.getSize(), date, bill.getConnetionType().getValue());
		return 1;
	}

	@Override
	public int insertRandomBill(UUID id) {
		Random rnd = new Random();
		String randomPhoneNumeberReceiver = String.format("%09d", rnd.nextInt(1000000000));
		String randomPhoneNumeberCaller = String.format("%09d", rnd.nextInt(1000000000));
		boolean randomOngoing = rnd.nextBoolean();
		long randomLenght = rnd.nextLong();
		long randomSize = rnd.nextLong();
		if (randomLenght < 0)
			randomLenght = randomLenght * -1;
		if (randomSize < 0)
			randomSize = randomSize * -1;

		Date randomDate = new Date(rnd.nextInt() * 1000L);
		int randomConnectionTypeValue = rnd.nextInt() % 2;
		if (randomConnectionTypeValue < 0)
			randomConnectionTypeValue = randomConnectionTypeValue * -1;
		final String sql = "Insert INTO Bill Values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, id, randomPhoneNumeberCaller, randomPhoneNumeberReceiver, randomOngoing, randomLenght,
				randomSize, randomDate, randomConnectionTypeValue);
		return 1;
	}

	@Override
	public List<Bill> selectAllBills() {
		final String sql = "Select * FROM Bill";
		List<Bill> bills = jdbcTemplate.query(sql, (resultSet, i) -> {
			return new Bill(UUID.fromString(resultSet.getString("id")), resultSet.getString("phoneNumberCaller"),
					resultSet.getString("phoneNumberReceiver"), resultSet.getBoolean("ongoing"),
					resultSet.getLong("size"), resultSet.getLong("lenght"), resultSet.getDate("callTime"),
					EConnectionType.createEnum(resultSet.getInt("connectionType")));
		});
		return bills;
	}

	@Override
	public Optional<Bill> selectBillById(UUID id) {
		return null;
		// return DB.stream().filter(bill -> bill.getId().equals(id)).findFirst();
	}

	@Override
	public int deleteBillById(UUID id) {
		final String sql = "DELETE FROM Bill where id = ?";
		jdbcTemplate.update(sql, id);
		return 1;
	}

	@Override
	public int deleteAllBill() {
		final String sql = "DELETE FROM Bill";
		jdbcTemplate.update(sql);
		return 1;
	}

	@Override
	public int updateBillById(UUID id, Bill bill) {
		Date date = new Date(System.currentTimeMillis());
		final String sql = "UPDATE Bill" + " set phoneNumberCaller = ?" + " set phoneNumberReceiver = ?"
				+ " set ongoing = ?" + " set lenght = ?" + " set size = ?" + " set callTime = ?"
				+ " set connectionType = ?" + " where id = ?";
		jdbcTemplate.update(sql, bill.getPhoneNumberCaller(), bill.getPhoneNumberReceiver(), bill.isOngoing(),
				bill.getLenght(), bill.getSize(), date, bill.getConnetionType().getValue(), id);
		return 1;
	}

	@Override
	public List<Bill> selectAllBillsSortById() {
		final String sql = "Select * FROM Bill Order By id";
		List<Bill> bills = jdbcTemplate.query(sql, (resultSet, i) -> {
			return new Bill(UUID.fromString(resultSet.getString("id")), resultSet.getString("phoneNumberCaller"),
					resultSet.getString("phoneNumberReceiver"), resultSet.getBoolean("ongoing"),
					resultSet.getLong("size"), resultSet.getLong("lenght"), resultSet.getDate("callTime"),
					EConnectionType.createEnum(resultSet.getInt("connectionType")));
		});
		return bills;
	}

	@Override
	public List<Bill> selectAllBillsSortByPhoneNumberReceiver() {
		final String sql = "Select * FROM Bill Order By id";
		List<Bill> bills = jdbcTemplate.query(sql, (resultSet, i) -> {
			return new Bill(UUID.fromString(resultSet.getString("id")), resultSet.getString("phoneNumberCaller"),
					resultSet.getString("phoneNumberReceiver"), resultSet.getBoolean("ongoing"),
					resultSet.getLong("size"), resultSet.getLong("lenght"), resultSet.getDate("callTime"),
					EConnectionType.createEnum(resultSet.getInt("connectionType")));
		});
		return bills;
	}

	@Override
	public List<Bill> selectAllBillsSortByPhoneNumberCaller() {
		final String sql = "Select * FROM Bill Order By phoneNumberCaller";
		List<Bill> bills = jdbcTemplate.query(sql, (resultSet, i) -> {
			return new Bill(UUID.fromString(resultSet.getString("id")), resultSet.getString("phoneNumberCaller"),
					resultSet.getString("phoneNumberReceiver"), resultSet.getBoolean("ongoing"),
					resultSet.getLong("size"), resultSet.getLong("lenght"), resultSet.getDate("callTime"),
					EConnectionType.createEnum(resultSet.getInt("connectionType")));
		});
		return bills;
	}

	@Override
	public List<Bill> selectAllBillsSortByCallTime() {
		final String sql = "Select * FROM Bill Order By callTime";
		List<Bill> bills = jdbcTemplate.query(sql, (resultSet, i) -> {
			return new Bill(UUID.fromString(resultSet.getString("id")), resultSet.getString("phoneNumberCaller"),
					resultSet.getString("phoneNumberReceiver"), resultSet.getBoolean("ongoing"),
					resultSet.getLong("size"), resultSet.getLong("lenght"), resultSet.getDate("callTime"),
					EConnectionType.createEnum(resultSet.getInt("connectionType")));
		});
		return bills;
	}

}
