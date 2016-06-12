import java.util.TreeMap;

public class TreeMapTest {
	
	public static void main(String args[]){
		String[] raw_data_array = {"AA", "CC", "BB", "BB", "CC", "CC"};
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(); 
		
		for(int i=0; i<raw_data_array.length; i++){
			String key = raw_data_array[i];
			if(result.get(key)!= null){
				int count = result.get(key)+1;
				result.put(key, count);
			}else{
				result.put(key, 1);
			}
		}
		for(String key:result.descendingKeySet()){
			System.out.println(key + ":" + result.get(key));
		}
	}
}

