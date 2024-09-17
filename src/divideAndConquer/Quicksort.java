package divideAndConquer;

// https://www.algolist.net/Algorithms/Sorting/Quicksort
public class Quicksort {

    public static void main(String args[]){
        Quicksort q = new Quicksort();
        int[] input = new int[]{1, 12, 5, 26, 7, 14, 3, 7, 2};
        q.sort(input, 0, input.length-1);
        for(int num: input){
            System.out.println("########");
            System.out.println(num);
        }
    }

    public void sort(int[] input, int start, int end){
        if(start < end){
            int pivotIndex = partition(input, start, end);
            sort(input, start, pivotIndex - 1);
            sort(input, pivotIndex, end);
        }
    }

    /**
     * There are two indices i and j and at the very beginning of the partition algorithm i points
     * to the first element in the array and j points to the last one. Then algorithm moves i forward,
     * until an element with value greater or equal to the pivot is found. Index j is moved backward,
     * until an element with value lesser or equal to the pivot is found.
     * If i ≤ j then they are swapped and i steps to the next position (i + 1),
     * j steps to the previous one (j - 1). Algorithm stops, when i becomes greater than j.
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] arr, int start, int end){
        int pivot = arr[(start + end) >>>1]; //取 中間數
        while (start <= end) {//還沒走完則繼續左右比對
            while (arr[start] < pivot) // 左邊都要小於中間,是的話pass
                start++;
            while (arr[end] > pivot) // 右邊都要大於中間,是的話pass
                end--;
            // 1. 右邊有小於中間值, 且左邊有大於中間值
            // 2. 原本就已排序, start == end;
            // 3. 左邊排序完成,走過中間,右半邊沒排序好
            if (start <= end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        };
        System.out.println("pivotIndex=" + start);
        return start;
    }
}
