package Execution;

import Characters.Character;
import Characters.CharacterBuilder;
import Characters.Team;
import Items.Quiver;
import Items.Ring;
import Items.Staff;
import Moria.Moria;
import Moria.MoriaBuilder;
import Moria.DungeonLogic;
import Output.ResultWriter;
import Rooms.Room;

import java.time.LocalDateTime;

public class Run {
    final int maxPartyArrows = 30;
    final int maxPartyMagic = 30;
    public Moria moria;
    public Team team;
    public static int runNumber = 0;
    private int conqueredRooms;
    private int fledRooms;
    private int roomWhereRingUserDies = -1;
    private int roomWhereStaffUserDies = -1;
    private int roomWhereQuiverUserDies = -1;
    private boolean runResult;
    private LocalDateTime runStart;
    private LocalDateTime runEnd;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getConqueredRooms() {
        return conqueredRooms;
    }

    public void setConqueredRooms(int conqueredRooms) {
        this.conqueredRooms = conqueredRooms;
    }

    public int getFledRooms() {
        return fledRooms;
    }

    public void setFledRooms(int fledRooms) {
        this.fledRooms = fledRooms;
    }

    public int getRoomWhereRingUserDies() {
        return roomWhereRingUserDies;
    }

    public void setRoomWhereRingUserDies(int roomWhereRingUserDies) {
        this.roomWhereRingUserDies = roomWhereRingUserDies;
    }

    public int getRoomWhereStaffUserDies() {
        return roomWhereStaffUserDies;
    }

    public void setRoomWhereStaffUserDies(int roomWhereStaffUserDies) {
        this.roomWhereStaffUserDies = roomWhereStaffUserDies;
    }

    public int getRoomWhereQuiverUserDies() {
        return roomWhereQuiverUserDies;
    }

    public void setRoomWhereQuiverUserDies(int roomWhereQuiverUserDies) {
        this.roomWhereQuiverUserDies = roomWhereQuiverUserDies;
    }

    public boolean isRunResult() {
        return runResult;
    }

    public void setRunResult(boolean runResult) {
        this.runResult = runResult;
    }

    public LocalDateTime getRunStart() {
        return runStart;
    }

    public void setRunStart(LocalDateTime runStart) {
        this.runStart = runStart;
    }

    public LocalDateTime getRunEnd() {
        return runEnd;
    }

    public void setRunEnd(LocalDateTime runEnd) {
        this.runEnd = runEnd;
    }

    public Run ()
    {
        this.generateRunObjects();
    }

    public boolean getResult()
    {
        return this.runResult;
    }
    public void executeRun ()
    {
        runNumber++;
        boolean fail = false;
        runStart = LocalDateTime.now();
        int i = 0;
        for (Room room = moria.dungeon.get(i); i < moria.getNumberOfRooms();) {
            System.out.println("Room " + room.getNumber());
            Character challenger = team.getBestDude(room.getDanger());
            if (challenger != null) {
                if (!DungeonLogic.conquerRoom(challenger, room)) {
                    challenger.setLive(false);
                    if (challenger.getItem() instanceof Staff)
                        this.roomWhereStaffUserDies = room.getNumber();
                    else if (challenger.getItem() instanceof Quiver)
                        this.roomWhereQuiverUserDies = room.getNumber();
                    else if (challenger.getItem() instanceof Ring)
                        this.roomWhereRingUserDies = room.getNumber();
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
                    if (this.roomWhereStaffUserDies == -1)
                        this.roomWhereStaffUserDies = room.getNumber();
                    if (this.roomWhereQuiverUserDies == -1)
                        this.roomWhereQuiverUserDies = room.getNumber();
                    if (this.roomWhereRingUserDies == -1)
                        this.roomWhereRingUserDies = room.getNumber();
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
        System.out.println("End of Execution.Run\n");
    }

    public void printRun ()
    {
        ResultWriter rw = new ResultWriter();
        rw.fileWriter("Execution.Run Number: " + runNumber);
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

    public void generateRunObjects()
    {
        MoriaBuilder mBuilder = new MoriaBuilder();
        Moria moria = mBuilder
                .withMaxArrows(10)
                .withMaxEnemies(15)
                .withMaxMagic(10)
                .withRooms(36)
                .buildMoria();

        CharacterBuilder cBuilder = new CharacterBuilder();
        Character gandalf = cBuilder
                .withName("Gandalf")
                .withRace("Mage")
                .withItem(new Staff("Staff", (int)(Math.random()*maxPartyArrows + 1), maxPartyMagic))
                .buildCharacter();
        Character frodo = cBuilder
                .withName("Frodo")
                .withRace("Hobbit")
                .withItem(new Ring("Ring"))
                .buildCharacter();
        Character legolas = cBuilder
                .withName("Legolas")
                .withRace("Elf")
                .withItem(new Quiver("Quiver", (int)(Math.random()*maxPartyArrows + 1), maxPartyArrows))
                .buildCharacter();
        Team teamcomp = new Team();
        teamcomp.addCharacterToTeam(gandalf);
        teamcomp.addCharacterToTeam(frodo);
        teamcomp.addCharacterToTeam(legolas);
        this.moria = moria;
        this.team = teamcomp;
    }
}
