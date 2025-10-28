package pa;

import pa.network.MessagePost;
import pa.network.NewsFeed;
import pa.network.PhotoPost;

public class Demo1 {

	public static void main(String[] args) {
		MessagePost m1=new MessagePost("Javier","que pasa calabaza");
		for(int i=0;i<18;i++) {
			m1.like();
		}
		for(int i=0;i<25;i++) {
			m1.unlike();
		}
		for (int i=0;i<7;i++) {
			m1.addComment("comentario nº"+ i);
		}
		PhotoPost p1=new PhotoPost("Juan", "[src/main/resources/imagenes/leopardo.jpeg]","Leopardo enfadado");
		for(int i=0;i<35;i++) {
			p1.like();
		}
		for(int i=0;i<4;i++) {
			p1.unlike();
		}
		for (int i=0;i<10;i++) {
			p1.addComment("comentario nº"+ i);
		}
		
		NewsFeed n= new NewsFeed();
		n.addMessagePost(m1);
		n.addPhotoPost(p1);
		n.show();

	}

}
