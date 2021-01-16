package int102final_test_exam2;

import int102final_lab_exam1.Fruit;
import int102final_lab_exam2.Movie;
import int102final_lab_exam2.MovieList;
import java.lang.reflect.Field;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class INT102TestTwo {

    private static final int ROUND = 100;

    /**
     * random a sign : return 1 or -1
     */
    private static int randomSign(boolean[] sign) {
        if (sign.length > 0 && sign[0]) {
            return Math.round(Math.random()) == 0 ? -1 : 1;
        }
        return 1;
    }

    /**
     * random an int i where 1 <= i <= bound
     *
     * @param bound the upper bound; if bound < 2, return 1 or -1 @param sign if
     * sign is true, it may return positive or negative value @return the int
     */
    private static int randomInt(int bound, boolean... sign) {
        if (bound < 2) {
            return randomSign(sign);
        }
        return randomSign(sign) * (1 + (int) (bound * Math.random()));
    }

    /**
     * random a double d where 0 <= d < bound
     *
     * @param bound the upper bound; if bound <= 0, return 0 @param sign if sign
     * is true, it may return positive or negative value @return the double
     */
    private static double randomDouble(double bound, boolean... sign) {
        if (bound <= 0) {
            return 0;
        }
        return randomSign(sign) * bound * Math.random();
    }

    /**
     * random a string with a given length and specified (upper/lower) case
     *
     * @param length the length of the string; if length <= 0, return "" @param
     * upper ถ้าเป็น true คือ ใช้ uppercase เท่านั้น; ถ้าเป็น false คือ ใช้
     * lowercase เท่านั้น; ถ้าไม่มี คือ ใช้ทั้ง uppercase และ lowercase @return
     * string ตามความยาวที่กำหนด และใช้ uppercase หรือ lowercase ตามที่กำหนด
     */
    private static String randomString(int length, boolean... upper) {
        if (length <= 0) {
            return "";
        }
        StringBuilder str = new StringBuilder(length);
        if (upper.length > 0) {
            char letter = upper[0] ? 'A' : 'a';
            for (int i = 0; i < length; i++) {
                str.append((char) (letter + randomInt('Z' - 'A' + 1) - 1));
            }
        } else {
            for (int i = 0; i < length; i++) {
                char letter = Math.round(Math.random()) == 0 ? 'A' : 'a';
                str.append((char) (letter + randomInt('Z' - 'A' + 1) - 1));
            }
        }
        return str.toString();
    }

    private static String getMovieTitle(Movie movie) {
        try {
            Field f = movie.getClass().getDeclaredField("title");
            f.setAccessible(true);
            return (String) f.get(movie);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("Movie.title");
        }
        return null;
    }

    private static double getMovieHours(Movie movie) {
        try {
            Field f = movie.getClass().getDeclaredField("hours");
            f.setAccessible(true);
            return f.getDouble(movie);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("Movie.hours");
        }
        return 0.0;
    }

    private static int getMovieGrade(Movie movie) {
        try {
            Field f = movie.getClass().getDeclaredField("grade");
            f.setAccessible(true);
            return f.getInt(movie);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("Movie.grade");
        }
        return 1;
    }

    private static int getMovieListNumbers(MovieList ml) {
        try {
            Field f = ml.getClass().getDeclaredField("numberOfStories");
            f.setAccessible(true);
            return f.getInt(ml);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("MovieList.numberOfStories");
        }
        return 0;
    }

    private static Movie[] getMovieListArray(MovieList ml) {
        try {
            Field f = ml.getClass().getDeclaredField("movies");
            f.setAccessible(true);
            return (Movie[]) f.get(ml);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("MovieList.movies");
        }
        return null;
    }

    private static int getMovieListCapacity(MovieList ml) {
        Movie[] ms = getMovieListArray(ml);
        assertNotNull("MovieList.movies.length", ms);
        return ms.length;
    }

    private static boolean isMovieAtEqual(MovieList ml, int slot, String title, double hours, int grade) {
        try {
            Field f = ml.getClass().getDeclaredField("movies");
            f.setAccessible(true);
            Movie movie = ((Movie[]) f.get(ml))[slot];
            Class c = movie.getClass();
            f = c.getDeclaredField("title");
            f.setAccessible(true);
            if (!title.equals((String) f.get(movie))) {
                return false;
            }
            f = c.getDeclaredField("hours");
            f.setAccessible(true);
            if (hours != f.getDouble(movie)) {
                return false;
            }
            f = c.getDeclaredField("grade");
            f.setAccessible(true);
            return grade == f.getInt(movie);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("MovieList.movies[].{title|hours|grade}");
        }
        return false;
    }

    private static void addMovieAt(MovieList ml, int slot, String title, double hours, int grade) {
        try {
            Class c = ml.getClass();
            Field f = c.getDeclaredField("movies");
            f.setAccessible(true);
            ((Movie[]) f.get(ml))[slot] = new Movie(title, hours, grade);
            f = c.getDeclaredField("numberOfStories");
            f.setAccessible(true);
            f.setInt(ml, slot + 1);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("MovieList.{movies[]|numberOfStories}");
        }
    }

    private static Movie[] generateAllMovieCombination() {
        String[] title = new String[2];
        double[] hours = new double[2];
        int[] grades = new int[2];
        title[0] = randomString(3 + randomInt(4));
        do {
            title[1] = randomString(3 + randomInt(4));
        } while (title[0].equals(title[1]));
        hours[0] = randomDouble(10.0);
        do {
            hours[1] = randomDouble(10.0);
        } while (hours[0] == hours[1]);
        grades[0] = randomInt(5);
        do {
            grades[1] = randomInt(5);
        } while (grades[0] == grades[1]);
        Movie[] movies = new Movie[8];
        for (int n = 0; n < 2; n++) {
            for (int p = 0; p < 2; p++) {
                for (int q = 0; q < 2; q++) {
                    movies[2 * (2 * n + p) + q] = new Movie(new String(title[n]), hours[p], grades[q]);
                    // เจตนาสร้าง String object ตัวใหม่
                }
            }
        }
        return movies;
    }

    private static void generateMovieProperties(int size, String[][] titles, double[][] hours, int[][] grades) {
        if (size < 1) {
            size = 1;
        }
        titles[0] = new String[size];
        hours[0] = new double[size];
        grades[0] = new int[size];
        for (int i = 0; i < size; i++) {
            titles[0][i] = randomString(3 + randomInt(4), true);
            hours[0][i] = randomDouble(10.0);
            grades[0][i] = randomInt(5);
        }
    }

    /**
     * รับชื่อ (title) ความยาว (hours) และระดับคุณภาพ (grade) ของภาพยนตร์เข้ามา
     * เพื่อสร้างเป็น Movie object โดยมีเงื่อนไขการสร้างดังนี้ คือ ถ้า title
     * มีค่าเป็น null จะกำหนดให้ title เป็น "No Title", ถ้า hours
     * มีค่าน้อยกว่าหรือเท่ากับ 0.0 จะกำหนดให้ hours มีค่าเป็น 2.0, ถ้า grade
     * ไม่ได้มีค่าอยูในช่วงของ 1 ถึง 5 จะกำหนดให้ grade มีค่าเป็น 3
     */
    @Test
    public void _01_testMovie_constructor_getters() {

        int CASES = 10;

        String titles[] = new String[CASES + 2];
        for (int i = 0; i < CASES; i++) {
            titles[i] = randomString(6);
        }
        titles[CASES] = null;
        titles[CASES + 1] = "";

        double hours[] = new double[CASES * 2 + 1];
        for (int i = 0; i < CASES; i++) {
            hours[i] = 10 - randomDouble(10.0);
            hours[CASES + i] = randomDouble(10.0);
        }
        hours[CASES] = 0.0;

        int grades[] = new int[CASES * 3 + 4];
        for (int i = 0; i < CASES; i++) {
            grades[i] = randomInt(10);
            grades[CASES + i] = randomInt(10) - 10;
            grades[CASES * 2 + i] = randomInt(10) + 10;
        }
        grades[CASES * 3] = 0;
        grades[CASES * 3 + 1] = 1;
        grades[CASES * 3 + 2] = 10;
        grades[CASES * 3 + 3] = 11;

        for (String title : titles) {
            for (double hour : hours) {
                for (int grade : grades) {
                    title = (title == null ? null : new String(title)); // เจตนาสร้าง String object ตัวใหม่
                    Movie m = new Movie(title, hour, grade);
                    assertEquals("Movie.getTitle()", (title == null ? "No Title" : title), m.getTitle());
                    assertEquals("Movie.getHours()", (hour <= 0.0) ? 2.0 : hour, m.getHours(), 0.001);
                    assertEquals("Movie.getGrade()", (grade < 1 || grade > 5) ? 3 : grade, m.getGrade());
                }
            }
        }
    }

    /**
     * return ค่าเป็น String ซึ่งประกอบด้วย ชื่อ (title) ความยาว (hours)
     * และระดับคุณภาพ (grade) ของภาพยนตร์ โดย return ในรูปแบบดังนี้ Movie: $
     * (#.00 hours, grade:#) เช่น Movie: The Avengers (2.25 hours, grade:1)
     */
    @Test
    public void _02_testMovie_toString() {
        for (int i = 0; i < ROUND; i++) {
            String title = randomString(6);
            double hours = randomDouble(10.0);
            int grade = randomInt(5);
            Movie f = new Movie(title, hours, grade);
            String expected = String.format("Movie: %s (%.2f hours, grade:%d)", title, hours, grade);
            assertEquals("Movie.toString()", expected, f.toString());
        }
    }

    /**
     * รับอีก movie หนึ่งเข้ามาเปรียบเทียบ โดย (1) จะ return true
     * ถ้าภาพยนตร์เรื่องนี้ (this) และภาพยนตร์ที่รับเข้ามา มีชื่อเหมือนกัน
     * มีความยาวเท่ากัน และมีระดับคุณภาพเท่ากัน (เหมือนกันทุกประการ) หรือ (2)
     * method นี้จะ return ค่าเป็น false ถ้าภาพยนตร์เรื่องนี้ (this)
     * และภาพยนตร์ที่รับเข้ามา มีชื่อต่างกัน หรือมีความยาวต่างกัน
     * หรือมีระดับคุณภาพต่างกัน หรือภาพยนตร์ที่รับเข้ามา มีค่าเป็น null
     */
    @Test
    public void _03_testMovie_equals() {

        assertFalse("Movie.equals()-null",
                (new Movie("", 0.0, 0)).equals(null)); // เจตนาเปรียบเทียบกับ null

        for (int i = 0; i < ROUND; i++) {
            Movie[] movie = generateAllMovieCombination();
            for (Movie m1 : movie) {
                for (Movie m2 : movie) {
                    if (m1 == m2) {
                        m2 = new Movie(new String(getMovieTitle(m1)), getMovieHours(m1), getMovieGrade(m1));
                        // เจตนาสร้าง String object ตัวใหม่
                        assertTrue("Movie.equals()-true", m1.equals(m2));
                        assertTrue("Movie.equals()-true", m2.equals(m1));
                    } else {
                        assertFalse("Movie.equals()-false", m1.equals(m2));
                        assertFalse("Movie.equals()-false", m2.equals(m1));
                    }
                }
            }
        }
    }

    /**
     * รับอีก movie หนึ่งเข้ามาเปรียบเทียบ โดย (1) จะ return ค่าเป็น 1
     * ถ้าภาพยนตร์เรื่องนี้ (this) มีระดับคุณภาพ (grade) ดีกว่า (เลขน้อยกว่า)
     * ภาพยนตร์ที่รับเข้ามา หรือภาพยนตร์ที่รับเข้ามา มีค่าเป็น null หรือ (2) จะ
     * return ค่าเป็น -1 ถ้าภาพยนตร์เรื่องนี้ (this) มีระดับคุณภาพ (grade)
     * แย่กว่า (เลขมากกว่า) ภาพยนตร์ที่รับเข้ามา แต่ (3)
     * ถ้าภาพยนตร์ทั้งสองเรื่องมีระดับคุณภาพ (grade) เท่ากัน จะ return ค่าเป็น 0
     */
    @Test
    public void _04_testMovie_compareTo() {

        assertEquals("Movie.compareTo()-null", 1, (new Movie(null, 2.0, 5)).compareTo(null));

        for (int i = 0; i < ROUND; i++) {
            Movie[] movies = generateAllMovieCombination();
            for (Movie m1 : movies) {
                for (Movie m2 : movies) {
                    if (m1 == m2) {
                        m2 = new Movie(new String(getMovieTitle(m1)), getMovieHours(m1), getMovieGrade(m1));
                        // เจตนาสร้าง String object ตัวใหม่
                    }
                    assertTrue("Movie.compareTo()-inverse", -1 * m2.compareTo(m1) == m1.compareTo(m2));
                    int q1 = getMovieGrade(m1);
                    int q2 = getMovieGrade(m2);
                    if (q1 == q2) {
                        assertEquals("Movie.compareTo()-sameGrade", 0, m1.compareTo(m2));
                    } else {
                        assertEquals("Movie.compareTo()-differentGrade", (q1 < q2) ? 1 : -1, m1.compareTo(m2));
                    }
                }
            }
        }
    }

    /**
     * รับขนาดความจุ (capacity) เข้ามา เพื่อสร้าง Movie array
     * ที่มีขนาดความจุเท่ากับ capacity ให้กับ movies แต่ถ้า capacity
     * ที่รับเข้ามา มีค่าน้อยกว่าหรือเท่ากับ 0 จะสร้าง Movie array
     * ที่มีขนาดความจุเท่ากับ 10 ให้กับ movies ขนาดความจุของ array
     * นี้บ่งบอกถึงความจุของ MovieList ว่าสามารถใส่ Movie
     * ลงไปได้กี่ครั้งจึงจะเต็ม
     */
    @Test
    public void _05_testMovieList_constructor() {
        MovieList ml = new MovieList(0);
        assertEquals("MovieList.numberOfStories", 0, getMovieListNumbers(ml));
        assertEquals("MovieList.movies.length", 10, getMovieListCapacity(ml));

        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            ml = new MovieList(size);
            assertEquals("MovieList.numberOfStories", 0, getMovieListNumbers(ml));
            assertEquals("MovieList.movies.length", size, getMovieListCapacity(ml));
        }

        for (int i = 0; i < ROUND; i++) {
            ml = new MovieList(randomInt(10) - 20);
            assertEquals("MovieList.numberOfStories", 0, getMovieListNumbers(ml));
            assertEquals("MovieList.movies.length", 10, getMovieListCapacity(ml));
        }
    }

    /**
     * ตรวจสอบว่า MovieList นี้ ยังมีที่ว่างสำหรับบรรจุ Movie อีกหรือไม่ (1)
     * method นี้ return true ถ้า MovieList นี้ยังไม่เต็ม หรือ (2) return false
     * ถ้า MovieList นี้มี Movie บรรจุอยู่เต็มตามความจุที่รองรับได้แล้ว
     */
    @Test
    public void _06_testMovieList_getNumberOfStories_isAvailable() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            MovieList ml = new MovieList(size);
            for (int j = 0; j < size; j++) {
                assertEquals("MovieList.getNumberOfStories()", j, ml.getNumberOfStories());
                assertTrue("MovieList.isAvailable()", ml.isAvailable());
                addMovieAt(ml, j, "T", randomDouble(10.0), randomInt(5));
            }
            assertEquals("MovieList.getNumberOfStories()", size, ml.getNumberOfStories());
            assertFalse("MovieList.isAvailable()", ml.isAvailable());
        }
    }

    /**
     * (1) เพิ่ม Movie ที่มีชื่อเป็น title ความยาวมีค่าเป็น hours
     * และระดับคุณภาพมีค่าเป็น grade เข้าไปใน MovieList และนับจำนวน Movie ใน
     * MovieList เพิ่มขึ้นอีก 1 ก่อนจะ return ค่าเป็น true แต่ (2) ถ้า MovieList
     * นี้เต็มแล้ว หรือ hours ที่รับเข้ามา มีค่าน้อยกว่าหรือเท่ากับ 0 หรือ grade
     * ที่รับเข้ามา ไม่ได้มีค่าอยู่ในช่วงของ 1 ถึง 5 จะ return เป็น false
     * และไม่เพิ่มภาพยนตร์นี้เข้าไปใน MovieList
     */
    @Test
    public void _07_testMovieList_addMovie() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            MovieList ml = new MovieList(size);
            assertFalse("MovieList.addMovie()-false", ml.addMovie("F", randomDouble(10.0), 0));
            assertFalse("MovieList.addMovie()-false", ml.addMovie("F", randomDouble(10.0), randomInt(5) - 5));
            assertFalse("MovieList.addMovie()-false", ml.addMovie("F", randomDouble(10.0) - 20.0, randomInt(5)));
            assertFalse("MovieList.addMovie()-false", ml.addMovie("F", randomDouble(10.0) - 20.0, randomInt(5) - 5));
            assertEquals("MovieList.addMovie()-numberOfStories", 0, getMovieListNumbers(ml));
            for (int j = 0; j < size; j++) {
                double hours = randomDouble(10.0);
                int grade = randomInt(5);
                assertTrue("MovieList.addMovie()-true", ml.addMovie("T", hours, grade));
                assertTrue("MovieList.addMovie()-inside", isMovieAtEqual(ml, j, "T", hours, grade));
                assertEquals("MovieList.addMovie()-numberOfStories", j + 1, getMovieListNumbers(ml));
            }
            assertFalse("MovieList.addMovie()-false", ml.addMovie("F", randomDouble(10.0), randomInt(5)));
            assertEquals("MovieList.addMovie()-numberOfStories", size, getMovieListNumbers(ml));
        }
    }

    /**
     * (1) return Movie ที่อยู่ในช่องที่ slot ของ MovieList ถ้าช่อง (slot)
     * ที่รับเข้ามา มีค่าตั้งแต่ 0 ขึ้นไป และไม่เกินช่องที่มีภาพยนตร์อยู่
     * มิฉะนั้น (2) method นี้จะ return ค่าเป็น null
     */
    @Test
    public void _08_testMovieList_getMovieAt() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            for (int count = 0; count <= size; count++) {
                MovieList ml = new MovieList(size);
                String[][] titles = new String[1][];
                double[][] hours = new double[1][];
                int[][] grades = new int[1][];
                generateMovieProperties(size, titles, hours, grades);
                for (int j = 0; j < count; j++) {
                    addMovieAt(ml, j, titles[0][j], hours[0][j], grades[0][j]);
                }
                for (int j = 0; j < count; j++) {
                    Movie m = ml.getMovieAt(j);
                    assertEquals("MovieList.getMovieAt().title", titles[0][j], getMovieTitle(m));
                    assertEquals("MovieList.getMovieAt().hours", hours[0][j], getMovieHours(m), 0.001);
                    assertEquals("MovieList.getMovieAt().grade", grades[0][j], getMovieGrade(m));
                }
                for (int j = count; j < size * 2; j++) {
                    assertNull("MovieList.getMovieAt()-null", ml.getMovieAt(j));
                }
                for (int j = -10; j < 0; j++) {
                    assertNull("MovieList.getMovieAt()-null", ml.getMovieAt(j));
                }
            }
        }
    }

    /**
     * (1) เปลี่ยนขนาดความจุของ MovieList เป็น newSize ช่องและ return ค่าเป็น
     * true แต่ (2) ถ้าค่า newSize ที่รับเข้ามา
     * มีค่าน้อยกว่าหรือเท่ากับจำนวนภาพยนตร์ที่บรรจุอยู่แล้วใน MovieList
     * จะไม่เปลี่ยนแปลงขนาดของ MovieList และจะ return ค่าเป็น false
     */
    @Test
    public void _09_testMovieList_resize() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(5);
            String[][] titles = new String[1][];
            double[][] hours = new double[1][];
            int[][] grades = new int[1][];
            generateMovieProperties(size, titles, hours, grades);
            for (int count = 0; count < size; count++) {
                for (int resize = -5; resize < 20; resize++) {
                    MovieList ml = new MovieList(size);
                    for (int k = 0; k < count; k++) {
                        addMovieAt(ml, k, titles[0][k], hours[0][k], grades[0][k]);
                    }
                    if (resize <= size) {
                        assertFalse("MovieList.resize()-false", ml.resize(resize));
                    } else {
                        assertTrue("MovieList.resize()-true", ml.resize(resize));
                    }
                    int newSize = (resize <= size) ? size : resize;
                    assertEquals("MovieList.resize()-numberOfStories", count, getMovieListNumbers(ml));
                    assertEquals("MovieList.resize()-capacity", newSize, getMovieListCapacity(ml));
                    for (int j = 0; j < count; j++) {
                        assertTrue("MovieList.resize()-movies", isMovieAtEqual(ml, j, titles[0][j], hours[0][j], grades[0][j]));
                    }
                    for (int j = count; j < newSize; j++) {
                        assertNull("MovieList.resize()-movies", getMovieListArray(ml)[j]);
                    }
                }

            }

        }
    }

    /**
     * (1) return Movie ใน MovieList ที่มีชื่อ title ตามที่รับเข้ามา แต่ถ้ามี
     * Movie ที่มีชื่อ title ซ้ำกันหลายช่อง ให้ return Movie ในช่องแรกสุดที่พบ
     * โดยนับจากตำแหน่ง 0 เป็นช่องแรก แต่ (2) หากว่าไม่มี Movie ในชื่อ title
     * หรือ title ที่รับเข้ามา มีค่าเป็น null ให้ return ค่า null
     */
    @Test
    public void _10_testMovieList_searchForMovieTitle() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(5);

            // generate movie properties to add into the list
            String[][] titles = new String[1][];
            double[][] hours = new double[1][];
            int[][] grades = new int[1][];
            generateMovieProperties(size, titles, hours, grades);

            // random a search title that is not in the generated properties
            boolean found;
            String target;
            do {
                found = false;
                target = randomString(3 + randomInt(4), true);
                for (int j = 0; j < size; j++) {
                    if (target.equals(titles[0][j])) {
                        found = true;
                        break;
                    }
                }
            } while (found);

            // prepare the list
            for (int count = 0; count < size; count++) {

                // generate 0-3 positions to have the targeted title
                int duplicate = count < 4 ? count : 4;
                for (int dup = 0; dup < duplicate; dup++) {
                    boolean[] same = new boolean[count];
                    int d = 0;
                    while (d < dup) {
                        int pos = randomInt(count);
                        if (!same[pos - 1]) {
                            same[pos - 1] = true;
                            d++;
                        }
                    }

                    // get first position that contains the targeted title
                    int first = -1;
                    for (int j = 0; j < count; j++) {
                        if (same[j]) {
                            first = j;
                            break;
                        }
                    }

                    // add movie into the list
                    MovieList ml = new MovieList(size);
                    for (int k = 0; k < count; k++) {
                        String n = same[k] ? target : titles[0][k];
                        addMovieAt(ml, k, n, hours[0][k], grades[0][k]);
                    }
                    assertNull("MovieList.searchForMovieTitle()-notFound", ml.searchForMovieTitle(null));
                    Movie m = ml.searchForMovieTitle(target);
                    if (first == -1) {
                        assertNull("MovieList.searchForMovieTitle()-notFound", m);
                    } else {
                        assertTrue("MovieList.searchForMovieTitle()-first position",
                                isMovieAtEqual(ml, first, getMovieTitle(m), getMovieHours(m), getMovieGrade(m)));
                    }
                }
            }
        }
    }

    @Test
    public void _00_testClassSpecification() {
        String packageName = "int102final_lab_exam2.";
        String[] classNames = {"Movie", "MovieList"};
        String[][] attributes = {{"title", "hours", "grade"}, {"movies", "numberOfStories"}};
        int[] constructors = {1, 1};
        String[][] methods = {{"getTitle", "getHours", "getGrade", "toString", "equals", "compareTo"},
        {"getNumberOfStories", "isAvailable", "addMovie", "getMovieAt", "resize", "searchForMovieTitle"}};

        Class[][][] params = {{{}, {}, {}, {}, {}, {}}, {{}, {}, {}, {}, {}, {}}};
        Class mv[], in[];

        mv = new Class[1];
        try {
            mv[0] = Class.forName(packageName + classNames[0]);
        } catch (ClassNotFoundException e) {
            fail(e.toString());
        }

        params[0][4] = params[0][5] = mv; // equals(Movie m), compareTo(Movie m)

        in = new Class[1];
        in[0] = int.class;
        params[1][3] = params[1][4] = in; // getMovieAt(int slot), resize(int size)

        params[1][2] = new Class[3]; // addMovie(String title, double hours, int grade)
        params[1][2][0] = java.lang.String.class;
        params[1][2][1] = double.class;
        params[1][2][2] = int.class;

        params[1][5] = new Class[1];
        params[1][5][0] = java.lang.String.class; // searchForMovieTitle(String)

        for (int i = 0; i < classNames.length; i++) {
            testClass(packageName + classNames[i], attributes[i], constructors[i], methods[i], params[i]);
        }
    }

    private void testClass(String className, String[] attributes, int constructors, String[] methods, Class[][] params) {
        try {
            Class c = Class.forName(className);
            assertEquals("Spec:" + className + " (number of attributes)", attributes.length, c.getDeclaredFields().length);
            for (String attribute : attributes) {
                assertNotNull("Spec:" + className + "." + attribute, c.getDeclaredField(attribute));
            }
            assertEquals("Spec:" + className + "()", constructors, c.getDeclaredConstructors().length);
            assertEquals("Spec:" + className + " (number of methods)", methods.length, c.getDeclaredMethods().length);
            for (int i = 0; i < methods.length; i++) {
                assertNotNull("Spec:" + className + "." + methods[i] + "()", c.getDeclaredMethod(methods[i], params[i]));
            }
        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | SecurityException e) {
            fail("Invalid Class Specification");
        }
    }
}
