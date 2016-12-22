import java.util.Random;

public class Sudoku {
	
	// Attribute
	
	// das Sudoku-Feld
	private int[][] feld;
	// wird benötigt um den String für toString zu erzeugen
	private String outputStr = "";
	
	// Konstruktoren

	/**
	 * Erzeugt eine Startbelegung
	 */

// Aufgabe 9-4-(a)
//	public Sudoku(){
//		feld = new int[9][9];
//		for (int y=0; y<9; y++ ){
//			for (int x=0; x<9; x++){
//				feld[x][y] =  (( 3*y + y/3 + x )%9 + 1) ;
//			}
//		}
//	}

	
	// Aufgabe 9-4-(h)
	/**
	 * Erzeugt eine Startbelegung und wendet auf diese n Permutationen an
	 * @param anzahlPermutationen
	 */
	public Sudoku(int anzahlPermutationen){
		feld = new int[9][9];
		// erzeuge randomisierte 1. Zeile
		int[] randRow = this.randomRow();
		// erzeuge Sudoku Feld
		int a=0;
		int b=0;
		for (int y=0; y<9; y++){
			for (int x=0; x<9; x++){
				feld[x][y] = randRow[(x+3*a+b)%9];
			}
			a++; if ((y+1)%3==0) {a=0;b++;}

		}
		// wende Permutationen an	
		for (int i=0; i<anzahlPermutationen; i++ ){
			randomPermutation(anzahlPermutationen);
			}	
	}
	
	// Methoden
	
	// Aufgabe 9-4-(h)
	/**
	 * Hilfsmethode für Konstruktor, erzeugt ein Zufallszahlenarray[9] mit Werten 1..9
	 * @return	Zufallszahlenarray[9]
	 */
	private int[] randomRow(){
		// ruft die nächste Methode aufm die ein Random Array mit 9 Werten erstellt
		return randomArray(9);
		
	}
	/**
	 * Hilfsmethode, erzeugt ein randomArray der Größe size mit Randomwerten
	 * Hierbei sind Randomwerte lückenlos, 
	 * also bei (4) 4,2,1,3
	 * @param size			Größe des Random-Arrays
	 * @return				Array mit Randomwerten der Größe size
	 */
	private int[] randomArray(int size){
		// Index Array n Randomzahlen wird zunächst mit n Zahlen aufgefüllt und 
		// im weiteren Schritt durch eine hohe Anzahl von Vertauschungen randomisiert
		int[] randArray = new int[size];
		// Indizes der zu vertauschenden Werte
		Random randomIndex1 = new Random();
		Random randomIndex2 = new Random();
		// Variable für Anzahl der Vertauschungen, um ein Zufallszahlenarray zu erzeugen
		Random randomAnzahlSwap = new Random();
		
		// Initialisiere das Array mit den Zahlen 0..size-1
		for (int i=0; i<9; i++){randArray[i]=i+1;}
		
		// führe bis zu 5000 zufällige Vertauschungen im obigen Array durch
		int i1;
		int i2;
		int temp;
		
		for (int i = 0; i < randomAnzahlSwap.nextInt(5000); i++ ){
			// erzeuge zwei zufällige Indizes i1 und i2
			i1 = randomIndex1.nextInt(size);
			i2 = randomIndex2.nextInt(size);
			// vertausche die jeweiligen Werte im Array
			temp = randArray[i1];
			randArray[i1] = randArray[i2];
			randArray[i2] = temp;

		}		
		return randArray;		
	}
	

	/**
	 * Hilfsmethode für toString
	 * 
	 */	
	public String getValue(int x, int y) {
		int n = this.feld[x][y];
		return (n != 0 ? n + "" : " ");
	}
	
	// Aufgabe 9-4-(b)
	/**
	 * Wandelt eine Sudoku Belegung in ein String um. 
	 * Ausgabe z.B. über System.out.println(mySudoku.toString());
	 */
	public String toString() {
		String horizontalborder = "-------------------------\n";
		String board = "";
		for(int i = 0; i < 9; i++) {
			board += (i%3 == 0 ? horizontalborder + "| ": "| ");
			for(int j = 0; j < 9; j++) {
				board += getValue(i, j) + " " + (j%3 == 2 ? "| " : "");
			}
			board += "\n";
			
		}
		return board + horizontalborder;
	}
	
	
	// Aufgabe 9-4-(c)
	/**
	 * Vertauscht zwei Sudoku Zeilen, die innerhalb des selben Stacks liegen
	 * @param a	Zeile 1
	 * @param b	Zeile 2
	 */
	private void permutateRows(int a, int b){
		int temp;
		// Check ob Zeilen innerhalb eines Bands liegen
		if ( (a<=2 && b<=2) || (a>=6 && b>=6) || ( a>=3 && b>=3 && a<=5 && b<=5) ){
			for (int x=0; x<9; x++){
				temp = this.feld[x][a];
				this.feld[x][a] = this.feld[x][b];
				this.feld[x][b] = temp;
			}
		}
	}
	
	// Aufgabe 9-4-(c)
	/**
	 * Vertauscht zwei Sudoku Spalten, die innerhalb des selben Bands liegen
	 * @param a	Spalte 1
	 * @param b	Spalte 2
	 */
	private void permutateColumns(int a, int b){
		int temp;
		if ( (a<=2 && b<=2) || (a>=6 && b>=6) || ( a>=3 && b>=3 && a<=5 && b<=5) ){
			for (int y=0; y<9; y++){
				temp = this.feld[a][y];
				this.feld[a][y] = this.feld[b][y];
				this.feld[b][y] = temp;
			}
		}
	}
	
	// Aufgabe 9-4-(d)
	/**
	 * Vertauscht zwei Stacks
	 * @param a	Stack 1
	 * @param b	Stack 2
	 */
	private void permutateStack(int a, int b){
		int temp;
		// wenn die a und b zwei unterschiedliche, gültige Stacks sind ....
		if (a>=0 && b>=0 && a<=2 && b<= 2  && a!=b){
			// vertausche die korrespondierenden Elemente der Stacks
			for (int x=0; x<9; x++){
				temp = this.feld[x][3*a];
				this.feld[x][3*a] = this.feld[x][3*b];
				this.feld[x][3*b] = temp;
				
				temp = this.feld[x][3*a+1];
				this.feld[x][3*a+1] = this.feld[x][3*b+1];
				this.feld[x][3*b+1] = temp;
				
				temp = this.feld[x][3*a+2];
				this.feld[x][3*a+2] = this.feld[x][3*b+2];
				this.feld[x][3*b+2] = temp;
			}
		}	
	}
	
	// Aufgabe 9-4-(d)
	/**
	 * Vertauscht zwei Bänder
	 * @param a	Band 1
	 * @param b	Band 2
	 */
	private void permutateBand(int a, int b){
		int temp;
		// wenn die a und b zwei unterschiedliche, gültige Bänder sind ....
		if (a>=0 && b>=0 && a<=2 && b<= 2 && a!=b){
			// vertausche die korrespondierenden Elemente der Bänder
			for (int y=0; y<9; y++){
				temp = this.feld[3*a][y];
				this.feld[3*a][y] = this.feld[3*b][y];
				this.feld[3*b][y] = temp;
				
				temp = this.feld[3*a+1][y];
				this.feld[3*a+1][y] = this.feld[3*b+1][y];
				this.feld[3*b+1][y] = temp;
				
				temp = this.feld[3*a+2][y];
				this.feld[3*a+2][y] = this.feld[3*b+2][y];
				this.feld[3*b+2][y] = temp;
			}
		}	
	}
	
	// Aufgabe 9-4-(e)
	/**
	 * vertauscht zwei zufällig ausgewählte Rows, sofern die in einem Stack liegen
	 */
	private void permutateRows(){
		Random r1 = new Random();
		Random r2 = new Random();
		int a = r1.nextInt(9);
		int b = r2.nextInt(9);
		// erzeuge zwei Randomzahlen für Rows, die innerhalb eines Stack liegen
		while (!( (a<=2 && b<=2) || (a>=6 && b>=6) || ( a>=3 && b>=3 && a<=5 && b<=5) ) ){
			a = r1.nextInt(9);
			b = r2.nextInt(9);
		}
		this.permutateRows(a, b);
	}
	
	// Aufgabe 9-4-(e)
	/**
	 * vertauscht zwei zufällig ausgewählte Columns, sofern die in einem Band liegen
	 */
	private void permutateColumns(){
		Random r1 = new Random();
		Random r2 = new Random();
		int a = r1.nextInt(9);
		int b = r2.nextInt(9);
		// erzeuge zwei Randomzahlen für Rows, die innerhalb eines Stack liegen
		while (!( (a<=2 && b<=2) || (a>=6 && b>=6) || ( a>=3 && b>=3 && a<=5 && b<=5) ) ){
			a = r1.nextInt(9);
			b = r2.nextInt(9);
		}
		this.permutateColumns(a, b);
	}
	
	// Aufgabe 9-4-(e)
	/**
	 * vertauscht zwei zufällig ausgewählte Stacks
	 */
	private void permutateStack(){
		Random a = new Random();
		Random b = new Random();
		int aRandom = a.nextInt(3);
		int bRandom = b.nextInt(3);
		// erzeuge zwei ungleiche Randomzahlen für Stacks zwischen 0..2
		while (aRandom == bRandom){
			aRandom = a.nextInt(3);
			bRandom = a.nextInt(3);
		}
		this.permutateStack(aRandom, bRandom);
	}

	// Aufgabe 9-4-(e)
	/**
	 * vertauscht zwei zufällig ausgewählte Bänder
	 */
	private void permutateBand(){
		Random a = new Random();
		Random b = new Random();
		int aRandom = a.nextInt(3);
		int bRandom = b.nextInt(3);
		// erzeuge zwei ungleiche Randomzahlen für Bänder zwischen 0..2
		while (aRandom == bRandom){
			aRandom = a.nextInt(3);
			bRandom = a.nextInt(3);
		}
		this.permutateBand(aRandom, bRandom);
	}
	
	// Aufgabe 9-4-(f)
	/**
	 * Spiegelt das Sudoku um die diagonale Achse von links oben nach rechts unten
	 */
	private void transpose(){
		int temp;
		for (int y=0;y<9;y++){
			for (int x=y+1;x<9;x++){
				temp = this.feld[x][y];
				this.feld[x][y] = this.feld[y][x];
				this.feld[y][x] = temp;
			}
		}
	}
	
	// Aufgabe 9-4-(g)
	/**
	 * Erzeuge eine zufällige ausgewählte Permutation von:
	 * permutateRows(), permutateColumns(), permutateStack(), permutateBand(), transpose() 
	 */
	private void randomPermutation(){
		Random r = new Random();
		int n = r.nextInt(5);
		switch(n){
			case 0: permutateRows();
					break;
			case 1: permutateColumns();
					break;
			case 2: permutateStack();
					break;
			case 3: permutateBand();
					break;
			case 4: transpose();
		}		
	}

	// Aufgabe 9-4-(g)
	/**
	 * Erzeuge eine n zufällig ausgewählte Permutationen
	 * @param anzahlPermutationen
	 */
	private void randomPermutation(int anzahlPermutationen){
		for (int i=0; i<anzahlPermutationen; i++){
			randomPermutation();
		}		
	}
	
	// Aufgabe 9-4 (i)
	/**
	 * Erzeugt n Leerstellen im Sudoku und gibt dass Array als String aus
	 * @param 	numberOfHides Anzahl Leerstellen
	 * @return	String Darstellung des Susoku
	 */
	public void hide(int numberOfHides){
		int counter = 0;
		Random r = new Random();
		int position;
		// fülle die Stellen der Random Indizes mit 0
		while (counter != numberOfHides){
			position = r.nextInt(81); // aus einer Zahl lässt sich mit / und % die Koord. berechnen
			if ( this.feld[position/9][position%9] != 0){
				this.feld[position/9][position%9] = 0;
				counter++;
			}	
		}
	}
	
	public static void main(String[] args) {
		Sudoku mySudoku = new Sudoku(5000);		
 		mySudoku.hide(50);
		System.out.println(mySudoku);
//		Sudoku mySudoku = new Sudoku(100000);	
//		Sudoku mySudoku = new Sudoku();
//		mySudoku.randomPermutation(10000000);
//		mySudoku.transpose();
//		mySudoku.permutateStack();
//		mySudoku.permutateBand();	
//		mySudoku.permutateBand(1,2);
//		mySudoku.permutateStack(1,2);	
//		mySudoku.permutateColumns(0,1);	
//		mySudoku.permutateRows(3, 4);
	}
}