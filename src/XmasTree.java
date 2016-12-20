
public class XmasTree {
	
	// Attribute
	
	private final String TREETOPPER = "*";
	private final String TRUNK = "[_]";
	private int level = 0;
	
	// Konstruktor
	
	public XmasTree (int level){
		this.level = level;	
	}
	

	
	public String spitze(){
		String str = "";
		for (int i = 0 ; i < this.level+1; i++){
			str = str + " ";
		}
		return str + TREETOPPER + '\n';
		
	}
	
	public String stamm(){
		String str = "";
		for (int i = 0 ; i < this.level; i++){
			str = str + "^";
		}
		return str + TRUNK + str;
		
	}
	
	public String levelZeileOben(int y){
		String str = "";
		for (int x = 1 ; x < this.level+y; x++){
			str = str + " ";
		}
		str = str + "/";
		for (int x = 0 ; x < this.level-2*y; x++ ){
			if ( x%2!=0 ){ 
				str = str + "," ; 
			}
			else { 
				str = str + "." ;
			}
		}
		return (str + (char)92);
		
	}
	
	public String levelZeileUnten(int y){
		String str = "";
		for (int x = 1 ; x < this.level-y+y; x++){
			str = str + " ";
		}
		str = str + "/";
		for (int x = 0 ; x < this.level-2*y; x++ ){
			if ( x%2!=0 ){ 
				str = str + "," ; 
			}
			else { 
				str = str + "." ;
			}
		}
		return (str + (char)92);
		
	}
	
	public String toString(){
		String str = this.spitze() + '\n';
		for (int y = this.level; y > 0; y--){
			str = levelZeileOben(y) + (char)10 + levelZeileUnten(y) + (char)10;
		}
		return str;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XmasTree tannenbaum = new XmasTree(5);

		System.out.println(tannenbaum.toString());
		System.out.println(tannenbaum.stamm());
	}

}
