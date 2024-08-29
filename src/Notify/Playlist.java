package Notify;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
public String name;
List<String> songs=new ArrayList<String>();

public void addSong(Song song){
    songs.add(song.title);
}
public void removeSong(Song song){
    songs.remove(song.title);
}
public void playAllSings(){
    for (int i = 0; i < songs.size() - 1; i++){
        System.out.println(songs);
    }
}
}
