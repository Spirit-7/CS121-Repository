import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SodaSurvey implements SodaSurveyInterface
{
	int[][] array;
	
	public SodaSurvey(String filename)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(filename));
		
			int numRows = Integer.parseInt(fileReader.next());
			int numCols = Integer.parseInt(fileReader.next());
			array = new int[numRows][numCols];
		
			for (int i = 0; i < numRows; i++)
			{
				for (int j = 0; j < numCols; j++)
				{
					array[i][j] = Integer.parseInt(fileReader.next());
				}
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found."
					+ "\nPlease try again."
					+ "\nExiting...");
		}
	}
	
	@Override
	public double rowAvg(int rowIndex) 
	{
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < array[rowIndex].length; i++)
		{
			sum = sum + array[rowIndex][i];
			
			avg = ((double) sum) / (double) (i + 1);
		}
		
		DecimalFormat f = new DecimalFormat("00.00");
		avg = Double.parseDouble(f.format(avg));
		
		return avg;
	}

	@Override
	public double colAvg(int colIndex) 
	{
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			sum = sum + array[i][colIndex];
			
			avg = ((double)sum / (double)(i + 1));
		}
		
		DecimalFormat f = new DecimalFormat("00.00");
		avg = Double.parseDouble(f.format(avg));
		
		return avg;
	}
	
	@Override
	public String toString()
	{
		String text = "";
		
		for (int i = 0; i < array.length; i++)
		{
			text = text + "Person " + i + " Mean: "
					+ rowAvg(i) + "\n";
		}
		
		text = text + "\n";
		
		for (int i = 0; i < array[0].length; i++)
		{
			text = text + "Soda " + i + " Mean: "
					+ colAvg(i) + "\n";
		}
		return text;
	}
}
