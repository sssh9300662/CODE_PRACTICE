package opennet;

import java.util.*;

// https://leetcode.com/discuss/interview-question/1930478/football-scores-hackerrank-question
public class FootballScore {

	public static void main(String[] args) {
		FootballScore fb = new FootballScore();
		Integer[] teamA = new Integer[]{1,2,3};
		Integer[] teamB = new Integer[]{2,4};
		System.out.println(fb.counts(Arrays.asList(teamA), Arrays.asList(teamB)));
		// TODO Auto-generated method stub

	}
	
	
	public List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
		List<Integer> result = new ArrayList<Integer>();
		Collections.sort(teamA);
		for(Integer score : teamB) {
			int startIndex = 0;
			int endIndex = teamA.size() - 1;
			while (startIndex <= endIndex) {
				int mid = (startIndex + endIndex) / 2;
				if (teamA.get(mid) > score) {
					endIndex = mid - 1;
				} else {
					startIndex = mid + 1;
				}
			}
			result.add(startIndex);
		}
		return result;
	    // Write your code here

	}

}
