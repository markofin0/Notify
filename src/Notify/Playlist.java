package Notify;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
public static String name;
List<String> songs=new ArrayList<String>();

public void addSong(Song song){
    songs.add(song.getTitle(String.valueOf(song)));
}
public void removeSong(Song song){
    songs.remove(song.getTitle(String.valueOf(song)));
}
public void playAllSongs(){
    for (int i = 0; i < songs.size() - 1; i++){
        System.out.println(songs);
    }
}
}
