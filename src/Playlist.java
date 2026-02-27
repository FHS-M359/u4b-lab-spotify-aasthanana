import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Playlist {

    ArrayList<Song> songs = new ArrayList<>();
//loads info from file and stores into these variables
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
//layout of how to print data
    public void printInfo(){
        System.out.printf("%-30s %-20s %-25s %-8s %-6s %-12s", "Title", "Artist", "Album", "Seconds", "Year", "Genre");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (Song s: songs) {
            System.out.println(s);
        }
    }
    //puts each song in alaphabetical order via artist
    public void alphabet() {
        for (int i = 0; i < songs.size(); i++) {
            int minIndex = i;

            for (int j = i + 1; j < songs.size(); j++) {
                if (songs.get(j).getartist().compareToIgnoreCase(songs.get(minIndex).getartist()) < 0) {
                    minIndex = j;
                }
            }
            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }
        printInfo();

    }
    //puts each song in revesrse alaphabetical order via artist
    public void reversealphabet(){
        for (int i = 0; i < songs.size(); i++) {
            int maxIndex = i;

            for (int j = i + 1; j < songs.size(); j++) {
                if (songs.get(j).getartist().compareToIgnoreCase(songs.get(maxIndex).getartist()) > 0) {
                    maxIndex = j;
                }
            }
            Song temp = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, temp);
        }
        printInfo();
    }
    //puts each song in numerical order via release date
    public void sortByRelease(){
        for(int i = 0; i < songs.size(); i++){
            Song temp = songs.get(i);
            int position = i;

            while(position > 0 && songs.get(position - 1).getreleaseYear() > temp.getreleaseYear()){
                songs.set(position, songs.get(position - 1));
                position --;
            }

            songs.set(position, temp);
        }
        printInfo();

    }
    //puts each song in reverse numerical order via release date
    public void sortByReleaseReverse(){
        for(int i = 0; i < songs.size(); i++){
            Song temp = songs.get(i);
            int position = i;

            while(position > 0 && songs.get(position - 1).getreleaseYear() < temp.getreleaseYear()){
                songs.set(position, songs.get(position - 1));
                position --;
            }

            songs.set(position, temp);
        }
        printInfo();
    }
//sort the songs and finds all songs in the genre they pick
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
}
