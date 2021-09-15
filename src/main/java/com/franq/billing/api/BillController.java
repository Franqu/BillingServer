package com.franq.billing.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franq.billing.model.Bill;
import com.franq.billing.service.BillService;

@RequestMapping("/api/v1/billing")
@RestController
public class BillController {

	private final BillService billService;

	@Autowired
	public BillController(BillService billService) {
		this.billService = billService;
	}

	@PostMapping
	public void addBill(@NonNull @RequestBody Bill bill) {
		billService.addBill(bill);
	}
	
	@PostMapping("/random")
	public void addBillRandom() {
		billService.addRandomBill();
	}
	
	@GetMapping
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
	@GetMapping("/sort/id")
	public List<Bill> getAllBillsSortedById(){
		return billService.getAllBillsSortById();
	}
	
	@GetMapping("/sort/callTime")
	public List<Bill> getAllBillsSortedByCallTime(){
		return billService.getAllBillsSortByCallTime();
	}
	
	@GetMapping("/sort/phoneNumberCaller")
	public List<Bill> getAllBillsSortedByPhoneNumberCaller(){
		return billService.getAllBillsSortByPhoneNumberCaller();
	}
	
	@GetMapping("/sort/phoneNumberReceiver")
	public List<Bill> getAllBillsSortedByPhoneNumberReceiver(){
		return billService.getAllBillsSortByPhoneNumberReceiver();
	}
	
	
	@GetMapping(path = "/{id}")
	public Bill getBillById(@PathVariable("id") UUID id) {
		return billService.getBillById(id)
				.orElse(null);
	}
	@DeleteMapping(path = "/{id}")
	public void deleteBillById(@PathVariable("id") UUID id) {
		billService.deleteBill(id);
	}
	
	@DeleteMapping("/delete/all")
	public void deleteAllBill(){
		billService.deleteAllBill();
	}
	
	@PutMapping(path = "/{id}")
	public void updateBillById(@PathVariable("id") UUID id, @NonNull @RequestBody Bill billToUpdate) {
		billService.updateBill(id, billToUpdate);
	}

}
