package ATM;

public class account_info {
	private int customerNumber ;
	private  int currentBalance = 0;
	private String customerName;
	private int pinNumber;
	
	public account_info() {
	}	
	
public account_info( String custName , int cn, int  pn, int curB) {
		customerName=custName;
		customerNumber=cn;
		pinNumber=pn;
		currentBalance=curB;
	}

public int getpinNumber() {

	return pinNumber;
}
public int getcurrentBalance() {

	return currentBalance;
}
public int  getcustomerNumber() {

	return customerNumber;
}
public String getcustomerName() {
//	Taba
	return customerName;
} 
public double calcBalanceWithdraw(int amount) {
	currentBalance = (currentBalance - amount);
	return currentBalance;
}

public double calcBalanceDeposit(int amount) {
	currentBalance = (currentBalance + amount);
	return currentBalance;
}

}
