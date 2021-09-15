public class CharacterBuilder {
    private String name = "Default";
    private String race = "Defect";
    private boolean isLive = true;
    private Item item = null;

    public CharacterBuilder(){
    }

    public CharacterBuilder withName(String name){
        this.name = name;
        return this;
    }
    public CharacterBuilder withRace(String race){
        this.race = race;
        return this;
    }
    public CharacterBuilder withIsLive(boolean live){
        this.isLive = live;
        return this;
    }
    public CharacterBuilder withItem(Item item){
        this.item = item;
        return this;
    }
    public Character buildCharacter(){
        Character character = new Character();
        character.setName(this.name);
        character.setRace(this.race);
        character.setLive(this.isLive);
        character.setItem(this.item);
        return character;
    }
}
