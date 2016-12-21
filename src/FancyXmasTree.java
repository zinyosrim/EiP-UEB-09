import java.util.Scanner;

public class FancyXmasTree extends XmasTree {
	
	// Konstruktor
	public FancyXmasTree(int level) {
		super(level);
	}


	public String getTreeTopper(int level) {
		String space = " ";
		for(int i = 0; i < level; i++) {
			space += " ";
		}
		return space +  "X\n" + space + "|\n";
	}
	

	public static void main(String[] args) {
		
		System.out.println("Wie viele Level soll der Weihnachtsbaum haben?");
		
		Scanner sc = new Scanner(System.in);
	    int level = sc.nextInt();
	    sc.close();
		
		System.out.println("Hier ist dein Weihnachtsbaum mit " + level + " Level" + "\n");
		
		XmasTree T1 = new FancyXmasTree(level);
		System.out.println(T1.toString());

	}

}