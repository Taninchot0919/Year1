
import java.util.*;

class A implements Comparable {

    private String x;

    A(String x) {
        this.x = x;
    }

    public String toString() {
        return "" + x;
    }

    public String getX() {
        return x;
    }

    public int compareTo(Object o) {

        A a = (A) o;
        int i = getX().compareTo(a.x);
        if (i != 0) {
            return -i;  // reverse sort
        }
        return getX().compareTo(a.x);
//        return (getX() < a.getX())?-1:0;
//         if(getX() > a.getX()){
//            return -1;
//        }else{
//            return 0;
//        }
    }

}

class ComparableTest {

    public static void main(String args[]) {

        A a[] = {new A("A"), new A("B"), new A("C")};

        Arrays.sort(a);

        System.out.println(Arrays.asList(a));

    }

}
