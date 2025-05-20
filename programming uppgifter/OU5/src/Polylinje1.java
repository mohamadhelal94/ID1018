import java.util.Arrays;

public class Polylinje1 {
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje1() {
		this.horn = new Punkt[0];
	}

	public Polylinje1(Punkt[] horn) {
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt(horn[i]);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for (int i = 0; i < horn.length - 1; i++) {
			sb.append(horn[i] + ", ");
		}
		sb.append(horn[horn.length - 1] + "}");
		return sb.toString();
	}

	public Punkt[] getHorn() {
		return this.horn;
	}

	public String getFarg() {
		return farg;
	}

	public int getBredd() {
		return bredd;
	}

	public void setFarg(String farg) {
		this.farg = farg;
	}

	public void setBredd(int bredd) {
		this.bredd = bredd;
	}

	public double langd() {
		double length = 0;
		for (int i = 0; i < this.horn.length - 1; i++) {
			length += this.horn[i].avstand(this.horn[i + 1]);
		}
		return length;
	}

	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);

		this.horn = h;
	}

	public void laggTillFramfor(Punkt horn, String hornNamn) {
		Punkt newHorn = new Punkt(horn);
		Punkt[] arrayHorn = new Punkt[this.horn.length + 1];
		int index = 0;
		for (int i = 0; i < this.horn.length; i++) {
			if (this.horn[i].getNamn().equals(hornNamn)) {
				index = i;
				break;
			}

		}
		for (int i = 0; i < arrayHorn.length - 1; i++) {
//			arrayHorn[i < index ? i : i + 1] = this.horn[i];
			if (i < index) {
				arrayHorn[i] = this.horn[i];
			} else if (i >= index) {
				arrayHorn[i + 1] = this.horn[i];
			}
		}
		arrayHorn[index] = newHorn;
		this.horn = arrayHorn;
	}

	public void taBort(String hornNamn) {
		Punkt[] arrayHorn = new Punkt[this.horn.length - 1];
		int index = 0;
		for (int i = 0; i < this.horn.length; i++) {
			if (this.horn[i].getNamn().equals(hornNamn)) {
				index = i;
				break;
			}
		}
		for (int j = 0; j < index; j++) {
			arrayHorn[j] = this.horn[j];
		}
		for (int j = index; j < arrayHorn.length; j++) {
			arrayHorn[j] = this.horn[j + 1];
		}
		this.horn = arrayHorn;
	}
	
	/**
     * Iterator for denna classen polylinje. Implementeras methoden
     * hasVertex(), vertex() and advance().
     */
	public class PolylinjeIterator {
		private int aktuell = -1;

		public PolylinjeIterator() {
			if (Polylinje1.this.horn.length > 0)
				aktuell = 0;
		}

		public boolean finnsHorn() {
			return aktuell != -1;
		}

		public Punkt horn() throws java.util.NoSuchElementException {
			if (!this.finnsHorn())
				throw new java.util.NoSuchElementException("slut av iterationen");
			Punkt horn = Polylinje1.this.horn[aktuell];

			return horn;
		}

		public void gaFram() {
			if (aktuell >= 0 && aktuell < Polylinje1.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
	}
}
