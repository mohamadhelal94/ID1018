import java.util.Scanner;

public class PolyLinjeTest {

	public static void main(String[] args) {
		Scanner inPut = new Scanner(System.in);
		Punkt p1 = new Punkt("A", 3, 4);
		Punkt p2 = new Punkt("B", 5, 6);
		Punkt p3 = new Punkt("C", 8, 2);
		Punkt p5 = new Punkt("E", 7, 9);
		Punkt p4 = new Punkt("D", 4, 1);
//		Punkt p5 = new Punkt("E", 7, 9);

		System.out.println(" " + p1 + p2 + p3);
		System.out.println();

		Punkt[] arrayPunkt = { p1, p2, p3 };
		Polylinje poly = new Polylinje(arrayPunkt);
		System.out.println("Current Colour is " + poly.getFarg());
		System.out.println();
		System.out.println("Enter new Colour ");
		poly.setFarg(inPut.next());
		System.out.println("Current Colour is now " + poly.getFarg());
		System.out.println();

		System.out.println("Current Width is " + poly.getBredd());
		System.out.println();
		System.out.println("Enter the new Width ");
		poly.setBredd(inPut.nextInt());
		System.out.println("Current Width is now " + poly.getBredd());
		System.out.println();

		System.out.println("Polyline length is " + poly.langd());
		System.out.println();

		System.out.println("Adding Punkt E att the end ");
		poly.laggTill(p5);
		System.out.println(poly);
		System.out.println();

		System.out.println("Adding Punkt D befor E");
		poly.laggTillFramfor(p4, "E");
		System.out.println(poly);
		System.out.println();

		System.out.println("Removing Punkt C");
		poly.taBort("C");
		System.out.println(poly);
		System.out.println();
		
		Polylinje.PolylinjeIterator pp =  poly.new PolylinjeIterator();
		while(pp.finnsHorn()) {
			System.out.println(pp.finnsHorn());
			System.out.println(pp.horn());
			
			pp.gaFram();
		}

	}

}
