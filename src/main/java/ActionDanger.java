public class ActionDanger extends Danger{
	public int arrows;
	public int enemies;

	public ActionDanger (int arrows, int enemies)
	{
		this.dangerType = DangerType.action;
		this.arrows = arrows;
		this.enemies = enemies;
	}
}
