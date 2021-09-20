import Characters.Character;
import Characters.Team;
import Moria.Moria;
import Moria.DungeonLogic;
import Output.ResultWriter;
import Rooms.Room;

import java.time.LocalDateTime;

public class Run {
    public static int runNumber = 0;
    private int conqueredRooms;
    private int fledRooms;
    private boolean runResult;
    private LocalDateTime runStart;
    private LocalDateTime runEnd;

    public Run ()
    {

    }

    public boolean getResult()
    {
        return this.runResult;
    }
    public void executeRun (Moria moria, Team team)
    {
        runNumber++;
        boolean fail = false;
        runStart = LocalDateTime.now();
        int i = 0;
        for (Room room = moria.dungeon.get(i); i < moria.getNumberOfRooms();) {
            System.out.println("Rooms.Room " + room.getNumber());
            Character challenger = team.getBestDude(room.getDanger());
            if (challenger != null) {
                if (!DungeonLogic.conquerRoom(challenger, room)) {
                    challenger.setLive(false);
                    System.out.println(challenger.getName() + " ded xd");
                    fail = true;
                }
            }
            else
            {
                fail = true;
            }
            if (fail) {
                if (DungeonLogic.attemptFlee()) {
                    this.fledRooms++;
                    fail = false;
                    System.out.println("party flees");
                }
                else {
                    team.killAll();
                    System.out.println("all dead xd");
                    break;
                }
            }
            else
            {
                this.conqueredRooms++;
                System.out.println("party wins");
            }
            i++;
            if (i < moria.getNumberOfRooms())
                room = moria.dungeon.get(i);
        }
        runEnd = LocalDateTime.now();
        this.runResult = !fail;
        System.out.println("End of Run\n");
    }

    public void printRun ()
    {
        ResultWriter rw = new ResultWriter();
        rw.fileWriter("Run Number: " + runNumber);
        if (this.runResult)
            rw.fileWriter("Resultado Simulación: Mazmorra superada");
        else
            rw.fileWriter("Resultado Simulación: Mazmorra no superada");
        rw.fileWriter("Salas conquistadas: " + this.conqueredRooms);
        rw.fileWriter("Salas esquivadas: " + this.fledRooms);
        rw.fileWriter("Inicio: " + this.runStart.toString());
        rw.fileWriter("Fin: " + this.runEnd.toString());
        rw.fileWriter("");
    }
}
