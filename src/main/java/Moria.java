import java.util.ArrayList;

public class Moria {
	public final ArrayList<Room> moria;
	public static final int NUMBER_ROOMS = 36;
	public static final int MAX_MAGIC_POINTS = 30;
	public static final int MAX_ARROWS = 30;
	public static final int MAX_ENEMIES = 30;
	public static Moria singleton;
	private Moria ()
	{
		this.moria = new ArrayList<>();
		this.generateMoria();
	}

	public static Moria getInstance()
	{
		if (singleton == null)
		{
			singleton = new Moria();
		}
		return singleton;
	}
	private void generateMoria()
	{
		for (int i = 0; i < Moria.NUMBER_ROOMS; i++)
		{
			this.moria.add(new Room(
					i + 1, DangerType.values()[(int)(Math.random()*3)], MAX_MAGIC_POINTS, MAX_ARROWS, MAX_ENEMIES));
		}
	}

	public void clearMoria()
	{

		while (!this.moria.isEmpty())
		{
			this.moria.remove(0);
		}
	}
}
