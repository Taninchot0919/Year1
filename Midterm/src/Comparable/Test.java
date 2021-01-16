
package Comparable;

import java.util.Arrays;

public class Test {
    
    public static void main(String[] args) {
        MovieComparable[] m = new MovieComparable[4];
        m[0] = new MovieComparable("A", 10.0, 2000);
        m[1] = new MovieComparable("H", 9.5, 2012);
        m[2] = new MovieComparable("B", 10.0, 1998);
        m[3] = new MovieComparable("C", 9.5, 2020);
        Arrays.sort(m); //ใช้ Object Arrays ที่เราจะ sort
        for (int i = 0; i < m.length; i++) { // ทำ for เพราะ Array ต้องปริ้นทีละช่อง
            System.out.println(m[i]);
        }
    }
    
}
