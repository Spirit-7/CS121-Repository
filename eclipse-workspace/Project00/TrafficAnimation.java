import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 0: Traffic Animation
 * 2/7/2022
 * Animates a small plane traveling above the landscape.
 *
 * @author BSU CS 121 Instructors
 * @author Joey Weston
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;
	
	private final Color BACKGROUND_COLOR = new Color(119, 173, 252);

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);
		
		// Colors
		final Color WINDOW = new Color(188, 212, 247);
		final Color BROWN_TERRAIN = new Color(206, 145, 63);
		final Color GREEN_TERRAIN = new Color(36, 125, 51);
		final Color VANILLA_CLOUD = new Color(239, 229, 188);
		final Color SEAGULL_GREY = new Color(173, 173, 173);
		final Color SEAGULL_DARKGREY = new Color(122, 122, 122);
		final Color BEAK_YELLOW = new Color(234, 211, 39);
		// Scenery
		//		Clouds
		g.setColor(VANILLA_CLOUD);
		int[] xCloudArray = new int[] {0, 0, width, width, width - width/3 + width/12, width - width/3, width - width/12, width/3, width/9, width/8};
		int[] yCloudArray = new int[] {height/6, height, height, 0, 0, height/3, height/3 + height/12, height - height/4, height/3 + height/6, height/3};
		g.fillPolygon(xCloudArray, yCloudArray, 10);
				
		//		Brown Terrain
		g.setColor(BROWN_TERRAIN);
		int[] xBTerrainArray = new int[] { 0, 0, width, width, width - width/3, width/3};
		int[] yBTerrainArray = new int[] { height - height/3, height, height, height - height/3, height - height/9, height - height/12};
		g.fillPolygon(xBTerrainArray, yBTerrainArray, 6);

		
		//		Green Terrain
		g.setColor(GREEN_TERRAIN);
		int[] xGTerrainArray = new int[] { 0, 0, width/3, width - width/3, width, width, width - width/3, width/3};
		int[] yGTerrainArray = new int[] { height - height/3, height - height/3 + height/24, height - height/12 + height/24, height, height, height - height/3, height - height/9, height - height/12};
		g.fillPolygon(xGTerrainArray, yGTerrainArray, 8);
		
		// Avatar Seagull
		int seagullXOffset = width/3 + width/8;
		int seagullW = height/25;
		int seagullH = seagullW;
		int seagullX = seagullXOffset;
		int seagullY = height/4;
		
		
		
// 		LeftWing
		g.setColor(SEAGULL_GREY);
		int[] xLeftWing = new int[] { seagullX-seagullW*3,seagullX-seagullW*2,seagullX-seagullW+seagullW/5,seagullX-seagullW,seagullX-seagullW-(seagullW*2)/3};
		int[] yLeftWing = new int[] { seagullY, seagullY, seagullY+(seagullH*2)/3+seagullH/4, seagullY+seagullH/2, seagullY-seagullH/2};
		g.fillPolygon(xLeftWing, yLeftWing, 5);
		
		// 		Tail
		g.setColor(Color.black);
		int [] xTail = new int[] { seagullX, seagullX, seagullX+seagullW};
		int [] yTail = new int[] { seagullY, seagullY+seagullH/2, seagullY};
		g.fillPolygon(xTail, yTail, 3);
		
		//		Body
		g.setColor(Color.white);
		int[] xBody = new int[] { seagullX-seagullW-seagullW/4, seagullX-seagullW-seagullW/2+seagullW/5, seagullX, seagullX };
		int[] yBody = new int[] { seagullY+seagullH/2, seagullY+seagullH, seagullY+seagullH/2, seagullY};
		g.fillPolygon(xBody, yBody, 4);
		
		//		Head 
		g.setColor(BEAK_YELLOW);
		int[] xBeak = new int[] { seagullX-seagullW-seagullW/2+seagullW/5, seagullX-seagullW-seagullW/4-seagullW/16, seagullX-seagullW};
		int[] yBeak = new int[] { seagullY+seagullH, seagullY+(seagullH*3)/4, seagullY+(seagullH*29)/32};
		g.fillPolygon(xBeak, yBeak, 3);
		
		g.setColor(Color.black);
		g.fillOval(seagullX-seagullW, seagullY+seagullH/2, seagullW/8, seagullH/8);
		
		//		RightWing
		g.setColor(SEAGULL_GREY);
		int[] xRightWing = new int[] { seagullX-seagullW/2, seagullX-seagullW/2, seagullX-seagullW/2 + seagullW, seagullX-seagullW/2 + seagullW/8, seagullX-seagullW/2 + seagullW/7};
		int[] yRightWing = new int[] { seagullY+(seagullH*18)/24, seagullY-seagullH, seagullY-seagullH-seagullH/4, seagullY-seagullH+seagullH/8, seagullY+(seagullH*17)/24};
		g.fillPolygon(xRightWing, yRightWing, 5);
		
		// 		RightWingShadow
		g.setColor(SEAGULL_DARKGREY);
		int[] xRightWingShadow = new int[] { seagullX-seagullW/2 + seagullW/7, seagullX-seagullW/2 + seagullW/8, seagullX, seagullX};
		int[] yRightWingShadow = new int[] { seagullY+(seagullH*17)/24, seagullY-seagullH+seagullH/8, seagullY-seagullH-seagullH/8+seagullH/12, seagullY+seagullH/2};
		g.fillPolygon(xRightWingShadow, yRightWingShadow, 4);
		
		// Text!
		g.setColor(Color.black);
		String text = "FLIGHT";
		
		g.drawString(text, width/2-seagullW, height/8);
		
		// Calculate the new xOffset position of the moving object.
		xOffset  = ((xOffset + stepSize) % (width + (width / 2)));

		// This draws a green square. Replace it with your own object.
		int planeW = height/10;
		int planeH = planeW; 
		int planeX = xOffset - (width/4);
		int planeY = height/2;
		
		int mainWingH = planeH * (5/2);
		int mainWingY = planeY + (planeH) / 6 - mainWingH / 2;
		
		int planeBodyW = planeW * 4;
		int planeBodyX = planeX - planeBodyW / 2;
		int planeBodyY = planeY - planeH / 2;
		
		int planeMidY = planeY + planeH / 4;
		
		int planeBackWingH = planeH * (3/2);
		int planeBackWingY = planeY + (planeH) / 6 - planeBackWingH / 2;
		int planeBackWingX = planeBodyX - planeW / 2;
		
		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen
		
		// Plane
		// 		Plane Landing Gear
		g.setColor(Color.black);
		g.fillOval(planeX - planeW / 4 + planeW, mainWingY, planeW / 2, planeH / 2);
		g.fillOval(planeX - planeW / 4 + planeW, mainWingY + mainWingH - planeH/2, planeW / 2, planeH / 2);
		g.fillOval(planeBackWingX - planeW / 4 + planeW, planeMidY, planeW / 2, planeH / 2);
		
		// 		Plane Main Wings
		g.setColor(Color.white);
		g.fillRect(planeX, mainWingY, planeW, mainWingH);
		g.fillOval(planeX, mainWingY + mainWingH - planeH, planeW, planeH * 2);
		g.fillOval(planeX, mainWingY - planeH, planeW, planeH * 2);
		
		// 		Plane Body
		g.setColor(Color.white);
		g.fillRect(planeBodyX, planeBodyY, planeBodyW, planeH);
		g.fillOval(planeBodyX - planeW + planeBodyW, planeBodyY, planeW * 2, planeH);
		g.setColor(Color.black);
		g.drawLine(planeX, planeMidY, planeX + (planeW), planeMidY);
		
		// 		Plane Body Windows
		g.setColor(WINDOW);
		g.fillRect(planeBodyX + planeW/2 + planeW * 0 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 1 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 2 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 3 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 4 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 5 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 6 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 7 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 8 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 9 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 10 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 11 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 12 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 13 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 14 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 15 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 16 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 17 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 18 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 19 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 20 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 21 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 22 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 23 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 24 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 25 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 26 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 27 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		g.fillRect(planeBodyX + planeW/2 + planeW * 28 / 8, planeMidY - planeH / 4, planeW/12 , planeH/6);
		
		g.fillRect(planeBodyX + planeW/2 + planeW * 30/8, planeMidY - planeH / 4, planeW/2 , planeH/6);
		
		// 		Plane Back Wings
		g.setColor(Color.white);
		g.fillRect(planeBackWingX, planeBackWingY, planeW, planeBackWingH);
		g.fillOval(planeBackWingX, planeBackWingY + planeBackWingH - planeH, planeW, planeH * 2);
		g.fillOval(planeBackWingX, planeBackWingY - planeH, planeW, planeH * 2);
		g.setColor(Color.black);
		g.drawArc(planeBackWingX, planeBodyY, planeW * 2, (planeH*3)/2, 90, 90);
		g.drawLine(planeBackWingX, planeMidY, planeBackWingX + planeW, planeMidY);
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
