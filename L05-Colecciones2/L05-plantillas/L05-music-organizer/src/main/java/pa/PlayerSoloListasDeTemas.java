package pa;

import pa.music.organizer.MusicOrganizer;

public class PlayerSoloListasDeTemas {

	public static void main(String[] args) {
		System.out.println("Inicializamos nuestro organizador de música...");
		MusicOrganizer m1=new MusicOrganizer();
		String[] titles= {"tema1A","tema2B","tema3A","tema4B","tema5A","tema6B","tema7B"};
		m1.loadSongs("mp3/album1", ".mp3", titles);
		m1.printAllTitleNames();
		m1.printAllFileNames();
		m1.printTitleName(3);
		m1.printTitleName(-1);
		m1.printTitleName(8);
		m1.addSong("mp3/album_NUEVO", ".mp3", "tema1C");
		System.out.println("Borramos las canciones que contienen \"B\"");
		for (int index=m1.getNumberOfFiles();index>=1;index--) {
			if(m1.getFiles().get(index-1).contains("B")) {
				m1.removeSong(index);
			}
		}
		m1.printAllTitleNames();
		m1.printAllFileNames();
		
	
	}

}
