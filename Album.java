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

    //adicionando uma música ao álbum
    public void addSong(String name, int duration) {
        albumList.add(new Song(name, duration));
        System.out.println("new song " + name + ": " + duration + "s" + " added to album " + this.name);

    }

    public void getSongsFromInside() {

        for (int i = 0; i < this.albumList.size(); i++) {
            System.out.println("    " + this.albumList.get(i).getName());
        }


    }


//é assim chamado foreach usando a palavra-chave for. Apenas aprenda esta sintaxe.
  // A coleção this.songs será iterada, cada elemento será Song e 
  //será colocado na variável checkedSong. O próprio sinal de cólon não tem um significado especial, 
  //é uma parte inseparável do foreach, 
  //assim como os ponto-e-vírgulas são parte inseparável de um fórum comum.
    private Song findSong(String name) {
    	int o = 3; //PARAMOS AQUI PQ NÃO TAVA ENTRANDO NO ÁLBUM PRA PERCORRER AS MÚSICAS
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