package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showCustomer(){
		Customer cust=new Customer(1001, "Raja", "Hyd", 89989.0,
				                   new String[] {"red","green","blue"}, List.of("10th", "10+2", "Btech"),
				                   Set.of(999999999L, 888888888L, 77777777777L),
				                   Map.of("aadhar", 758564783,"PAN", "KRIPK8705H"), 
				                   new Company("SAMSUNG", "Hyd","Electronic", 4000));
		//Customer cust=new Customer(1001, "Raja", "Hyd", 89989.0);
		//Returning REsponseEntity Object
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
}
