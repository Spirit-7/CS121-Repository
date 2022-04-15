import java.util.Scanner;
/**
 * TextBookDriver.java
 * This was the main method of this project.
 * This was used to write code so the user can
 * interact with the TextBook social media platform
 * through the menu printed within the console.
 * @author Joey Weston
 * 4/1/2022
 * CS 121 Section 004 - Sarah Frost
 */
public class TextBookDriver {

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Hello! Welcome to TextBook!");
		System.out.print("Please input your login name: ");
		String user = kb.next();
		kb.nextLine();
		System.out.println("\nThank you!");
		TextBook main = new TextBook();
		System.out.println("\nTexbook Menu");
		
		final String DIVIDER = "==============================";
		
		String menu = DIVIDER;
		menu = menu + "\n(P)rint TextBook posts.";
		menu = menu + "\n(A)dd a new post.";
		menu = menu + "\n(D)elete a post.";
		menu = menu + "\n(C)omment on a post.";
		menu = menu + "\n(R)ead a post with comments.";
		menu = menu + "\n(Q)uit.";
		menu = menu + "\n" + DIVIDER;
		
		System.out.println(menu);
		
		String input = "";
		while (!input.equalsIgnoreCase("Q"))
		{
			System.out.println("\nPlease select a menu option or reprint the (M)enu: ");
			
			input = kb.next();
			
			String text;
			int index;
			
			switch (input)
			{
				case "P":
				case "p":
					System.out.println(main.toString());
					break;
				case "A":
				case "a":
					System.out.println("\nPlease enter your post's text: ");
					
					text = kb.next() + kb.nextLine();
					
					main.addPost(user, text);
					break;
				case "D":
				case "d":
					System.out.println("Please enter the index of the post you wish to delete: ");
					index = kb.nextInt();					
					main.removePost(index);
					break;
				case "C":
				case "c":
					System.out.println("Please enter the index of the post you wish to comment on: ");
					index = kb.nextInt();
					System.out.println("Please enter your comment's text: ");
					text = kb.next() + kb.nextLine();
					
					main.addComment(index, user, text);
					break;
				case "R":
				case "r":
					System.out.println("Please enter the index of the post you wish to read: ");
					index = kb.nextInt();
					if (!(main.getPostString(index) == null))
					{
						System.out.println(main.getPostString(index));
					}
					break;
				case "Q":
				case "q":
					System.out.println("Goodbye " + user + "!");
					System.out.println("Quitting...");
					break;
				case "M":
				case "m":
					System.out.println(menu);
					break;
				default:
					System.out.println("Invalid input... Please Try again.");
					break;
			}
		}
		kb.close();
	}

}
