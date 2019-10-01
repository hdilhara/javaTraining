package JavaPassByValue;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class PassByValue {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        System.out.println("X is : " + x + " and Y is : " + y);
        swap(x,y);
        System.out.println("X is : " + x + " and Y is : " + y);
    }

    public static void swap(int a, int b) {
        int c = a;
        a = b;
        b = c;
        System.out.println("A is : " + a + " and B is : " + b);
    }
}
