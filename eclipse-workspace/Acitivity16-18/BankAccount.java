import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * BankAccount.java
 * This class allows the user to use methods such as:
 * the creation of bank accounts,deposits, withdrawals,
 * getters, setters, saving, parsing, and
 * listing information about the bank account.
 * @author Joey Weston
 * 3/28/22
 * CS 121 Section 004 - Sarah Frost
 */
public class BankAccount implements AccountInterface, AccountWithTransactionsInterface, FileIOInterface 
{
	private long number;
	private String name;
	private float balance;
	
	private final long BASE = 100000000;
	private static int accountsMade;
	
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public BankAccount()
	{
		number = BASE + accountsMade; accountsMade++;
		name = "No Name";
		balance = 0.00f;
		
		Transaction currTransaction = new Transaction(balance, TransactionInterface.Type.Deposit, "Account Opened");
		transactions.add(currTransaction);
	}
	
	public BankAccount(String accountName)
	{
		number = BASE + accountsMade; accountsMade++;
		name = accountName;
		balance = 0.00f;
		
		Transaction currTransaction = new Transaction(balance, TransactionInterface.Type.Deposit, "Account Opened");
		transactions.add(currTransaction);
	}
	
	public BankAccount(String accountName, float initialFunds)
	{
		number = BASE + accountsMade; accountsMade++;
		name = accountName;
		balance = initialFunds;
		
		Transaction currTransaction = new Transaction(balance, TransactionInterface.Type.Deposit, "Account Opened");
		transactions.add(currTransaction);
	}
	
		public String getNumber()
		{
			return ("" + number);
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setName(String newName)
		{
			name = newName;
		}
		
		public float getBalance()
		{
			return balance;
		}
			
		public boolean withdraw(float amount)
		{
			if (amount >= 0.01f | amount == 0.01f)
			{
				if (amount <= balance | amount == balance) 
				{
					balance = balance - amount;
					Transaction currTransaction = new Transaction(amount, TransactionInterface.Type.Withdraw);
					transactions.add(currTransaction);
					return true;
				}
				else 
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		
		public boolean withdraw(float amount, String description)
		{
			if (withdraw(amount)) 
			{
				Transaction currTransaction = new Transaction(amount, TransactionInterface.Type.Withdraw, description);
				transactions.add(currTransaction);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean deposit(float amount)
		{
			if (amount >= 0.01f | amount == 0.01f)
			{
				balance = balance + amount;
				Transaction currTransaction = new Transaction(amount, TransactionInterface.Type.Deposit);
				transactions.add(currTransaction);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean deposit(float amount, String description)
		{
			if (deposit(amount))
			{
				Transaction currTransaction = new Transaction(amount, TransactionInterface.Type.Deposit, description);
				transactions.add(currTransaction);
				return true;
			}
			else
			{
			return false;
			}
		}
		
		public ArrayList<Transaction> getTransactions()
		{
			return transactions;
		}
		
		public String toString()
		{
			int numTransactions = transactions.size() - 1;
			String text = BankDriver.DIVIDER;
			text = text + "\n" + number + " | " + name + ": $" + balance;
			text = text + "\n" + BankDriver.DIVIDER;
			for (int i = 0; i <= numTransactions; i++)
			{
				text = text + "\n" + transactions.get(i).toString();
			}
			text = text + "\n" + "END";
			return text;
		}
		
		public void save(PrintWriter fileWriter) throws FileNotFoundException
		{
			
			
			String text = toString();
			
			fileWriter.write(text); 
			fileWriter.close();
		}
		
		public void parse(Scanner fileScanner) throws FileNotFoundException, ParseException
		{
			fileScanner.next();
			number = fileScanner.nextLong();
			
			fileScanner.next();
			name = fileScanner.next();
			name = name + " " + fileScanner.next();
			name = name.substring(0, name.length() - 1);
			
			balance = Float.parseFloat(fileScanner.next().substring(1));
			
			
			fileScanner.close();
		}
}
