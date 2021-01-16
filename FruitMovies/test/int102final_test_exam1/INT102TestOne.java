package int102final_test_exam1;

import int102final_lab_exam1.Fruit;
import int102final_lab_exam1.FruitCollection;
import java.lang.reflect.Field;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class INT102TestOne {

    private static final int ROUND = 100;

    /**
     * random a sign : return 1 or -1
     */
    private static int randomSign(boolean[] sign) {
        if (sign.length > 0 && sign[0]) {
            return Math.round(Math.random()) == 0 ? -1 : 1;
        }
        return 1;
    }

    /**
     * random an int i where 1 <= i <= bound
     *
     * @param bound the upper bound; if bound < 2, return 1 or -1 @param sign if
     * sign is true, it may return positive or negative value @return the int
     */
    private static int randomInt(int bound, boolean... sign) {
        if (bound < 2) {
            return randomSign(sign);
        }
        return randomSign(sign) * (1 + (int) (bound * Math.random()));
    }

    /**
     * random a double d where 0 <= d < bound
     *
     * @param bound the upper bound; if bound <= 0, return 0 @param sign if sign
     * is true, it may return positive or negative value @return the double
     */
    private static double randomDouble(double bound, boolean... sign) {
        if (bound <= 0) {
            return 0;
        }
        return randomSign(sign) * bound * Math.random();
    }

    /**
     * random a string with a given length and specified (upper/lower) case
     *
     * @param length the length of the string; if length <= 0, return "" @param
     * upper ถ้าเป็น true คือ ใช้ uppercase เท่านั้น; ถ้าเป็น false คือ ใช้
     * lowercase เท่านั้น; ถ้าไม่มี คือ ใช้ทั้ง uppercase และ lowercase @return
     * string ตามความยาวที่กำหนด และใช้ uppercase หรือ lowercase ตามที่กำหนด
     */
    private static String randomString(int length, boolean... upper) {
        if (length <= 0) {
            return "";
        }
        StringBuilder str = new StringBuilder(length);
        if (upper.length > 0) {
            char letter = upper[0] ? 'A' : 'a';
            for (int i = 0; i < length; i++) {
                str.append((char) (letter + randomInt('Z' - 'A' + 1) - 1));
            }
        } else {
            for (int i = 0; i < length; i++) {
                char letter = Math.round(Math.random()) == 0 ? 'A' : 'a';
                str.append((char) (letter + randomInt('Z' - 'A' + 1) - 1));
            }
        }
        return str.toString();
    }

    private static String getFruitName(Fruit fruit) {
        try {
            Field name = fruit.getClass().getDeclaredField("name");
            name.setAccessible(true);
            return (String) name.get(fruit);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("Fruit.name");
        }
        return null;
    }

    private static double getFruitPrice(Fruit fruit) {
        try {
            Field price = fruit.getClass().getDeclaredField("price");
            price.setAccessible(true);
            return price.getDouble(fruit);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("Fruit.price");
        }
        return 0.0;
    }

    private static int getFruitQuality(Fruit fruit) {
        try {
            Field quality = fruit.getClass().getDeclaredField("quality");
            quality.setAccessible(true);
            return quality.getInt(fruit);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("Fruit.quality");
        }
        return 1;
    }

    private static int getFruitCollectionCount(FruitCollection fc) {
        try {
            Field f = fc.getClass().getDeclaredField("count");
            f.setAccessible(true);
            return f.getInt(fc);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("FruitCollection.count");
        }
        return 0;
    }

    private static Fruit[] getFruitCollectionArray(FruitCollection fc) {
        try {
            Field f = fc.getClass().getDeclaredField("fruits");
            f.setAccessible(true);
            return (Fruit[]) f.get(fc);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("FruitCollection.fruits");
        }
        return null;
    }

    private static int getFruitCollectionSize(FruitCollection fc) {
        Fruit[] fruits = getFruitCollectionArray(fc);
        assertNotNull("FruitCollection.fruits.length", fruits);
        return fruits.length;
    }

    private static boolean isFruitAtEqual(FruitCollection fc, int slot, String name, double price, int quality) {
        try {
            Field f = fc.getClass().getDeclaredField("fruits");
            f.setAccessible(true);
            Fruit fruit = ((Fruit[]) f.get(fc))[slot];
            Class c = fruit.getClass();
            f = c.getDeclaredField("name");
            f.setAccessible(true);
            if (!name.equals((String) f.get(fruit))) {
                return false;
            }
            f = c.getDeclaredField("price");
            f.setAccessible(true);
            if (price != f.getDouble(fruit)) {
                return false;
            }
            f = c.getDeclaredField("quality");
            f.setAccessible(true);
            return quality == f.getInt(fruit);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("FruitCollection.fruits[].{name|price|quality}");
        }
        return false;
    }

    private static void addFruitAt(FruitCollection fc, int slot, String name, double price, int quality) {
        try {
            Class c = fc.getClass();
            Field f = c.getDeclaredField("fruits");
            f.setAccessible(true);
            ((Fruit[]) f.get(fc))[slot] = new Fruit(name, price, quality);
            f = c.getDeclaredField("count");
            f.setAccessible(true);
            f.setInt(fc, slot + 1);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            fail("FruitCollection.{fruits[]|count}");
        }
    }

    private static Fruit[] generateAllFruitCombination() {
        String[] names = new String[2];
        double[] prices = new double[2];
        int[] qualities = new int[2];
        names[0] = randomString(3 + randomInt(4));
        do {
            names[1] = randomString(3 + randomInt(4));
        } while (names[0].equals(names[1]));
        prices[0] = randomDouble(100.0);
        do {
            prices[1] = randomDouble(100.0);
        } while (prices[0] == prices[1]);
        qualities[0] = randomInt(10);
        do {
            qualities[1] = randomInt(10);
        } while (qualities[0] == qualities[1]);
        Fruit[] fruits = new Fruit[8];
        for (int n = 0; n < 2; n++) {
            for (int p = 0; p < 2; p++) {
                for (int q = 0; q < 2; q++) {
                    fruits[2 * (2 * n + p) + q] = new Fruit(new String(names[n]), prices[p], qualities[q]);
                    // เจตนาสร้าง String object ตัวใหม่
                }
            }
        }
        return fruits;
    }

    private static void generateFruitProperties(int size, String[][] names, double[][] prices, int[][] qualities) {
        if (size < 1) {
            size = 1;
        }
        names[0] = new String[size];
        prices[0] = new double[size];
        qualities[0] = new int[size];
        for (int i = 0; i < size; i++) {
            names[0][i] = randomString(3 + randomInt(4), true);
            prices[0][i] = randomDouble(100.0);
            qualities[0][i] = randomInt(10);
        }
    }

    /**
    รับชื่อ (name) ราคา (price) และคุณภาพ (quality) ของผลไม้เข้ามา 
    เพื่อสร้างเป็น Fruit object โดยมีเงื่อนไขการสร้างดังนี้ คือ 
    ถ้า name มีค่าเป็น null จะกำหนดให้ name เป็น "" (empty string), 
    ถ้า price มีค่าน้อยกว่า 0.0 จะกำหนดให้ price มีค่าเป็น 0.0, 
    ถ้า quality มีค่าน้อยกว่า 1 จะกำหนดให้ quality มีค่าเป็น 1 
    และถ้า quality มีค่ามากกว่า 10 จะกำหนดให้ มีค่าเป็น 10
     */
    @Test
    public void _01_testFruit_constructor_getters() {

        int CASES = 10;

        String names[] = new String[CASES + 2];
        for (int i = 0; i < CASES; i++) {
            names[i] = randomString(6);
        }
        names[CASES] = null;
        names[CASES + 1] = "";

        double prices[] = new double[CASES * 2 + 1];
        for (int i = 0; i < CASES; i++) {
            prices[i] = 100 - randomDouble(100.0);
            prices[CASES + i] = randomDouble(100.0);
        }
        prices[CASES] = 0.0;

        int qualities[] = new int[CASES * 3 + 4];
        for (int i = 0; i < CASES; i++) {
            qualities[i] = randomInt(10);
            qualities[CASES + i] = randomInt(10) - 10;
            qualities[CASES * 2 + i] = randomInt(10) + 10;
        }
        qualities[CASES * 3] = 0;
        qualities[CASES * 3 + 1] = 1;
        qualities[CASES * 3 + 2] = 10;
        qualities[CASES * 3 + 3] = 11;

        for (String name : names) {
            for (double price : prices) {
                for (int quality : qualities) {
                    name = (name==null? null : new String(name)); // เจตนาสร้าง String object ตัวใหม่
                    Fruit f = new Fruit(name, price, quality);
                    assertEquals("Fruit.getName()", (name==null? "" : name), f.getName());
                    assertEquals("Fruit.getPrice()", (price < 0) ? 0 : price, f.getPrice(), 0.001);
                    assertEquals("Fruit.getQuality()", (quality < 1) ? 1 : (quality > 10) ? 10 : quality, f.getQuality());
                }
            }
        }
    }

    /**
    return ในรูปแบบดังนี้ 
    $ (price:#.00, quality:#) เช่น 
    Apple (price:150.90, quality:10)
    */
    @Test
    public void _02_testFruit_toString() {
        for (int i = 0; i < ROUND; i++) {
            String name = randomString(6);
            double price = randomDouble(100.0);
            int quality = randomInt(10);
            Fruit f = new Fruit(name, price, quality);
            String expected = String.format("%s (price:%.2f, quality:%d)", name, price, quality);
            assertEquals("Fruit.toString()", expected, f.toString());
        }
    }

    /**
    รับอีก fruit หนึ่งเข้ามาเปรียบเทียบ โดย 
    (1) จะ return true ถ้าผลไม้นี้ (this) และผลไม้ที่รับเข้ามา 
    มีชื่อเหมือนกัน มีราคาเท่ากัน และมีคุณภาพเท่ากัน (เหมือนกันทุกประการ) หรือ 
    (2) method นี้จะ return ค่าเป็น false ถ้าผลไม้นี้ (this) และผลไม้ที่รับเข้ามา 
    มีชื่อต่างกัน หรือมีราคาต่างกัน หรือมีคุณภาพต่างกัน หรือผลไม้ที่รับเข้ามา มีค่าเป็น null
    */
    @Test
    public void _03_testFruit_equals() {

        assertFalse("Fruit.equals()-null",
                (new Fruit("", 0.0, 1)).equals(null)); // เจตนาเปรียบเทียบกับ null

        for (int i = 0; i < ROUND; i++) {
            Fruit[] fruits = generateAllFruitCombination();
            for (Fruit f1 : fruits) {
                for (Fruit f2 : fruits) {
                    if (f1 == f2) {
                        f2 = new Fruit(new String(getFruitName(f1)), getFruitPrice(f1), getFruitQuality(f1));
                        // เจตนาสร้าง String object ตัวใหม่
                        assertTrue("Fruit.equals()-true", f1.equals(f2));
                        assertTrue("Fruit.equals()-true", f2.equals(f1));
                    } else {
                        assertFalse("Fruit.equals()-false", f1.equals(f2));
                        assertFalse("Fruit.equals()-false", f2.equals(f1));
                    }
                }
            }
        }
    }

    /**
    รับอีก fruit หนึ่งเข้ามาเปรียบเทียบ โดย 
    (1) จะ return ค่าเป็น 1 ถ้าผลไม้นี้ (this) มีคุณภาพ (quality) 
    สูงกว่าผลไม้ที่รับเข้ามา หรือผลไม้ที่รับเข้ามา มีค่าเป็น null หรือ 
    (2) จะ return ค่าเป็น -1 ถ้าผลไม้นี้ (this) มีคุณภาพ (quality) 
    ต่ำกว่าผลไม้ที่รับเข้ามา แต่ 
    (3) ถ้าผลไม้ทั้งสองมีคุณภาพ (quality) เท่ากัน จะ return ค่าเป็น 0
     */
    @Test
    public void _04_testFruit_compareTo() {

        assertEquals("Fruit.compareTo()-null", 1, (new Fruit(null, 0.0, 10)).compareTo(null));

        for (int i = 0; i < ROUND; i++) {
            Fruit[] fruits = generateAllFruitCombination();
            for (Fruit f1 : fruits) {
                for (Fruit f2 : fruits) {
                    if (f1 == f2) {
                        f2 = new Fruit(new String(getFruitName(f1)), getFruitPrice(f1), getFruitQuality(f1));
                        // เจตนาสร้าง String object ตัวใหม่
                    }
                    assertTrue("Fruit.compareTo()-inverse", -1 * f2.compareTo(f1) == f1.compareTo(f2));
                    int q1 = getFruitQuality(f1);
                    int q2 = getFruitQuality(f2);
                    if (q1 == q2) {
                        assertEquals("Fruit.compareTo()-sameQaulity", 0, f1.compareTo(f2));
                    } else {
                        assertEquals("Fruit.compareTo()-differentQaulity", (q1 > q2) ? 1 : -1, f1.compareTo(f2));
                    }
                }
            }
        }
    }

    /**
    รับขนาด (size) เข้ามา เพื่อสร้าง Fruit array ที่มีขนาดเท่ากับ size ให้กับ fruits 
    แต่ถ้า size ที่รับเข้ามา มีค่าน้อยกว่า 1 จะสร้าง Fruit array ที่มีขนาดเท่ากับ 1 ให้กับ fruits 
    ขนาดของ array นี้บ่งบอกถึงความจุของ FruitCollection ว่าสามารถใส่ Fruit ลงไปได้กี่ครั้ง
    จึงจะเต็ม
    */
    @Test
    public void _05_testFruitCollection_constructor() {
        FruitCollection fc = new FruitCollection(0);
        assertEquals("FruitCollection.count", 0, getFruitCollectionCount(fc));
        assertEquals("FruitCollection.fruits.length", 1, getFruitCollectionSize(fc));

        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            fc = new FruitCollection(size);
            assertEquals("FruitCollection.count", 0, getFruitCollectionCount(fc));
            assertEquals("FruitCollection.fruits.length", size, getFruitCollectionSize(fc));
        }

        for (int i = 0; i < ROUND; i++) {
            fc = new FruitCollection(randomInt(10) - 20);
            assertEquals("FruitCollection.count", 0, getFruitCollectionCount(fc));
            assertEquals("FruitCollection.fruits.length", 1, getFruitCollectionSize(fc));
        }
    }

    /**
    ตรวจสอบว่า FruitCollection นี้ ได้บรรจุ Fruit เต็มแล้วหรือไม่ 
    (1) method นี้ return true ถ้า FruitCollection นี้เต็มแล้ว หรือ 
    (2) return false ถ้า FruitCollection นี้ยังไม่เต็ม
    */
    @Test
    public void _06_testFruitCollection_getCount_isFull() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            FruitCollection fc = new FruitCollection(size);
            for (int j = 0; j < size; j++) {
                assertEquals("FruitCollection.getCount()", j, fc.getCount());
                assertFalse("FruitCollection.isFull()", fc.isFull());
                addFruitAt(fc, j, "T", randomDouble(100.0), randomInt(10));
            }
            assertEquals("FruitCollection.getCount()", size, fc.getCount());
            assertTrue("FruitCollection.isFull()", fc.isFull());
        }
    }

    /**
    (1) เพิ่มผลไม้ที่มีชื่อเป็น name ราคามีค่าเป็น price และคุณภาพมีค่าเป็น quality เข้าไปใน FruitCollection 
    และนับจำนวนผลไม้ใน FruitCollection  เพิ่มขึ้นอีก 1 ก่อนจะ return ค่าเป็น true แต่ 
    (2) ถ้า FruitCollection นี้เต็มแล้ว หรือ price ที่รับเข้ามา มีค่าน้อยกว่า 0 หรือ quality ที่รับเข้ามา 
    ไม่ได้มีค่าอยู่ในช่วงของ 1 ถึง 10 จะ return เป็น false และไม่เพิ่มผลไม้เข้าไปใน FruitCollection
    */
    @Test
    public void _07_testFruitCollection_addFruit() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            FruitCollection fc = new FruitCollection(size);
            assertFalse("FruitCollection.addFruit()-false", fc.addFruit("F", randomDouble(100.0), 0));
            assertFalse("FruitCollection.addFruit()-false", fc.addFruit("F", randomDouble(100.0), randomInt(10) - 10));
            assertFalse("FruitCollection.addFruit()-false", fc.addFruit("F", randomDouble(100.0) - 200.0, randomInt(10)));
            assertFalse("FruitCollection.addFruit()-false", fc.addFruit("F", randomDouble(100.0) - 200.0, randomInt(10) - 10));
            assertEquals("FruitCollection.addFruit()-count", 0, getFruitCollectionCount(fc));
            for (int j = 0; j < size; j++) {
                double price = randomDouble(100.0);
                int quality = randomInt(10);
                assertTrue("FruitCollection.addFruit()-true", fc.addFruit("T", price, quality));
                assertTrue("FruitCollection.addFruit()-inside", isFruitAtEqual(fc, j, "T", price, quality));
                assertEquals("FruitCollection.addFruit()-count", j + 1, getFruitCollectionCount(fc));
            }
            assertFalse("FruitCollection.addFruit()-false", fc.addFruit("F", randomDouble(100.0), randomInt(10)));
            assertEquals("FruitCollection.addFruit()-count", size, getFruitCollectionCount(fc));
        }
    }

    /**
    (1) return Fruit ที่อยู่ในช่องที่ slot ของ FruitCollection 
    ถ้าช่อง (slot) ที่รับเข้ามา มีค่าตั้งแต่ 0 ขึ้นไป และไม่เกินช่องที่มีผลไม้อยู่ มิฉะนั้น 
    (2) method นี้จะ return ค่าเป็น null
    */
    @Test
    public void _08_testFruitCollection_getFruitAt() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(10);
            for (int count = 0; count <= size; count++) {
                FruitCollection fc = new FruitCollection(size);
                String[][] names = new String[1][];
                double[][] prices = new double[1][];
                int[][] qualities = new int[1][];
                generateFruitProperties(count, names, prices, qualities);
                for (int j = 0; j < count; j++) {
                    addFruitAt(fc, j, names[0][j], prices[0][j], qualities[0][j]);
                }
                for (int j = 0; j < count; j++) {
                    Fruit f = fc.getFruitAt(j);
                    assertEquals("FruitCollection.getFruitAt().name", names[0][j], getFruitName(f));
                    assertEquals("FruitCollection.getFruitAt().price", prices[0][j], getFruitPrice(f), 0.001);
                    assertEquals("FruitCollection.getFruitAt().quality", qualities[0][j], getFruitQuality(f));
                }
                for (int j = count; j < size * 2; j++) {
                    assertNull("FruitCollection.getFruitAt()-null",fc.getFruitAt(j));                    
                }
                for (int j = -10; j < 0; j++) {
                    assertNull("FruitCollection.getFruitAt()-null",fc.getFruitAt(j));
                }
            }
        }
    }

    /**
    (1) ขยายขนาดของ FruitCollection ขึ้นอีก size ช่อง (ขนาดใหม่ มีค่าเท่ากับ ขนาดเดิม + size) 
    และ return ค่าเป็น true แต่ 
    (2) ถ้าค่า size ที่รับเข้ามา มีค่าน้อยกว่า 1 จะไม่ขยายขนาดของ FruitCollection 
    และจะ return ค่าเป็น false
    */
    @Test
    public void _09_testFruitCollection_expand() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(5);
            String[][] names = new String[1][];
            double[][] prices = new double[1][];
            int[][] qualities = new int[1][];
            generateFruitProperties(size, names, prices, qualities);
            for (int count = 0; count < size; count++) {
                for (int expand = -5; expand < 10; expand++) {
                    FruitCollection fc = new FruitCollection(size);
                    for (int k = 0; k < count; k++) {
                        addFruitAt(fc, k, names[0][k], prices[0][k], qualities[0][k]);
                    }
                    if (expand < 1) {
                        assertFalse("FruitCollection.expand()-false", fc.expand(expand));
                    } else {
                        assertTrue("FruitCollection.expand()-true", fc.expand(expand));
                    }
                    int newSize = size + ((expand < 1) ? 0 : expand);
                    assertEquals("FruitCollection.expand()-count", count, getFruitCollectionCount(fc));
                    assertEquals("FruitCollection.expand()-size", newSize, getFruitCollectionSize(fc));
                    for (int j = 0; j < count; j++) {
                        assertTrue("FruitCollection.expand()-fruits", isFruitAtEqual(fc, j, names[0][j], prices[0][j], qualities[0][j]));
                    }
                    for (int j = count; j < newSize; j++) {
                        assertNull("FruitCollection.expand()-fruits", getFruitCollectionArray(fc)[j]);
                    }
                }

            }

        }
    }

    /**
    (1) return ค่าตำแหน่งช่องใน FruitCollection ที่มีผลไม้ที่มีชื่อ name ตามที่รับเข้ามา 
    หากมีผลไม้ที่มีชื่อ name ซ้ำกันหลายช่อง ให้ return ตำแหน่งช่องแรกสุดที่พบ โดยนับจากตำแหน่ง 0 เป็นช่องแรก 
    แต่ (2) หากว่าไม่มีผลไม้ในชื่อ name หรือ name ที่รับเข้ามา มีค่าเป็น null ให้ return ค่า -1
    */
    @Test
    public void _10_testFruitCollection_searchForFruitName() {
        for (int i = 0; i < ROUND; i++) {
            int size = 5 + randomInt(5);

            // generate fruit properties to add into the collection
            String[][] names = new String[1][];
            double[][] prices = new double[1][];
            int[][] qualities = new int[1][];
            generateFruitProperties(size, names, prices, qualities);

            // random a search name that is not in the generated properties
            boolean found;
            String target;
            do {
                found = false;
                target = randomString(3 + randomInt(4), true);
                for (int j = 0; j < size; j++) {
                    if (target.equals(names[0][j])) {
                        found = true;
                        break;
                    }
                }
            } while (found);

            // prepare the collection
            for (int count = 0; count < size; count++) {

                // generate 0-3 positions to have the targeted name
                int duplicate = count < 4 ? count : 4;
                for (int dup = 0; dup < duplicate; dup++) {
                    boolean[] same = new boolean[count];
                    int d = 0;
                    while (d < dup) {
                        int pos = randomInt(count);
                        if (!same[pos - 1]) {
                            same[pos - 1] = true;
                            d++;
                        }
                    }

                    // get first position that contains the targeted name
                    int first = -1;
                    for (int j = 0; j < count; j++) {
                        if (same[j]) {
                            first = j;
                            break;
                        }
                    }

                    // add fruit into the collection
                    FruitCollection fc = new FruitCollection(size);
                    for (int k = 0; k < count; k++) {
                        String n = same[k] ? target : names[0][k];
                        addFruitAt(fc, k, n, prices[0][k], qualities[0][k]);
                    }
                    assertEquals("FruitCollection.searchForFruitName()", -1, fc.searchForFruitName(null));
                    assertEquals("FruitCollection.searchForFruitName()", first, fc.searchForFruitName(target));
                }
            }
        }
    }

    @Test
    public void _00_testClassSpecification() {
        String packageName = "int102final_lab_exam1.";
        String[] classNames = {"Fruit", "FruitCollection"};
        String[][] attributes = {{"name", "price", "quality"}, {"fruits", "count"}};
        int[] constructors = {1, 1};
        String[][] methods = {{"getName", "getPrice", "getQuality", "toString", "equals", "compareTo"},
        {"getCount", "isFull", "addFruit", "getFruitAt", "expand", "searchForFruitName"}};

        Class[][][] params = {{{}, {}, {}, {}, {}, {}}, {{}, {}, {}, {}, {}, {}}};
        Class fr[], in[];

        fr = new Class[1];
        try {
            fr[0] = Class.forName(packageName + classNames[0]);
        } catch (ClassNotFoundException e) {
            fail(e.toString());
        }

        params[0][4] = params[0][5] = fr; // equals(Fruit f), compareTo(Fruit f)

        in = new Class[1];
        in[0] = int.class;
        params[1][3] = params[1][4] = in; // getFruitAt(int slot), expand(int size)

        params[1][2] = new Class[3]; // addFruit(String name, double price, int quality)
        params[1][2][0] = java.lang.String.class;
        params[1][2][1] = double.class;
        params[1][2][2] = int.class;

        params[1][5] = new Class[1];
        params[1][5][0] = java.lang.String.class; // searchForFruitName(String)

        for (int i = 0; i < classNames.length; i++) {
            testClass(packageName + classNames[i], attributes[i], constructors[i], methods[i], params[i]);
        }
    }

    private void testClass(String className, String[] attributes, int constructors, String[] methods, Class[][] params) {
        try {
            Class c = Class.forName(className);
            assertEquals("Spec:" + className + " (number of attributes)", attributes.length, c.getDeclaredFields().length);
            for (String attribute : attributes) {
                assertNotNull("Spec:" + className + "." + attribute, c.getDeclaredField(attribute));
            }
            assertEquals("Spec:" + className + "()", constructors, c.getDeclaredConstructors().length);
            assertEquals("Spec:" + className + " (number of methods)", methods.length, c.getDeclaredMethods().length);
            for (int i = 0; i < methods.length; i++) {
                assertNotNull("Spec:" + className + "." + methods[i] + "()", c.getDeclaredMethod(methods[i], params[i]));
            }
        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | SecurityException e) {
            fail("Invalid Class Specification");
        }
    }
}
