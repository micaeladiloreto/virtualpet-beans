import java.util.ArrayList;

public class VirtualPetShelter {

    ArrayList<OrganicPet> organicPetStorage = new ArrayList<OrganicPet>();
    ArrayList<RoboticPet> roboticPetStorage = new ArrayList<RoboticPet>();

    public void addInitialPetsToShelter(){
        RoboticDog pet1 = new RoboticDog("Pippi", "a small robotic pomeranian, very friendly!", 50,50,50);
        OrganicDog pet2 = new OrganicDog("Ralph","a large Alaskan Malamute, loves cookies!", 50,50,50,50,50,50);
        RoboticCat pet3 = new RoboticCat("Beemo","calls herself a cat but actually looks more like a Nintendo Gameboy. Will not stop meow even after repeatedly being asked not to.", 50,50,50);
        OrganicCat pet4 = new OrganicCat("Franklin", "an orange tabby cat that thoroughly dislikes carrots.", 50,50,50,50,50,50);
        roboticPetStorage.add(pet1);
        organicPetStorage.add(pet2);
        roboticPetStorage.add(pet3);
        organicPetStorage.add(pet4);
    }

    public void resetShelterState(){
        organicPetStorage.removeAll(organicPetStorage);
        roboticPetStorage.removeAll(roboticPetStorage);
    }
}

