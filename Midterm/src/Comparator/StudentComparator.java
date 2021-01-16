
package Comparator;

import java.util.Comparator;

public class StudentComparator {
    private String name;
    private int id;

    public StudentComparator(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public Comparator nameCom(){ // Comparator แบบ method
        return new Comparator<StudentComparator>() {
            @Override
            public int compare(StudentComparator s1, StudentComparator s2) {
                return s1.name.compareTo(s2.name);
            }
        };
    }
    
    //Comparator แบบ class
    static class nameCompare implements Comparator<StudentComparator>{
        public int compare(StudentComparator s1,StudentComparator s2){ //s1 , s2 เป็นตัวแปรสามารถเปลี่ยนเป็นอะไรก็ได้
            return s1.name.compareTo(s2.name);
        }
    }
    static class idCompare implements Comparator<StudentComparator>{
        public int compare(StudentComparator s1,StudentComparator s2){
            return s1.id - s2.id;
        }
    }

    @Override
    public String toString() {
        return "StudentComparator{" + "name=" + name + ", id=" + id + '}';
    }
    
    
    
}
