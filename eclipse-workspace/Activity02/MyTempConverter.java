/**
 * MyTempConverter.java
 * 1/19/22
 * @author Joey Weston ~ 
 * Converts a Fahrenheit Temperature into Celsius using the formula: C = (F - 32) * (5/9)
 * 
 */
public class MyTempConverter 
{
	public static void main(String[] args)
	{
		final int BASE = 32;
		final double CONVERSION_FACTOR = 5.0/9.0;
		
		int fahrenheitTemp = 72;
		double celsiusTemp;
		
		celsiusTemp = (fahrenheitTemp - BASE) * CONVERSION_FACTOR;
		
		System.out.println("Fahrenheit Tempature: " + fahrenheitTemp);
		System.out.println("Celsius Equivalent: " + celsiusTemp);
	}
}
