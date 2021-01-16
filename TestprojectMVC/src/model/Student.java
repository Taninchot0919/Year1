package model;

public class Student {
    private long id;
    private String fullName;
    private String lastName;
    private String faculty;
    private Student[] member;
    private int count;

    public Student() {
        member= new Student[1];
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setMember(int number){
        member = new Student[number];
    }
    

}
