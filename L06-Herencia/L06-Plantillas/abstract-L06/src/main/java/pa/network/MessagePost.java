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
    	System.out.println(username);
        System.out.println("Text Message: " + message);
        System.out.println(timeString(timestamp));

        if (comments.isEmpty()) {
            System.out.println("   No comments.");
        } else {
            System.out.println("   " + comments.size() + " comment(s).");
            for (String c : comments) {
                System.out.println("   Anónimo dice :" + c);
            }
        }
        System.out.println();
    }
    
}
