import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Playlist {

    ArrayList<Song> songs = new ArrayList<>();

    public void loadInfo() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/spotify_unique_years_artists.txt"));

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] data = line.split(",");

            String ptitle = data[0];
            String partist = data[1];
            String palbum = data[2];
            int pdurationSeconds = Integer.parseInt(data[3]);
            int preleaseYear = Integer.parseInt(data[4]);
            String pgenre = data[5];

            songs.add(new Song(ptitle, partist, palbum, pdurationSeconds, preleaseYear, pgenre));
        }
        scan.close();
    }

    public void printInfo(){
        System.out.printf("%-30s %-20s %-25s %-8s %-6s %-12s", "Title", "Artist", "Album", "Seconds", "Year", "Genre");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (Song s: songs) {
            System.out.println(s);
        }
    }
    public void alphabet(){

    }
    public void reversealphabet(){

    }
    public void years(){

    }
    public void reverseyears(){

    }
    public void genre(String genre){
        boolean found = false;
        for (Song s: songs) {
            if(s.getgenre().equalsIgnoreCase(genre)) {
                System.out.println(s);
                found = true;
            }
        }
        if(!found){
            System.out.println("Sorry no songs found in the genre " + genre);
        }

    }
    public void quit(){

    }
}
