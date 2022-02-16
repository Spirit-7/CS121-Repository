
public class PrintPretty 
{
	// Instance
	private String name;
	private int age;
	
	// Constructor
	public PrintPretty(int x, String y)
	{
		name = y;
		age = x;
	}
	
	// make getter for name
	public String getName() 
	{
		return name;
	}
	
	// make getter for age
	public int getAge()
	{
		return age;
	}
	
	// make setter for name
	public void setName(String inName)
	{
		name = inName;
	}
	
	// make setter for age
	public void setAge(int inAge)
	{
		age = inAge;
	}
	
	// print info in predetermined format
	public void printInfo()
	{
		System.out.println(name + " is " + age + " years old!");
	}
	
	// print info and birthday present
	public void printInfoPresent(String present)
	{
		System.out.println(name + " is getting " + present + " for their birthday!");
	}
}
