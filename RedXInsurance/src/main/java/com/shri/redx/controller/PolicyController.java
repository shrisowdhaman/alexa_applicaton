package com.shri.redx.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shri.redx.model.Policy;
import com.shri.redx.repo.PolicyRepository;

@RestController
public class PolicyController {

	private PolicyRepository repository;
	
	
	public PolicyController(PolicyRepository repository) {
		this.repository = repository;
	}
	
	//To test get All policy Details
	@GetMapping("/api")
	public Collection<Policy> getPolicy() {
		
		return repository.findAll();
	  
	}
	//To Check the policy availability against user input
	@GetMapping("/validatePolicy/{policyNumber}")
	public boolean validatePolicy(@PathVariable String policyNumber) throws ParseException {
	
		boolean status = false;
		Policy policy = repository.findByPolicynumber(policyNumber);
		
		//check the policy Details  
		if(policy != null) {
			status = true;
		}
		return status;
	}
	
	//Check the policy Expeiry Date
	@GetMapping("/getPolicyExpDate/{policyNumber}/{dob}")
	public Date getPolicyExpDate(@PathVariable String policyNumber,@PathVariable String dob) {
		
		Date policyExpDt = null;
		LocalDate localDate = LocalDate.parse(dob);
		Date dateObj = java.sql.Date.valueOf(localDate);
		
		Policy policy = repository.findPolicyexpdtByPolicynumberAndDob(policyNumber,dateObj);
				
		if(policy != null) {
			policyExpDt = policy.getPolicyexpdt();
		}
		return policyExpDt;
	}
	
}
