import java.util.Random;
/**
 * 
 * @author Joey Weston
 *
 */
public class BubbleSorter 
{
	int[] intArray;
	
	BubbleSorter(int size)
	{
		Random random = new Random();
		intArray = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			intArray[i] = random.nextInt(size * 2);
		}
	}
	
	private void swap(int indexX, int indexY)
	{
		int valueX = intArray[indexX];
		int valueY = intArray[indexY];
		
		intArray[indexX] = valueY;
		intArray[indexY] = valueX;
	}
	
	public void sort()
	{
		boolean isSorted = false;
		
		while (!isSorted)
		{
			isSorted = true;
			for (int i = 0; i < intArray.length - 1; i++)
			{
				if (intArray[i] > intArray[i + 1])
				{
					swap(i, i + 1);
					isSorted = false;
				}
			}
		}
	}
	
	public String toString()
	{
		String text = "intArray Contents: ";
		
		for (int i = 0; i < intArray.length - 1; i++)
		{
			text = text + intArray[i] + ", ";
		}
		text = text + intArray[intArray.length - 1];
		
		return text;
	}
}
