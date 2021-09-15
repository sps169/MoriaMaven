public class MagicDanger extends Danger{
	public int magicPoints;

	public MagicDanger (int magicPoints)
	{
		this.dangerType = DangerType.magic;
		this.magicPoints = magicPoints;
	}
}