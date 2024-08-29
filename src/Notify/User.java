package Notify;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String username;
    List<Playlist> playlists=new ArrayList<Playlist>();

    public void createPlaylist(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter playlist name: ");
        String playlistName=input.nextLine();
        System.out.println("Is it a Pop, Rock, or Jazz Playlist? ");
        String playlist=input.nextLine();
        if(playlist.equals("Rock")){
            RockPlaylist playlistObj=new RockPlaylist();
            playlistObj.name=playlistName;
            playlists.add(playlistObj);
        }
        else if(playlist.equals("Jazz")){
            JazzPlaylist playlistObj=new JazzPlaylist();
            playlistObj.name=playlistName;
            playlists.add(playlistObj);
        }
        else if(playlist.equals("Pop")){
            PopPlaylist playlistObj=new PopPlaylist();
            playlistObj.name=playlistName;
            playlists.add(playlistObj);
        }
        else{
            System.out.println("Invalid playlist name");
            createPlaylist();
        }
    }
    public void deletePlaylist(String name){
        playlists.removeIf(playlist->playlist.name.equals(name));
    }
    public void addSongToPlaylist(Playlist playlist, Song song){
        playlist.addSong(song);
    }
    public void removeSongFromPlaylist(Playlist playlist, Song song){
        playlist.removeSong(song);
    }

    public static void main(String[] args) {

    }
}
