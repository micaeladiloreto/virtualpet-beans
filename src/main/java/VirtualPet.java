public class VirtualPet implements Ticks{

    private String name;
    private String description;
    public int cleanliness;

    public VirtualPet(String name, String description, int cleanliness) {
        this.name = name;
        this.description = description;
        this.cleanliness = cleanliness;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void cleanCages() {
        cleanliness += 20;
    }

    @Override
    public void tick() {
        cleanliness -= 3;
        if (cleanliness > 100){
            cleanliness = 100;
        }
    }

}
