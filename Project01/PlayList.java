/**
 * An application that manages a user's songs in a simplified playlist
 * 2/16/2022
 * @author Joey Weston
 * 
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class PlayList 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		// SONG 1
		// Prompts the user for song1 information
		System.out.println("Enter the following information for your FIRST song:");
		
		System.out.print("Song Title: ");
		String title = scan.nextLine();
		
		System.out.print("Song Artist: ");
		String artist = scan.nextLine();
		
		System.out.print("Song Album: ");
		String album = scan.nextLine();
		
		System.out.print("Song Play Time (mm:ss) : ");
		String playTime = scan.nextLine();
		
		// Converts play time into integer representing total number of seconds
		int playTimeSeperator = playTime.indexOf(':');
		int playTimeMins = Integer.parseInt(playTime.substring(0, playTimeSeperator));
		int playTimeSeconds = Integer.parseInt(playTime.substring(playTimeSeperator + 1));
		playTimeSeconds = playTimeMins * 60 + playTimeSeconds;
		
		// Instantiating new song object
		Song song1 = new Song(title, artist, album, playTimeSeconds);
		
		
		
		// SONG 2
		// Prompts the user for song2 information
		System.out.println("Enter the following information for your SECOND song:");
				
		System.out.print("Song Title: ");
		title = scan.nextLine();
				
		System.out.print("Song Artist: ");
		artist = scan.nextLine();
				
		System.out.print("Song Album: ");
		album = scan.nextLine();
				
		System.out.print("Song Play Time (mm:ss) : ");
		playTime = scan.nextLine();
				
		// Converts play time into integer representing total number of seconds
		playTimeSeperator = playTime.indexOf(':');
		playTimeMins = Integer.parseInt(playTime.substring(0, playTimeSeperator));
		playTimeSeconds = Integer.parseInt(playTime.substring(playTimeSeperator + 1));
		playTimeSeconds = playTimeMins * 60 + playTimeSeconds;
				
		// Instantiating new song object
		Song song2 = new Song(title, artist, album, playTimeSeconds);
		
		
		
		// SONG 3
		// Prompts the user for song3 information
		System.out.println("Enter the following information for your THIRD song:");
				
		System.out.print("Song Title: ");
		title = scan.nextLine();
				
		System.out.print("Song Artist: ");
		artist = scan.nextLine();
				
		System.out.print("Song Album: ");
		album = scan.nextLine();
				
		System.out.print("Song Play Time (mm:ss) : ");
		playTime = scan.nextLine();
				
		// Converts play time into integer representing total number of seconds
		playTimeSeperator = playTime.indexOf(':');
		playTimeMins = Integer.parseInt(playTime.substring(0, playTimeSeperator));
		playTimeSeconds = Integer.parseInt(playTime.substring(playTimeSeperator + 1));
		playTimeSeconds = playTimeMins * 60 + playTimeSeconds;
				
		// Instantiating new song object
		Song song3 = new Song(title, artist, album, playTimeSeconds);
		
		
		// Calculate Average Play Time
		double playTimeAvg = (song1.getPlayTime() + song2.getPlayTime() + song3.getPlayTime()) / 3.00;
		DecimalFormat decimalFormat = new DecimalFormat("####.00");
		System.out.println("Average Play Time: " + decimalFormat.format(playTimeAvg));
		
		
		// Find Song With Play Time Closest to 4 Minutes
		String songPlayTime4Min;
		if ((Math.abs(song1.getPlayTime() - 240) < Math.abs(song2.getPlayTime() - 240)) &&
			(Math.abs(song1.getPlayTime() - 240) < Math.abs(song3.getPlayTime() - 240)))
		{
			songPlayTime4Min = song1.getTitle();
		}
		else if (Math.abs(song2.getPlayTime() - 240) < Math.abs(song3.getPlayTime() - 240))
		{
			songPlayTime4Min = song2.getTitle();
		}
		else
		{
			songPlayTime4Min = song3.getTitle();
		}
		System.out.println("The song with play time closest to 240 secs is: " + songPlayTime4Min);
		
		
		// Build a Sorted Playlist
		Song songSorted1;
		Song songSorted2;
		Song songSorted3;
		String separator = "========================================================================================";
		if ((song1.getPlayTime() < song2.getPlayTime()) &&
			(song1.getPlayTime() < song3.getPlayTime()))
		{
			songSorted1 = song1;
			if (song2.getPlayTime() < song3.getPlayTime())
			{
				songSorted2 = song2;
				songSorted3 = song3;
			}
			else
			{
				songSorted2 = song3;
				songSorted3 = song2;
			}
		}
		else if(song2.getPlayTime() < song3.getPlayTime())
		{
			songSorted1 = song2;
			if (song1.getPlayTime() < song3.getPlayTime())
			{
				songSorted2 = song1;
				songSorted3 = song3;
			}
			else
			{
				songSorted2 = song3;
				songSorted3 = song1;
			}
		}
		else
		{
			songSorted1 = song3;
			if (song1.getPlayTime() < song2.getPlayTime())
			{
				songSorted2 = song1;
				songSorted3 = song2;
			}
			else
			{
				songSorted2 = song2;
				songSorted3 = song1;
			}
		}
		
		
		System.out.println(separator);
		System.out.println("Title                          Artist               Album                           Time");
		System.out.println(separator);
		System.out.println(songSorted1.toString());
		System.out.println(songSorted2.toString());
		System.out.println(songSorted3.toString());
		System.out.println(separator);
		
		
	}

}
