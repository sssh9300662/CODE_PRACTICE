import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenNetTest1 {

	public static void main(String[] args) {
		OpenNetTest1 obj = new OpenNetTest1();
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(3);
		numbers.add(4);
		numbers.add(4);
		System.out.println(obj.countNonUnique(numbers));
		// TODO Auto-generated method stub

	}
	
	
	public static int countNonUnique(List<Integer> numbers) {
		Set<Integer> result = new HashSet<Integer>();
		int count = 0;
		for(Integer number : numbers) {
			if(result.contains(number)) {
				count++;
			}else {
				result.add(number);
			}
		}
		return count;
	    // Write your code here

	}


}
