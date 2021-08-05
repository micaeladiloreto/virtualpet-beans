public class RoboticDog extends RoboticPet implements Walkable {


    public RoboticDog(String name, String description, int cleanliness, int battLevel, int conditionLevel) {
        super(name, description, cleanliness, battLevel, conditionLevel);
    }

    @Override
    public void walk() {
        battLevel -= 40;
        conditionLevel -= 20;
    }
}
