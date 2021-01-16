package int102final_lab_exam2;

/**
 * Movie class ภาพยนตร์ มี title, hours, grade
 */
public class Movie {

    private final String title; // ชื่อภาพยนตร์
    private final double hours; // ความยาวของภาพยนตร์เป็นชั่วโมง
    private final int grade; // ระดับคุณภาพเป็นเกรดของภาพยนตร์ 1 คือ ดีมาก; 5 คือ แย่มาก

    public Movie(String title, double hours, int grade) {
        this.title = (title == null) ? "No Title" : title;
        this.hours = (hours <= 0) ? 2.0 : hours;
        this.grade = (grade < 1 || grade > 5) ? 3 : grade;
    }

    public String getTitle() {
        return title;
    }

    public double getHours() {
        return hours;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("Movie: %s (%.2f hours, grade:%d)", title, hours, grade);
    }

    public boolean equals(Movie m) {
        return m != null && this.title.equals(m.title) && this.hours == m.hours && this.grade == m.grade;
    }

    public int compareTo(Movie m) {
        if (m == null) {
            return 1;
        }
        int val = this.grade - m.grade;
        return (val > 0) ? -1 : (val < 0) ? 1 : 0;
    }

}
