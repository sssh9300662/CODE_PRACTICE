import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintNumber {

	public static void main(String args[]) throws IOException{
        System.out.println("Print the n-th value in this series: 1, 3, 4, 7, 11, 18, 29, 47, 76, ...");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.valueOf(bufferedReader.readLine());
        printValue(index);
	}
	
	public static void printValue(int index) {
		if (index <= 0) {
			System.out.println("Value must greater than 0, try again");
			return;
		}
		
		int current_num = 2;
		int next_num =1;
		int result =0;
		
		if(index == 1){
			result = next_num;
		}else{
			for (int i = 1; i < index; i++) {
				result = current_num + next_num;
				current_num = next_num;
				next_num = result;
			}
		}
		
		System.out.println("Value is " + result);
	}
}
