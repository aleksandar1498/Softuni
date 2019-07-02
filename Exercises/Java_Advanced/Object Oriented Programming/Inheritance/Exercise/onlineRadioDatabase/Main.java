package onlineRadioDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        SongDatabase songDatabase=new SongDatabase();
        String [] tokens=scanner.nextLine().split(";");
        try {
            Song song=new Song(tokens[0],tokens[1],tokens[2]);
            songDatabase.addSong(song);
            System.out.println(song.getLengthInSeconds());
            song.getLength();
            System.out.println(songDatabase.getTotalLengthOfSongs());
        } catch (InvalidArtistNameException | InvalidSongNameException | InvalidSongLengthException e) {
            System.out.println(e.getMessage());
        }
    }
}
