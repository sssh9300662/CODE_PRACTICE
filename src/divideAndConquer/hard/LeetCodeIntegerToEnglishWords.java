package divideAndConquer.hard;

/**
 * https://leetcode.com/problems/integer-to-english-words/solution/
 * 1. Consider outliers (Zero, Ten, Twenty....and so on)
 * 2. Maximum is billion
 * 3. Divide three digit to a group. thousand > million > billion
 * 4. Based on #3, rest is hundred. For hundred, it's one digit(getOne) + two digit (getTwo)
 * 5. each group (thousand,,,,) also contain at most three digit (Based on #4, we can have
 * function call getThree)
 */
class Solution {
	public String numberToWords(int num) {
		if(num == 0){
			return "Zero";
		}

		int billion = num / 1000000000;
		int million = (num - billion * 1000000000) / 1000000;
		int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
		int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

		String result = "";
		if (billion != 0)
			result = getThreeDigitText(billion) + " Billion";
		if (million != 0) {
			if (! result.isEmpty())
				result += " ";
			result += getThreeDigitText(million) + " Million";
		}
		if (thousand != 0) {
			if (! result.isEmpty())
				result += " ";
			result += getThreeDigitText(thousand) + " Thousand";
		}
		if (rest != 0) {
			if (! result.isEmpty())
				result += " ";
			result += getThreeDigitText(rest);
		}
		return result;
	}

	public String getThreeDigitText(int num) {
		int hundred = num / 100;
		int rest = num - hundred * 100;
		String res = "";
		if (hundred*rest != 0)
			res = getOne(hundred) + " Hundred " + getTwo(rest);
		else if ((hundred == 0) && (rest != 0))
			res = getTwo(rest);
		else if ((hundred != 0) && (rest == 0))
			res = getOne(hundred) + " Hundred";
		return res;
	}

	public String getTwo(int num) {
		if (num == 0)
			return "";
		else if (num < 10)
			return getOne(num);
		else if (num < 20)
			return getTwoLessThanTwenty(num);
		else {
			int tenner = num / 10;
			int rest = num - tenner * 10;
			if (rest != 0)
				return getTen(tenner) + " " + getOne(rest);
			else
				return getTen(tenner);
		}
	}

	private static String getTen(int value) {
		switch (value)
		{
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
		}
		return "";
	}

	private static String getTwoLessThanTwenty(int value) {
		switch (value) {
			case 10:
				return "Ten";
			case 11:
				return "Eleven";
			case 12:
				return "Twelve";
			case 13:
				return "Thirteen";
			case 14:
				return "Fourteen";
			case 15:
				return "Fifteen";
			case 16:
				return "Sixteen";
			case 17:
				return "Seventeen";
			case 18:
				return "Eighteen";
			case 19:
				return "Nineteen";
		}
		return "";
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
		}
		return "";
	}

	public static void main(String args[]){
		Solution solution = new Solution();
		System.out.println(solution.numberToWords(1000010));
	}
}
