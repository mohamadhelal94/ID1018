
import java.util.Iterator;

public class NPolylinje implements polyInterface {

	private static class Node {
		public Punkt horn;
		public Node nextNode;

		public Node(Punkt horn) {
			this.horn = horn;
			nextNode = null;
		}
	}

	private Node nHorn;
	private String farg = "svart";
	private int bredd = 1;

	public NPolylinje() {
		this.nHorn = null;

	}

	public NPolylinje(Punkt[] nHorn) {
		if (nHorn.length > 0) {
			Node nod = new Node(new Punkt(nHorn[0]));
			this.nHorn = nod;
			int pos = 1;
			while (pos < nHorn.length) {
				nod.nextNode = new Node(new Punkt(nHorn[pos++]));
				nod = nod.nextNode;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		if (nHorn != null) {
			sb.append("[");
			Node n = nHorn;
			while (n != null) {
				sb.append(n.horn);
				n = n.nextNode;
			}
			sb.append("], ");
		}
		sb.append(farg);
		sb.append(", ");
		sb.append(bredd);
		sb.append("}");
		return sb.toString();
	}

	@Override
	public Punkt[] getHorn() {
		int punkter = 0;
		Node n = this.nHorn;

		while (n != null) {
			punkter++;
			n = n.nextNode;
		}
		Punkt[] p = new Punkt[punkter];
		n = this.nHorn;
		for (int i = 0; i < punkter; i++) {
			p[i] = n.horn;
			n = n.nextNode;
		}
		return p;
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
		int punkter = 0;
		Node n = nHorn;

		while (n != null) {
			punkter++;
			n = n.nextNode;
		}
		return punkter;
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
		if (this.nHorn == null) {
			this.nHorn = new Node(horn);
		} else {
			Node n = this.nHorn;
			while (n.nextNode != null) {
				n = n.nextNode;
			}

			n.nextNode = new Node(horn);
		}
	}

	public void laggTillIborjan(Punkt horn) {
		Node node = nHorn;
		node.horn = horn;
		node.nextNode = null;
		node.nextNode = this.nHorn;
		this.nHorn = node;
	}

	@Override
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		Node n = nHorn;
		
			while (n.nextNode != null) {

				if (n.nextNode.horn.getNamn().equals(hornNamn)) {

					Node buff = n.nextNode;
					n.nextNode = new Node(horn);
					n.nextNode.nextNode = buff;
					break;
				}

				n = n.nextNode;
			}
		
	}

	@Override
	public void taBort(String hornNamn) {
		
		 if(nHorn != null && nHorn.horn.getNamn().equals(hornNamn)) {
			nHorn = nHorn.nextNode;
			
		}else {
		Node n = nHorn;
		while (n != null) {

			if (n.nextNode.horn.getNamn().equals(hornNamn)) {

				n.nextNode = n.nextNode.nextNode;
				break;
			}

			n = n.nextNode;
		}
		}
	}

	private class PolylinjeIterator implements Iterator<Punkt> {

		Node aktuell = nHorn;

		public boolean hasNext() {
			return aktuell != null;
		}

		public Punkt next() {
			if (hasNext()) {
				Punkt p = aktuell.horn;
				aktuell = aktuell.nextNode;
				return p;
			}
			return null;
		}

	}

	public void remove() {
		throw new UnsupportedOperationException("Remove not implemented.");
	}

	public Iterator<Punkt> iterator() {
		return this.new PolylinjeIterator();
	}
}