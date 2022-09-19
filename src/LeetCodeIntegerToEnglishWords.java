import java.util.HashMap;
import java.util.Map;

class Solution {
	public String numberToWords(int num) {
		if(num == 0){
			return "Zero";
		}
		Map<Integer, String> digitsUnitMap = new HashMap<>();
		digitsUnitMap.put(4, "Thousand");
		digitsUnitMap.put(5, "Thousand");
		digitsUnitMap.put(6, "Thousand");
		digitsUnitMap.put(7, "Million");
		digitsUnitMap.put(8, "Million");
		digitsUnitMap.put(9, "Million");
		digitsUnitMap.put(10, "Billion");

		String value = String.valueOf(num);
		Integer valueLength = value.length();
		String currentUnit = digitsUnitMap.get(valueLength);

		StringBuilder sb = new StringBuilder();
		StringBuilder digitStack = new StringBuilder();

		for(int i=1; i < valueLength + 1; i++){
			String digit = String.valueOf(value.charAt(i-1));
			digitStack.append(digit);
			if((valueLength -i)%3 == 0){
				System.out.println(digitStack.toString());
				StringBuilder textBuilder = getText(digitStack.toString());
				if(textBuilder.length() > 0){
					sb.append(textBuilder.toString());
					sb.append(" ");
					sb.append(currentUnit);
					sb.append(" ");
				}
				currentUnit = digitsUnitMap.get(valueLength -i);
				digitStack.setLength(0);
			}
			System.out.println(sb.toString());
		}
		if(digitStack.length() > 0){
			sb.append(getText(digitStack.toString()));
		}
		return sb.toString().replace("null", "").trim();
	}

	private static StringBuilder getText(String value) {
		StringBuilder sb = new StringBuilder();
		int number = Integer.valueOf(value);
		if(number == 0){
			return sb;
		}
		switch (String.valueOf(number).length()) {
			case 1:
				sb.append(getOne(number));
				break;
			case 2:
				sb.append(getTen(number));
				if(number > 20){
					Integer remainder = number%10;
					if(remainder > 0){
						sb.append(' ');
						sb.append(getOne(remainder));
					}
				}
				break;
			case 3:
				Integer quotient = number/100;
				sb.append(getOne(quotient));
				sb.append(' ');
				sb.append("Hundred");
				Integer remainder = number%100;
				if(remainder >= 10){
					sb.append(' ');
					sb.append(getTen(remainder));
					if(remainder > 20){
						remainder = remainder%10;
						if(remainder > 0){
							sb.append(' ');
							sb.append(getOne(remainder));
						}
					}
				}else{
					if(remainder > 0){
						sb.append(' ');
						sb.append(getOne(remainder));
					}
				}
				break;
			default:
				throw new RuntimeException();
		}
		return sb;
	}

	private static String getTen(int value) {
		switch (value/10)
		{
			case 1:
				return getTenUnderTwenty(value-10);
			case 2:
				return "Twenty";
			case 3:
				return "Thirty";
			case 4:
				return "Forty";
			case 5:
				return "Fifty";
			case 6:
				return "Sixty";
			case 7:
				return "Seventy";
			case 8:
				return "Eighty";
			case 9:
				return "Ninety";
			default:
				throw new RuntimeException();
		}
	}

	private static String getTenUnderTwenty(int value) {
		switch (value) {
			case 0:
				return "Ten";
			case 1:
				return "Eleven";
			case 2:
				return "Twelve";
			case 3:
				return "Thirteen";
			case 4:
				return "Fourteen";
			case 5:
				return "Fifteen";
			case 6:
				return "Sixteen";
			case 7:
				return "Seventeen";
			case 8:
				return "Eighteen";
			case 9:
				return "Nineteen";
			default:
				throw new RuntimeException();
		}
	}

	private static String getOne(int value) {
		switch (value) {
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			default:
				throw new RuntimeException();
		}
	}

	public static void main(String args[]){
		Solution solution = new Solution();
		System.out.println(solution.numberToWords(1000010));
	}
}
