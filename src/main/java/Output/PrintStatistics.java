package Output;

public class PrintStatistics {
	public static void printStatistics(Statistics runStats)
	{
		if (runStats != null)
		{
			System.out.println("GENERAL STATISTICS:\n");
			System.out.println("Number of runs: " + runStats.getRunsSample().size());
			System.out.println("Number of successful runs: " + runStats.getSuccessfulRuns());
			System.out.println("Number of non-successful runs: " + runStats.getNonSuccessfulRuns());

			System.out.println("Numbers above show that a mean " + runStats.getMeanSuccessfulRuns()*100 + "% of runs are successful\n\n");


			System.out.println("CHARACTER-WISE STATISTICS:\n");
			System.out.println("Successful runs where a mage made it to the end: " + runStats.getAliveMages());
			System.out.println("Successful runs where an archer made it to the end: " + runStats.getAliveArchers());
			System.out.println("Successful runs where a ring user made it to the end: " + runStats.getAliveRingUsers());

			System.out.println("Numbers above show these mean percentages:\n"
					+ runStats.getMeanAliveMages() + "% of mages are successful.\n"
					+ runStats.getMeanAliveArchers() + "% of archers are successful.\n"
					+ runStats.getMeanAliveRingUsers() + "% of ring users are successful.\n"
			);
//Not working yet
//			System.out.println("Extra data:\n" +
//					"In average, characters reach this room number:\n" +
//					"Mage: " + runStats.getMeanRoomNumberMageDead() + "\n" +
//					"Archer: " + runStats.getMeanRoomNumberArcherDead() + "\n" +
//					"Ring User: " + runStats.getMeanRoomNumberRingDead() + "\n\n");

			System.out.println("ROOM-WISE STATISTICS:\n");
			System.out.println("Total Rooms conquered: " + runStats.getRoomsConquered());
			System.out.println("Total Rooms fled: " + runStats.getRoomsFled());
			System.out.println("Total Rooms generated: " + runStats.getRunsSample().size()*runStats.getRunsRoomNumber());

			System.out.println("Numbers above show these mean percentages:\n"
					+runStats.getMeanConqueredRooms()*100+ "% of rooms are conquered.\n" +
					+runStats.getMeanFledRooms()*100+ "% of rooms are fled.");
			System.out.println("This data shows that a mean number of "
					+ (1 - (runStats.getMeanFledRooms() + runStats.getMeanConqueredRooms())) * 100
					+ "% of the generated rooms are never visited."
			);
		}
	}
}
