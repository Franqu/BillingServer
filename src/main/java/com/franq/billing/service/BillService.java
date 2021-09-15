package com.franq.billing.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.franq.billing.dao.IBillDao;
import com.franq.billing.model.Bill;


@Service
public class BillService {
	
	private final IBillDao billDao;
	
	@Autowired
	public BillService(@Qualifier("postgre") IBillDao billDao) {
		this.billDao = billDao;
	}
	
	public int addBill(Bill bill) {
		return billDao.insertBill(bill);
	}
	
	public int addRandomBill() {
		return billDao.insertRandomBill();
	}
	
	public List<Bill> getAllBills(){
		return billDao.selectAllBills();
	}
	
	public List<Bill> getAllBillsSortById(){
		return billDao.selectAllBillsSortById();
	}
	
	public List<Bill> getAllBillsSortByCallTime(){
		return billDao.selectAllBillsSortByCallTime();
	}
	public List<Bill> getAllBillsSortByPhoneNumberCaller(){
		return billDao.selectAllBillsSortByPhoneNumberCaller();
	}
	
	public List<Bill> getAllBillsSortByPhoneNumberReceiver(){
		return billDao.selectAllBillsSortByPhoneNumberReceiver();
	}
	
	public Optional<Bill> getBillById(UUID id){
		return billDao.selectBillById(id);
	}
	
	public int deleteBill(UUID id) {
		return billDao.deleteBillById(id);
		
	}
	
	public int deleteAllBill() {
		return billDao.deleteAllBill();
		
	}
	
	public int updateBill(UUID id, Bill bill) {
		return billDao.updateBillById(id, bill);
	}
	

}
