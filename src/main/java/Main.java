import Characters.Character;
import Characters.CharacterBuilder;
import Characters.Team;
import Items.Quiver;
import Items.Ring;
import Items.Staff;
import Moria.Moria;
import Moria.MoriaBuilder;

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
					.withItem(new Staff("Items.Staff", (int)(Math.random()*maxPartyArrows + 1), maxPartyMagic))
					.buildCharacter();
			Character frodo = cBuilder
					.withName("Frodo")
					.withRace("Hobbit")
					.withItem(new Ring("Items.Ring"))
					.buildCharacter();
			Character legolas = cBuilder
					.withName("Legolas")
					.withRace("Elf")
					.withItem(new Quiver("Items.Quiver", (int)(Math.random()*maxPartyArrows + 1), maxPartyArrows))
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
	}
}
