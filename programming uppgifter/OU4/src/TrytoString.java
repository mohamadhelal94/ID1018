
public class TrytoString {

	public static String addera(String tal1, String tal2) {
		StringBuilder result = new StringBuilder();
		int carry = 0;
		int num1 = 0;
		int num2 = 0;
		int p1 = tal1.length() - 1;
		int p2 = tal2.length() - 1;
		int sum = 0;

		while (p1 >= 0 && p2 >= 0) {
			num1 = tal1.charAt(p1) - 48;
			num2 = tal2.charAt(p2) - 48;
			sum = num1 + num2 + carry;
			carry = sum / 10;
			result.append(sum % 10);
			p1--;
			p2--;
		}
		while (p1 >= 0) {
			num1 = tal1.charAt(p1) - 48;
			sum = num1 + carry;
			result.append(sum);
		}
		while (p2 >= 0) {
			num2 = tal2.charAt(p2) - 48;
			sum = num2 + carry;
			result.append(sum);
		}
		result.reverse();
		return result.toString();
	}
	/*public static String substruct (String tal1, String tal2) {
		StringBuilder result = new StringBuilder();
		int carry = 0;
		int num1 = 0;
		int num2 = 0;
		int diff = 0;
		for(int i = tal1.length() - 1; i > 0; i--) {
//			num1 = tal1.charAt(i) - 48;
			 num1 = Character.getNumericValue(tal1.charAt(i)) - carry;
//			num2 = tal2.charAt(i) - 48;
			num2 = Character.getNumericValue(tal2.charAt(i));
			if(num1 > num2) {
				diff = num1 - num2;
				carry = 0;
			}else {
				diff = (num1 + 10) - num2;
				carry = 1;
			}
			result.append(String.valueOf(diff));
		}
		result.reverse();
		return result.toString();
	}*/

	public static String substrahera(String tal1, String tal2) {
		StringBuilder result = new StringBuilder();
		Boolean lon = false;
		int num1 = 0;
		int num2 = 0;
		
		int diff = 0;
		int p1 = tal1.length() - 1;
		int p2 = tal2.length() - 1;
		while (p1 > 0 && p2 > 0) {
			num1 = tal1.charAt(p1) - 48;
			num2 = tal2.charAt(p2) - 48;
//			
			if (lon == true && num1 != 0) {
				num1--;
				lon = false;
			}
			if (lon == true && num1 == 0) {
				num1 = 10 - 1;
			}
			if (num1 >= num2) {
				diff = num1 - num2;
				result.append(diff);
			}
			if (num1 < num2) {
				num1 += 10;
				diff = num1 - num2;
				result.append(diff);
				lon = true;
			}
			p1--;
			p2--;
		}
		while (p1 >= 0) {
			num1 = tal1.charAt(p1) - 48;
			if (lon == true) {
				num1--;
				result.append(num1);
			} else {
				result.append(num1);
			}
			p1--;
		}
		result.reverse();
		while (result.charAt(0) == '0' && result.length() > 1) {
			result.deleteCharAt(0);
		}
	
		return result.toString();
	}
		
}

