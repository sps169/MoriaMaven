import java.util.ArrayList;

public class Team {
    ArrayList<Character> team;

    public Team()
    {
        this.team =  new ArrayList<>();
    }

    public void addCharacterToTeam(Character character)
    {
        this.team.add(character);
    }

    public void removeCharacterFromTeam(Character character)
    {
        this.team.remove(character);
    }

    public void killAll()
    {
        for (Character character:this.team)
        {
            character.setLive(false);
        }
    }

    public ArrayList<Character> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Character> team) {
        this.team = team;
    }

    public Character getBestDude(Danger danger)
    {
        for (Character character: this.team) {
            if (character.getItem().getDangerType() == danger.getDangerType() && character.isLive())
                return character;
        }
        return null;
    }
}
