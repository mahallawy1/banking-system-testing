package test_cases;

import java.util.ArrayList;

public class User {

	String username;
	String password;
	String name;
	String Address;
	String phone_number;
	int age;
	
	// may add feature that there's a maximum of three accounts for each user
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	ArrayList<Item> items = new ArrayList<Item>();
	
	ArrayList<Bill> bills = new ArrayList<Bill>();
	
	ArrayList<Item> bought_items = new ArrayList<Item>();
	
	public User(String username, String password, String name, String Address, String phone_number, int age) 
	{
		this.username = username;
		this.password = password;
		this.name = name;
		this.Address = Address;
		this.phone_number = phone_number;
		this.age = age;
	}
	
	public User(String username, String password, String name, String Address, String phone_number, int age, int security_number, float balance, AccountType type ) 
	{
		this.username = username;
		this.password = password;
		this.name = name;
		this.Address = Address;
		this.phone_number = phone_number;
		this.age = age;
		accounts.add(new Account(name, security_number, balance, type));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void add_account(Account a) 
	{
		this.accounts.add(a);
	}
	
	public void change_phone_number(String new_number) 
	{
		this.phone_number = new_number;
	}
	
	public void change_Address(String new_Address) 
	{
		this.Address = new_Address;
	}
	
	public boolean withdraw_from_Account(float amount, int security_number) 
	{
		Account acc = null;
		for(Account a: this.accounts) 
		{
			if (a.getSecurity_number() == security_number) {
				acc = a;
			}
		}
		if (acc == null) 
		{
			System.out.println("cannot identify account");
			return false;
		}else 
		{
			return acc.withdraw(amount);
		}
		
	}
	
	public boolean deposit_into_Account(float amount, int security_number) 
	{
		Account acc = null;
		for(Account a: this.accounts) 
		{
			if (a.getSecurity_number() == security_number) {
				acc = a;
			}
		}
		if (acc == null) 
		{
			System.out.println("cannot identify account");
			return false;
		}else 
		{
			return acc.deposit(amount);
		}
		
	}
	
	public boolean buy_item(Item i, int security_number) 
	{
		Account acc = null;
		for(Account a: this.accounts) 
		{
			if (a.getSecurity_number() == security_number) {
				acc = a;
			}
		}
		if (acc != null) 
		{
			if(acc.checkBalance() >= i.price) 
			{
				this.bought_items.add(i);
				acc.withdraw(i.price);
				return true;
			}else 
			{
				return false;
			}
		}else 
		{
			System.out.println("account does not exist");
			return false;
		}
		
		
	}
	
	public int getNumOfItems() 
	{
		return items.size();
	}
	
	public boolean pay_bill(int security_number)
	{
		Account acc = null;
		for(Account a: this.accounts) 
		{
			if (a.getSecurity_number() == security_number) {
				acc = a;
			}
		}
		
		if (acc != null) 
		{
			float total = 0;
			for(Item item: this.items) 
			{
				total+=item.price;
			}
			if (acc.checkBalance() >= total) 
			{
				acc.withdraw(total);
				for(Item item: this.items) 
				{
					this.bought_items.add(item);
				}
				this.bills.add(new Bill(total, acc, this));
				items.clear();
				return true;
			}else 
			{
				System.out.println("balance not enough");
				return false;
			}
			
		}else 
		{
			System.out.println("account does not exist");
			return false;
		}
		
	}
}
