import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpotifyTester {

    public static void main (String[] args) throws FileNotFoundException {

        System.out.println("==== Spotify Menu ====");
        System.out.println("1 - Sort by artist A → Z");
        System.out.println("2 - Sort by artist Z → A");
        System.out.println("3 - Sort by year oldest → newest");
        System.out.println("4 - Sort by year newest → oldest");
        System.out.println("5 - Search by genre");
        System.out.println("6 - Display all songs");
        System.out.println("7 - Quit");
        System.out.println("Pick a number 1-7");

            Scanner in = new Scanner(System.in);
            int menunum = 0;
            boolean tryAgain = true;
            while (tryAgain) {
                try {
                    System.out.print("Please enter a number 1-7");
                    int number = in.nextInt();
                    menunum = number;
                    if(number > 0 && number < 8) {
                        System.out.println("You entered: " + number);
                        tryAgain = false;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid entry - Please pick a number from 1-7");
                    in.nextLine();
                }

            }

            Playlist playlist = new Playlist();
if(menunum == 1){
    playlist.loadInfo();
    playlist.printInfo();
}
else if(menunum == 2){
    playlist.alphabet();

}
else if(menunum == 3){
    playlist.reversealphabet();

}
else if(menunum == 4){
    playlist.years();

}
else if(menunum == 5){

    playlist.reverseyears();

}
else if(menunum == 6){
    Scanner out = new Scanner(System.in);
    System.out.println("What genre do you want to search for?");
    String generpicked = out.nextLine();
    playlist.loadInfo();
    playlist.genre(generpicked);

}
else{
    playlist.quit();
    System.out.println("Thank You for participating! Have a good day :)");
}

    }
}
