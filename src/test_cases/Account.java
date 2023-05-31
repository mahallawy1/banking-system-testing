package test_cases;

public class Account {

	String name;
	float balance;
	int security_number; 
	AccountType type;
	
	Account(String name, int security_number, float balance, AccountType type)
	{
		this.name = name;
		this.security_number = security_number;
		this.balance = balance;
		this.type = type;
	}

	public boolean deposit(float amount) 
	{
		if( amount >0)
		{
			
		        this.balance += amount;
		        return true;
	    } 
	    else {
	        System.out.println("invalid amount ");
	        return false;
	    }
	}
	
	public boolean withdraw(float amount) 
	{
		if (this.balance >= amount) 
		{
			this.balance -= amount;
			return true;
		}else 
		{
			System.out.println("not enough balance to do the transaction");
			return false;
		}
	}
	
	public float checkBalance() 
	{
		return this.balance;
	}
	
	public boolean moneyTransfer(Account a, float amount) 
	{
		if(this.balance >= amount) 
		{
			a.balance += amount;
			balance-=amount;
			return true;
		}else 
		{
			System.out.println("not enough balance to do the transaction");
			return false;
		}
		
	}
	
	public AccountType getAccountType() 
	{
		return this.type;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getSecurity_number() {
		return security_number;
	}

	public void setSecurity_number(int security_number) {
		this.security_number = security_number;
	}
	
}
