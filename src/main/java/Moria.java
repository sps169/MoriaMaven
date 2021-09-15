import java.util.ArrayList;

public class Moria {
	public final ArrayList<Room> moria;
	public static final int NUMBER_ROOMS = 36;
	public static Moria singleton;
	private Moria ()
	{
		this.moria = new ArrayList<>();
	}

	public Moria getInstance()
	{
		if (singleton == null)
		{
			singleton = new Moria();
			this.generateMoria();
		}
		return singleton;
	}
	private void generateMoria()
	{
		for (int i = 0; i < Moria.NUMBER_ROOMS; i++)
		{
			this.moria.add(new Room(i + 1, DangerType.values()[(int)(Math.random()*3)], 30, 30, 30));
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
