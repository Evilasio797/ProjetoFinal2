package testeSpotify;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {

    public static LinkedList<Album> listAlbums = new LinkedList<>(); // PRIVATE STATIC

    // NON STATIC FIELD listAlbums CAN NOT BE REFERENCE FROM A STATIC CONTEX
    
    public static void main(String[] args) {
    	

// ADDING SONGS
        Album album = new Album("Kill Em All", "ACDC");
    	// Playlist playlist1 = new Playlist("nome_playl", "nome_art");
        album.addSong("Seek & Destory", 12);
        album.addSong("Ride The Lightin", 13);
        album.addSong("Seek & Destory", 14);
        listAlbums.add(album);

        album = new Album("Death Magnectis", "Metallica");
        album.addSong("The Day That Never Comes", 123);
        album.addSong("All Nightmare Long", 123);
        album.addSong("Blood and scared", 123);
        album.addSong("outra musica", 1234);
        listAlbums.add(album);
        
        //printListAlbum(playlists);

        printEverything(listAlbums);


        /*LinkedList<Song> playlist = new LinkedList<Song>();

        playlists.get(0).addToPlaylist("Seek & Destory", playlist);
        playlists.get(0).addToPlaylist(2, playlist);
        playlists.get(1).addToPlaylist(2, playlist);
        printListPlaylist(playlist);
*/
 //  	Playlist p1 = new Playlist("p1", "Evilasio");
    	// LinkedList<Song> p1 = new LinkedList<Song>();
    	System.out.println("+++"+album);
    	System.out.println("---" + listAlbums);
        play(listAlbums);


    }

    public static void play(LinkedList<Album> listAlbums) {

        System.out.println("listalbums: "+ listAlbums.size());
        Scanner scanner = new Scanner(System.in);
        boolean forward = true;
        boolean isQuit = true;
        LinkedList<Song> playlist = new LinkedList<Song>();
        ListIterator<Song> listIterator = playlist.listIterator();
        System.out.println("Antes do while"+ !isQuit);
//    ListIterator<Song> listIterator = playList.listIterator();


        /*if (playlist.size() == 0) { //COMENTAMOS PRA INCLUIR O MENU, PQ SENAO NAO ENTRVA E A PLAYL FICAVA VAZIA
            System.out.println("NO SONG IN PLAYLIST");
            return;
        } else {
            System.out.println("NOW PLAYING " + listIterator.next().toString());
            printMenu();
        }
*/
        
        while (isQuit) {
        	printMenu();
            int choose = scanner.nextInt();
            Scanner musica = new Scanner(System.in);
            String musicaTittle;
            scanner.nextLine();
            

//            0 - to quit
//            1 - to play next song
//            2 - to play previous song
//            3 - to replay the current song
//            4 - list songs in the playlist
//            5 - print available actions.
//            6 - delete current song from playlist
//			  7 - add songs to playlist
            switch (choose) {
                case 0:
                    System.out.println("Playlist is Done");
                    isQuit = false;
                    break;

                case 1: // PLAY NEXT SONG
                    if (!forward) { // por padrão, true
                        if (listIterator.hasNext()) { //estamos na posição 0 e checamos se há algo mais
                            listIterator.next(); // nos movemos ^ o indicador do iterador mais
                        }
                        forward = true; // a direção continua --->
                    }
                    if (listIterator.hasNext()) {  // nós verificamos se há algo mais
                        System.out.println("Now playing " + listIterator.next().toString()); // nós tocamos o que é o próximo (?)
                    } else { //  se não houver mais nada
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:  // PLAY PREVIOUS SONG
                    if (forward) { // pode ser verdadeiro ou falso
                        if (listIterator.hasPrevious()) {  // analogicamente para o próximo
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) { // nós voltamos e soltamos o que era antes
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {  // se não há nada, não pode ser revertido
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3: // REPLAY CURRENT SONG
                    if (forward) { // pode ser verdadeiro ou falso

                        // Então, se há algo de volta, então repetimos, se não a última música conhecida

                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4: // PRINT PLAYLIST
                    printListPlaylist(playlist);
                    break;
                case 5: // PRINT THIS MENU
                    printMenu();
                    break;

                case 6: // DELETE CURRENT SONG
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
                case 7: 
                	if (listAlbums.size() > 0) {
                		System.out.println("Informe o nome da musica: \n" + listAlbums.size());
                		musicaTittle = musica.nextLine();
                		listAlbums.get(0).addToPlaylist(musicaTittle, playlist);
                        
                        
                	}


            }


        }


    }

    // method to print everything what is storaged in playlists LinkedList (everything you've added)
    public static void printEverything(LinkedList<Album> linkedList) {
        System.out.println("=============================");
//        System.out.println("List of song in album: " + albumName);

        Iterator<Album> i = linkedList.iterator(); // algo como for (int i = 0; i < linkedList.size(); i++ )
        int j = 0;
        while (i.hasNext()) {
            j++;
            Album currentAlbum = i.next();
            System.out.println(j + ": " + currentAlbum.getName());

            currentAlbum.getSongsFromInside();

        }
        System.out.println("=============================");

    }

    // method to print everything what is storaged in Album LinkedList (everything you've added to Album)
    public static void printListAlbum(LinkedList<Album> linkedList) {
        System.out.println("=============================");
//        System.out.println("List of song in album: " + albumName);

        Iterator<Album> i = linkedList.iterator(); // algo como for (int i = 0; i < linkedList.size(); i++ )
        int j = 0;
        while (i.hasNext()) {

            j++;
            Album currentAlbum = i.next();
            System.out.println(j + ": " + currentAlbum.getName());


        }
        System.out.println("=============================");

    }

    public static void printListPlaylist(LinkedList<Song> playlist) {
        System.out.println("============ playlist =================");
//        System.out.println("List of song in album: " + albumName);

        Iterator<Song> i = playlist.iterator(); // algo como for(int i = 0; i < playlist.size(); i++ )
        int j = 0;
        while (i.hasNext()) {

            j++;
            Song currentSong = i.next();
            System.out.println(j + ": " + currentSong.getName());
        }
        System.out.println("=============================");

    }


    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist" +
        		"7 - add songs to playlist");
    }
}
