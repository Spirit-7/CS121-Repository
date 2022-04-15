import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;
/**
 * BankDriver.java
 * This is the main method of this Activity.
 * This was mostly used for testing and will be
 * used as the central hub for users when they
 * are interacting with their bank accounts.
 * @author Joey Weston
 * 3/28/22
 * CS 121 Section 004 - Sarah Frost
 */
public class BankDriver 
{
	final static String DIVIDER = "---------------------------------";
	
	public static PrintWriter fileWriter(BankAccount account) throws IOException
	{
		File accountFile = new File("D:\\University\\Classes\\CS121\\Acitivity16-18\\BankAccounts\\" + account.getNumber() + ".txt");
		PrintWriter fileWriter = new PrintWriter(accountFile);
		
		return fileWriter;
	}
	
	public static Scanner fileScanner(BankAccount account) throws IOException
	{
		File accountFile = new File("D:\\University\\Classes\\CS121\\Acitivity16-18\\BankAccounts\\" + account.getNumber() + ".txt");
		Scanner fileScanner = new Scanner(accountFile);
		
		return fileScanner;
	}
	
	public static void main(String[] args) throws IOException, ParseException
	{
		BankAccount testAccount1 = new BankAccount();
		BankAccount testAccount2 = new BankAccount("Joey's Checkings");
		BankAccount testAccount3 = new BankAccount("Joey's Savings", 77.77f);
		
		testAccount1.deposit(2.22f);
		testAccount2.deposit(2.22f);
		testAccount3.deposit(2.22f);
		
		testAccount1.deposit(222.22f);
		testAccount2.deposit(222.22f);
		testAccount3.deposit(222.22f);
		
		testAccount1.withdraw(22.22f);
		testAccount2.withdraw(22.22f);
		testAccount3.withdraw(22.22f);
		
		testAccount1.withdraw(2.22f);
		testAccount2.withdraw(2.22f);
		testAccount3.withdraw(2.22f);
		
		testAccount1.deposit(222.22f);
		testAccount2.deposit(222.22f);
		testAccount3.deposit(222.22f);
		
		testAccount1.save(fileWriter(testAccount1));
		testAccount2.save(fileWriter(testAccount2));
		testAccount3.save(fileWriter(testAccount3));
		
		Bank myBank = new Bank();
		
		myBank.addAccount(testAccount1);
		myBank.addAccount(testAccount2);
		myBank.addAccount(testAccount3);
		
		System.out.println(myBank.toString());
		
	}
}
