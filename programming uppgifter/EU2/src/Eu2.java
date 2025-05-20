
public class Eu2 {

	public static void main(String[] args) {
		int[] arr = { 4, 7, 2, 8, 6, 9 };
		System.out.println(java.util.Arrays.toString(arr));
		System.out.println();

		int tempo;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					tempo = arr[i];
					arr[i] = arr[j];
					arr[j] = tempo;
					System.out.println(java.util.Arrays.toString(arr));
					System.out.println();

				}
			}
		}

		System.out.println("the last sort is " + java.util.Arrays.toString(arr));
	}
	
	/* Bevis för algoritmen
	 *  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
	 *  
	 *  A) INRE LOOPEN
	 *  	ETT PÅSTÅENDE OM INRE LOOPEN
	 *		
	 *		När den inre loopen har utförts, gäller följande:
	 *		xi = minimum {xi, xi+1, …, xn}
	 *		
	 *		BEVIS
	 *		
	 *		För varje iteration i den inre loopen, jämförs alla element
	 *		efter och från index i+1 med det element på index i.
	 *		Om de är mindre än det element som för tillfället finns på index i,
	 *		byter de plats och fortsätter med nästa tal.
	 *
	 *		På så sätt kommer alltid det minsta talet ligga på position i efter att den inre
	 *		loopen har utförts.
	 *
	 *  B) HUVUDLOOPEN
	 *  	ETT PÅSTÅENDE OM HUVUDLOOPEN
	 *  
	 *		När huvudloopen har utförts, gäller följande:
	 *		x1 < x2 < … < xn
	 *
	 *		BEVIS
	 *
	 *		Om den inre loopen alltid slutar med att det minsta talet
	 *		av alla tal efter i mängden, ligger på position i, så måste
	 *		alla tal ligga i storleksordning ifall man utför innerloopen på
	 *		varje tal index i mängden från vänster till höger (från 0 till mängdens längd)
	 *		då minsta talet kommer läggas först på index 0, sen näst största på index 1 (minsta
	 *		av de resesterande talen), osv..
	 */

}
