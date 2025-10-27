package pa;

import java.util.Scanner;

import pa.music.organizer.MusicOrganizer;

public class PlayerModoTexto {

	public static void main(String[] args) {
		MusicOrganizer m1=new MusicOrganizer();
		MusicOrganizer m2=new MusicOrganizer();
		String[] canciones= {"All I See Is You - Omnia feat. Christian Burns","Body to Body - Sture Zetterberg",
				"I Wish - Andrew Rayel","In The Dark-Armin van Armin van Buuren & David Guetta","Invincible - Christina Novelli",
				"Robarte un Beso - Carlos Vives","Save Your Tears - Ariana Grande","Secret Love Song - Little Mix ft Jason Derulo",
				"Simples Corazones - Fonseca-feat Melendi","Stay With Me - AVIRA","The Reason - Hoobastank","Vagabundo - Sebastián Yatra","With My Own Eyes - Sash"};
		m1.loadSongs("src/main/resources/mp3", ".mp3", canciones);
		Scanner s=new Scanner(System.in);
		System.out.println("Cargando las canciones en el reproductor...");
		boolean repetir=true;
		m1.printAllTitleNames();
		while (repetir) {
			System.out.println("Elija el número del tema y pulse enter");
			int opcion=-1;
			boolean entrada=true;
			while (entrada) {
				if(s.hasNextInt()) {
					opcion=s.nextInt();
					s.nextLine();
					if (opcion>=1 && opcion<=m1.getNumberOfFiles()) {
						entrada=false;
					}
					}
				else {
					s.nextLine();
				}
				System.out.println("Entrada erronea. Intente de nuevo");
			}
			System.out.println("Voy a reproducir el tema "+ opcion+". "+ m1.getTitle(opcion));
			System.out.println("Pulse para parar...");
			m1.startPlaying(opcion);
			s.nextLine();
			m1.stopPlaying();
			System.out.println("Reproductor detenido");
			System.out.println("Quiere escuchar otra canción?(s/n)");
			String respuesta=s.nextLine().toLowerCase();
			repetir=respuesta.contains("s");
		}
		s.close();
		System.out.println("Gracias por usar nuestro reproductor!!");
	}

}
