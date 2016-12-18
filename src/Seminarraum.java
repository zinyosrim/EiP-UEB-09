/**
 * Klasse Seminarraum erzeugt einen Seminarraum mit einer max. Anzahl von Stühlen 
 * @author Zin Yosrim
 *
 */
public class Seminarraum {
	
	// Attribute
	
	private final int MAX_STUEHLE;
	private int anzahlStuehle;
	
	// Konstruktor
	
	public Seminarraum(int anzahlStuehle){
		this.MAX_STUEHLE = anzahlStuehle;
	}

	// Methoden
	
	/**
	 * Setter für das Attribut Stuehle
	 * @param 	anzahl	Anzahl der Stühle	
	 */
	public void setStuehle(int anzahl){
		if (anzahl <= MAX_STUEHLE){
			this.anzahlStuehle = anzahl;
		}
		else System.out.println("Dieser Seminarraum erlaubt keine höhere Bestuhlung als "+this.MAX_STUEHLE);
	}
	
	/**
	 * Getter für das Attribut Stühle
	 * @return	Anzahl der Stühle in einem Seminarraum
	 */
	public int getStuehle(){
		return anzahlStuehle;
	}
	
	/**
	 * Erhäht die Anzahl der der STühle in einem Seminarraum 
	 * @param anzahl	Die Anzahl der Stühle wird um diesen Wert erhöht
	 */
	public void incrementStuehle(int anzahl){
		if (anzahlStuehle + anzahl < MAX_STUEHLE){
			anzahlStuehle = anzahlStuehle+anzahl;
		}
		else System.out.println("Dieser Seminarraum erlaubt keine höhere Bestuhlung als "+this.MAX_STUEHLE+
				". Der aktuelle Stand sind "+this.anzahlStuehle+" Stuehle!");
	}
	
	/**
	 * Reduziert die Anzahl der Stühle in einem Seminarraum
	 * @param anzahl	Die Anzahl der Stühle wird um diesen Wert reduziert
	 */
	public void decrementStuehle(int anzahl){
		if (anzahlStuehle - anzahl >= 0){
			anzahlStuehle = anzahlStuehle-anzahl;
		}
		else System.out.println("Dieser Seminarraum erlaubt keine niedrigere Bestuhlung als 0. Der aktuelle Stand sind "+ 
				+this.anzahlStuehle+" Stuehle!");
	}
	
	/**
	 * Vergleicht zwei Seminarräume bzgl. der Anzahl der Stühle in den Räumen
	 * @param 	semRaum	Seminarraum, mit dem verglichen wird
	 * @return	true bei gleicher Anzahl von Stühlen, sonst false
	 */
	public boolean equals(Seminarraum semRaum){
		if (this.anzahlStuehle == semRaum.getStuehle()) return true;
		else return false;
	}
	
	/**
	 * Überschreibt die Objektmethode toString()	
	 */
	@Override public String toString(){
		    
			System.out.println();
			for (int i=1; i<=anzahlStuehle/3;i++){
					System.out.println("|     |     |    ");
					System.out.println("|     |     |    ");				
					System.out.println("|____ |____ |____");
					System.out.println("|   | |   | |   |");
					System.out.println("|   | |   | |   |");
					System.out.println();
			}
			for (int i=1; i<=this.anzahlStuehle%3; i++){
				System.out.print("|     ");
			}
			System.out.println();
			for (int i=1; i<=this.anzahlStuehle%3; i++){
				System.out.print("|     ");
			}
			System.out.println();
			for (int i=1; i<=this.anzahlStuehle%3; i++){
				System.out.print("|____ ");
			}
			System.out.println();
			for (int i=1; i<=this.anzahlStuehle%3; i++){
				System.out.print("|   | ");
			}
			System.out.println();
			for (int i=1; i<=this.anzahlStuehle%3; i++){
				System.out.print("|   | ");
			}
			System.out.println();
			System.out.println();
		
			return String.format("Name des Seminarraums ist "+this.getClass().getName()+" mit "+this.anzahlStuehle+" und einer Maximalkapazität von "+this.MAX_STUEHLE );
	}			

}