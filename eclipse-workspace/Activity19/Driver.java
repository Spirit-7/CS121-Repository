/**
 * 
 * @author Joey Weston
 *
 */
public class Driver 
{
	public static void main(String[] args) 
	{
		BubbleSorter test1 = new BubbleSorter(12);
		
		System.out.println("Before sort():");
		System.out.println(test1.toString());
		
		System.out.println("");
		test1.sort();
		
		System.out.println("After sort():");
		System.out.println(test1.toString());
	}

}
