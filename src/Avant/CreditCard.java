package Avant;

import java.util.HashMap;
import java.util.Scanner;

class Account{
	int accountNumber;
	double APR;
	double creditLimit;
	int curtday;
	double curtAmount;
	double curtInterest;
	public Account(int accountNumber, double APR, double creditLimit, int curtday, double curtAmount, double curtInterest) {
		this.accountNumber = accountNumber;
		this.APR = APR;
		this.creditLimit = creditLimit;
		this.curtday = curtday;
		this.curtAmount = curtAmount;
		this.curtInterest = curtInterest;
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
		
		Account curtAccount = new Account(accountNumber, APR, creditLimit, 0, 0, 0);
		hash.put(accountNumber, curtAccount);
	}
	
	
	public void charge() {
		System.out.println("Please type in the account number which you want to make a charge. (eg: 1234)");
		Scanner accountNumberScanner = new Scanner(System.in);
		int accountNumber = accountNumberScanner.nextInt();
		
		System.out.println("How much money you want to charge? (eg: 100)");
		Scanner amountScanner = new Scanner(System.in);
		int amount = amountScanner.nextInt();
		
		System.out.println("How many days after the opening of the account? (eg: 10)");
		Scanner dayScanner = new Scanner(System.in);
		int day = dayScanner.nextInt();
		
		Account courtAccount = hash.get(accountNumber);
		
		
	}
	public void payment() {
		System.out.println("Please type in the account number which you want to make a payment. (eg: 1234)");
		Scanner accountNumberScanner = new Scanner(System.in);
		int accountNumber = accountNumberScanner.nextInt();
		
		System.out.println("How much money you want to pay? (eg: 100)");
		Scanner amountScanner = new Scanner(System.in);
		int amount = amountScanner.nextInt();
		
		System.out.println("How many days after the opening of the account? (eg: 10)");
		Scanner dayScanner = new Scanner(System.in);
		int day = dayScanner.nextInt();
		
		Account courtAccount = hash.get(accountNumber);
		
	}
	public void balance() {
		System.out.println("Please type in the account number which you want to make a payment. (eg: 1234)");
		Scanner accountNumberScanner = new Scanner(System.in);
		int accountNumber = accountNumberScanner.nextInt();
		
		System.out.println("How many days after the opening of the account? (eg: 10)");
		Scanner dayScanner = new Scanner(System.in);
		int day = dayScanner.nextInt();
		
		Account courtAccount = hash.get(accountNumber);
		
	}

	public int numOfAccount() {
		return hash.size();
	}

}
