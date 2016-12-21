import java.util.Scanner;

public class XmasTree {
	
	// Attribute
	
	protected final String TreeTopper = "*";
	protected final String Trunk = "[_]";
	protected int level = 0;

	
	// Konstruktor
	
	/** Erzeugt ein Weihnachtsbaum mit der Größe level
	 * @param level Größe des Baumes
	 */
	public XmasTree(int level) {
		this.level = level;
	}
	
	
	/** Gibt die Baumspitze als String zurück
	 * @param level	Größe des Baumes
	 * @return	textuelle Darstellung der Spitze
	 */
	public String getTreeTopper(int level) {
		String space = " ";
		for(int i = 0; i < level; i++) {
			space += " ";
		}
		return space + TreeTopper + "\n";
	}
	
	
	/** Gibt den Mittelteil des Baumes als String zurück
	 * @param level	Größe des Baumes
	 * @return	textuelle Darstellung des Mittelteils
	 */
	public String getBody(int level) {
		int currentlevel = 0;	// jeweils 2 Zeilen von oben = 0 nach unten = (level - 1)
		int sublevel = 0;		// Subzeilen von currentlevel: oben = 0; unten = 1
		String body = "";
		for (int k = 0; k < level; k++) {	//durchläuft currentlevel
			for (int j = 0; j < 2; j++) {	//durchläuft beide sublevel
				for(int i = 0; i < level - currentlevel - sublevel; i++) {
					body += " ";	//bestimmt Anzahl der Leerzeichen vor "/" der Zeile
				}
				body += "/";
				for(int i = 0; i < 2*currentlevel + 2*sublevel + 1; i++) {
					body += (i%2 == sublevel ? "." : ",");	//bestimmt Anzahl und Position der Punkte und Kommata
				}
				body += "\\\n";	//setzt "\" und springt in neue Zeile
				sublevel = (sublevel%2 == 0 ? 1 : 0);	//toggled sublevel zwischen 0 und 1 
			}
			currentlevel++;
		}
		return body;
	}
	
	
	/** Gibt den Baumstumpf als String zurück
	 * @param level	Größe des Baumes
	 * @return	textuelle Darstellung des Baumstumpfes
	 */
	public String getTrunk(int level) {
		String bottom = "";
		for(int i = 0; i < level; i++) {
			bottom += "^";
		}
		return bottom + Trunk + bottom;
	}
	
	
	/** Gibt den gesamten Baum als String zurück
	 * @return	textuelle Darstellung des gesamten Baumes
	 */
	public String toString() {
		int level = this.level;
		String Tree = getTreeTopper(level) + getBody(level) + getTrunk(level);
		return Tree;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Wie viele Level soll der Weihnachtsbaum haben?");
		
		Scanner sc = new Scanner(System.in);
	    int level = sc.nextInt();
	    sc.close();
		
		System.out.println("Hier ist dein Weihnachtsbaum mit " + level + " Level" + "\n");
		
		XmasTree T1 = new XmasTree(level);
		System.out.println(T1.toString());

	}

}
