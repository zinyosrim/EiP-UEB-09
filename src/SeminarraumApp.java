
public class SeminarraumApp {
	public static Seminarraum hoersaalB101 = new Seminarraum(18);
	public static Seminarraum hoersaalB201 = new Seminarraum(18);
	public static void main(String[] args) {
//			System.out.println(hoersaalB101.getStuehle());
			hoersaalB101.setStuehle(18);
			hoersaalB101.decrementStuehle(2);
//			System.out.println(hoersaalB101.getStuehle());
//			hoersaalB101.incrementStuehle(1);
//			System.out.println(hoersaalB101.getStuehle());
//			
			System.out.println(hoersaalB101.toString());
//			
//			hoersaalB201.setStuehle(18);
//			hoersaalB201.decrementStuehle(1);
//			
//			System.out.println("HS B101 hat "+hoersaalB101.getStuehle()+" Stuehle");
//			System.out.println("HS B201 hat "+hoersaalB201.getStuehle()+" Stuehle");
//			if (hoersaalB101.equals(hoersaalB201) == true){
//				System.out.println("Hörsaale haben gleiche Bestuhlung");
//			}
//			else System.out.println("Hörsaale haben ungleiche Bestuhlung");
			
		
	}

}
