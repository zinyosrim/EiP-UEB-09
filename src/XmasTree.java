import java.util.Scanner;

public class XmasTree {
	
	// Attribute
	protected final String TreeTopper = "*";
	protected final String Trunk = "[_]";
	protected int level = 0;

	
	// Konstruktor
	public XmasTree(int level) {
		this.level = level;
	}
	
	public String getTreeTopper(int level) {
		String space = " ";
		for(int i = 0; i < level; i++) {
			space += " ";
		}
		return space + TreeTopper + "\n";
	}
	
	public String getBody(int level) {
		int currentlevel = 0;
		int sublevel = 0;
		String body = "";
		for (int k = 0; k < level; k++) {
			for (int j = 0; j < 2; j++) {
				for(int i = 0; i < level - currentlevel - sublevel; i++) {
					body += " ";
				}
				body += "/";
				for(int i = 0; i < 2*currentlevel + 2*sublevel + 1; i++) {
					body += (i%2 == sublevel ? "." : ",");
				}
				body += "\\\n";
				sublevel = (sublevel%2 == 0 ? 1 : 0);
			}
			currentlevel++;
		}
		return body;
	}
	
	public String getTrunk(int level) {
		String bottom = "";
		for(int i = 0; i < level; i++) {
			bottom += "^";
		}
		return bottom + Trunk + bottom;
	}
	
	public String toString() {
		String Tree = getTreeTopper(this.level) + getBody(this.level) + getTrunk(this.level);
		return Tree;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Wie viele Level soll der Weihnachtsbaum haben?");
		
		Scanner sc = new Scanner(System.in);
	    int level = sc.nextInt();
	    sc.close();
		
		System.out.println("Hier ist dein Weihnachtsbaum mit " + level + " Level");
		
		XmasTree T1 = new XmasTree(level);
		System.out.println(T1.toString());

	}

}
