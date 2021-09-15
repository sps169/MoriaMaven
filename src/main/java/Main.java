import java.sql.SQLOutput;

public class Main {
	public static void main (String[] args){
		MoriaBuilder mBuilder = new MoriaBuilder();
		Moria moria = mBuilder
				.withMaxArrows(10)
				.withMaxEnemies(15)
				.withMaxMagic(10)
				.withRooms(36)
				.buildMoria();

		for(int i = 0; i < moria.dungeon.size(); i++) {
			Room room = moria.dungeon.get(i);
			System.out.println(room.getNumber() + ". " + room.getDanger().getDangerType());
			switch (room.getDanger().getDangerType()) {
				case magic:
					System.out.println("Magic Danger: " + ((MagicDanger) room.getDanger()).getMagicPoints());
					break;
				case action:
					System.out.println("Arrows: " + ((ActionDanger) room.getDanger()).getArrows() +
							" Enemies: " + ((ActionDanger) room.getDanger()).getEnemies());
					break;
			}
		}
	}
}
