
class DenKortasteVagen {

	public static int[] mellanstationer(double[] a, double[][] b, double[] c) {
		int[] mellanstation = { 0, 1, 1 };
		double shortPath = a[1] + b[1][1] + c[1];

		// den här loopen använder för hitta den kortaste vägen och spara
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < c.length; j++) {
				double tillfaliga = a[i] + b[i][j] + c[j];
				// om den tillfaliga path är mindre än den kortaste vägen då kortapassen ändrar
				// till den tillfaliga
				if (tillfaliga < shortPath) {
					mellanstation[1] = i;
					mellanstation[2] = j;
					shortPath = tillfaliga;
				}
			}
		}
		return mellanstation;
	}

	public static double lengd(double[] a, double[][] b, double[] c) {
		// här vi kallar den mellanstationers method
		int[] s = mellanstationer(a, b, c);
		// för att addera tottalt den kortaste vägen
		return a[s[1]] + b[s[1]][s[2]] + c[s[2]];
	}
}