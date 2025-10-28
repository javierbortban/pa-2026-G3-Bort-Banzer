package pa.network;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Post {
	protected String username;
	protected long timestamp;
	protected int likes;
	protected ArrayList<String> comments;
	
	public Post(String username) {
		this.username=username;
		this.timestamp = System.currentTimeMillis();
        this.likes = 0;
        this.comments = new ArrayList<>();
	}
	/**
     * Incrementa en 1 el número de likes
     */
    public void like() {
        likes++;
    }

    /**
     * Decrementa en 1 el número de likes (puede ser negativo)
     */
    public void unlike() {
        likes--;
    }

    /**
     * Añade un comentario
     * @param text contenido del comentario
     */
    public void addComment(String text) {
        comments.add(text);
    }
    
    public String getTimeStamp()
    {
        String date = new SimpleDateFormat("H:mm:ss").format(new Date(timestamp));
        return date;
    }
    /**
     * Devuelve el tiempo transcurrido desde la creación
     */
    protected String timeString(long time) {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;
        long seconds = pastMillis / 1000;
        long minutes = seconds / 60;

        if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }

    public abstract void display();
	
}
