public class Room
{
	public final int number;
	public final Danger danger;

	public Room (int number, DangerType dangerType, int maxMagic, int maxArrows, int maxEnemies)
	{
		this.number = number;
		if (dangerType == DangerType.magic)
			this.danger = new MagicDanger(maxMagic);
		else if (dangerType == DangerType.action)
			this.danger = new ActionDanger(maxArrows, maxEnemies);
		else
			this.danger = new AbilityDanger();
	}
}