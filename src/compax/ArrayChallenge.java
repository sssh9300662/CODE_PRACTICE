package compax;

/**
 * Take the array of positive integers stored in arr and perform the following algorithm:
 * continuously get the difference of adjacent integers to create a new array of integers,
 * then do the same for the new array until a single number is left and return that number.
 * For example: if arr is [4, 5, 1, 2, 7] then taking the difference of each pair of elements produces
 * the following new array: [1, 4, 1, 5]. Then do the same for this new array to produce [3, 3, 4] -> [0, 1] -> 1.
 * So for this example your program should return the number 1 because that is what’s left at the end.
 */
public class ArrayChallenge {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2};
        int length = arr.length;

        while(length > 1) {
            int[] arr2 = new int[length-1];
            for(int i = 0; i < length; i++) {
                if(i == length-1){
                    break;
                }
                int diff = Math.abs(arr[i] - arr[i+1]);
                arr2[i] = diff;
            }
            arr = arr2;
            length = arr.length;
        }

        System.out.println(arr[0]);
    }
}
