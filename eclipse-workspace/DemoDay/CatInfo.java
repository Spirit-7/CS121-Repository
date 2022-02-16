
public class CatInfo 
{
	// Instance Variables
	private String name;
	private int age;
	private String color;
	
	// Constructor
	public CatInfo(String newName, int newAge, String newColor)
	{
		name = newName;
		age = newAge;
		color = newColor;
		
	}
	
	// Getters and Setters
	// getName
	public String getName()
	{
		return name;
	}
	
	// setName
	public void setName(String newName)
	{
		name = newName;
	}
	
	// setAge
	public void setAge(int newAge)
	{
		age = newAge;
	}
	
}
