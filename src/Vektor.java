
public class Vektor {
	
	//Attribute
	
	private Integer[] v;

	
	//Konstruktoren
	
	/** Erzeugt einen Array der Länge size mit 0
	 * @param size	Länge des Arrays
	 */
	public Vektor(int size) {
		v = new Integer[size];
		for(int i = 0; i < size; i++) {
			this.v[i] = 0;
		}
	}
	
	
	/** Erzeugt ein Array mit Länge size und füllt ihn mit dem Wert value
	 * @param size	Länge des Arrays
	 * @param value	Wert aller Elemente
	 */
	public Vektor(int size, Integer value) {
		v = new Integer[size];
		for(int i = 0; i < size; i++) {
			this.v[i] = value;
		}
	}

	
	/** Gibt das Element an der Stelle position des Arrays zurück
	 * @param position	gewünschte Stelle 
	 * @return	Element der gewünschten Stelle
	 */
	public Integer getElement(int position) {
		try {
			return this.v[position];
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	/** Gibt die Länge des Arrays zurück
	 * @return	Länge des Arrays
	 */
	public int getDimension() {
		return this.v.length;
	}
	
	
	/** Überschreibt das Element an der Stelle position mit dem Wert value
	 * @param position	gewünschte Stelle
	 * @param value	gewünschter Wert
	 */
	public void setElement(int position, Integer value) {
		try {
			this.v[position] = value;
		}
		catch(Exception e) {}
	}
	
	
	/** Vergleicht zwei Arrays bezüglich ihrer Elemente
	 * @param other	Vergleichsarray
	 * @return ArraysAreEqual	Boolscher Wert, ob Gleichheit vorliegt
	 */
	public boolean istGleich(Vektor other) {
		int dthis = this.getDimension();
		if(dthis != other.getDimension()) {
			return false;
		}
		boolean ArraysAreEqual = true;
		for(int i = 0; (i < dthis) && (ArraysAreEqual == true); i++) {
			if(this.getElement(i) != other.getElement(i)) {
				ArraysAreEqual = false;
			}
		}
		return ArraysAreEqual;
	}
	
	
	/** Sucht im Array nach dem Wert k und gibt dessen kleinste Stelle zurück
	 * @param k gesuchter Wert
	 * @return kleinste Stelle
	 */
	public Integer enthaelt(int k) {
		int length = this.getDimension();
		for(int i = 0; i < length; i++) {
			if(k == this.getElement(i)) {
				length = 0;
				return i;
			}
		}
		return null;
	}
	
	/** Gibt den Array als String aus
	 * @return String des Arrays
	 */
	public String toString() {
		String array = "[";
		if(this.v != null) {
			int length = this.getDimension();
			for(int i = 0; i < length; i++) {
				array += this.getElement(i) + (i != length - 1 ? " " : "");
			}
		}
		array += "]";
		return array;
	}
	
	
	/** Addiert die Elemente von gleichen Stellen
	 * @param other Summandarray
	 * @return	Addierter Array
	 */
	public Vektor addiere(Vektor other) {
		int dthis = this.getDimension();
		if(dthis != other.getDimension()) {
			return null;
		}
		Vektor vector = new Vektor(dthis);
		for(int i = 0; i < dthis; i++) {
			vector.setElement(i, this.getElement(i) + other.getElement(i));
		}
		return vector;
	}
	
	
	/** Berechnet das Skalarprodukt zweier Arrays
	 * @param other	zweiter Array
	 * @return	Skalarprodukt der Eingangsarrays
	 */
	public Integer skalarprodukt(Vektor other) {
		int dthis = this.getDimension();
		if(dthis != other.getDimension()) {
			return null;
		}
		Integer DotProduct = 0;
		for(int i = 0; i < dthis; i++) {
			DotProduct += this.getElement(i) * other.getElement(i);
		}
		return DotProduct;
	}
	
	
	
	public static void main(String[] args) {
		
//		Vektor v0 = new Vektor(0);
//		Vektor v1 = new Vektor(5);
//		Vektor v2 = new Vektor(5, 2);
//		Vektor v3 = new Vektor(5, 3);
//		Vektor v4 = new Vektor(2, 5);
		
//		System.out.println(v0.toString());
//		System.out.println(v3.addiere(v4));
//		v3.setElement(0, 33);
//		v3.setElement(1, 33);
//		System.out.println(v3.enthaelt(3));
//		System.out.println(v0.istGleich(v1));
//		System.out.println(v0.skalarprodukt(v0));
		
//		Vektor vek0 = new Vektor(6,66);
//		System.out.println("vek0: "+vek0.toString());
//		
//		Vektor vek1 = new Vektor(8);
//		vek1.setElement(3,11);
//		System.out.println("vek1: "+vek1.toString());
//		
//		Vektor vek2 = new Vektor( 6, 66 );
//		System.out.println("vek2: "+vek2.toString());
//		
//		Vektor vek3 = new Vektor( 7, 33 );
//		vek3.setElement( 3, 44 );
//		vek3.setElement( 5, 222 );
//		System.out.println("vek3: "+vek3.toString());
//		
//		Vektor vek4 = new Vektor( 7, 101 );
//		vek4.setElement (3, 44);
//		vek4.setElement (5, 88);	
//		System.out.println("vek4: "+vek4.toString());
//		
//		Vektor vek5 = new Vektor(0);
//		Vektor vek5 = null;
//		System.out.println("vek5: "+ vek5.toString());
//		
//		System.out.println();
//
//		System.out.println("vek1 ist gleich vek2: "+vek1.istGleich(vek2));
//		System.out.println("vek0 ist gleich vek2: "+vek0.istGleich(vek2));
//		System.out.println("vek4 enthält den Wert 88 an Position: "+vek4.enthaelt(88));
//		System.out.println("vek4 enthält den Wert 67 an Position: "+vek4.enthaelt(67));
//		System.out.println("vek0 + vek2: "+ vek0.addiere(vek2).toString());
//		if (vek0.addiere(vek3) == null) System.out.println("nullinger");
//		System.out.println("vek0 + vek3: "+ vek0.addiere(vek3).toString());
//		System.out.println("Skalarprodukt von vek0 und vek2: "+ vek0.skalarprodukt(vek2));
		
		
	}
}
