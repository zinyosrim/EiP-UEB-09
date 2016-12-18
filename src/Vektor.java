
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
	

	public Integer getElement(int position){
		try {
		return this.v[position];
		} catch (Exception e) {return null;}
	}
	
	public void setElement(int position, Integer value){
		try{
			this.v[position] = value;
		} catch (Exception e){}
	}
	
	public int getDimension(){
		return this.v.length;
	}
	
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
	
	public Integer enthaelt(int k){
		for (int i=0; (i < this.getDimension()) || ( (Integer)k == this.getElement(i) ) ; i++){
			if ( (Integer)k == this.getElement(i) ) {
				return (Integer)i;}
		}
		return null;
	}
	
	public String toString(){
		if ( this == null) return null;
		else {
			String s = "[";
			int index = 0;
			while ( index < this.getDimension() ){
				s = s + " " + this.v[index];
				index++;
			}
			s = s + " ]";
			return s;
		}
	}
	
	
	public Vektor add(Vektor other){
		
		if ( this.getDimension() != other.getDimension() || other == null || this == null )
			return null;
		else {
			Vektor sumV = new Vektor(this.getDimension());
			for ( int i = 0; i < this.getDimension(); i++ ){
				sumV.setElement(i, this.getElement(i) + other.getElement(i));
			}
			return sumV;
		}
	}
	
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
		// TODO Auto-generated method stub
		Vektor vek0 = new Vektor(6,66);
		System.out.println("vek0: "+vek0.toString());
		
		Vektor vek1 = new Vektor(8);
		vek1.setElement(3,11);
		System.out.println("vek1: "+vek1.toString());
		
		Vektor vek2 = new Vektor(6,66);
		System.out.println("vek2: "+vek2.toString());
		
		Vektor vek3 = new Vektor( 7, 33 );
		Vektor vek4 = new Vektor( 7, 101 );
		
		vek3.setElement( 3, 44 );
		vek3.setElement( 5, 222 );
		System.out.println("vek3: "+vek3.toString());
		
		vek4.setElement (3, 44);
		vek4.setElement (5, 88);	
		System.out.println("vek4: "+vek4.toString());
		System.out.println();
		
		//System.out.println (istGleich (vek3, vek4));
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
