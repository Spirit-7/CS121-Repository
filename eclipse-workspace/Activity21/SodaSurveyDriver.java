
public class SodaSurveyDriver 
{
	public static void main(String[] args) 
	{
		if (args[0] != null)
		{
			SodaSurvey survey = new SodaSurvey(args[0]);
			
			System.out.println(survey.rowAvg(0));
			System.out.println(survey.rowAvg(1));
			
			System.out.println(survey.colAvg(0));
			System.out.println(survey.colAvg(1));
			
			System.out.println(survey.toString());
		}
		else
		{
			System.out.println("No command line argument for filename found."
					+ "\nPlease input command line argument and try again."
					+ "\nExiting...");
		}
	}

}
