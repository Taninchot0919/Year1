import int102final_lab_exam2.Movie;
import int102final_lab_exam2.MovieList;

public class MovieDriver {
    public static void main(String[] args) {
        Movie a = new Movie("Ant-Man", 1.99, 3);
        Movie b = new Movie("Black Panther", 2.25, 2);
        System.out.println(a);
        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));

        MovieList ml = new MovieList(2);
        ml.addMovie("Doctor Strange", 1.92, 3);
        ml.addMovie("Iron Man", 2.1, 1);
        ml.resize(5);
        ml.addMovie("The Avengers", 2.33, 1);
        for (int i = 0; i < ml.getNumberOfStories(); i++) {
            System.out.println("No:" + i + " :: " + ml.getMovieAt(i));
        }
        Movie m = ml.searchForMovieTitle("Doctor Strange");
        if (m != null) {
            System.out.println(m);
        }
    }
}
