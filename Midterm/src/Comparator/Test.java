package Comparator;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        StudentComparator[] std = new StudentComparator[4]; //New Array
        StudentComparator s = new StudentComparator("A", 111); // New Object เพื่อที่จะใช้ Arrays.sort แบบ method
        std[0] = new StudentComparator("Art", 001);
        std[1] = new StudentComparator("Nestle", 006);
        std[2] = new StudentComparator("AArk", 121);
        std[3] = new StudentComparator("Airpod", 071);
        System.out.println("-- This is Normal Print --");
        for (int i = 0; i < std.length; i++) {
            System.out.println(std[i]);
        }
        System.out.println("-- Use Method --");
        Arrays.sort(std, s.nameCom());                  // Pattern อย่างงี้อุอิซ่าๆ
        for (int i = 0; i < std.length; i++) {
            System.out.println(std[i]);
        }

        Arrays.sort(std, new StudentComparator.idCompare());
        System.out.println("");
        System.out.println("-- This is ID Compare --");
        for (int i = 0; i < std.length; i++) {
            System.out.println(std[i]);
        }
        System.out.println("");
        Arrays.sort(std, new StudentComparator.nameCompare());
        System.out.println("-- This is Name Compare");
        for (int i = 0; i < std.length; i++) {
            System.out.println(std[i]);
        }
    }
}
