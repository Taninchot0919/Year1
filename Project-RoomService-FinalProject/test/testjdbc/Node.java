/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjdbc;

/**
 *
 * @author Laptop
 */
public class Node<E> {

    public Node() {

    }
    E data;

    <T> void method1(T t) {
        //TODO
    }

    <T> T method2(T t) {
        //TODO
        return t;
    }

    public static void main(String[] args) {
        Node n = new Node();
        n.method1(123);
        String str = (String) n.method2("Test1234");
        System.out.println(str);
    }
}
