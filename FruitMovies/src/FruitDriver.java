
import int102final_lab_exam1.Fruit;
import int102final_lab_exam1.FruitCollection;


public class FruitDriver {
    public static void main(String[] args) {
        Fruit a = new Fruit("Apple", 150.9, 10);
        Fruit b = new Fruit("Banana", 48.52, 6);
        System.out.println(a);
        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));

        FruitCollection fc = new FruitCollection(2);
        fc.addFruit("Cherry", 85.179, 8);
        fc.addFruit("Date", 94.62, 9);
        fc.expand(1);
        fc.addFruit("Kiwi", 64.93, 7);
        for (int i = 0; i < fc.getCount(); i++) {
            System.out.println("No:" + i + " :: " + fc.getFruitAt(i));
        }
        int s = fc.searchForFruitName("Cherry");
        if (s>=0) {
            System.out.println(fc.getFruitAt(s));
        }
    }
    
}
