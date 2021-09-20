package Moria;

import java.util.ArrayList;
import Rooms.Room;

public class Moria {
	public final ArrayList<Room> dungeon;
	public int rooms;
	public int magicPoints;
	public int arrows;
	public int enemies;
	public static final int NUMBER_ROOMS = 36;
	public static final int MAX_MAGIC_POINTS = 30;
	public static final int MAX_ARROWS = 30;
	public static final int MAX_ENEMIES = 30;
	public static Moria singleton;
	private Moria ()
	{
		this.dungeon = new ArrayList<>();
	}

	public static Moria getInstance()
	{
		if (singleton == null)
		{
			singleton = new Moria();
		}
		return singleton;
	}

	public int getEnemies() {
		return enemies;
	}

	public void setEnemies(int enemies) {
		this.enemies = enemies;
	}

	public int getArrows() {
		return arrows;
	}

	public void setArrows(int arrows) {
		this.arrows = arrows;
	}

	public int getMagicPoints() {
		return magicPoints;
	}

	public void setMagicPoints(int magicPoints) {
		this.magicPoints = magicPoints;
	}

	public int getNumberOfRooms() {
		return rooms;
	}

	public void setNumberOfRooms(int rooms) {
		this.rooms = rooms;
	}

	public void clearMoria()
	{

		while (!this.dungeon.isEmpty())
		{
			this.dungeon.remove(0);
		}
	}
}
