package opennet;

import java.util.*;

public class OpenNetTest1 {

	public static void main(String[] args) {
		OpenNetTest1 obj = new OpenNetTest1();
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(3);
		numbers.add(3);
		numbers.add(4);
		numbers.add(4);
		System.out.println(obj.countNonUnique(numbers));
		// TODO Auto-generated method stub

	}
	
	
	public static int countNonUnique(List<Integer> numbers) {
		Map<Integer, Integer> map = new HashMap<>();
		for(Integer number : numbers) {
			int curCount = Optional.ofNullable(map.get(number)).orElse(0);
			map.put(number, curCount + 1);
		}
		System.out.println(map);
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1){
				count++;
			}
		}
		return count;
	}


}
