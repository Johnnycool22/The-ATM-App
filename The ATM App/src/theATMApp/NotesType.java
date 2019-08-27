package theATMApp;

import java.io.*;

class NotesType {
	public static void main(String args[]) throws IOException {
		// create object buffer class
		BufferedReader cashAmount = new BufferedReader(new InputStreamReader(System.in));

		// ATM machine denominations available into an array
		int Denom[] = { 20, 20, 20, 20, 20, 20, 20, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5, 5,
				5 };

		//  enter cash amount you require
		System.out.print("Please enter your cash withdrawal amount: ");

		// store amount entered
		int amount = Integer.parseInt(cashAmount.readLine());

		// create copy of the amount
		int copy = amount;
		int totalNotes = 0, count = 0;

		System.out.println("\nDenominations amount: \n");

		// check for notes
		for (int i = 0; i < 26; i++) {
			// count quantity of notes.
			count = amount / Denom[i];
			if (count != 0) {
				System.out.println(Denom[i] + "\tx\t" + count + "\t= " + Denom[i] * count);
			}
			// finds total number of notes
			totalNotes = totalNotes + count; 
			// finds the remaining number denominations
			amount = amount % Denom[i];
		}

		System.out.println("--------------------------------");

		// displays the total amount
		System.out.println("TOTAL\t\t\t= " + copy);
		System.out.println("--------------------------------");

		// displays the total number of notes
		System.out.println("Total Number of Notes\t= " + totalNotes);
	}
}
