public class RoboticPet extends VirtualPet implements Playable, Ticks {

    protected int battLevel;
    protected int conditionLevel;

    public RoboticPet(String name, String description, int cleanliness, int battLevel, int conditionLevel) {
        super(name, description, cleanliness);
        this.battLevel = battLevel;
        this.conditionLevel = conditionLevel;
    }



    public int getBattLevel() {
        return battLevel;
    }

    public int getConditionLevel() {
        return conditionLevel;
    }

    public void charge() {
        battLevel = 100;
    }

    public void maintenance() {
        conditionLevel += 40;
    }

    @Override
    public void play() {
        battLevel -= 30;
        conditionLevel -= 30;
    }

    @Override
    public void tick() {
        cleanliness -=7;
        if (cleanliness > 100) {
            cleanliness = 100;
        }

        battLevel -= 7;
        conditionLevel -= 7;
        if (conditionLevel > 100) {
            conditionLevel = 100;
        }
    }
}
