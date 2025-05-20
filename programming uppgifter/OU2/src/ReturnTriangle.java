
public class ReturnTriangle {

	// bisektris tar emot två sidor i en triangel och vinkeln(i radianer) mellan
	// dessa sidor.
	// Metoden returnerar längdenav den motsvarande bisektrisen -den som delar den
	// givnavinkeln
	// i två lika delar.
	public static double bisektris(double b, double c, double alfa) {
		double p = 2 * b * c * Math.cos(alfa / 2);
		double bis = p / (b + c);
		return bis;
	}

	// den här metoden är för utsidan radie
	public static double radieOutside(double a, double b, double c) {
		double s = (a + b + c) / 2; // s är semi perimeter av triangel
		return (a * b * c) / (4 * Math.sqrt(s * (s - a) * (s - b) * (s - c)));
	}
	
	// den här metoden är för insidan radie
	public static double radieInside(double a, double b, double c) {
		double s = (a + b + c) / 2;
		return Math.sqrt(((s - a) * (s - b) * (s - c)) / s);
	}

	// den här metoden är för arean av utsidan cirkel.
	public static double areaOutsideCircle(double a, double b, double c) {
		double r = radieOutside(a, b, c);
		return Math.PI * r * r;
	}

	// den här metoden är för arean av insidan cirkel.
	public static Double areaInsideCircle(double a, double b, double c) {
		double r = radieInside(a, b, c);
		return Math.PI * r * r;
	}

	// den här metoden är för arean av triengel.
	public static double areaTriangle(double a, double b, double c) {
		double s = (a + b + c) / 2;
		return Math.sqrt(((s - a) * (s - b) * (s - c)));
	}

	public static double circumferenceTriangle(double a, double b, double c) {
		return a + b + c;
	}
}
