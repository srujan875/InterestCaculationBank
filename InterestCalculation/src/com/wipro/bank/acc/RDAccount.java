package com.wipro.bank.acc;

public class RDAccount extends Account {

	
	
	
	
	public RDAccount(int tenure,float principal)
	{
		this.principal=principal;
		this.tenure=tenure;
	}

	@Override
	public float calculateInterest() {
		float r=rateOfInterest/100;
		float n=4;
		
		int t=tenure*12;
		float total=0.0f;
            
		for(int i=0;i<t;i++)
		{
			total+=principal*(float)(Math.pow(1+(r/n),n*((t-i)/12.0))-1);
		}
		return total;
	}

	@Override
	public float calculateAmountDeposited() {
		return principal*tenure*12;
	}

}
