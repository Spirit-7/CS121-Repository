import java.time.Instant;
/**
 * Transaction.java
 * This class allows the user to keep track of
 * money going into and out of a certain bank account.
 * @author Joey Weston
 * 3/28/22
 * CS 121 Section 004 - Sarah Frost
 */
public class Transaction implements TransactionInterface
{
	private Instant date;
	private float amount;
	private Type type;
	private String description;
	
	public Transaction()
	{
		date = Instant.now();
		amount = 0.00f;
		type = Type.None;
		description = "No Description";
	}
	
	public Transaction(float transactionAmount, Type transactionType)
	{
		date = Instant.now();
		amount = transactionAmount;
		type = transactionType;
		description = "No Description";
	}
	
	public Transaction(float transactionAmount, Type transactionType, String transactionDescription)
	{
		date = Instant.now();
		amount = transactionAmount;
		type = transactionType;
		description = transactionDescription;
	}
	
		public Instant getDate()
		{
			return date;
		}
		
		public float getAmount()
		{
			return amount;
		}
		
		public Type getType()
		{
			return type;
		}
		
		public String getDescription()
		{
			return description;
		}
		
		public void setDescription(String newDescription)
		{
			description = newDescription;
		}
		
		public String toString()
		{
			String text = "";
			text = text + date.toString().substring(0, 10) + " " + date.toString().substring(11, 19);
			text = text + " $" + amount;
			text = text + " (" + type + ": ";
			text = text + description + ")";
			text = text + "\n" + BankDriver.DIVIDER;
			return text;
		}
}
