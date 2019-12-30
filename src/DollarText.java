import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DollarText {
	
	private static boolean isSkipToNext = false;
	
	public static void main(String args[]){
		StringBuilder sb = new StringBuilder();
		getResult(getValue(), sb);
		System.out.println(sb.toString() + " Dollars");
	}

	private static void getResult(String dollarString, StringBuilder sb) {
		while(dollarString.length()> 0){
			System.out.println("bfore;" + dollarString);
			getDollarText(dollarString, sb);
			if(isSkipToNext){//Don't need check value in next digit, e.g. nineteen(19)
				dollarString = dollarString.substring(2);
				isSkipToNext = false;
			}else{
				dollarString = dollarString.substring(1);//Move to next digit
			}
			System.out.println("after:" + dollarString);
		}
	}

	private static void getDollarText(String value, StringBuilder sb) {
		switch (value.length()) {
		case 1:
			sb.append(getOne(value));
			break;
		case 2:
			sb.append(getTen(value));
			break;
		case 3:
			getHundred(value, sb);
			break;
		case 4:
		case 5:
		case 6:
			if(sb.toString().endsWith("Thousand")){
				break;
			}
			getThousand(value, sb);
			break;
		default:
			throw new RuntimeException();
		}
	}

	private static void getThousand(String value, StringBuilder sb) {
		int digit = value.length();
		String thousandValue = value.substring(0, digit -3);
		getResult(thousandValue, sb);
		sb.append("Thousand");
	}

	private static void getHundred(String value, StringBuilder sb) {
		sb.append(getOne(value.substring(0, 1)));
		if(!sb.toString().endsWith("Thousand")){
			sb.append("Hundred");
		}
	}

	private static String getTen(String value) {
		switch (Integer.valueOf(value.substring(0, 1)))
		{
			case 0:
				return "";
			case 1:
				isSkipToNext = true;
				return getTenUnderTwenty(value.substring(1));
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

	private static String getTenUnderTwenty(String value) {
		switch (Integer.valueOf(value)) {
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

	private static String getOne(String value) {
		switch (Integer.valueOf(value)) {
		  case 0:
			return "";
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

	private static String getValue() {
		System.out.println("Input dollar value, e.g. 1000000");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bufferedReader.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Cannot get input value");
	}

}
