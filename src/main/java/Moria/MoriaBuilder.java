package Moria;


import Rooms.RoomBuilder;
import Rooms.Room;

public class MoriaBuilder {
	private Moria moria;
	private int maxArrows = 15;
	private int maxMagic = 10;
	private int maxEnemies = 10;
	private int nRooms = 36;
	public MoriaBuilder()
	{
		this.moria = Moria.getInstance();
	}

	public void generateRooms(Moria moria){
		RoomBuilder roomBuilder = new RoomBuilder();
		for(int i = 1; i < moria.getNumberOfRooms() + 1; i++){
			int roomTypeRandomizer = (int)(Math.random() * 3);
			switch(roomTypeRandomizer){
				case 0:
					moria.dungeon.add(roomBuilder
							.withMagicDanger((int)(Math.random() * maxMagic + 1))
							.withNumber(i)
							.buildRoom());
					break;
				case 1:
					moria.dungeon.add(roomBuilder
							.withActionDanger((int)(Math.random() * maxEnemies + 1), (int)(Math.random() * maxArrows + 1))
							.withNumber(i)
							.buildRoom());
					break;

				case 2:
					moria.dungeon.add(roomBuilder
							.withAbilityDanger()
							.withNumber(i)
							.buildRoom());
					break;
			}
		}
	}

	public MoriaBuilder withMaxArrows(int maxArrows){
		this.maxArrows =  maxArrows;
		return this;
	}

	public MoriaBuilder withMaxMagic(int maxMagic){
		this.maxMagic = maxMagic;
		return this;
	}

	public MoriaBuilder withMaxEnemies(int maxEnemies){
		this.maxEnemies = maxEnemies;
		return this;
	}

	public MoriaBuilder withRooms (int rooms){
		this.nRooms = rooms;
		return this;
	}

	public Moria buildMoria(){
		Moria moria = Moria.getInstance();
		moria.setArrows((int)(Math.random() * this.maxArrows + 1));
		moria.setEnemies((int)(Math.random() * this.maxEnemies + 1));
		moria.setMagicPoints((int)(Math.random() * this.maxMagic + 1));
		moria.setNumberOfRooms(nRooms);
		generateRooms(moria);
		return moria;
	}
}
