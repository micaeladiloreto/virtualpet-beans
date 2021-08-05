import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualPetShelterTest {

    RoboticCat roboCat;
    RoboticDog roboDog;
    OrganicCat orgCat;
    OrganicDog orgDog;
    VirtualPetShelter underTest = new VirtualPetShelter();
    ArrayList<OrganicPet> organicPetStorage;
    ArrayList<RoboticPet> roboticPetStorage;

    @BeforeEach
        public void beforeAllTests(){
        roboCat = new RoboticCat("RoboCat", "description", 50, 50, 50);
        roboDog = new RoboticDog("RoboDog", "description", 50, 50, 50);
        orgCat = new OrganicCat("OrganicCat", "description", 50, 50, 50, 50, 50, 50);
        orgDog = new OrganicDog("OrganicDog", "description", 50, 50, 50, 50, 50, 50);
        organicPetStorage = new ArrayList<OrganicPet>();
        roboticPetStorage = new ArrayList<RoboticPet>();
        roboticPetStorage.add(roboCat);
        roboticPetStorage.add(roboDog);
        organicPetStorage.add(orgCat);
        organicPetStorage.add(orgDog);
    }

    @Test
    public void addInitialPetsToShelterShouldAddInitialPets() {
        underTest.addInitialPetsToShelter();
        assertFalse(organicPetStorage.isEmpty());
    }

//    @Test
//    void resetShelterState() {
//        underTest.organicPetStorage.clear();
//        underTest.roboticPetStorage.clear();
//        assertEquals(0,organicPetStorage.size());
//        assertEquals(0,roboticPetStorage.size());
//    }
}


