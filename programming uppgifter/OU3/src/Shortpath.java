import java.util.Scanner;

public class Shortpath {
	public static void main(String[] args) {

		Scanner inPut = new Scanner(System.in);

		// Read number of stations (nodes) in zone 2 and zone 3
		System.out.print("Please, enter the number of stations in zone 2: ");
		int zone2 = inPut.nextInt();
		System.out.println();
		System.out.print("Enter the number of stations in zone 3: ");
		int zone3 = inPut.nextInt();
		System.out.println();

		// Create storage arrays for the distances
		double[] a = new double[zone2 + 1];
		double[][] b = new double[zone2 + 1][zone3 + 1];
		double[] c = new double[zone3 + 1];

		// Insert distances of segments
		System.out.println("Please, enter the distance for the following segments.");
		for (int i = 1; i <= zone2; i++) {
			System.out.printf("X - U" + i + ": ");
			a[i] = inPut.nextDouble();
		}
		for (int i = 1; i <= zone2; i++) {
			for (int j = 1; j <= zone3; j++) {
				System.out.printf("U" + i + " to V" + j + ": ");
				b[i][j] = inPut.nextDouble();
			}
		}
		for (int j = 1; j <= zone3; j++) {
			System.out.printf("V" + j + " to Y: ");
			c[j] = inPut.nextDouble();
		}
		System.out.println();

		// Print the shortest path using the method intermediateStations from the class
		// TheShortestPath
		int[] pathStaioner = DenKortasteVagen.mellanstationer(a, b, c);
		System.out.println("The shortest path is: X to U" + pathStaioner[1] 
				+ " then to V" + pathStaioner[2] + " then to Y");

		// Print the length of the path using the method length from the class
		// TheShortestPath
		double length = DenKortasteVagen.lengd(a, b, c);
		System.out.println("The length is: " + length);

	}
}