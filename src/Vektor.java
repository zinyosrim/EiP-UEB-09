
public class Vektor {
	
	private Integer[] v;

	
	public Vektor(int size) {
		v = new Integer[size];
		for(int i = 0; i < size; i++) {
			this.v[i] = 0;
		}
	}
	
	
	public Vektor(int size, Integer value) {
		v = new Integer[size];
		for(int i = 0; i < size; i++) {
			this.v[i] = value;
		}
	}

	
	public Integer getElement(int position) {
		try {
			return this.v[position];
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	public int getDimension() {
		return this.v.length;
	}
	
	
	public void setElement(int position, Integer value) {
		try {
			this.v[position] = value;
		}
		catch(Exception e) {}
	}
	
	
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
	
	
	public String toString() {
		String array = "[";
		if(this.v != null) {
			int length = this.getDimension();
			for(int i = 0; i < length; i++) {
				array += this.getElement(i);
				if(i != length - 1) {
					array += " ";
				}
			}
		}
		array += "]";
		return array;
	}
	
	
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
		
		Vektor v0 = new Vektor(0);
		Vektor v1 = new Vektor(5);
		Vektor v2 = new Vektor(5, 2);
		Vektor v3 = new Vektor(5, 3);
		Vektor v4 = new Vektor(2, 5);
		
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
//		System.out.println("vek5: "+vek5.toString());
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
