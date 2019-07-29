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
        int totLengthInSeconds= this.songs.stream().mapToInt(Song::getLengthInSeconds).sum();
        int h=(int)totLengthInSeconds/3600;
        totLengthInSeconds-=h*3600;
        int m=(int)totLengthInSeconds/60;
        totLengthInSeconds-=m*60;
        return String.format("%02d:%02d:%02d",h,m,totLengthInSeconds);
    }
}
