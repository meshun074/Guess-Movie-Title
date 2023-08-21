import java.util.Scanner;

public class GamePlay {

//    Updates game as user enters the guess characters
    public static String StartGame(String movies)
    {
        String wrongGuess="";
        int wrongGuessCount=0;
        String updatedmovie =movies;
        String guess;
        String guessing = "_".repeat(movies.length());
        do {
            System.out.printf("""
                    Movie: %s
                    You are guessing: %s
                    You are left with (%d) guesses Wrong guess:%s
                    """,movies, guessing,(10-wrongGuessCount),wrongGuess);
            guess = getGuess();
            if(updatedmovie.contains(guess))
            {
                while (updatedmovie.contains(guess))
                {
                    if(updatedmovie.indexOf(guess)==0)
                    {
                        guessing=guess+guessing.substring(1);
                        updatedmovie="_"+updatedmovie.substring(1);
                    }
                    else if(updatedmovie.indexOf(guess)==1) {
                        guessing=guessing.charAt(0)+guess+guessing.substring(2);
                        updatedmovie=updatedmovie.charAt(0)+"_"+updatedmovie.substring(2);
                    }
                    else {
                        guessing=guessing.substring(0,updatedmovie.indexOf(guess))+guess+guessing.substring(updatedmovie.indexOf(guess)+1);
                        updatedmovie=updatedmovie.substring(0,updatedmovie.indexOf(guess))+"_"+updatedmovie.substring(updatedmovie.indexOf(guess)+1);
                    }
                }
            }else
            {
                wrongGuess+=guess;
                wrongGuessCount++;
            }
            if(guessing.equals(movies))
            {
                return "You Won";
            }
        } while (wrongGuessCount<5);
        return "You Lost";
    }

    //return the guess character
    private static String getGuess()
    {
        Scanner sc = new Scanner(System.in);
        String guess=sc.nextLine();
        if(guess.length()!=1 || guess.equals("_")) {
            System.out.println("Cant guess this character | Cant guess 2 or more characters. ");
            return getGuess();
        }
        else
            return guess;
    }
    // get user input to continue or exist game
    public static boolean getOption()
    {
        Scanner sc = new Scanner(System.in);
        try {
            return Integer.parseInt(sc.nextLine()) == 1;
        }catch (Exception e)
        {
            return false;
        }
    }
}
