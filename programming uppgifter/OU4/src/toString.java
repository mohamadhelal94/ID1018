
public class toString {
	
	// denna metod ändrar från string till double och adderar och sedan retunerar;
	public static String addera(String tal1, String tal2) 
	{
		double sum = (Double.parseDouble(tal1) + Double.parseDouble(tal2));
		return Double.toString(sum);
	}

	// denna metod ändrar från string till double och subrtaherar och sedan retunerar;
	public static String subtrahera(String tal1, String tal2) 
	{
		double sum = (Double.parseDouble(tal1) - Double.parseDouble(tal2));
		return Double.toString(sum);
	}

	// denna metod ändrar från string till double och gångrar och sedan retunerar;
	public static String multipulicera(String tal1, String tal2) 
	{
		double sum = (Double.parseDouble(tal1) * Double.parseDouble(tal2));
		return Double.toString(sum);
	}

	// denna metod ändrar från string till double och dividerar och sedan retunerar;
	public static String dividera(String tal1, String tal2) 
	{
		double sum = (Double.parseDouble(tal1) / Double.parseDouble(tal2));
		return Double.toString(sum);
	}
}
