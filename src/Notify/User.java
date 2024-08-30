package Notify;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    public static String username;
    static List<Playlist> playlists=new ArrayList<Playlist>();
    static List<Song> songs = new ArrayList<>();

    public static void createPlaylist(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter playlist name: ");
        String playlistName=input.nextLine();
        System.out.println("Is it a Pop, Rock, or Jazz Playlist? ");
        String playlist=input.nextLine();
        if(playlist.equals("Rock")){
            RockPlaylist playlistObj=new RockPlaylist();
            playlistObj.name=playlistName;
            playlists.add(playlistObj);
            displayMenu();
        }
        else if(playlist.equals("Jazz")){
            JazzPlaylist playlistObj=new JazzPlaylist();
            playlistObj.name=playlistName;
            playlists.add(playlistObj);
            displayMenu();
        }
        else if(playlist.equals("Pop")){
            PopPlaylist playlistObj=new PopPlaylist();
            playlistObj.name=playlistName;
            playlists.add(playlistObj);
            displayMenu();
        }
        else{
            System.out.println("Invalid playlist name");
            createPlaylist();
        }
    }
    public static void deletePlaylist(String name){
        playlists.removeIf(playlist->Playlist.name.equals(name));
        displayMenu();
    }
    public static void addSongToPlaylist(Playlist playlist, Song song){
        playlist.addSong(song);
        displayMenu();
    }
    public static void removeSongFromPlaylist(Playlist playlist, Song song){
        playlist.removeSong(song);
        displayMenu();
    }
    public static void displayMenu(){

        String menuNum;

        System.out.println("Hello " + username + ".");
        System.out.println("What would you like to do?");
        System.out.println("1. Make a playlist");
        System.out.println("2. Delete a playlist");
        System.out.println("3. Add a song to a playlist");
        System.out.println("4. Remove a song from a playlist");
        System.out.println("5. Quit");

        Scanner menu = new Scanner(System.in);
        menuNum = menu.nextLine();

        if (menuNum.equals("1")) {

            createPlaylist();

        } else if (menuNum.equals("2")) {

            System.out.println("What playlist would you like to delete?");
            Scanner delPlaylistScanner = new Scanner(System.in);
            String delPlaylist = delPlaylistScanner.nextLine();
            deletePlaylist(delPlaylist);

        } else if (menuNum.equals("3")) {

            System.out.println("What playlist?");
            for(int i = 0; i < playlists.size(); i++){
                System.out.println((i + 1) + ". " +playlists.get(i));
            }
            Scanner playlistChooser = new Scanner(System.in);
            int chosenPlaylist = Integer.parseInt(playlistChooser.nextLine());
            Playlist playlistChosen = playlists.get(chosenPlaylist);

            System.out.println("What song?");
            for(int i = 0; i < songs.size(); i++){
                System.out.println((i+1) + ". " + songs.get(i));
            }
            Scanner songChooser = new Scanner(System.in);
            int chosenSong = Integer.parseInt(songChooser.nextLine());
            Song songChosen = songs.get(chosenSong);

            addSongToPlaylist(playlistChosen,songChosen);

        } else if (menuNum.equals("4")) {

            System.out.println("What playlist?");
            for(int i = 0; i < playlists.size(); i++){
                System.out.println((i + 1) + ". " +playlists.get(i));
            }
            Scanner playlistChooser = new Scanner(System.in);
            int chosenPlaylist = Integer.parseInt(playlistChooser.nextLine());
            Playlist playlistChosen = playlists.get(chosenPlaylist);

            System.out.println("What song?");
            for(int i = 0; i < songs.size(); i++){
                System.out.println((i+1) + ". " + songs.get(i));
            }
            Scanner songChooser = new Scanner(System.in);
            int chosenSong = Integer.parseInt(songChooser.nextLine());
            Song songChosen = songs.get(chosenSong);

            removeSongFromPlaylist(playlistChosen,songChosen);

        } else if (menuNum.equals("5")) {

            System.exit(0);

        } else {

            displayMenu();

        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Not-ify!");
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        username = input.nextLine();
        displayMenu();
    }
}
