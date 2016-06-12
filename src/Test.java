import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String args[]) {
		Integer[] raw_data_array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> even = new ArrayList<Integer>();
		
		for (int i : raw_data_array) {
		    if ((i & 1) == 1) {
		        odd.add(i);
		    } else {
		        even.add(i);
		    }
		}
		
		Collections.sort(odd);
		Collections.sort(even);
		odd.addAll(even);
		
		Integer[] result_data_array = new Integer[odd.size()];
		result_data_array = odd.toArray(result_data_array);
		
		for(int value:result_data_array){
			System.out.println(value);
		}
	}
}
