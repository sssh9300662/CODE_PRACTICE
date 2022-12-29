package basic;

import java.util.HashMap;
import java.util.Map;

public class NumberConversion {

    private Map<Integer, int[][]> intervalValueMap = new HashMap<>();
    public static void main(String[] args){
        int value= 0xFFFFFFFF;
        System.out.println(value);
        System.out.println((value >>> 31));//不保留正負符號

        long a =100;
        long c= 3;
        double b = 100.1d;
        System.out.println(a == b);
        System.out.println(a == Double.valueOf(b).intValue());
        System.out.println(a == (int)b);
        System.out.println(1%3);
        System.out.println("duck");

    }
}
