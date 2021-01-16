package int102final_lab_exam1;

/**
 * FruitCollection class เก็บ array ของ Fruit
 */
public class FruitCollection {

    private Fruit[] fruits; // array เก็บผลไม้
    private int count; // จำนวนผลไม้ที่เก็บอยู่ใน array

    /**
     * constructor สร้าง FruitCollection 
     * ที่สามารถเก็บ Fruit ได้ทั้งหมด size ชนิด
     *
     * @param size คือ ขนาดของ FruitCollection ที่ต้องการสร้าง ซึ่งถ้า size
     * น้อยกว่าหรือเท่ากับ 0 จะสร้าง FruitCollection ที่มีขนาดเท่ากับ 1
     */
    public FruitCollection(int size) {
        size = (size > 0) ? size : 1;
        fruits = new Fruit[size];
    }

    public int getCount() { // given
        return count;
    }

    /**
     * ตรวจสอบว่า FruitCollection นี้เต็มแล้วหรือไม่
     *
     * @return true ถ้า FruitCollection นี้เต็มแล้ว; false ถ้า FruitCollection
     * นี้ยังไม่เต็ม
     */
    public boolean isFull() {
        return count == fruits.length;
    }

    /**
     * ใส่ผลไม้เข้าไปใน FruitCollection
     *
     * @param name ชื่อของผลไม้ที่ต้องการใส่
     * @param price ราคาของผลไม้ที่ต้องการใส่
     * @param quality คุณภาพของผลไม้ที่ต้องการใส่
     * @return false ถ้าไม่สามารถใส่ผลไม้เข้าไปใน FruitCollection ได้ เนื่องจาก
     * FruitCollection เต็ม หรือ price น้อยกว่า 0 หรือ quality ไม่ได้อยู่ในช่วง
     * 1 ถึง 10; true ถ้าสามารถใส่ผลไม้เข้าไปใน FruitCollection ได้
     */
    public boolean addFruit(String name, double price, int quality) {
        if (price < 0 || quality < 1 || quality > 10 || isFull()) {
            return false;
        }
        fruits[count++] = new Fruit(name, price, quality);
        return true;
    }

    /**
     * ขอ Fruit ใน FruitCollection ในช่อง slot
     *
     * @param slot ช่องที่ต้องการขอ Fruit จาก FruitCollection
     * @return null ถ้า slot ที่ขอไม่มีผลไม้หรือเกินขอบเขตของ array; Fruit
     * ในช่อง slot ของ FruitCollection ที่ขอ
     */
    public Fruit getFruitAt(int slot) {
        if (slot >= 0 && slot < count) {
            return fruits[slot];
        }
        return null;
    }

    /**
     * ขยายขนาดของ FruitCollection เพิ่มขึ้นอีก size และ return true แต่ถ้า size
     * น้อยกว่า 1 จะไม่ขยาย และจะ return false
     *
     * @param size ขนาดที่ต้องการเพิ่มขึ้น
     * @return true ถ้าทำสำเร็จ; false ถ้าไม่มีการขยาย
     */
    public boolean expand(int size) {
        if (size <= 0) {
            return false;
        }

        Fruit f[] = new Fruit[fruits.length + size];
        System.arraycopy(fruits, 0, f, 0, count);
        // for (int i = 0; i < count; i++) f[i] = fruits[i];
        fruits = f;
        return true;
    }

    /**
     * หาผลไม้ที่ชื่อ name ใน FruitCollection และ return
     * ตำแหน่งแรกที่พบผลไม้ตามชื่อนั้น หากไม่พบผลไม้ในชื่อนั้น หรือ name เป็น
     * null ให้ return -1
     *
     * @param name ชื่อของผลไม้ที่ต้องการหา
     * @return ตำแหน่งแรกที่พบ
     */
    public int searchForFruitName(String name) {
        if (name == null) {
            return -1;
        }
        for (int i = 0; i < count; i++) {
            if (name.equals(fruits[i].getName())) {
                return i;
            }
        }
        return -1;
    }
}
