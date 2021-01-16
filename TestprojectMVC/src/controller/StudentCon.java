package controller;

import model.Student;

public class StudentCon {

    private Student model;

    public void setStudentName(String fullName) {
        model.setFullName(fullName);
    }

    public void setStudentLastName(String lastName) {
        model.setLastName(lastName);
    }

    public void setStudentId(int ID) {
        if (ID != 0) {
            model.setId(ID);
        } else {
            System.out.println("Cannot SET");
        }
    }
}
