public class Main {
	public static void main (String[] args){
		Moria moria = Moria.getInstance();
		for(int i = 0; i < moria.moria.size(); i++) {
			Room room = moria.moria.get(i);
			System.out.println(room.number + ". " + room.danger.getDangerType());
		}
	}
}
