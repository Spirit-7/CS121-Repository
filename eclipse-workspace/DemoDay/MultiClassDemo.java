/**
 * MultiClassDemo.java
 * 2/9/2022
 * @author Joey Weston
 * DemoDay program using multiple classes
 */
public class MultiClassDemo 
{
	public static void main(String[] args) 
	{
		int myInt = 0;
		String myString = "Hi";
		
		PrintPretty printThing = new PrintPretty(5, "Yogi");
		
		// Test using the setName, setAge, getName, and getAge methods
		//System.out.print("Name: " + printThing.getName());
		//System.out.println(" | Age: " + printThing.getAge());
		
		printThing.setName("Cooper");
		printThing.setAge(12);
		//System.out.print("Name: " + printThing.getName());
		//System.out.println(" | Age: " + printThing.getAge());
		
		// Use the printInfo method
		//printThing.printInfo();
		
		// Use printInfoPresent method
		//printThing.printInfoPresent("cake");
		
		
		
		PrintPretty pet2 = new PrintPretty(2, "Nutmeg");
		//pet2.printInfo();
		//pet2.printInfoPresent("a toy");
		
		
		
		// Test CatInfo constructor and getName()
		CatInfo cat1 = new CatInfo("Kitty", 4, "Gray and Black");
		
		//System.out.println("There is our Cat name: " + cat1.getName());
		
		cat1.setName("Steve");
		//System.out.println("There is our Cat name: " + cat1.getName());
		
		
		// Test FishInfo Constructor and getters and setters
		FishInfo fish1 = new FishInfo("Paul", 3, "Fresh Water");
		System.out.println(fish1.getName() + " is a " + fish1.getWaterType() + " fish who is " + fish1.getAge() + " years old");
		
		fish1.setName("George");
		fish1.setAge(15);
		fish1.setWaterType("Salt Water");
		System.out.println(fish1.getName() + " is a " + fish1.getWaterType() + " fish who is " + fish1.getAge() + " years old");
	}
}
