import java.util.Date;

public class Run {
    private int conqueredRooms;
    private int fledRooms;
    private Date runStart;
    private Date runEnd;

    public void executeRun (Moria moria, Team team)
    {
        boolean fail = false;
        for (Room room : moria.dungeon)
        {
            Character challenger = team.getBestDude(room.getDanger());
            if (challenger != null)
            {
                if(!DungeonLogic.conquerRoom(challenger, room))
                {
                    challenger.setLive(false);
                    fail = true;
                }
            }
            if (fail)
            {
                if (DungeonLogic.attemptFlee())
                    this.fledRooms++;
                else
                {
                    team.killAll();
                    break;
                }
            }
            else
                this.conqueredRooms++;
        }
    }
}
