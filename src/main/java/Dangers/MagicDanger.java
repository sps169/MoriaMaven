package Dangers;

public class MagicDanger extends Danger{
	private int magicPoints;

	public MagicDanger (int magicPoints)
	{
		this.dangerType = DangerType.magic;
		this.magicPoints = magicPoints;
	}

	public int getMagicPoints() {
		return this.magicPoints;
	}

	public void setMagicPoints(int magicPoints) {
		this.magicPoints = magicPoints;
	}
}