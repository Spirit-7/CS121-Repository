import java.awt.Point;
/**
 * TicTacToeGame.Java
 * 
 * @author Joey Weston
 * 4/15/2022
 * CS 121 Section 004 - Sarah Frost
 */
public class TicTacToeGame implements TicTacToe
{
	private GameState gameState;
	private BoardChoice[][] board;
	private Point[] moves;
	private int numMoves;
	
	private BoardChoice player;
	private BoardChoice previousPlayer;
	
	public TicTacToeGame()
	{
		board = new BoardChoice[3][3];
		newGame();
	}
	
	@Override
	public void newGame() 
	{
		for (int i = 0; i < board[0].length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				board[i][j] = BoardChoice.OPEN;
			}
		}
		gameState = GameState.IN_PROGRESS;
		numMoves = 0;
		moves = new Point[numMoves];
		
		player = BoardChoice.X;
		previousPlayer = null;
	}

	@Override
	public boolean choose(TicTacToe.BoardChoice player, int row, int col) 
	{
		
		if (isValid(player, row, col))
		{
			board[row][col] = player;
			 
			
			Point[] newMoves = moves.clone();
			
			moves = new Point[numMoves + 1];
			
			for (int i = 0; i < newMoves.length; i++)
			{
				moves[i] = newMoves[i];
			}
			
			moves[numMoves] = new Point(row, col);
			numMoves++;
			
			previousPlayer = player;
			if (previousPlayer == BoardChoice.X)
			{
				player = BoardChoice.O;
			}
			else
			{
				player = BoardChoice.X;
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean gameOver() 
	{
		boolean isXWinner = isWinner(BoardChoice.X);
		boolean isOWinner = isWinner(BoardChoice.O);
		boolean isNoWinner = isTie();
	
		if (isXWinner || isOWinner || isNoWinner)
		{
			getGameState();
			return true;
		}
		
		return false;
	}

	@Override
	public TicTacToe.GameState getGameState() 
	{
		boolean isXWinner = isWinner(BoardChoice.X);
		boolean isOWinner = isWinner(BoardChoice.O);
		boolean isNoWinner = isTie();
		
		if (isXWinner)
		{
			gameState = GameState.X_WON;
		}
		else if (isOWinner)
		{
			gameState = GameState.O_WON;
		}
		else if (isNoWinner)
		{
			gameState = GameState.TIE;
		}
		else 
		{
			gameState = GameState.IN_PROGRESS;
		}
		
		return gameState;
	}

	@Override
	public TicTacToe.BoardChoice[][] getGameGrid() 
	{
		BoardChoice[][] gameGrid = board.clone();
		
		return gameGrid;
	}

	@Override
	public Point[] getMoves() 
	{
		Point[] movesCopy = moves.clone();
		
		return movesCopy;
	}
	
	private boolean isWinner(TicTacToe.BoardChoice player)
	{
		int winnerThreshold = 0;
		
		// Is there a 3 in a row within a row?
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[j][i] == player)
				{
					winnerThreshold++;
				}
			}
			if (winnerThreshold != 3)
			{
				winnerThreshold = 0;
			}
			else if (winnerThreshold == 3)
			{
				return true;
			}
		}
		
		// Is there a 3 in a row within a column?
		for (int i = 0; i < board[0].length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				if (board[i][j] == player)
				{
					winnerThreshold++;
				}
			}
			if (winnerThreshold != 3)
			{
				winnerThreshold = 0;
			}
			else if (winnerThreshold == 3)
			{
				return true;
			}
		}
		
		// Is there a 3 in a row diagonally? (From Top Left to Bottom Right)
		for (int i = 0; i < board.length; i++)
		{
			if (board[i][i] == player)
			{
				winnerThreshold++;
			}
		}
		if (winnerThreshold != 3)
		{
			winnerThreshold = 0;
		}
		else if (winnerThreshold == 3)
		{
			return true;
		}
		
		// Is there a 3 in a row diagonally? (From Bottom Left to Top Right)
		int j = 0; 
		for (int i = board.length - 1; i >= 0; i--)
		{
			if (board[j][i] == player)
			{
				winnerThreshold++;
			}
			j++;
		}
		if (winnerThreshold != 3)
		{
			winnerThreshold = 0;
		}
		else if (winnerThreshold == 3)
		{
			return true;
		}
		
		return false;
	}
	
	private boolean isTie()
	{
		int filledSpaces = 0;
		
		for (int i = 0; i < board[0].length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				if ((board[i][j] != BoardChoice.OPEN) && (board[i][j] != null))
				{
					filledSpaces++;
				}
			}
		}
		if (filledSpaces != 9)
		{
			return false;
		}
		else if (filledSpaces == 9)
		{
			return true;
		}
		
		return false;
	}
	
	private boolean isValid(TicTacToe.BoardChoice choosingPlayer, int row, int col)
	{
		boolean isValidPlayer = false;
		boolean isValidRow = false;
		boolean isValidCol = false;
		boolean isOpen = false;
		
		if (((choosingPlayer == BoardChoice.X) || (choosingPlayer == BoardChoice.O)) &&
				(choosingPlayer != previousPlayer))
		{
			isValidPlayer = true;
		}
		
		if (row >= 0 && row <= 2)
		{
			isValidRow = true;
		}
		
		if (col >= 0 && col <= 2)
		{
			isValidCol = true;
		}
		
		if (isValidPlayer && isValidRow && isValidCol)
		{
			if (board[row][col] == BoardChoice.OPEN)
			{
				isOpen = true;
			}
		}
		
		if (isValidPlayer && isValidRow && isValidCol && isOpen && !gameOver())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
