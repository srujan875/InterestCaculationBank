package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {

	public boolean validateData(float principal,int tenure,int age,String gender) throws BankValidationException
	{
	if(principal<500)
		throw new BankValidationException();
	if(tenure!=5 && tenure !=10)
		throw new BankValidationException();
	if(!(gender.equalsIgnoreCase("Male")|| gender.equalsIgnoreCase("Female")))
		throw  new BankValidationException();
	if(!(age>=1 && age<=100))
		throw new BankValidationException();
	else
		return true;
	
   }
	
	public void calculate(float principal,int tenure,int age,String gender) throws BankValidationException
	{
		if(validateData(principal, tenure, age, gender))
		{
			RDAccount rd=new RDAccount(tenure,principal);
			rd.setInterest(age, gender);
			System.out.println(rd.calculateInterest());
			System.out.println(rd.calculateAmountDeposited());
			System.out.println(rd.calculateMaturityAmount(rd.calculateAmountDeposited(),rd.calculateInterest()));
			
		}
		else
		{
			throw new BankValidationException();
		}
	}
}
