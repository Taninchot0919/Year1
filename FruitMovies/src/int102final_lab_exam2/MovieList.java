package int102final_lab_exam2;

/**
 * MovieList class เก็บ array ของ Movie
 */
public class MovieList {

    private Movie[] movies; // array เก็บภาพยนตร์
    private int numberOfStories; // จำนวนเรื่องของภาพยนตร์ที่เก็บอยู่ใน array

    public MovieList(int capacity) {
        capacity = (capacity > 0) ? capacity : 10;
        movies = new Movie[capacity];
    }

    public int getNumberOfStories() {
        return numberOfStories;
    }

    public boolean isAvailable() {
        return numberOfStories != movies.length;
    }

    public boolean addMovie(String title, double hours, int grade) {
        if (hours <= 0 || grade < 1 || grade > 5 || !isAvailable()) {
            return false;
        }
        movies[numberOfStories++] = new Movie(title, hours, grade);
        return true;
    }

    public Movie getMovieAt(int slot) {
        if (slot >= 0 && slot < numberOfStories) {
            return movies[slot];
        }
        return null;
    }

    public boolean resize(int newSize) {
        if (newSize <= movies.length) {
            return false;
        }

        Movie m[] = new Movie[newSize];
        System.arraycopy(movies, 0, m, 0, numberOfStories);
        //for (int i = 0; i < numberOfStories; i++) m[i] = movies[i];
        movies = m;
        return true;
    }

    public Movie searchForMovieTitle(String title) {
        if (title == null) {
            return null;
        }
        for (int i = 0; i < numberOfStories; i++) {
            if (title.equals(movies[i].getTitle())) {
                return movies[i];
            }
        }
        return null;
    }
}
