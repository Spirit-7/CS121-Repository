import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Lesson 11: Activity - for Loops
 * Uses nested for loops to draw a checkerboard
 * @author CS121 Instructors
 * @version Spring 2022 
 * @author Joey Weston  
 */
@SuppressWarnings("serial")
public class CheckerBoard extends JPanel
{
	private static final int NUM_ROWS = 8;
	private static final int NUM_COLS = 8;

	/**
	 * Sets the initial dimensions of the panel. 
	 */
	public CheckerBoard()
	{
		setPreferredSize(new Dimension(500, 500));
	}

	/**
	 *  Draws the checker board.
	 *  @param page Graphics context
	 */
	public void paintComponent(Graphics page)
	{
		int width = getWidth();
		int height = getHeight();

		int boxWidth = (int) Math.ceil((double) width/NUM_COLS);
		int boxHeight = (int) Math.ceil((double) height/NUM_ROWS);
		
		int currentRow;
		int currentCol;
		int numBox = 1;
		for (currentRow = 0; currentRow < NUM_ROWS; ++currentRow)
		{
			for (currentCol = 0; currentCol < NUM_COLS; ++currentCol)
			{
				if ((numBox % 2) == 1)
				{
					page.setColor(Color.RED);
				}
				else
				{
					page.setColor(Color.BLACK);
				}
				page.fillRect(boxWidth * currentCol, boxHeight * currentRow, boxWidth, boxHeight);
				++numBox;
			}
			++numBox;
		}
	}

	/**
	 * Creates the main frame of the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Checker Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckerBoard panel = new CheckerBoard();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
