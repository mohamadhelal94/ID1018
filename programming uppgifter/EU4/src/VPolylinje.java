import java.util.Arrays;
import java.util.Iterator;

public class VPolylinje implements polyInterface {
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public VPolylinje() {
		this.horn = new Punkt[0];
	}

	public VPolylinje(Punkt[] horn) {
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

	@Override
	public Punkt[] getHorn() {
		return Arrays.copyOf(this.horn, this.horn.length);
	}

	@Override
	public String getFarg() {
		
		return farg;
	}

	@Override
	public int getBredd() {

		return bredd;
	}

	@Override
	public double langd() {
		double length = 0;
		for (int i = 0; i < this.horn.length - 1; i++) {
			length += this.horn[i].avstand(this.horn[i + 1]);
		}
		return length;
	}

	@Override
	public void setFarg(String farg) {
		this.farg = farg;

	}

	@Override
	public void setBredd(int bredd) {
		this.bredd = bredd;

	}

	@Override
	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);

		this.horn = h;

	}

	@Override
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
//		arrayHorn[i < index ? i : i + 1] = this.horn[i];
			if (i < index) {
				arrayHorn[i] = this.horn[i];
			} else if (i >= index) {
				arrayHorn[i + 1] = this.horn[i];
			}
		}
		arrayHorn[index] = newHorn;
		this.horn = arrayHorn;
	}

	@Override
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

	public class VPolylinjeIterator {
		private int aktuell = -1;

		public VPolylinjeIterator() {
			if (VPolylinje.this.horn.length > 0)
				aktuell = 0;
		}

		public boolean finnsHorn() {
			return aktuell != -1;
		}

		public Punkt horn() throws java.util.NoSuchElementException {
			if (!this.finnsHorn())
				throw new java.util.NoSuchElementException("slut av iterationen");
			Punkt horn = VPolylinje.this.horn[aktuell];

			return horn;
		}

		public void gaFram() {
			if (aktuell >= 0 && aktuell < VPolylinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
	}


	private class PolylinjeIterator implements Iterator<Punkt> {

        int aktuell = -1;

        public PolylinjeIterator() {
            if (VPolylinje.this.horn.length > 0) {
                aktuell = 0;
            }
        }

        @Override
        public boolean hasNext() {
            return aktuell != -1;
        }

        @Override
        public Punkt next() {
            if (!this.hasNext())
                throw new java.util.NoSuchElementException(
                        "slut av iterationen");
            Punkt horn = VPolylinje.this.horn[aktuell];
            if (aktuell >= 0 && aktuell < VPolylinje.this.horn.length - 1) {
                aktuell++;
            } else {
                aktuell = -1;
            }
            return horn;
        }

        // return null;

    }

    @Override
    public Iterator<Punkt> iterator() {
        return this.new PolylinjeIterator();
    }

}
