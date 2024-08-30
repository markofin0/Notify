package Notify;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    public static String username; // a name attribute to the User class/object
    static List<Playlist> playlists=new ArrayList<Playlist>(); // defines a new ArrayList of playlists "owned" by the user class/object
    static List<Song> songs = new ArrayList<>(); // defines a new ArrayList of songs "owned" by the user class/object

    public static void createPlaylist(){ // creates a playlist object and adds it to the "playlists" ArrayList

        Scanner input = new Scanner(System.in); // looks for user input
        System.out.println("Enter playlist name: "); // asks for playlist name
        String playlistName=input.nextLine(); // assigns a string variable to user input
        System.out.println("Is it a Pop, Rock, or Jazz Playlist? "); // asks clarification
        String playlist=input.nextLine(); // assigns user input to variable
        if(playlist.equals("Rock")){ // these if-else statements check to see what type of playlist the user wishes to create, then adds it to the ArrayList of playlists, then returns to the menu
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
        else{ // checks if inputted value is invalid
            System.out.println("Invalid playlist name");
            createPlaylist();
        }
    }
    public static void deletePlaylist(String name){ // finds a playlist in the ArrayList with the matching attribute of what is entered and removes it
        playlists.removeIf(playlist->Playlist.name.equals(name));
        displayMenu();
    }
    public static void addSongToPlaylist(Playlist playlist, Song song){ // adds a song to a playlist (complexity is in what calls the method)
        playlist.addSong(song);
        displayMenu();
    }
    public static void removeSongFromPlaylist(Playlist playlist, Song song){ // removes a song from a playlist (complexity is in what calls the method)
        playlist.removeSong(song);
        displayMenu();
    }
    public static void displayMenu(){ // displays and acts as a menu

        String menuNum; // defines variable that will later decide what action is taken in the menu

        System.out.println("Hello " + username + "."); // some outputted strings displaying a menu
        System.out.println("What would you like to do?");
        System.out.println("1. Make a playlist");
        System.out.println("2. Delete a playlist");
        System.out.println("3. Add a song to a playlist");
        System.out.println("4. Remove a song from a playlist");
        System.out.println("5. Quit");

        Scanner menu = new Scanner(System.in); // gets user input
        menuNum = menu.nextLine();

        if (menuNum.equals("1")) {

            createPlaylist(); // calls the create playlist method

        } else if (menuNum.equals("2")) {

            System.out.println("What playlist would you like to delete?");
            Scanner delPlaylistScanner = new Scanner(System.in);
            String delPlaylist = delPlaylistScanner.nextLine(); // gets input from user on what playlist to delete
            deletePlaylist(delPlaylist);

        } else if (menuNum.equals("3")) {

            System.out.println("What playlist?");
            for(int i = 0; i < playlists.size(); i++){ // prints every playlist in the ArrayList "playlists"
                System.out.println((i + 1) + ". " +playlists.get(i));
            }
            Scanner playlistChooser = new Scanner(System.in);
            int chosenPlaylist = Integer.parseInt(playlistChooser.nextLine()); // gets input and then assigns the correlating chosen playlist from "playlists" to a Playlist object
            Playlist playlistChosen = playlists.get(chosenPlaylist);

            System.out.println("What song?");
            for(int i = 0; i < songs.size(); i++){ // does the same as the previous playlist function but for songs
                System.out.println((i+1) + ". " + songs.get(i));
            }
            Scanner songChooser = new Scanner(System.in);
            int chosenSong = Integer.parseInt(songChooser.nextLine());
            Song songChosen = songs.get(chosenSong);

            addSongToPlaylist(playlistChosen,songChosen); // calls the addSongToPlaylist method using both inputted Playlist and Song objects

        } else if (menuNum.equals("4")) {

            System.out.println("What playlist?");
            for(int i = 0; i < playlists.size(); i++){
                System.out.println((i + 1) + ". " +playlists.get(i));
            }
            Scanner playlistChooser = new Scanner(System.in); // does the same as menu 3
            int chosenPlaylist = Integer.parseInt(playlistChooser.nextLine());
            Playlist playlistChosen = playlists.get(chosenPlaylist);

            System.out.println("What song?");
            for(int i = 0; i < songs.size(); i++){ // does the same as menu 3
                System.out.println((i+1) + ". " + songs.get(i));
            }
            Scanner songChooser = new Scanner(System.in);
            int chosenSong = Integer.parseInt(songChooser.nextLine());
            Song songChosen = songs.get(chosenSong);

            removeSongFromPlaylist(playlistChosen,songChosen); // calls the removeSongFromPlaylist method using chosen Playlist and Song objects

        } else if (menuNum.equals("5")) {

            System.exit(0); // quits the application

        } else {

            displayMenu(); // if any other input other than the required ones are given, it redisplays the menu

        }
    }

    public static void main(String[] args) { // main method that welcomes the user then displays the menu
        System.out.println("Welcome to Not-ify!");
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        username = input.nextLine();
        displayMenu();
    }
}
