package Test;

interface ComparableShape<T> {
	// compareTo jämför arean av den här figuren med arean av en given figur.
	// Metoden returnerar -1 om den här figurens area är mindre, 1 om den här
	// figurens area är större, och 0 om figurernas areor är lika.
	int compareTo(T shape);
}
