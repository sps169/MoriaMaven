package Dangers;

public class ActionDanger extends Danger{
	private int arrows;
	private int enemies;

	public ActionDanger (int arrows, int enemies)
	{
		this.dangerType = DangerType.action;
		this.arrows = arrows;
		this.enemies = enemies;
	}

	public int getArrows() {
		return arrows;
	}

	public void setArrows(int arrows) {
		this.arrows = arrows;
	}

	public int getEnemies() {
		return enemies;
	}

	public void setEnemies(int enemies) {
		this.enemies = enemies;
	}
}
