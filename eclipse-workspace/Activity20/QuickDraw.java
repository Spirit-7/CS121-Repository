/**
 * QuickDraw.java
 * This is the main method of this activity.
 * This was used to print text to the console
 * in order to facilitate a card game where the
 * objective is to draw the highest card rank.
 * Whichever player draws the highest card rank
 * wins and the game ends.
 * In the event of the tie the game also ends
 * but on a tie.
 * @author Joey Weston
 * 4/6/22
 * CS 121 Section 004 - Sarah Frost
 */
public class QuickDraw 
{
	public static void main(String[] args) 
	{
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		
		System.out.println("Hello!");
		System.out.println("Welcome to QuickDraw!\n");
		
		if (args.length > 2)
		{
			System.out.println("Too many players detected. Quitting...");
			System.exit(0);
		}
		else if (args.length < 2)
		{
			System.out.println("Too little players detected. Quitting...");
		}
		
		String player1 = args[0];
		String player2 = args[1];
		
		System.out.print(player1 + ", here is your card: ");
		Card player1Card = deck.draw();
		System.out.println(player1Card + "\n");
		
		System.out.print(player2 + ", here is your card: ");
		Card player2Card = deck.draw();
		System.out.println(player2Card + "\n");
		
		if (player1Card.compareTo(player2Card) == 1)
		{
			System.out.println(player1 + " wins!!!\nThanks for playing!");
		}
		else if (player1Card.compareTo(player2Card) == -1)
		{
			System.out.println(player2 + " wins!!!\nThanks for playing!");
		}
		else if (player1Card.compareTo(player2Card) == 0)
		{
			System.out.println(player1 + " and " + player2 + " ties!!!\nThanks for playing!");
		}
	}

}
