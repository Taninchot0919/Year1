package model;

public class Student {

    private long studentId;
    private String name;
    private String lastName;
    private String faculty;

    public Student() {

    }

    public Student(long studentId, String name, String lastName, String faculty) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.faculty = faculty;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name=" + name + ", lastName=" + lastName + ", faculty=" + faculty + '}';
    }

}
