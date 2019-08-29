package theATMApp;

import java.io.*;

public class NotesType  {
		// current balance set to £220 and overdraft £100
		private static double balance = 220;
		private static double overdraft = 100;
	
	public static void main(String args[]) throws IOException {
		// Welcome header
		System.out.println("*******************************");
		System.out.println("**  Welcome to The ATM App!  **");
		System.out.println("*******************************");
		System.out.println("**Lets get withdrawing some cash!!**\n");
		
		// create object buffer class
		BufferedReader cashAmount = new BufferedReader(new InputStreamReader(System.in));

		// ATM machine denominations available into an array
		int Notes[] = { 20, 20, 20, 20, 20, 20, 20, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5, 5,
				5 };
		
		System.out.println("Your current balance is: £"+balance+"\n");
		System.out.println("You have an overdraft limit of: £" + overdraft + "\n");
		System.out.println("-------------------------------------------\n");

		//  enter cash amount you require
		System.out.print("Please enter your cash withdrawal amount: £");

		// store amount entered
		int amount = Integer.parseInt(cashAmount.readLine());
		if (amount > balance || amount > balance + overdraft) {
			System.out.println("You have overdrawn!! £100 maximum allowable\n\n");
		} else {
			balance = balance - amount;
			System.out.println("\nYou have withdrawn £" + amount + ", your new balance is: £" + balance + "\n");
			System.out.println("**Please collect your money!**\n");
		}

		// create copy of the amount
		int copy = amount;
		int totalNotes = 0, count = 0;

		System.out.println("\nDenominations amount: \n");

		// check for notes
		for (int i = 0; i < 26; i++) {
			// count quantity of notes.
			count = amount / Notes[i];
			if (count != 0) {
				System.out.println("£"+Notes[i] + "\tx\t" + count + "\t= £" + Notes[i] * count);
			}
			// finds total number of notes
			totalNotes = totalNotes + count; 
			// finds the remaining number denominations
			amount = amount % Notes[i];
		}

		System.out.println("--------------------------------");

		// displays the total amount
		System.out.println("TOTAL\t\t\t= £" + copy);
		System.out.println("--------------------------------");

		// displays the total number of notes
		System.out.println("Total Number of Notes\t= " + totalNotes);
	}
	
}
