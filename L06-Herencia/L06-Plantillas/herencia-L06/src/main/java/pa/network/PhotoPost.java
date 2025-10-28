package pa.network;


/**
 * This class stores information about a post in a social network. 
 * The main part of the post consists of a photo and a caption. 
 * Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class PhotoPost extends Post 
{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption

    /**
     * Constructor for objects of class PhotoPost.
     * 
     * @param author    The username of the author of this post.
     * @param filename  The filename of the image in this post.
     * @param caption   A caption for the image.
     */
    public PhotoPost(String username, String filename, String caption)
    {
        super(username);
        this.filename = filename;
        this.caption = caption;
    }

    
    /**
     * Return the file name of the image in this post.
     * 
     * @return The post's image file name.
     */
    public String getImageFile()
    {
        return filename;
    }

    /**
     * Return the caption of the image of this post.
     * 
     * @return The image's caption.
     */
    public String getCaption()
    {
        return caption;
    }

    

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
    	System.out.println("Message author: "+username);
        System.out.println("Message content: "+filename+""+ caption);
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
