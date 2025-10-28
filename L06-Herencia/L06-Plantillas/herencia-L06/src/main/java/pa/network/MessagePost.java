package pa.network;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class stores information about a post in a social network. 
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class MessagePost extends Post
{
    private String message;   // an arbitrarily long, multi-line message

    /**
     * Constructor for objects of class MessagePost.
     * 
     * @param author    The username of the author of this post.
     * @param text      The text of this post.
     */
    public MessagePost(String username, String text)
    {
    	super(username);
        message = text;
        
    }


    public String getText()
    {
        return message;
    }
    
    @Override 
    public void display()
    {
        System.out.println("Message author: "+username);
        System.out.println("Message content: "+message);
        System.out.print("Message date: "+timeString(timestamp));
        if (likes>0) {
            System.out.println("  -  "+likes+ " people like this");
            }
        if (comments.isEmpty()) {
            System.out.println("No comments.");
            }
            else if (comments.size()>0) {
            	int iteradorindex=1;
            	for(String comment:comments){
            		System.out.println(iteradorindex+". "+comment);
            		iteradorindex++;	
            	}
            }
    }
    
}
