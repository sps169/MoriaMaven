public class Main {
	public static void main (String[] args){
		final int maxPartyArrows = 30;
		final int maxPartyMagic = 30;
		MoriaBuilder mBuilder = new MoriaBuilder();
		Moria moria = mBuilder
				.withMaxArrows(10)
				.withMaxEnemies(15)
				.withMaxMagic(10)
				.withRooms(36)
				.buildMoria();

		CharacterBuilder cBuilder = new CharacterBuilder();
		Character gandalf = cBuilder
				.withName("Gandalf")
				.withRace("Mage")
				.withItem(new Staff("Staff", (int)(Math.random()*maxPartyArrows + 1), maxPartyMagic))
				.buildCharacter();
		Character frodo = cBuilder
				.withName("Frodo")
				.withRace("Hobbit")
				.withItem(new Ring("Ring"))
				.buildCharacter();
		Character legolas = cBuilder
				.withName("Legolas")
				.withRace("Elf")
				.withItem(new Quiver("Quiver", (int)(Math.random()*maxPartyArrows + 1), maxPartyArrows))
				.buildCharacter();

		System.out.println("Characters:\n");
		System.out.println("[ " + frodo.toString() + "]");
		System.out.println("[" + gandalf.toString() + "]");
		System.out.println("[" + legolas.toString() + "]\n");

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
