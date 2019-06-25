package testeSpotify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Album {
    LinkedList<Song> albumList = new LinkedList<>();
    private String name;
    private String artist;

    // construtor Album
    public Album(String name, String artist) {
        this.artist = artist;
        this.name = name;
        System.out.println("New album added");
    }

    public LinkedList<Song> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(LinkedList<Song> albumList) {
        this.albumList = albumList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //adicionando uma m�sica ao �lbum
    public void addSong(String name, int duration) {
        albumList.add(new Song(name, duration));
        System.out.println("new song " + name + ": " + duration + "s" + " added to album " + this.name);

    }

    public void getSongsFromInside() {

        for (int i = 0; i < this.albumList.size(); i++) {
            System.out.println("    " + this.albumList.get(i).getName());
        }


    }


//� assim chamado foreach usando a palavra-chave for. Apenas aprenda esta sintaxe.
  // A cole��o this.songs ser� iterada, cada elemento ser� Song e 
  //ser� colocado na vari�vel checkedSong. O pr�prio sinal de c�lon n�o tem um significado especial, 
  //� uma parte insepar�vel do foreach, 
  //assim como os ponto-e-v�rgulas s�o parte insepar�vel de um f�rum comum.
    private Song findSong(String name) {
    	int o = 3; //PARAMOS AQUI PQ N�O TAVA ENTRANDO NO �LBUM PRA PERCORRER AS M�SICAS
    	int i=0;
        for (Song checkedSong : this.albumList) {
        	System.out.println(this.albumList.size() + "elemento_album ");
        	//for(Song checkedSong2; i<=o ; i++)  {
        		if (checkedSong.getName().equals(name)) {
                    System.out.println(getName());
        			return checkedSong;
                }	
        	//}
            
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.albumList.size())) {

            playlist.add(this.albumList.get(index));
            return true;

        }
        System.out.println("this album does not contain track no: " + trackNumber);
        return false;
    }


    //LinkedList<Song> playlist
    public boolean addToPlaylist(String songTittle, LinkedList<Song> playlist) {
        Song checkedSong = findSong(songTittle);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            System.out.println("Song " + songTittle + " added to playlist");
            return true;
        }
        System.out.println("Can not find song");
        return false;
    }

}