public class MagicDanger extends Danger{
	public final int magicPoints;

	public MagicDanger (int magicPoints)
	{
		this.dangerType = DangerType.magic;
		this.magicPoints = magicPoints;
	}
}