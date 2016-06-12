import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxRangeSum {

	public static void main(String args[]){
	     String values[] = getValues();
	     int maxRangeSum = getMaxRangeSum(values);
	     System.out.println("Max range sum is " + maxRangeSum);
	}
	
	private static String[] getValues() {
		System.out.println("Input integer series, e.g. 1,3,4,7,11,18,29,47,76, ...");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bufferedReader.readLine().trim().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Cannot get input value");
	}

	private static int getMaxRangeSum(String values[]){
		int globalMaxSum = Integer.valueOf(values[0]);
		for(int i =0; i < values.length; i++){
			int currentMaxSum = Integer.valueOf(values[i]);
			for(int j = i+1; j < values.length; j++){
				if(Integer.valueOf(values[j]) < 0){
					//for negative max
					if(currentMaxSum < Integer.valueOf(values[j])){
						currentMaxSum = Integer.valueOf(values[j]);
						globalMaxSum = judgeMaxSum(globalMaxSum, currentMaxSum);
					}
					//skip negative number
					continue;
				}
				//for positive max
				currentMaxSum = currentMaxSum + Integer.valueOf(values[j]);
				globalMaxSum = judgeMaxSum(globalMaxSum, currentMaxSum);
			}
			//for the last num is max
			globalMaxSum = judgeMaxSum(globalMaxSum, currentMaxSum);
		}
		return globalMaxSum;
	}

	private static int judgeMaxSum(int maxSum, int currentSum) {
		System.out.println("maxSum is " + maxSum + " and current is " + currentSum);
		if(maxSum > currentSum){
			return maxSum;
		}
		return currentSum;
	}
}
