package Rooms;

import Dangers.AbilityDanger;
import Dangers.ActionDanger;
import Dangers.Danger;
import Dangers.MagicDanger;

public class RoomBuilder {
	private Danger danger;
	private int number;

	public RoomBuilder()
	{

	}

	public RoomBuilder withNumber(int number)
	{
		this.number = number;
		return this;
	}

	public RoomBuilder withMagicDanger(int magicDanger)
	{
		this.danger = new MagicDanger(magicDanger);
		return this;
	}

	public RoomBuilder withActionDanger(int enemies, int arrows)
	{
		this.danger = new ActionDanger(enemies, arrows);
		return this;
	}

	public RoomBuilder withAbilityDanger()
	{
		this.danger = new AbilityDanger();
		return this;
	}

	public Room buildRoom()
	{
		Room room = new Room();
		room.setDanger(this.danger);
		room.setNumber(this.number);
		return room;
	}
}
