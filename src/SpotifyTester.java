import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpotifyTester {

    public static void main (String[] args) throws FileNotFoundException {
        int menunum = 0;

        Scanner in = new Scanner(System.in);
        Playlist playlist = new Playlist();
        playlist.loadInfo();
//displays the 7 options and when an option is picked it will show the corespoding list
        while (menunum != 7){
            System.out.println("==== Spotify Menu ====");
            System.out.println("1 - Sort by artist A → Z");
            System.out.println("2 - Sort by artist Z → A");
            System.out.println("3 - Sort by year oldest → newest");
            System.out.println("4 - Sort by year newest → oldest");
            System.out.println("5 - Search by genre");
            System.out.println("6 - Display all songs");
            System.out.println("7 - Quit");

            boolean tryAgain = true;
//try catch method that looks for a number between 1-7
            while (tryAgain) {
                try {
                    System.out.print("Please enter a number 1-7");
                    int number = in.nextInt();
                    menunum = number;
                    if (number > 0 && number < 8) {
                        System.out.println("You entered: " + number);
                        tryAgain = false;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid entry - Please pick a number from 1-7");
                    in.nextLine();
                }

            }
//if else loop coreponding with number picked from the above while loop
            if (menunum == 1) {
                playlist.alphabet();

            } else if (menunum == 2) {
                playlist.reversealphabet();

            } else if (menunum == 3) {
                playlist.sortByRelease();

            } else if (menunum == 4) {
                playlist.sortByReleaseReverse();

            } else if (menunum == 5) {
                Scanner out = new Scanner(System.in);
                System.out.println("What genre do you want to search for?");
                String generpicked = out.nextLine();
                playlist.genre(generpicked);

            } else if (menunum == 6) {
                playlist.printInfo();

            } else {
                System.out.println("Thank You for participating! Have a good day :)");
            }
        }
    }
}
