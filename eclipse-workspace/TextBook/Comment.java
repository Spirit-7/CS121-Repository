import java.time.Instant;
/**
 * Comment.java
 * This class allows for the creation of Comment
 * objects that can be attached under Posts in a
 * Post's save file. 
 * @author Joey Weston
 * 4/1/2022
 * CS 121 Section 004 - Sarah Frost
 */
public class Comment 
{
	private Instant timestamp;
	private String author;
	private String text;
	/**
	 * Creates a Comment object with attributes such as:
	 * a timestamp - the date of when the comment was made
	 * @param commentAuthor - the one-word name of the user who
	 * made the comment
	 * @param commentText - the actual text of a comment
	 */
	public Comment(String commentAuthor, String commentText)
	{
		timestamp = Instant.now();
		author = commentAuthor;
		text = commentText;
	}
	/**
	 * Creates a Comment object with attributes such as:
	 * @param commentTimestamp - the date of when the comment
	 * was made
	 * @param commentAuthor - the one-word name of the user who
	 * made the comment
	 * @param commentText - the actual text of a comment
	 */
	public Comment(Instant commentTimestamp, String commentAuthor, String commentText)
	{
		timestamp = commentTimestamp;
		author = commentAuthor;
		text = commentText;
	}
	/**
	 * Transforms the attributes of the comment into a string
	 * in order to be displayed or saved in a file.
	 */
	public String toString()
	{
		String returnText = "";
		
		returnText = returnText + timestamp.toString() + " " + author + " " + text; 
		
		return returnText;
	}
}
