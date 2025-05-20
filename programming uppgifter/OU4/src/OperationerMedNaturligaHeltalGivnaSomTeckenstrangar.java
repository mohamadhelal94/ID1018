import java.util.*; // Scanner 
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
	public static void main(String[] args) {
		out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

		// mata in två naturliga heltal
		Scanner in = new Scanner(System.in);
		out.println("två naturliga heltal:");
		String tal1 = in.next();
		String tal2 = in.next();
		out.println();

		// addera heltalen och visa resultatet
		String summa = addera(tal1, tal2);
		visa(tal1, tal2, summa, '+');

		// subtrahera heltalen och visa resultatet
		String substruct = substrahera(tal1, tal2);
		visa(tal1, tal2, substruct, '-');

	}

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
			carry = sum / 10;
			result.append(sum);

			p1--;
		}
		while (p2 >= 0) {
			num2 = tal2.charAt(p2) - 48;
			sum = num2 + carry;
			carry = sum / 10;
			result.append(sum);
			p2--;
		}

		if (carry != 0)
			result.append(carry);
		result.reverse();
		return result.toString();

	}

	public static String substrahera(String tal1, String tal2) {
		StringBuilder result = new StringBuilder();
		int num1 = 0;
		int num2 = 0;
		int diff = 0;
		Boolean lon = false;
		int p1 = tal1.length() - 1;
		int p2 = tal2.length() - 1;
		while (p1 >= 0 && p2 >= 0) {
			num1 = tal1.charAt(p1) - 48;
			num2 = tal2.charAt(p2) - 48;

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
	// visa visar två givna naturliga heltal, och resultatet av en aritmetisk
	// operation
	// utförd i samband med hetalen
	public static void visa(String tal1, String tal2, String resultat, char operator) {
		// sätt en lämplig längd på heltalen och resultatet
		int len1 = tal1.length();
		int len2 = tal2.length();
		int len = resultat.length();
		int maxLen = Math.max(Math.max(len1, len2), len);
		tal1 = sattLen(tal1, maxLen - len1);
		tal2 = sattLen(tal2, maxLen - len2);
		resultat = sattLen(resultat, maxLen - len);

		// visa heltalen och resultatet
		out.println("  " + tal1);
		out.println("" + operator + " " + tal2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print("-");
		out.println();
		out.println("  " + resultat + "\n");
	}

	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
	public static String sattLen(String s, int antal) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < antal; i++)
			sb.insert(0, " ");
		return sb.toString();
	}
}
