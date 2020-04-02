package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = null;

		try {

			sc = new Scanner(System.in);

			System.out.println("Enter account data");

			System.out.print("Number: ");
			int number = sc.nextInt();

			System.out.print("Holder: ");
			String holder = sc.next();

			System.out.print("Initial Balance: ");
			Double initialBalance = sc.nextDouble();

			System.out.print("Withdraw Limit: ");
			Double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, initialBalance, withdrawLimit);

			char answer = ' ';

			do {

				System.out.printf("" + "Please select which operation you want to perform: %n" + "D | Deposit %n"
						+ "W | Withdraw %n" + "B | See Balance and limit %n" + "E | Exit %n");
				answer = sc.next().toUpperCase().charAt(0);

				switch (answer) {
				case 'D':
					System.out.println("Enter amount to deposit: ");
					account.deposit(sc.nextDouble());
					break;

				case 'W':
					System.out.println("Enter amount to withdraw: ");
					account.withdraw(sc.nextDouble());
					break;

				case 'B':
					System.out.printf("Balance: US$ %.2f %n", account.getBalance());
					System.out.printf("Withdraw limit: US$ %.2f %n", account.getWithdrawLimit());
					System.out.println("----------------------------------------------------");
					System.out.printf("Total: US$ %.2f %n", (account.getBalance() + account.getWithdrawLimit()));
					System.out.println();
					break;

				case 'E':
					break;

				default:
					System.out.printf("Invalid answer%n%n");
				}

				if (answer != 'E') {
					do {
						System.out.print("Do you want do do another operation? (Y/N) ");
						answer = sc.next().toUpperCase().charAt(0);
						System.out.println();
						if (answer != 'Y' && answer != 'N') {
							System.out.printf("Invalid answer%n%n");
						}
					} while (answer != 'Y' && answer != 'N');
				}

			} while (answer != 'E' && answer != 'N');

		} catch (DomainException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
