
public class FishInfo 
{
	// Instance Variables
	private String name;
	private int age;
	private String waterType;
	
	// Constructors
	public FishInfo(String newName, int newAge, String newWaterType)
	{
		name = newName;
		age = newAge;
		waterType = newWaterType;
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
	
	// getAge
	public int getAge()
	{
		return age;
	}
	
	// setAge
	public void setAge(int newAge)
	{
		age = newAge;
	}
	
	// getWaterType
	public String getWaterType()
	{
		return waterType;
	}
	
	// setWaterType
	public void setWaterType(String newWaterType)
	{
		waterType = newWaterType;
	}
	
}
