public class DungeonLogic {

    public static final int fleeChances = 80;

    public static boolean attemptFlee()
    {
        if ((int)(Math.random()*100) > fleeChances)
            return false;
        else
            return true;
    }

    public static boolean conquerRoom(Character character, Room room)
    {
        if (room.getDanger().getDangerType() == character.getItem().getDangerType())
        {
            switch(room.getDanger().getDangerType())
            {
                case magic:
                    return magicCombat((Staff)character.getItem(), (MagicDanger)room.getDanger());
                case action:
                    return actionCombat((Quiver)character.getItem(), (ActionDanger)room.getDanger());
                case ability:
                    return abilityCombat((Ring)character.getItem());
                default:
                    System.err.println("Wrong Danger Type");
                    return false;
            }
        }
        else
            return false;
    }

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

    public static boolean magicCombat(Staff magicItem, MagicDanger magicDanger)
    {
        boolean result;

        magicItem.rechargeStaff((int)(Math.random()*10)+1);
        if (magicDanger.getMagicPoints() < magicItem.getEnergy())
            return true;
        else if  (magicDanger.getMagicPoints() < magicItem.getEnergy())
        {
            if ((int)(Math.random()*100) > 60)
                result = false;
            else
                result = true;
        }
        else
        {
            if ((int)(Math.random()*100) > 30)
                result = false;
            else
                result = true;
        }
        if (result)
            magicItem.setEnergy(magicItem.getEnergy()-magicDanger.getMagicPoints());
        return result;
    }

    public static boolean abilityCombat(Ring abilityItem)
    {
        boolean result;

        if (Math.random()*100 > 50)
            abilityItem.putOnRing();
        if (abilityItem.getIsWearing())
        {
            if (Math.random() * 100 > 90)
                result = false;
            else
                result = true;
        }
        else
        {
            if (Math.random() * 100 > 20)
                result = false;
            else
                result = true;
        }
        abilityItem.takeOffRing();
        return result;

    }
}
