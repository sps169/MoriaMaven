package Rooms;

import Dangers.Danger;

public class Room
{
	private int number;
	private Danger danger;

	public Room ()
	{

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Danger getDanger() {
		return danger;
	}

	public void setDanger(Danger danger) {
		this.danger = danger;
	}
}