package Avant;

import java.util.HashMap;
import java.util.Scanner;

class Account{
	int accountNumber;
	double APR;
	double creditLimit;
	int curtday;
	double curtAmount;
	double curtMonthInterest;
	double prevMonthInterest;
	public Account(int accountNumber, double APR, double creditLimit, int curtday, double curtAmount, double curtMonthInterest, double prevMonthInterest) {
		this.accountNumber = accountNumber;
		this.APR = APR;
		this.creditLimit = creditLimit;
		this.curtday = curtday;
		this.curtAmount = curtAmount;
		this.curtMonthInterest = curtMonthInterest;
		this.prevMonthInterest = prevMonthInterest;
	}
}
public class CreditCard {
	HashMap<Integer, Account> hash = new HashMap<>();
	
	public void creatAccount() {
		System.out.println("Please type in your account number. (Please type in an integer. eg: 1234)");
		Scanner accountNumberScanner = new Scanner(System.in);
		int accountNumber = accountNumberScanner.nextInt();
		
		System.out.println("Please type in your APR. (Please type in a number. eg: 35.2)");
		Scanner APRScanner = new Scanner(System.in);
		double APR = APRScanner.nextDouble();
		
		System.out.println("Please type in your credit limit. (Please type in a number. eg: 1000.15)");
		Scanner creditLimitScanner = new Scanner(System.in);
		double creditLimit = creditLimitScanner.nextDouble();
		
		Account curtAccount = new Account(accountNumber, APR, creditLimit, 0, 0, 0, 0);
		hash.put(accountNumber, curtAccount);
	}
	
	
	public void charge() {
		System.out.println("Please type in the account number which you want to make a charge. (eg: 1234)");
		Scanner accountNumberScanner = new Scanner(System.in);
		int accountNumber = accountNumberScanner.nextInt();
		
		System.out.println("How much money you want to charge? (eg: 100)");
		Scanner amountScanner = new Scanner(System.in);
		double amount = amountScanner.nextDouble();
		
		System.out.println("How many days after the opening of the account? (eg: 10)");
		Scanner dayScanner = new Scanner(System.in);
		int day = dayScanner.nextInt();
		
		Account curtAccount = hash.get(accountNumber);
		
		double curtAmount = curtAccount.curtAmount + amount;
		double curtMonthInterest = curtAccount.curtMonthInterest;
		double prevMonthInterest = curtAccount.prevMonthInterest;
		
		if((curtAccount.curtday) / 30 == (day / 30)) {
			curtMonthInterest = (day - curtAccount.curtday) * curtAccount.curtAmount * (curtAccount.APR / 100 / 365) + curtAccount.curtMonthInterest;
			
		}else {
			curtMonthInterest = (double)(day - day / 30 * 30) * curtAccount.curtAmount * (curtAccount.APR / 100 / 365);
			prevMonthInterest = (double)(day / 30 * 30 - curtAccount.curtday)* curtAccount.curtAmount * (curtAccount.APR / 100 / 365) + curtAccount.curtMonthInterest + curtAccount.prevMonthInterest;
		}
		Account accountAfterCharge = new Account(curtAccount.accountNumber, curtAccount.APR, curtAccount.creditLimit, day, curtAmount, curtMonthInterest, prevMonthInterest);
		hash.put(accountNumber, accountAfterCharge);
		
	}
	public void payment() {
		System.out.println("Please type in the account number which you want to make a payment. (eg: 1234)");
		Scanner accountNumberScanner = new Scanner(System.in);
		int accountNumber = accountNumberScanner.nextInt();
		
		System.out.println("How much money you want to pay? (eg: 100)");
		Scanner amountScanner = new Scanner(System.in);
		double amount = amountScanner.nextDouble();
		
		System.out.println("How many days after the opening of the account? (eg: 10)");
		Scanner dayScanner = new Scanner(System.in);
		int day = dayScanner.nextInt();
		
		Account curtAccount = hash.get(accountNumber);
		
		double curtAmount = curtAccount.curtAmount - amount;
		double curtMonthInterest = curtAccount.curtMonthInterest;
		double prevMonthInterest = curtAccount.prevMonthInterest;
		
		if((curtAccount.curtday) / 30 == (day / 30)) {
			curtMonthInterest = (day - curtAccount.curtday) * curtAccount.curtAmount * (curtAccount.APR / 100 / 365) + curtAccount.curtMonthInterest;
			
		}else {
			curtMonthInterest = (double)(day - day / 30 * 30) * curtAccount.curtAmount * (curtAccount.APR / 100 / 365);
			prevMonthInterest = (double)(day / 30 * 30 - curtAccount.curtday)* curtAccount.curtAmount * (curtAccount.APR / 100 / 365) + curtAccount.curtMonthInterest + curtAccount.prevMonthInterest;
		}
		Account accountAfterPayment = new Account(curtAccount.accountNumber, curtAccount.APR, curtAccount.creditLimit, day, curtAmount, curtMonthInterest, prevMonthInterest);
		hash.put(accountNumber, accountAfterPayment);
		
	}
	public void balance() {
		System.out.println("Please type in the account number which you want to make a payment. (eg: 1234)");
		Scanner accountNumberScanner = new Scanner(System.in);
		int accountNumber = accountNumberScanner.nextInt();
		
		System.out.println("How many days after the opening of the account? (eg: 10)");
		Scanner dayScanner = new Scanner(System.in);
		int day = dayScanner.nextInt();
		
		Account curtAccount = hash.get(accountNumber);
		
		double totalOutstandingBalance = 0;
		if((curtAccount.curtday) / 30 == (day / 30)) {
			totalOutstandingBalance = curtAccount.curtAmount + curtAccount.prevMonthInterest;
			
		}else {
			totalOutstandingBalance = curtAccount.curtAmount + (double)(day / 30 * 30 - curtAccount.curtday)* curtAccount.curtAmount * (curtAccount.APR / 100 / 365) + curtAccount.curtMonthInterest +curtAccount.prevMonthInterest;
		}
		totalOutstandingBalance = roundoff(totalOutstandingBalance);
		System.err.println("The total outstanding balance is " + totalOutstandingBalance);
	}

	public int numOfAccount() {
		return hash.size();
	}
	
	public double roundoff(double val) {
		double roundoff = (double)Math.round(val * 100) / 100;
		return roundoff;
	}

}
