package binarysearch;

import java.util.Arrays;

public class BinaySearch {

    public static int binarySearch(final int[] array, final int targetElement) {
        int start = 0;
        int end = array.length - 1;

        while (end >= start) {
            final int middle = (end + start) >>> 1;//unsigned right shift右移一位 ＝ 除以2
            if (targetElement == array[middle] ) {
                return middle;
            } else if (targetElement > array[middle]) {
                start = middle + 1; // 直接切右半癲
            } else {
                end = middle - 1; // 直接切左半癲
            }
        }
        return -1;
        /**
         * 往往我們無法真的找到 target，但我們還是想要一個最接近 target 的答案，那該怎麼辦呢？
         * Ans: return start
         */

    }

    public static void main(String args[]) {
        int[] array = new int[]{0,1,3,6,9};
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch(array, 6));
        System.out.println(Arrays.binarySearch(array, 3));
    }
}
