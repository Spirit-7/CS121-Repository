import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * TextBook.java
 * This is the TextBook class which is the
 * primary class when this program is ran.
 * This class allows the creation of a 
 * TextBook object which then holds a list of
 * posts objects.
 * @author Joey Weston
 * 4/1/2022
 * CS 121 Section 004 - Sarah Frost
 */
public class TextBook implements TextBookInterface
{
	private int lastID;
	private ArrayList<Post> posts;
	
	/**
	 * Creates the TextBook object with new attributes
	 * or creates the TexBook object with recovered
	 * attributes from the saved post list file
	 */
	public TextBook()
	{
		try
		{
			int postID;
			
			posts = new ArrayList<Post>();
			
			Scanner filer = new Scanner(new File(TextBookInterface.POST_LIST_FILENAME));
			try
			{
				filer.nextLine();
			}
			catch (NoSuchElementException ex)
			{
				lastID = 0;
			}
			
			while (filer.hasNextLine())
			{
				postID = filer.nextInt();
				if (lastID < postID)
				{
					lastID = postID;
					Post newPost = new Post(lastID);
					posts.add(newPost);
				}
				else
				{
					try 
					{
						filer.nextLine();
					}
					catch (NoSuchElementException ex)
					{
						
					}
				}
				
			}
			filer.close();
		
		}
		catch (FileNotFoundException ex)
		{
			lastID = 0;
		}
	}

	/**
	 * Returns the lastID of this particular
	 * TextBook object.
	 * The lastID is the largest postID in this
	 * TextBook object.
	 */
	@Override
	public int getLastID() 
	{
		return lastID;
	}

	/**
	 * Returns the amount of posts in this
	 * particular TextBook object
	 */
	@Override
	public int getPostCount() 
	{
		return posts.size();
	}

	/**
	 * Returns the attributes of the Post
	 * (specified by the index)
	 * into a string in order to be displayed or saved in a file.
	 * @param index - the index of the post wanted to be
	 * turned into a string. The index can be found using
	 * the method toString()
	 */
	@Override
	public String getPostString(int index) 
	{
		int size = posts.size();
		if (index < size && index >= 0)
		{
			return posts.get(index).toString();
		}
		else 
		{
			System.out.println("The index entered was invalid...");
			return null;
		}
	}

	/**
	 * Returns whether or not a post was successfully
	 * created and added to the TextBook Object.
	 * @param author - the one-word name of the user who
	 * is making the post.
	 * @param text - the actual text of a post.
	 */
	@Override
	public boolean addPost(String author, String text) 
	{
		
		try 
		{
			lastID++;
			
			Post newPost = new Post(lastID, author, text);
			posts.add(newPost);
			
			FileWriter filer = new FileWriter(TextBookInterface.POST_LIST_FILENAME, true);
			filer.write("\n" + lastID);
			filer.close();
			
			System.out.println("Success! Post made!");
			return true;
		} 
		catch (IOException ex) 
		{
			System.out.println("Unable to make new Post.");
			return false;
		}
		
	}

	/**
	 * Returns the post that is removed from
	 * the TextBook Object and TextBook posts file
	 * @param index - the index of the post wanted to be
	 * removed. The index can be found using
	 * the method toString().
	 */
	@Override
	public Post removePost(int index) 
	{	
		int size = posts.size();
			if (index < size && index >= 0)
			{	
				String text = "";
				Post post = posts.get(index);
				
				try 
				{
					Scanner filerScanner;
					filerScanner = new Scanner(new File(TextBookInterface.POST_LIST_FILENAME));
				
					filerScanner.nextLine();
					
					for (int i = 0; i != index; i++)
					{
						text = text + "\n" + filerScanner.nextLine();
					}
					
					filerScanner.nextLine();
					
					for (int i = index + 1; i < posts.size(); i++)
					{
						text = text + "\n" + filerScanner.nextLine();
					}
					
					filerScanner.close();
				} 
				catch (FileNotFoundException e)
				{
					
				}
				
				try 
				{
					PrintWriter filerWriter = new PrintWriter(new File(TextBookInterface.POST_LIST_FILENAME));
					
					filerWriter.write(text);
					
					filerWriter.close();
				} 
				catch (FileNotFoundException ex)
				{
					
				}
				
				posts.remove(index);
				
				System.out.println("Success! Post deleted");
				return post;
				
			}
			else
			{
				System.out.println("The index entered was invalid...");
				return null;
			}
	}

	/**
	 * Returns whether or not a comment was successfully
	 * created and added to the post Object.
	 * @param postIndex - the index of the post wanted to be
	 * commented on. The index can be found using
	 * the method toString().
	 * @param author - the one-word name of the user who
	 * is making the comment.
	 * @param text - the actual text of a comment.
	 */
	@Override
	public boolean addComment(int postIndex, String author, String text) 
	{
		int size = posts.size();
		if (postIndex < size && postIndex >= 0)
		{
			posts.get(postIndex).addComment(author, text);
			
			System.out.println("Success! Comment made!");
			return true;
		}
		else
		{
		System.out.println("Unable to make new comment."
				+ "\nThe index entered was invalid...");
		return false;
		}
	}

	/**
	 * Returns an ArrayList of all the Posts added to
	 * the TextBook object.
	 */
	@Override
	public ArrayList<Post> getPosts() 
	{
		ArrayList<Post> returnPosts = new ArrayList<Post>();
		
		returnPosts.addAll(posts);
		
		return returnPosts;
	}
	
	public String toString()
	{
		String text = "TextBook contains " + posts.size() + " posts:\n";
		
		for (int i = 0; i < posts.size(); i++)
		{
			text = text + i + " - ";
			text = text + posts.get(i).toStringPostOnly();
			text = text + "\n";
		}
		
		return text;
	}

}
