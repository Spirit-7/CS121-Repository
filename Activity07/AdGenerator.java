import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * AdGenerator.java
 * 2/7/2022
 * @author Joey Weston
 * Uses Scanner, String, and NumberFormat classes to generate a service
 * advertisement based on the inputed user's profile information.
 */
public class AdGenerator 
{
	public static void main(String[] args)
	{
		// Create Scanner object
		Scanner scnr = new Scanner(System.in);
		
		// Create Currency Format
		NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();
		
		// Welcome message
		System.out.println("Welcome to AdGenerator");
		System.out.println("Please enter your profile information...");
		System.out.println("____________________________________________________________");
		System.out.println("\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");
		System.out.println("____________________________________________________________");
		
		// Entered information variable storage
		// First Name:
		System.out.print("First Name: ");
		String firstName = scnr.nextLine();
		
		// Middle Name:
		System.out.print("Middle Name: ");
		String middleName = scnr.nextLine();
		
		// Last Name:
		System.out.print("Last Name: ");
		String lastName = scnr.nextLine();
		
		// Job Title:
		System.out.print("Job Title: ");
		String jobTitle = scnr.nextLine();
		
		// Phone Number:
		System.out.print("Phone Number (10 digit): ");
		String phoneNum = scnr.nextLine();
		
		// Hourly Rate:
		System.out.print("Hourly Rate: ");
		double hourRate = scnr.nextDouble();
		
		// Divider
		System.out.println("\n____________________________________________________________");
		System.out.println("\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");
		System.out.println("____________________________________________________________");
		
		// Service Advertisement
		
		System.out.println("Need a " + jobTitle + "?");
		System.out.println("CALL NOW!  (" + phoneNum.substring(0, 3) + ")  " + phoneNum.substring(3, 6) + "-" + phoneNum.substring(6));
		System.out.println("Ask for " + firstName + " " +  middleName.charAt(0) + ". " + lastName);
		System.out.println("(Rates start at " + currencyFmt.format(hourRate) + "/hr)");
		
		//Divider
		System.out.println("____________________________________________________________");
		System.out.println("\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");
		System.out.println("____________________________________________________________");
	}
}
