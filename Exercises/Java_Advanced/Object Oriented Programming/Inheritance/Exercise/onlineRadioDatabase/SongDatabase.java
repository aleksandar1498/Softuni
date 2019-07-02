package onlineRadioDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongDatabase {
    List<Song> songs;

    public SongDatabase() {
        songs = new ArrayList<>();
    }
    public void addSong(Song song){
        this.songs.add(song);
    }
    public String getTotalLengthOfSongs(){
        double totLength= this.songs.stream().mapToDouble(Song::getLength).sum();
    }
}
