import static java.lang.System.out;

import java.util.Iterator;

public class PolylinjeTest {

	public static void main(String[] args) {
		polyInterface polylinje = null;
		polylinje = new NPolylinje(); // (1) for linkedlist
//		polylinje = new VPolylinje (); // (2) for arraylist

		polylinje.laggTill(new Punkt("A", 2, 4));
		polylinje.laggTill(new Punkt("B", 6, 1));
		polylinje.laggTill(new Punkt("C", 8, 12));
		polylinje.laggTill(new Punkt("F", 4, 2));
		polylinje.laggTill(new Punkt("E", 14, 23));

		out.println(polylinje);
		out.println();

		polylinje.taBort("C");
		polylinje.laggTillFramfor(new Punkt("D", 5, 4), "B");
		

		polylinje.setFarg("yellow");

		out.println(polylinje);

		for (Punkt horn : polylinje)
			out.println(horn);

		out.println(Polylinjer.shortestYellow(new polyInterface[] { polylinje }));

		Iterator<Punkt> iter = polylinje.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());

		}
	}

}