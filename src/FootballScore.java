import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FootballScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
		List<Integer> result = new ArrayList<Integer>();
		Collections.sort(teamA);
		Collections.sort(teamB);
		Set<Integer> pre = new HashSet<Integer>();
		for(Integer score : teamB) {
			int count = 0;
			for(Integer score_A : teamA) {
				if(pre.contains(score_A)) {
					continue;
				}
				if(score_A <= score) {
					pre.add(score_A);
					count++;
				}
			}
			result.add(pre.size() + count);
		}
		return result;
	    // Write your code here

	}

}
