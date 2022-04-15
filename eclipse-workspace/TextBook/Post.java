import java.io.*;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Post.java
 * This class allows for the creation of a
 * Post object. These objects' information is 
 * stored in a file which the TextBook class then
 * reads in order to return information to the 
 * user
 * @author Joey Weston
 * 4/1/2022
 * CS 121 Section 004 - Sarah Frost
 */
public class Post implements PostInterface
{
	private String author;
	private String text;
	private Instant timestamp;
	private int postID;
	
	private DecimalFormat postIDPattern = new DecimalFormat("00000");
	
	private ArrayList<Comment> comments = new ArrayList<Comment>();

	/**
	 * New Post Constructor - makes a completely new Post object 
	 * with attributes such as:
	 * @param newPostID - postID in order to properly name
	 * the Post object
	 * @param postAuthor - the one-word name of the user who
	 * made the comment
	 * @param postText - the actual text of the post
	 * @throws FileNotFoundException
	 */
	public Post(int newPostID, String postAuthor, String postText) throws FileNotFoundException
	{
		timestamp = Instant.now();
		postID = newPostID;
		author = postAuthor;
		text = postText;
		
		File post = new File("Post-" + postIDPattern.format(postID) + ".txt");
		PrintWriter filer = new PrintWriter(post);
		
		String fileText = "";
		fileText = fileText + postIDPattern.format(postID) + " " + timestamp.toString()+  " " + author + " " + text;
		
		filer.write(fileText);
		
		filer.close();
	}
	/**
	 * Post Recovery Constructor - makes a new Post object using
	 * an old Post objects information previously stored in a file
	 * @param newPostID - postId in order to name and find the
	 * Post object's information stored in a file
	 */
	public Post(int newPostID)
	{
		try 
		{
			postID = newPostID;
	
			File post = new File("Post-" + postIDPattern.format(postID) + ".txt");
			
			Scanner filer = new Scanner(post);
			
			filer.next();
			
			timestamp = Instant.parse(filer.next());
			author = filer.next();
			text = filer.nextLine();
			
			while (filer.hasNextLine())
			{
				Instant commentTimestamp = Instant.parse(filer.next());
				String commentAuthor = filer.next();
				String commentText = filer.next() + filer.nextLine();
				
				Comment comment = new Comment(commentTimestamp, commentAuthor, commentText);
				comments.add(comment);
			}
			
			filer.close();
		}
		catch (FileNotFoundException ex) 
		{
			System.out.println("That file cannot be opened or doesn't exist!");
		}
		
	}
	/**
	 * Allows for the creation of a new comment which is then
	 * appended to the end of the post's file.
	 * The comment has attributes such as:
	 * @param commentAuthor - the one-word name of the user who
	 * made the comment
	 * @param commentText - the actual text of a comment
	 */
	@Override
	public void addComment(String commentAuthor, String commentText)
	{
		try
		{
		Instant commentTimestamp = Instant.now();
		
		FileWriter filer = new FileWriter(getFilename(), true);
		
		String fileText = "";
		fileText = "\n" + commentTimestamp.toString() + " " + commentAuthor + " " + commentText;
		
		filer.write(fileText);
		filer.close();
		
		Comment comment = new Comment(commentTimestamp, commentAuthor, commentText);
		comments.add(comment);
		}
		catch (IOException ex)
		{
			
		}
	}
	
	/**
	 * Checks to see if the Post object has any null attributes
	 * and also has a file for this post.
	 */
	@Override
	public boolean isValid() 
	{
		boolean isAuthorNull = author != null;
		boolean isTextNull = text != null;
		boolean isTimestampNull = timestamp != null;
		boolean isPostIDNull = postID != 0;
		
		File post = new File(getFilename());
		boolean doesPostExist = post.isFile();
		
		if (isAuthorNull && isTextNull && isTimestampNull && isPostIDNull && doesPostExist)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns the attributes of the Post 
	 * (and any comments appended to the post's file) 
	 * into a string in order to be displayed or saved in a file.
	 */
	public String toString()
	{
		int numComments = comments.size() - 1;
		String returnText = "";
		
		returnText = returnText + postIDPattern.format(postID) + " " + timestamp.toString() + " " + author + " " + text;
		for (int i = 0; i <= numComments; i++)
		{
		returnText = returnText + "\n\t" + comments.get(i);
		}
		
		return returnText;
	}
	
	/**
	 * Returns the attributes of the Post into a string
	 * in order to be displayed or saved in a file.
	 */
	@Override
	public String toStringPostOnly() 
	{
		String returnText = "";
		
		returnText = returnText + postIDPattern.format(postID) + " " + timestamp.toString() + " " + author + " " + text;
		
		return returnText;
	}
	
	/**
	 * Returns the file name in which the Post's
	 * information is stored.
	 */
	@Override
	public String getFilename() 
	{
		String text = "Post-" + postIDPattern.format(postID) + ".txt";
		
		return text;
	}
	
	/**
	 * Returns the postID of this particular
	 * Post object.
	 */
	@Override
	public int getPostID() 
	{
		return postID;
	}
	
	/**
	 * Returns the text of this particular
	 * Post object.
	 */
	@Override
	public String getText()
	{
		return text;
	}

	/**
	 * Returns the timestamp of this particular
	 * Post object
	 */
	@Override
	public Instant getTimestamp() 
	{
		return timestamp;
	}

	/**
	 * Returns the author of this particular
	 * Post object
	 */
	@Override
	public String getAuthor() 
	{
		return author;
	}
	
}
