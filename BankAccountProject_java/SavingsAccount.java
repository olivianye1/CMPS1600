//Olivia Nye -- CMPS 1600 Lab 1/2? Bank Account
public class SavingsAccount extends BankAccount {
	

	
	protected double interestRate;
	
	public SavingsAccount(String n, double b, double i) {
		super(n, b);
		interestRate = i / 100.0;
	}
		
	
	public void addInterest(){
						//calculate interest				//add it to balance
		this.balance = (super.getBalance() * interestRate) + super.getBalance();
	
	}
	
}


