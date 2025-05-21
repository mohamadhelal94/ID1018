import java.util.*;

public class EU1 {

	public static void main(String[] args) {
		int[] aray = { 11, 23, 32, 45, 57, 61, 77, 82, 94, 10, 117, 12, 34, 42, 18, 100, /*2, 68, 50*/ };
		System.out.print(min(aray));
//		System.out.print(minMax(aray));
	}

	public static int min(int[] element) throws IllegalArgumentException {
		if (element.length == 0)
			throw new IllegalArgumentException("tom samling");

		// ör ihop med spårutskriften 2:
		int antalVarv = 1;

		int[] sekvens = element;
		int antaletPar = sekvens.length / 2;
		int antaletOparadeElement = sekvens.length % 2;
		int antaletTankbaraElement = antaletPar + antaletOparadeElement;
		int[] delsekvens = new int[antaletTankbaraElement];
		int i = 0;
		int j = 0;
		while (antaletPar > 0) {	
			// skilj ur en delsekvens med de tänkbara elementen
			i = 0;
			j = 0;
			while (j < antaletPar) {
				delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
				i += 2;
//				System.out.println(java.util.Arrays.toString(sekvens));
			}
			if (antaletOparadeElement == 1)
				delsekvens[j] = sekvens[i];

			// utgå nu ifrån delsekvensen
			sekvens = delsekvens;
			antaletPar = antaletTankbaraElement / 2;
			antaletOparadeElement = antaletTankbaraElement % 2;
			antaletTankbaraElement = antaletPar + antaletOparadeElement;

			// spårutskrift 1 – för att följa sekvensen
			 System.out.println (java.util.Arrays.toString (sekvens));

			// spårutskrift 2 - för att avsluta loopen i förväg
			// (för att kunna se vad som händer i början)
			if (antalVarv++ == 10)
				System.exit(0);
		}

		// sekvens[0] är det enda återstående tänkbara elementet
		// - det är det minsta elementet
		return sekvens[0];
	}

	public static int minMax(int[] element) {
		int[] sekvens = element;
		int minVarde = sekvens[0];
		int maxVarde = sekvens[0];
		for (int i = 0; i < sekvens.length; i++) {
			if (sekvens[i] < minVarde) {
				minVarde = sekvens[i];
			}
			if (sekvens[i] > maxVarde) {
				maxVarde = sekvens[i];
			}
		}
		System.out.println(java.util.Arrays.toString(sekvens));
		System.out.println("den minsta varde ar " + minVarde);
		System.out.println("den storsta varde ar " + maxVarde);
		return minVarde;
	}

}
