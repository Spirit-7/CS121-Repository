import java.util.Random;
/**
 * DeckOfCards.java
 * This class creates an object which holds
 * an array of 52 cards, each with a different suit
 * or a different rank.
 * This class is used to play the QuickDraw game
 * described in QuickDraw.java
 * @author Joey Weston
 * 4/6/22
 * CS 121 Section 004 - Sarah Frost
 */
public class DeckOfCards implements DeckOfCardsInterface
{
	private final int DECK_SIZE = 52;
	private Card[] cards;
	private int nextCardIndex;
	
	DeckOfCards()
	{	
		cards = new Card[DECK_SIZE];
		int i = 0;
		for (Suit s : Suit.values())
		{
			for (Rank r : Rank.values())
			{
				cards[i] = new Card(s, r);
				i++;
			}
		}
		nextCardIndex = 0;
	}
	
	@Override
	public void shuffle() 
	{
		for (int i = 0; i < cards.length; i++)
		{
			int randomX = new Random().nextInt(cards.length);
			int randomY = new Random().nextInt(cards.length);
			
			swap(randomX, randomY);
		}	
			nextCardIndex = 0;
	}

	private void swap(int indexX, int indexY)
	{
		Card cardX = cards[indexX];
		Card cardY = cards[indexY];
		
		cards[indexX] = cardY;
		cards[indexY] = cardX;
	}
	
	@Override
	public Card draw()
	{
		if (nextCardIndex < DECK_SIZE)
		{
			nextCardIndex++;
			return cards[nextCardIndex - 1];
		}
		else
		{
		return null;
		}
	}

	@Override
	public int numCardsRemaining()
	{
		return DECK_SIZE - nextCardIndex;
	}

	@Override
	public int numCardsDealt()
	{
		return nextCardIndex;
	}

	@Override
	public Card[] dealtCards()
	{
		return null;
	}

	@Override
	public Card[] remainingCards()
	{
		return null;
	}

	public String toString()
	{
		String text = "This Deck of Cards includes: ";
		for (int i = 0; i < cards.length; i++)
		{
			text = text + "\n" + cards[i];
		}
		
		return text;
	}
}
