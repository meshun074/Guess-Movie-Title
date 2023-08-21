// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Game starts here
        do {
            System.out.printf("""
                    Hello and welcome to MKNE Guess a Movie!\s
                    %s
                    """, GamePlay.StartGame(Movies.getRandMovie()));
            System.out.println("Press any key to continue or 1 to exist");
            // Get user input to loop gameplay
        } while (!GamePlay.getOption());

    }
}