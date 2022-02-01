import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;


/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author Joey Weston
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		// TODO: 1. Instantiate a new Point object called "anchor". Use "mid" as your x value and
		//       "top" as your y value.  ~ DONE
		Point anchor = new Point(mid, top);
		// TODO: 2. Instantiate a new MiniFig object and give the reference variable a name of a person, 
		//       such as "bob". Use the MiniFig constructor with the following
		//       parameters: MiniFig(g, scaleFactor, anchor)  ~ DONE
		MiniFig raul = new MiniFig(g, scaleFactor, anchor);
		// TODO: 3. Create a new custom Color object. An example is shown below.
		Color coolPurple = new Color(100, 21, 173);
		// TODO: 4. Invoke the setTorsoColor(Color color) method on your MiniFig instance.
		//       Use your color object as a parameter to change the shirt color.
		//       This lets you change the color of "bob's" shirt. :)  ~ DONE
		raul.setTorsoColor(coolPurple);
		// TODO: 5. Invoke the draw() method on your MiniFig instance. This is where "bob" is displayed on the screen.  ~ DONE
		//raul.draw(); test1 yo did you get this?
		// TODO: 6. Adjust the size of your Avatar's window. Notice how the avatar does not stay grounded
		//       on the grass. To fix this, use the getBaseMidPoint() method to find the the base mid point of your
		//       MiniFig. This method returns a Point object that represents the x,y coordinates at the
		//       base of the MiniFig, right between its feet. 
		//       Replace the hard-coded value of grassYOffset with the y value 
		//       of the returned point. ~ Done
		Point baseMidPoint = raul.getBaseMidPoint();
		int grassYOffset = baseMidPoint.y;
		
		Color grassGreen = new Color (60,80,38);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);

		// TODO: 7. Create an Alias of for your MiniFig object and change the torso color of the alias.
		//       If in step 2 you used the variable name "bob", you can create an alias named "robert"
		//       using the following:
		//       MiniFig robert = bob;
		//       robert.setTorsoColor(Color.RED); ~ Done
		MiniFig capRaul = raul;
		capRaul.setTorsoColor(Color.BLUE);
	    // TODO: 8. Comment out the draw statement under TODO item 5 and then draw the original MiniFig 
		//       below. If you used the variable name "bob" is would simply be the following:
		//       bob.draw();
		//       What color is Bob's Shirt?  Why? 
		//	     Raul's shirt is blue because you aren't creating a copy of Raul when instantiating capRaul,
		//       instead you are just giving Raul another name, another address.
		//       Any changes done to capRaul are done to Raul because they are the same object. ~ Done
		raul.draw();
		
		//       Activity05 code:
		// 		 Object in hand: Wooden Staff
		
		Color wood = new Color(120, 76, 19);
		g.setColor(wood);
		int staffWidth =  (int) (20 * scaleFactor);
		int staffHeight = (int) (300 * scaleFactor);
		
		g.fillRect(raul.getRightHandCenterPoint().x - (staffWidth / 2), baseMidPoint.y - staffHeight, staffWidth, staffHeight);
		
		//  	 Object in background: Tree
		//       Tree Trunk
		int trunkWidth = (int) (50 * scaleFactor);
		int trunkHeight = (int) (250 * scaleFactor);
		g.fillRect(7 * currentWidth / 8, grassYOffset - trunkHeight, trunkWidth, trunkHeight);
		//       Tree Leaves
		g.setColor(Color.GREEN);
		int leavesWidth = (int) (250 * scaleFactor);
		int leavesHeight = (int) (200 * scaleFactor);
		Point leavesCenterPoint = new Point((7 * currentWidth / 8) + trunkWidth / 2, grassYOffset - trunkHeight);
		g.fillOval(leavesCenterPoint.x - (leavesWidth / 2), leavesCenterPoint.y - (leavesHeight / 2), leavesWidth, leavesHeight);
		
		//       Object on head: TopHat
		g.setColor(Color.BLACK);
		//       Main Hat Cylinder
		int hatWidth = raul.getFaceWidth();
		int hatHeight = raul.getFaceHeight();
		//       Hat Rim
		int hatRimWidth = (int) (150 * scaleFactor);
		int hatRimHeight = (int) (20 * scaleFactor);
		g.fillOval(raul.getCapPoint().x - (hatRimWidth / 2), raul.getCapPoint().y - (hatRimHeight / 2), hatRimWidth, hatRimHeight);
		g.fillRect(raul.getCapPoint().x - (hatWidth / 2), raul.getCapPoint().y - hatHeight, hatWidth, hatHeight);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MyAvatar()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}