public class ActionDanger extends Danger{
	public final int arrows;
	public final int enemies;

	public ActionDanger (int arrows, int enemies)
	{
		this.dangerType = DangerType.action;
		this.arrows = arrows;
		this.enemies = enemies;
	}
}
