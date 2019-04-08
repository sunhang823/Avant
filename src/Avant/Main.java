package Avant;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean createAccount = true;
		CreditCard cc = new CreditCard();	
		while(createAccount) {
			System.out.println("Create an account? Y or N");
			Scanner createAccountScanner = new Scanner(System.in);
			String createAccountString = createAccountScanner.nextLine();
			if(createAccountString.equals("Y")) {
				cc.creatAccount();	
				System.out.println("An account has been created.");
				System.out.println("If you want to create another account, please type in Y.");
				System.out.println("If you want to stop creating accounts and start tracking accounts, please type in S.");
				Scanner trackScanner = new Scanner(System.in);
				String  trackString = trackScanner.nextLine();
				if(trackString.equals("S")) {
					break;
				}
			}else if(createAccountString.equals("N")) {
				createAccount = false;
				System.out.println("Thank you! see you next time");

			}else if(createAccountString.equals("S")) {
				createAccount = false;
				
			}else {
				System.out.println("Please answer with Y or N");
			}
		}
		if(cc.numOfAccount() != 0) {
			boolean trackAccount = true;
			while(trackAccount) {
				System.out.println("If you want to track a charge, please type in C.");
				System.out.println("If you want to track a payment, please type in P.");
				System.out.println("If you want to check the balance, please type in B.");
				System.out.println("If you want to end the system, please type in E.");
				Scanner trackAccountScanner = new Scanner(System.in);
				String trackAccountString = trackAccountScanner.nextLine();
				if(trackAccountString.equals("C")) {
					cc.charge();
				}else if(trackAccountString.equals("P")) {
					cc.payment();
				}else if(trackAccountString.equals("B")) {
					cc.balance();
				}else if(trackAccountString.equals("E")) {
					System.out.println("Thank you! see you next time");
					break;
				}else {
					System.out.println("Please answer with C, P, B or E!");
				}
			}
		}

	}

}
