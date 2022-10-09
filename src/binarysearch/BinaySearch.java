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

    /**
     * 多個重複值，那該怎麼辦呢？最左或最右
     */
    public static int binarySearchForDuplicateValue(final int[] array, final int targetElement) {
        int start = 0;
        int end = array.length - 1;
        while (end >= start) {
            final int middle = (end + start) >>> 1;//unsigned right shift右移一位 ＝ 除以2
            if (targetElement <= array[middle]) {//不能直接return middle(可能是中間), 如果要找最右邊的移除=
                end = middle - 1; // 往左邊找
            } else {
                start = middle + 1; // 往右邊找
            }
        }
        return start;
    }

    public static void main(String args[]) {
        int[] array = new int[]{0,1,3,6,9};
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch(array, 6));
        System.out.println(Arrays.binarySearch(array, 3));
        int[] array2 = new int[]{1,3,4,4,4,7,8};
        System.out.println(binarySearchForDuplicateValue(array2, 3));
        System.out.println(binarySearchForDuplicateValue(array2, 4));
        System.out.println(binarySearchForDuplicateValue(array2, 5));
        System.out.println(binarySearchForDuplicateValue(array2, 11));
    }
}
