package pa;

import pa.network.MessagePost;
import pa.network.NewsFeed;
import pa.network.PhotoPost;

public class Demo1 {

	public static void main(String[] args) {
		// 1) Roberto, PhotoPost, tigre, sin comentarios
        PhotoPost p1 = new PhotoPost(
            "Roberto",
            "src/main/resources/imagenes/tigre.jpeg",
            "Imagen de un tigre"
        );

        // 2) Clara, PhotoPost, leopardo, 1 comentario
        PhotoPost p2 = new PhotoPost(
            "Clara",
            "src/main/resources/imagenes/leopardo.jpeg",
            "Os gusta este leopardo?"
        );
        p2.addComment("Qué chulo!!");

        // 3) Aitor, PhotoPost, guepardo, 20 likes, sin comentarios
        PhotoPost p3 = new PhotoPost(
            "Aitor",
            "src/main/resources/imagenes/guepardo.jpeg",
            "Este es mi guepardo"
        );
        for (int i = 0; i < 20; i++) p3.like();

        // 4) Gloria, MessagePost, 2 comentarios
        MessagePost m1 = new MessagePost("Gloria", "Me gustó la peli de anoche");
        m1.addComment("A mi también");
        m1.addComment("Pues a mí no");

        // NewsFeed
        NewsFeed nf = new NewsFeed();
        nf.addPost(p1);
        nf.addPost(p2);
        nf.addPost(p3);
        nf.addPost(m1);

        nf.show();
    }

}
