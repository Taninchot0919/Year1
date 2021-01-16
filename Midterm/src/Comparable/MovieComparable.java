package Comparable;

public class MovieComparable implements Comparable<MovieComparable> {  //ใช้ implements เพราะใช้กับคลาส interface

    private double rating;
    private String name;
    private int year;
    public int count;

//    @Override
//    public int compareTo(Movie o) { // oเราจะใช้เป็นตัวอื่นก็ได้ มันเป็นแค่ตัวแปร 
//        return this.name.compareTo(o.name); //อันนี้เป็นการเปรียบเทียบชื่อ
//    }

    @Override
    public int compareTo(MovieComparable o) {
        return this.year - o.year; //อันนี้เป็นการเปรียบเทียบ ปี หากอยากเปรียบเทียบมากไปน้อยก็สลับที่เอา
    }

    public MovieComparable(String name, double rating, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Movie{" + "rating=" + rating + ", name=" + name + ", year=" + year + '}';
    }

}
