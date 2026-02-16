import java.io.FileNotFoundException;

public class SpotifyTester {

    public static void main (String[] args) throws FileNotFoundException {

        Playlist playlist = new Playlist();

        playlist.loadInfo();
        playlist.printInfo();
    }
}
