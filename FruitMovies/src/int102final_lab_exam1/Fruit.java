package int102final_lab_exam1;

/**
 * Fruit class ผลไม้ มี name, price, quality
 */
public class Fruit {

    private final String name; // ชื่อผลไม้
    private final double price; // ราคาผลไม้ 
    private final int quality; // คุณภาพผลไม้ 10 คือ คุณภาพดี; 1 คือคุณภาพด้อย

    /**
     * Constructor สร้าง Fruit object โดยระบุชื่อผลไม้ ราคา และคุณภาพ
     *
     * @param name ชื่อผลไม้ โดยให้ชื่อเป็น "" ถ้าส่งมาเป็น null
     * @param price ราคา โดยให้ราคาเป็น 0 ถ้าส่งราคามาน้อยกว่า 0
     * @param quality คุณภาพ โดยให้คุณภาพเป็น 1
     * ถ้าส่งคุณภาพมาน้อยกว่า 1 และให้คุณภาพเป็น 10 ถ้าส่งคุณภาพมาเกิน 10
     */
    public Fruit(String name, double price, int quality) {
        this.name = (name == null) ? "" : name;
        this.price = (price < 0) ? 0 : price;
        this.quality = (quality < 1) ? 1 : (quality > 10) ? 10 : quality;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuality() {
        return quality;
    }

    /**
     * คืนค่าเป็น ชื่อผลไม้, ราคาเป็นทศนิยม 2 ตำแหน่ง, และคุณภาพ
     *
     * @return Name (price:#.00, quality:#)
     */
    @Override
    public String toString() {
        return String.format("%s (price:%.2f, quality:%d)", name, price, quality);
    }

    /**
     * เปรียบเทียบว่ามีรายละเอียดทุกอย่างเหมือนกันหรือไม่
     *
     * @param f ผลไม้อื่น
     * @return true ถ้าเป็นผลไม้ชื่อเดียวกัน ราคาเท่ากัน และคุณภาพเท่ากัน;
     * false ถ้า f เป็น null หรือ f มีชื่อ ราคา หรือคุณภาพ แตกต่างจากผลไม้นี้
     */
    public boolean equals(Fruit f) {
        return f != null && this.name.equals(f.name) && this.price == f.price && this.quality == f.quality;
    }

    /**
     * เปรียบเทียบว่า ผลไม้นี้ คุณภาพดีกว่า ด้อยกว่า หรือเท่ากันกับ ผลไม้ f
     *
     * @param f ผลไม้ที่ต้องการเปรียบเทียบ
     * @return 1 ถ้าผลไม้นี้คุณภาพดีกว่าผลไม้ f หรือผลไม้ f เป็น null; -1
     * ถ้าผลไม้นี้คุณภาพด้อยกว่าผลไม้ f; 0 ถ้าผลไม้นี้และผลไม้ f คุณภาพเท่ากัน
     */
    public int compareTo(Fruit f) {
        if (f == null) {
            return 1;
        }
        int val = this.quality - f.quality;
        return (val > 0) ? 1 : (val < 0) ? -1 : 0;
    }

}
