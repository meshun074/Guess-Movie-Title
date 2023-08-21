import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Movies {
    //returns an random movies from a list of movie titles
    public static String getRandMovie(){
        List<String> movies = new ArrayList<>(Objects.requireNonNull(readMovies()));
        return movies.size()>0?movies.get((int) (Math.random() * (movies.size()-1))):"";}

    // reads movie titles from a file
    private static List<String> readMovies()
    {
        List<String> movies = new ArrayList<>();
        File movieFile = new File("src/movies.txt");
        try {
            Scanner fr = new Scanner(movieFile);
            while (fr.hasNext())
            {
                movies.add(fr.nextLine());
            }
            if (movies.size()==0)
                System.out.println("File is empty");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file");
        }
        return movies;
    }

}
