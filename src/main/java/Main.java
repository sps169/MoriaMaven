public class Main {
	public static void main (String[] args){
		final int maxPartyArrows = 30;
		final int maxPartyMagic = 30;
		int i = 0;
		while(i < 1000) {

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
			Team teamcomp = new Team();
			teamcomp.addCharacterToTeam(gandalf);
			teamcomp.addCharacterToTeam(frodo);
			teamcomp.addCharacterToTeam(legolas);
			Run runner = new Run();
			runner.executeRun(moria, teamcomp);
			runner.printRun();
			i++;
		}
//		ResultWriter resultWriter = new ResultWriter();
//		resultWriter.fileWriter("Characters:\n");
//		resultWriter.fileWriter("[ " + frodo.toString() + "]");
//		resultWriter.fileWriter("[" + gandalf.toString() + "]");
//		resultWriter.fileWriter("[" + legolas.toString() + "]\n");
//
//		for(int i = 0; i < moria.dungeon.size(); i++) {
//			Room room = moria.dungeon.get(i);
//			resultWriter.fileWriter(room.getNumber() + ". " + room.getDanger().getDangerType());
//			switch (room.getDanger().getDangerType()) {
//				case magic:
//					resultWriter.fileWriter("Magic Danger: " + ((MagicDanger) room.getDanger()).getMagicPoints());
//					break;
//				case action:
//					resultWriter.fileWriter("Arrows: " + ((ActionDanger) room.getDanger()).getArrows() +
//							" Enemies: " + ((ActionDanger) room.getDanger()).getEnemies());
//					break;
//			}
//		}
	}
}
