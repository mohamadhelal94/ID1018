
public class Punkt {

	String name;
	int x;
	int y;

	Punkt(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + this.name + " " + this.x + " " + this.y + ")";
	}

	public Punkt(Punkt p) {
		this.name = p.getNamn();
		this.x = p.getX();
		this.y = p.getY();
	}

	public String getNamn() {
		return name;
	}

	public void setNamn(String name) {
		this.name = name;

	}

	public double avstand() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public double avstand(Punkt p) {
		return Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
