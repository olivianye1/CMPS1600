
//Olivia Nye -- CMPS 1600 Lab 1/2? Bank Account

public class BankAccount {
	
	protected String name;
	protected double balance;
	

	BankAccount(String n, double b) {
		this.name = n;
		this.balance = b;
	}
	

	public String getName() {
		return this.name;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}
	public void withdraw(double amount) {
		this.balance = this.balance - amount;
	}

	
	//fix this
	public void transfer(BankAccount other, double amount) {
		this.balance = this.balance - amount;
		other.balance = other.balance + amount;
		
	}
	
	
	public String toString() {
		return "The name on the account is: " + getName() + " .\n" + "The balance of this account is: $" + getBalance();
	}
	



