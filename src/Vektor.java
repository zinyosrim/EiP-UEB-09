
public class Vektor {
	
	// Attribute
	
	private Integer[] v;

	// Konstruktoren
	
	/**
	 * Erstellt einen 0 Vektor
	 * @param size	Dimension des Vektors 
	 */
	public Vektor(int size){
		v = new Integer[size]; 
		for (int i = 0; i < size; i++){
			this.v[i] = 0;
		}
	}
	
	/**
	 * Erstellt einen Vektor und weisst jedem Element den gleichen Wert zu
	 * @param size	Dimension des Vektors
	 * @param value	Zuzuweisender Wert
	 */
	public Vektor(int size, Integer value){
		v = new Integer[size]; 
		for (int i = 0; i < size; i++){
			this.v[i] = value;
		}
	}
	
	// Methoden	
	
	/**
	 * Liefert das n-te Element eines Vektors
	 * @param position	index des ELements
	 * @return
	 */
	public Integer getElement(int position){
		try {
		return this.v[position];
		} catch (Exception e) {return null;}
	}
	/**
	 * belegt das n-te Element eines Vektors mit einem Integer Wert
	 * @param position	Index des Elemts
	 * @param value		dessen Wert
	 */
	public void setElement(int position, Integer value){
		try{
			this.v[position] = value;
		} catch (Exception e){}
	}
	
	/**
	 * liefert die Größe bzw. Dimension eines Vektors
	 * @return die Dimension
	 */
	public int getDimension(){
		return this.v.length;
	}
	
	/**
	 * vergleicht zwei Vektoren auf Wertegleichheit
	 * @param 	other	der andere Vektor mit dem die Werte verglichen werden
	 * @return	true oder false
	 */
	public boolean istGleich(Vektor other){
		// Vektoren haben unterschiedliche Größe, sind also ungleich
		if ( this.getDimension() != other.getDimension() ){
			return false;
		}
		// Vektoren haben gleiche Größe
		else { 
			boolean werteSindGleich = true;
			int index = 0; 
			while ( werteSindGleich && index < this.getDimension() ){
				if ( this.getElement(index) == other.getElement(index) ){
					index++;
				}
				else werteSindGleich = false;
			}
			if ( !werteSindGleich ) return false;
			else return true;
		}
	}
	
	/**
	 * Gibt das k-te Element eines Vektors zurück
	 * @param 	k
	 * @return 	das Element
	 */
	public Integer enthaelt(int k){
		for (int i=0; (i < this.getDimension()) || ( (Integer)k == this.getElement(i) ) ; i++){
			if ( (Integer)k == this.getElement(i) ) {
				return (Integer)i;}
		}
		return null;
	}
	
	/**
	 * Liefert eine Stringdarstellung eines Vektors in der Form [ a, b, c, ... ]
	 */
	public String toString(){

		try {
				//if ( this != null){
					String s = "[";
					int index = 0;
					while ( index < this.getDimension() ){
						s = s + " " + this.v[index];
						index++;
					}
					s = s + " ]";
					return s;
				//}
				//else return "";
		} catch (Exception e){return "";}


	}
	
	/**
	 * Bildet den Summenvektor zweier Vektoren
	 * @param other	der Vektor, mit dem die Summe gebildet wird
	 * @return
	 */	
	public Vektor add(Vektor other){
		Vektor rV = new Vektor(this.getDimension());
		if ( this.getDimension() != other.getDimension() || other == null || this == null )
				return rV;
			else {
				Vektor sumV = new Vektor(this.getDimension());
				for ( int i = 0; i < this.getDimension(); i++ ){
					sumV.setElement(i, this.getElement(i) + other.getElement(i));
			}
			return sumV;
		} 
	}
	
	/**
	 * Bildet das Skalarprodukt zweier Vektoren
	 * @param other	der Vektor, mit dem das Produkt gebildet wird
	 * @return
	 */
	public Integer skalarprodukt(Vektor other){
			
			if ( this.getDimension() != other.getDimension() )
				return null;
			else {
				Integer sp = 0; 
				for ( int i = 0; i < this.getDimension(); i++ ){
					sp = sp +  ( this.getElement(i) * other.getElement(i) );
				}
				return sp;
			}
		}
	
	
	public static void main(String[] args) {

		Vektor vek0 = new Vektor(6,66);
		System.out.println("vek0: "+vek0.toString());
		
		Vektor vek1 = new Vektor(8);
		vek1.setElement(3,11);
		System.out.println("vek1: "+vek1.toString());
		
		Vektor vek2 = new Vektor( 6, 66 );
		System.out.println("vek2: "+vek2.toString());
		
		Vektor vek3 = new Vektor( 7, 33 );
		vek3.setElement( 3, 44 );
		vek3.setElement( 5, 222 );
		System.out.println("vek3: "+vek3.toString());
		
		Vektor vek4 = new Vektor( 7, 101 );
		vek4.setElement (3, 44);
		vek4.setElement (5, 88);	
		System.out.println("vek4: "+vek4.toString());
		
		Vektor vek5 = null;
		System.out.println("vek5: "+vek5.toString());
		
		System.out.println();

		System.out.println("vek1 ist gleich vek2: "+vek1.istGleich(vek2));
		System.out.println("vek0 ist gleich vek2: "+vek0.istGleich(vek2));
		System.out.println("vek4 enthält den Wert 88 an Position: "+vek4.enthaelt(88));
		System.out.println("vek4 enthält den Wert 67 an Position: "+vek4.enthaelt(67));
		System.out.println("vek0 + vek2: "+ vek0.add(vek2).toString());
		if (vek0.add(vek3) == null) System.out.println("nullinger");
		System.out.println("vek0 + vek3: "+ vek0.add(vek3).toString());
		System.out.println("Skalarprodukt von vek0 und vek2: "+ vek0.skalarprodukt(vek2));

	}

}
