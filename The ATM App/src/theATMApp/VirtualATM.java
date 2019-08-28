package theATMApp;

import java.util.Scanner;

public class VirtualATM extends NotesType {

	private static Scanner input;
	// current balance set to £220
	private static double balance = 220;
	private static double overdraft = 100;

	public static void main(String[] args) throws IllegalArgumentException {
		input = new Scanner(System.in);
		// methods statements used
		selection();
		withdrawal();
		furtherWithdrawal();

	}

	/**
	 * Switch statement method to select main ATM options
	 */
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
			withdrawal();
			break;

		case 2:
			float amount;
			System.out.println("Please enter your cash withdrawal amount: ");
			amount = input.nextFloat();
			if (amount > balance) {
				System.out.println("You have overdrawn!! £100 limit allowable\n\n");
				withdrawal();
			} else if (amount > balance + overdraft) {
				System.out.println("You have exceeded your overdraft limit!\n\n");
				withdrawal();
			} else {
				balance = balance - amount;
				System.out.println("You have withdrawn £" + amount + ", your new balance is: £" + balance + "\n");
				System.out.println("Please collect your money!\n");
				withdrawal();
			}
			break;

		case 3:
			System.out.println("Your ATM session has ended, please remove your card!");
			System.exit(0);

		default:
			System.out.println("Invalid selection:\n\n");
			selection();
			break;
		}

	}

	private static void withdrawal() {
		System.out.println("Would you like to make a cash withdrawal?\n");
		furtherWithdrawal();
	}

	/**
	 * Another Switch statement method to select a further cash withdrawal
	 */
	private static void furtherWithdrawal() {
		int selection;

		System.out.println("1. Cash Withdrawal");
		System.out.println("2. EXIT");
		System.out.println("Please select an option you wish to perform:");

		selection = input.nextInt();

		switch (selection) {

		case 1:
			float amount;
			System.out.println("Please enter your cash withdrawal amount: ");
			amount = input.nextFloat();
			if (amount >= balance + overdraft || amount == 0) {
				System.out.println("You have exceeded your overdraft limit!\n\n");
				withdrawal();
			} else {
				balance = balance - amount;
				System.out.println("You have withdrawn £" + amount + ", your new balance is: £" + balance + "\n");
				System.out.println("Please collect your money!\n");
				withdrawal();
			}
			break;

		case 2:
			System.out.println("Your ATM session has now ended, please remove your card!");
			System.exit(0);

		default:
			System.out.println("Invalid selection:\n\n");
			withdrawal();
			break;
		}

	}
}
