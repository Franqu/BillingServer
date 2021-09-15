package com.franq.billing.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.franq.billing.model.Bill;

public interface IBillDao {

	int insertBill(UUID id, Bill bill);
	
	int insertRandomBill(UUID id);
	
	default int insertBill(Bill bill) {
		UUID id = UUID.randomUUID();
		return insertBill(id, bill);
	}
	
	default int insertRandomBill() {
		UUID id = UUID.randomUUID();
		return insertRandomBill(id);
	}
	
	Optional<Bill> selectBillById(UUID id);
	
	List<Bill> selectAllBills();
	List<Bill> selectAllBillsSortById();
	List<Bill> selectAllBillsSortByPhoneNumberReceiver();
	List<Bill> selectAllBillsSortByPhoneNumberCaller();	
	List<Bill> selectAllBillsSortByCallTime();
	int deleteBillById(UUID id);
	int deleteAllBill();	
	int updateBillById(UUID id, Bill bill);
}
