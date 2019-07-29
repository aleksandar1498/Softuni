package onlineRadioDatabase;

public class Song {
    private String artistName;
    private String songName;
    private String length;
    private int lengthInSeconds;

    public Song(String artistName, String songName, String length) throws InvalidArtistNameException, InvalidSongLengthException, InvalidSongNameException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    public String getLength() {
        return this.length;
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setLength(String length) throws InvalidSongLengthException {
        String[] lengthToken = length.split(":");
        int min = Integer.parseInt(lengthToken[0]);
        int sec = Integer.parseInt(lengthToken[1]);
        this.lengthInSeconds = min * 60 + sec;
        if(this.lengthInSeconds < 0 || this.lengthInSeconds > 899){
            throw new InvalidSongLengthException("Invalid song length.");
        }
        if (min < 0 || min > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (sec < 0 || sec > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.lengthInSeconds = min * 60 + sec;
        this.length = length;
    }
}
