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
	public Sudoku(){
		feld = new int[9][9];
		int[] randRow = randomRow();

		for (int x=0; x<9; x++){
			feld[x][0] = randRow[x];
		}
		for (int x=0; x<9; x++){
			feld[x][1] = randRow[(x+3)%9];
		}
		for (int x=0; x<9; x++){
			feld[x][2] = randRow[(x+6)%9];
		}
		for (int x=0; x<9; x++){
			feld[x][3] = randRow[(x+1)%9];
		}
		for (int x=0; x<9; x++){
			feld[x][4] = randRow[(x+4)%9];
		}
		for (int x=0; x<9; x++){
			feld[x][5] = randRow[(x+7)%9];
		}
		for (int x=0; x<9; x++){
			feld[x][6] = randRow[(x+2)%9];
		}
		for (int x=0; x<9; x++){
			feld[x][7] = randRow[(x+5)%9];
		}
		for (int x=0; x<9; x++){
			feld[x][8] = randRow[(x+8)%9];
		}
		
		
	}
	
	/**
	 * Erzeugt eine Startbelegung und wendet auf diese n Permutationen an
	 * @param anzahlPermutationen
	 */
	public Sudoku(int anzahlPermutationen){
		feld = new int[9][9];
		for (int y=0; y<9; y++ ){
			for (int x=0; x<9; x++){
				feld[x][y] =  (( 3*y + y/3 + x )%9 + 1) ;
			}
		}
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
		int[] randomRow = {1,2,3,4,5,6,7,8,9};
		Random randomAnzahlSwap = new Random();
		Random randomIndex1 = new Random();
		Random randomIndex2 = new Random();
		int temp;
		int i1;
		int i2;
		// führe bis zu 200 zufällige Vertauschungen im Array durch
		for (int i = 0; i < randomAnzahlSwap.nextInt(200); i++ ){
			// erzeuge zwei zufällige Indizes i1 und i2
			i1 = randomIndex1.nextInt(9);
			i2 = randomIndex2.nextInt(9);
			// vertausche die jeweiligen Werte im Array
			temp = randomRow[i1];
			randomRow[i1] = randomRow[i2];
			randomRow[i2] = temp;
		}
		return randomRow;
	}
	
	// Aufgabe 9-4-(b)
	/**
	 * Wandelt eine Sudoku Belegung in ein String um. 
	 * Ausgabe z.B. über System.out.println(mySudoku.toString());
	 */
	public String toString(){
		this.outputStr = 	this.horizontalLine() +
							this.printSudokuRow(0)+this.printSudokuRow(1)+this.printSudokuRow(2)+
							this.horizontalLine()+
							this.printSudokuRow(3)+this.printSudokuRow(4)+this.printSudokuRow(5)+
							this.horizontalLine()+
							this.printSudokuRow(6)+this.printSudokuRow(7)+this.printSudokuRow(8)+
							this.horizontalLine();
		return this.outputStr;
		
	}
	
	/**
	 * Hilfsmethode für toString(). Erzeugt die Kopf-/Fuss-/Trennlinie.
	 * @return	Trennlinie als String
	 */
	private String horizontalLine(){
		return ("- - - - - - - - - - - - - "+ "\n" );
	}
	
	/**
	 * Hilfsmethode für toString(). 
	 * Erzeugt eine Zeilenausgabe als String für eine vorgegebene Zeile des Sudoku
	 * incl. den Abgrenzungen für die 3x3 Felder  
	 * @param 	lineNo
	 * @return 	Ausgabe einer Zeile in ein String
	 */
	private String printSudokuRow(int lineNo){
		String str = "|";
		for (int x=0; x<3; x++){
			str = str + " " + (this.feld[x][lineNo] == 0 ? 0 : this.feld[x][lineNo]);
		}
		str = str + " " + "|"; 
		for (int x=3; x<6; x++){
			str = str + " " + (this.feld[x][lineNo] == 0 ? 0 : this.feld[x][lineNo]);
		}
		str = str + " " + "|"; 
		for (int x=6; x<9; x++){
			str = str + " " + (this.feld[x][lineNo] == 0 ? 0 : this.feld[x][lineNo]);
		}
		str = str + " " + "|" + "\n";
		return str;
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
	
	
	//public void hide
//	public String hide(int anzahlElemente){
//		int[] tempArray = new int[81];
//		int[] hideArray = new int[anzahlElemente];
//		for (i=0; i<81;i++){
//			hideArray[i]=i+1;
//		}
//		
//		
//		
//		return;
//	}
	
	public static int[] randomRow2(int n){
		int[] randomRow = new int[81];
		Random randomAnzahlSwap = new Random();
		Random randomIndex1 = new Random();
		Random randomIndex2 = new Random();
		int temp;
		int i1;
		int i2;
		for (int i=0;i<81;i++){
			randomRow[i]=i;
		}
		// führe bis zu 20000 zufällige Vertauschungen im Array durch
		for (int i = 0; i < randomAnzahlSwap.nextInt(20000); i++ ){
			// erzeuge zwei zufällige Indizes i1 und i2
			i1 = randomIndex1.nextInt(81);
			i2 = randomIndex2.nextInt(81);
			// vertausche die jeweiligen Werte im Array
			temp = randomRow[i1];
			randomRow[i1] = randomRow[i2];
			randomRow[i2] = temp;
		}
		return randomRow;
	}
}