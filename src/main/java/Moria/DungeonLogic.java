package Moria;

import Characters.Character;
import Dangers.*;
import Items.Quiver;
import Items.Ring;
import Items.Staff;
import Rooms.Room;

public class DungeonLogic {

    public static final int CHANCES_FLEE = 80;
    public static final int CHANCES_SAME_PM = 60;
    public static final int CHANCES_LESS_PM = 30;
    public static final int CHANCES_PUT_ON_RING = 50;
    public static final int CHANCES_WEARING_RING = 90;
    public static final int CHANCES_NOT_WEARING_RING = 20;

    /**
     * Method that returns true if flee was successful
     * and false if flee wasn't successful
     * @return  boolean flee
     */
    public static boolean attemptFlee()
    {
        return ((int)(Math.random() * 100) <= CHANCES_FLEE);
    }

    /**
     * Method that returns true if the character beats the room
     * and returns false if the character fails to beat the room
     * @param character     {@link Character} that will challenge the room
     * @param room          {@link Room} that will be challenged
     * @return boolean      true if room was conquered, false otherwise
     */
    public static boolean conquerRoom(Character character, Room room)
    {
        if (room.getDanger().getDangerType() == character.getItem().getDangerType())
        {
            switch(room.getDanger().getDangerType())
            {
                case magic:
                    System.out.print(character.getName() + " fights with " +
                            ((Staff)character.getItem()).getEnergy() + " PM ");
                    System.out.println("a " + ((MagicDanger)room.getDanger()).getMagicPoints() + "PM danger.");

                    return magicCombat((Staff)character.getItem(), (MagicDanger)room.getDanger(), 30);
                case action:
                    System.out.print(character.getName() + " fights with " +
                            ((Quiver)character.getItem()).getArrows() + " arrows ");
                    System.out.println(((ActionDanger)room.getDanger()).getEnemies()
                            + " enemies with " + ((ActionDanger)room.getDanger()).getArrows() + " arrows on the floor.");
                    return actionCombat((Quiver)character.getItem(), (ActionDanger)room.getDanger());
                case ability:
                    System.out.println(character.getName() + " fights.");
                    return abilityCombat((Ring)character.getItem());
                default:
                    System.err.println("Wrong Dangers.Danger Type");
                    return false;
            }
        }
        else
            return false;
    }

    /**
     * Executes an action-type combat between a {@link Quiver}
     * and the {@link ActionDanger} it will face. It will manage the
     * quiver's arrows. (Shoots them and refills with the room's arrows)
     * @param actionItem    {@link Quiver} used at combat.
     * @param actionDanger  {@link ActionDanger} used at combat.
     * @return boolean      true if actionItem beats actionDanger, false otherwise.
     */
    public static boolean actionCombat(Quiver actionItem, ActionDanger actionDanger)
    {
        for (int i = 0; i < actionDanger.getEnemies(); i++)
        {
            if (actionItem.getArrows() != 0)
                actionItem.shootArrow();
            else
                return false;
        }
        actionItem.rechargeArrows(actionDanger.getArrows());
        return true;
    }

    /**
     * Executes a magic-type combat between a {@link Staff}
     * and the {@link MagicDanger} it will face. It will manage
     * the staff's magic points recharge and magic points usage.
     * @param magicItem         {@link Staff} that will fight the Danger.
     * @param magicDanger       {@link MagicDanger} that will be challenged by the staff.
     * @return                  true if danger is beaten, false otherwise.
     */
    public static boolean magicCombat(Staff magicItem, MagicDanger magicDanger, int CHANCES_LESS_PM)
    {
        boolean result;

        magicItem.rechargeStaff((int)(Math.random()*10)+1);
        if (magicDanger.getMagicPoints() < magicItem.getEnergy())
            result = true;
        else if  (magicDanger.getMagicPoints() == magicItem.getEnergy())
            result = (Math.random() * 100) <= CHANCES_SAME_PM;
        else
            result = (Math.random() * 100) <= CHANCES_LESS_PM;
        if (result)
            magicItem.setEnergy(magicItem.getEnergy()-magicDanger.getMagicPoints());
        return result;
    }

    /**
     * Executes an ability-type combat between a {@link Ring}
     * and the {@link AbilityDanger} it will face, returning the result.
     * The method manages the ring status and will take it off at
     * the end of the operation.
     * @param abilityItem   {@link Ring} that will be used in the combat
     * @return boolean      true if abilityItem conquers the Danger, false otherwise
     */
    public static boolean abilityCombat(Ring abilityItem)
    {
        boolean result;

        if (Math.random()*100 > CHANCES_PUT_ON_RING)
            abilityItem.putOnRing();
        if (abilityItem.getIsWearing())
            result = (Math.random() * 100) < CHANCES_WEARING_RING;
        else
            result = (Math.random() * 100) < CHANCES_NOT_WEARING_RING;
        abilityItem.takeOffRing();
        return result;

    }
}
