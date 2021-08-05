public class OrganicPet extends VirtualPet implements Playable, Ticks {

    protected int hunger;
    protected int tiredness;
    protected int boredom;
    protected int thirst;
    protected int bathroom;

    public OrganicPet(String name, String description, int cleanliness, int hunger, int tiredness, int boredom, int thirst, int bathroom) {
        super(name, description, cleanliness);
        this.hunger = hunger;
        this.tiredness = tiredness;
        this.boredom = boredom;
        this.thirst = thirst;
        this.bathroom = bathroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getThirst() {
        return thirst;
    }


    public void potty() {
        bathroom -= 20;
    }

    public void eat() {
        hunger -= 20;
        bathroom += 15;
    }

    public void sleep() {
        tiredness -= 20;
    }

    public void drink() {
        thirst -= 20;
        bathroom += 15;
    }

    @Override
    public void play() {
        boredom -= 20;
    }

    @Override
    public void tick() {
        hunger += 7;
        if (hunger < 0) {
            hunger = 0;
        }
        tiredness += 7;
        if (tiredness < 0) {
            tiredness = 0;
        }
        thirst += 7;
        if (thirst < 0) {
            thirst = 0;
        }
        boredom += 7;
        if (boredom < 0) {
            boredom = 0;
        }
        bathroom += 7;
        if (bathroom < 0) {
            bathroom = 0;
        }
        cleanliness -= 7;
        if (cleanliness > 100) {
            cleanliness = 100;
        }
    }
}
