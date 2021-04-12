package com.cognizant.loans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loans.model.Loan;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@GetMapping("/{number}")
	public Loan getLoanDetails(@PathVariable String number) {
		
		Loan loan = new Loan();
		loan.setNumber("WB00787977972342");
		loan.setType("bike");
		loan.setLoan(20000);
		loan.setEmi(2256);
		loan.setTenure(18);
		return loan;
	}
}
