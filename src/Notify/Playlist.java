package Notify;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
public static String name; // name of playlist object
List<String> songs=new ArrayList<String>(); // lists of song objects in playlist object

public void addSong(Song song){ // adds a song object to the ArrayList which is an attribute of the Playlist object
    songs.add(song.getTitle(String.valueOf(song)));
}
public void removeSong(Song song){
    songs.remove(song.getTitle(String.valueOf(song)));
} // removes a song object from the ArrayList in the Playlist object
public void playAllSongs(){ // for each index of the ArrayList of songs, it displays each song
    for (int i = 0; i < songs.size() - 1; i++){
        System.out.println(songs);
    }
}
}
