import java.util.ArrayList;
/**
 * Bank.java
 * This class allows the user to create banks
 * and also add bank accounts to that bank
 * @author Joey Weston
 * 3/28/22
 * CS 121 Section 004 - Sarah Frost
 */
public class Bank 
{
	
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public Bank()
	{
		
	}
		
		public void addAccount(BankAccount bankAccount)
		{
			accounts.add(bankAccount);
		}
		
		public String toString()
		{
			int numAccounts = accounts.size() - 1;
			String text = BankDriver.DIVIDER;
			
			for (int i = 0; i <= numAccounts; i++)
			{
				text = text + "\n" + accounts.get(i).getNumber();
				text = text + " | " + accounts.get(i).getName();
				text = text + "\n" + BankDriver.DIVIDER;
			}
			
			text = text + "\n" + "END";
			
			return text;
		}
}
