import java.util.Scanner;

/**
 * ConvertToHMS.java
 * 1/19/22
 * @author Joey Weston
 * Calculates seconds into appropriate units, such as: hours, minutes, and then seconds.
 * Then prints the results to the console.
 *
 */
public class ConvertToHMS 
{
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		System.out.println("How many seconds? ");
		int input = scnr.nextInt(); //Stores the users input as an int
		
		int seconds = input % 60; //Stores seconds
		int minutes = (input / 60) % 60; //Stores minutes
		int hours = (input / 60) / 60; //Stores hours - could be written as input / 360 but this way makes more sense to me
		
		
		System.out.print("\n" + input + " seconds is: ");
		System.out.print(hours + " hours, ");
		System.out.print(minutes + " minutes, and ");
		System.out.println(seconds + " seconds!");
	}
}
