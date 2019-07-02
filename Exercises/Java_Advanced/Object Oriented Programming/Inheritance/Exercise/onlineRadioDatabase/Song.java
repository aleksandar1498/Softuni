package onlineRadioDatabase;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, double length) {
        this.artistName = artistName;
        this.songName = songName;
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }
    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if(artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if(songName.length() < 3 || songName.length() > 20){
            throw new InvalidSongNameException("Song name should be between 3 and 20 symbols.");
        }
        this.songName = songName;
    }

    private void setLength(double length) {
        this.length = length;
    }
}
