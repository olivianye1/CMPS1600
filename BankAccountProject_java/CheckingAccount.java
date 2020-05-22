//Olivia Nye -- CMPS 1600 Lab 1/2? Bank Account

public class CheckingAccount extends BankAccount {
	protected int transactionCount;
	//private static int nextTransactionCount = 0;
	static final double TRANSACTION_FEE = 3.0;
	
	public CheckingAccount(String n, double b) {
		super(n, b);
	}
	
	public void deposit(double amount) {
		//call super deposit function
		super.deposit(amount);
		//add 1 to transaction count
		transactionCount= transactionCount + 1;
	}
		
	public void withdraw(double amount) {
		//call super withdraw function
		super.withdraw(amount);
		//add 1 to transaction count
		transactionCount= transactionCount + 1;
	}
	
	public void deductFees() {
										//total fees deducted is the constant fee times number of transactions
		this.balance = this.balance - (TRANSACTION_FEE * transactionCount);
		//clear counter
		transactionCount = 0;
	}
}


