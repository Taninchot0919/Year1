/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int102final_lab_exam1;

import java.lang.reflect.Field;

/**
 *
 * @author Umaporn
 */
public class TestFruit {
    public static void main(String[] args) {
        Fruit f=new Fruit("Apple", 10.5, 5);
        System.out.println(f);
        Class fc=f.getClass();
        System.out.println(fc);
        Field fields[]=fc.getDeclaredFields();
        for(Field fe: fields){
            System.out.println(fe);
            
        }
    }
}
