public class Song {
    private String title;
    private String artist;
    private String album;
    private int durationSeconds;
    private int releaseYear;
    private String genre;

    public Song(String title, String artist, String album, int durationSeconds, int releaseYear, String genre) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationSeconds = durationSeconds;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String gettitle() {
        return title;
    }
    public String getartist() {
        return artist;
    }
    public String getalbum(){
        return album;
    }
    public int getdurationSeconds(){
        return durationSeconds;
    }
    public int getreleaseYear(){
        return releaseYear;
    }
    public String getgenre(){
        return genre;
    }


    public void settitle(String title) {
        this.title = title;
    }
    public void setartist(String artist) {
        this.artist = artist;
    }
    public void setalbum(String album) {
        this.album = album;
    }
    public void setdurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
    public void setreleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public void setgenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return String.format("%-30s %-20s %-25s %-8d %-6d %-12s", title, artist, album, durationSeconds, releaseYear, genre);
    }
}
