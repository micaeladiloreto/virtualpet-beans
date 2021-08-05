public class OrganicDog extends OrganicPet implements Walkable{


    public OrganicDog(String name, String description, int cleanliness, int hunger, int tiredness, int boredom, int thirst, int bathroom) {
        super(name, description, cleanliness, hunger, tiredness, boredom, thirst, bathroom);
    }

    @Override
    public void walk() {
        boredom -= 50;
        bathroom -= 20;
    }
}
