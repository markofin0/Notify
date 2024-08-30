package Notify;

public class Song { // song class that is the bluebrint of a Song object with attributes title, artist, and duration with setters and getters
    private String title;
    String artist;
    double duration;
    public String getTitle(String addSong){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public double getDuration(){
        return duration;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public void setDuration(double duration){
        this.duration = duration;
    }

}
