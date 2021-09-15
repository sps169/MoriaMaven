public class Room
{
	public int number;
	public Danger danger;

	public Room (int number, int maxMagic, int maxArrows, int maxEnemies)
	{
		this.number = number;
		this.danger = null;
	}
}