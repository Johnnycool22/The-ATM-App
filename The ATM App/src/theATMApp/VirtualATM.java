package theATMApp;

import java.util.Scanner;

public class VirtualATM {

	private static Scanner input;
	// current balance set to £220
	private static double balance = 220;
	private static double overdraft = 100;
	private static int anotherWithdrawal;

	public static void main(String[] args) {
		input = new Scanner(System.in);

		selection();
		
	}

	private static void selection() {
		int selection;

		System.out.println("1. Check Balance");
		System.out.println("2. Cash Withdrawal");
		System.out.println("3. EXIT");
		System.out.println("Please select an option you wish to perform:");

		selection = input.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Your current balance is: £" + balance + "\n");
			System.out.println("You have an overdraft limit of: £" + overdraft + "\n");
			anotherWithdrawal();
			break;

		case 2:
			float amount;
			System.out.println("Please enter your cash withdrawal amount: ");
			amount = input.nextFloat();
			if (amount >= balance + overdraft || amount == 0) {
				System.out.println("You have exceeded your overdraft limit!\n\n");
				anotherWithdrawal();
			} else {
				balance = balance - amount;
				System.out.println("You have withdrawn £" + amount + ", your new balance is: £" + balance + "\n");
				System.out.println("Please collect your money!\n");
				anotherWithdrawal();
			}
			break;

		case 3:
			System.exit(0);

		default:
			System.out.println("Invalid selection:\n\n");
			selection();
			break;
		}

	}

	private static void anotherWithdrawal() {
		System.out.println("Would you like to make a cash withdrawal?\n\nPlease Select:");
		System.out.println("1. Cash Withdrawal\n2. EXIT");
		anotherWithdrawal = input.nextInt();
		if (anotherWithdrawal == 1) {
			selection();
		} else if (anotherWithdrawal == 2) {
			System.out.println("Your ATM session has ended, please remove your card!");
		} else {
			System.out.println("Invalid selection\n\n");
			anotherWithdrawal();
		}
	}
}
