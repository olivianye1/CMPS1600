/Olivia Nye -- CMPS 1600 Lab 1/2? Bank Account

public class BankAccountTest {

	public static void main(String[] args) {
		
		SavingsAccount Liv1 = new SavingsAccount("Liv's Saving Account", 0.0, 1.0);
		
		CheckingAccount Liv2 = new CheckingAccount("Liv's Checking Account", 500.0);
		
		
		Liv1.deposit(1000);
		
		Liv2.withdraw(100);
		
		Liv2.withdraw(5);
		
		Liv1.transfer(Liv2, 200);
		
		
		// missing transfer $200 from savings to checking
		
		System.out.println(Liv1.toString());
		System.out.println(Liv2.toString());
		
		
		
		
		Liv1.addInterest();
		
		Liv2.deductFees();
		
		System.out.println(Liv1.toString());
		System.out.println(Liv2.toString());
		
		
	}

}


