package Arrays;

public class Test {
    public static void main(String[] args) {
        Company c = new Company(1);
        c.add("ArTTho", 1);
        c.add("Beta", 2);
        c.add("Ceta", 3);
        c.add("EIEI", 666);
        c.display();
        System.out.println("------------------");
        c.remove("EIEI");
        c.display();
    }
}
