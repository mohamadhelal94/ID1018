import java.util.Scanner;
public class Triangle {

	public static void main(String[] args) {
//		ReturnTriangle.bisektris(5, , 30);
		// den här scanner sparar inputen för att beräkna
		Scanner inPut = new Scanner(System.in);
		System.out.println("write your number side ");
		double a = inPut.nextDouble();	
		double b = inPut.nextDouble();		 		
		double c = inPut.nextDouble();		
		
		// den här är för att kalla metoden som finns i andra classen som heter triangle return
		double outside = ReturnTriangle.radieOutside(a, b, c);
		double inside = ReturnTriangle.radieInside(a, b, c);
		double areatriangle = ReturnTriangle.areaTriangle(a, b, c);
		double areautsidan = ReturnTriangle.areaOutsideCircle(a, b, c);
		double areainsidan = ReturnTriangle.areaOutsideCircle(a, b, c);
		double circumference = ReturnTriangle.circumferenceTriangle(a, b, c);
		
		// den här är för att se resultaten 
		System.out.println("   the result \n ");
		System.out.println("the outside radius is " + outside);		
		System.out.println("the inside radius is " + inside);
		System.out.println("the area of triangle is " + areatriangle);
		System.out.println("the inside area is " + areautsidan);
		System.out.println("the inside area is " + areautsidan);
		System.out.println("the circumference is " + circumference);
	}
}
