package testeSpotify;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Playlist {
    LinkedList<Song> playlistList = new LinkedList<>();
    private String name;
    private String artist;

    // construtor playlist
    public Playlist(String name, String artist) {
        this.artist = artist;
        this.name = name;
        System.out.println("New playlist added");
    }

    public LinkedList<Song> getplaylistList() {
        return playlistList;
    }

    public void setplaylistList(LinkedList<Song> playlistList) {
        this.playlistList = playlistList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //dodawanie piosenki do playlistu
    public void addSong(String name, int duration) {
        playlistList.add(new Song(name, duration));
        System.out.println("new song " + name + ": " + duration + "s" + " added to playlist " + this.name);

    }

    public void getSongsFromInside() {

        for (int i = 0; i < this.playlistList.size(); i++) {
            System.out.println("    " + this.playlistList.get(i).getName());
        }


    }

    private Song findSong(String name) {

        for (Song checkedSong : this.playlistList) {
            if (checkedSong.getName().equals(name)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.playlistList.size())) {

            playlist.add(this.playlistList.get(index));
            return true;

        }
        System.out.println("this playlist does not contain track no: " + trackNumber);
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