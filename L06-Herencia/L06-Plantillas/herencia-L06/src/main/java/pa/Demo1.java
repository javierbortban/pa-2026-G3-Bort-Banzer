package pa;

import pa.network.MessagePost;
import pa.network.NewsFeed;
import pa.network.Post;

public class Demo1 {

	public static void main(String[] args) {
		Post p = new Post("Javierin");
        for (int i = 0; i < 17; i++) p.like();
        for (int i = 0; i < 13; i++) p.unlike();
        for (int i = 0; i < 5; i++) p.addComment("Comentario genérico " + (i + 1));
        MessagePost m=new MessagePost("Javier","que pasa calabazin");
        for (int i = 0; i < 17; i++){
        	m.like();
        	}
        for (int i = 0; i < 13; i++) {
        	m.unlike();
        }
        for (int i = 0; i < 5; i++) {
        	m.addComment("Comentario genérico " + (i + 1));
        }
        NewsFeed n=new NewsFeed();
        n.addPost(m);
        n.addPost(p);
        n.show();
        

	}

}
