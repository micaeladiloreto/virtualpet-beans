import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrganicCatTest {
    private OrganicCat underTest;

    @BeforeEach
    public void setup() {
        underTest = new OrganicCat("TestCat", "description", 50, 50,50,50,50,50);
    }

    @Test
    public void organicCatHasName() {
        assertEquals("TestCat", underTest.getName());
    }

    @Test
    public void organicCatHasDescription() {
        assertEquals("description", underTest.getDescription());
    }


    @Test
    public void organicCatShouldBeAbleToEat() {
        int initialHungerLevel = underTest.getHunger();
        underTest.eat();
        assertTrue(underTest.getHunger() < initialHungerLevel);
    }

    @Test
    public void organicCatHungerLevelShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.eat();
        }
        underTest.tick();
        assertTrue(underTest.getHunger() == 0);
    }

    @Test
    public void organicCatShouldBeAbleToSleep() {
        int initialTirednessLevel = underTest.getTiredness();
        underTest.sleep();
        assertTrue(underTest.getTiredness() < initialTirednessLevel);
    }

    @Test
    public void organicCatTirednessShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.sleep();
        }
        underTest.tick();
        assertTrue(underTest.getTiredness() == 0);
    }

    @Test
    public void organicCatShouldBeAbleToPlay() {
        int initialBoredom = underTest.getBoredom();
        underTest.play();
        assertTrue(underTest.getBoredom() < initialBoredom);
    }

    @Test
    public void organicCatBoredomShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.play();
                  }
        underTest.tick();
        assertTrue(underTest.getBoredom() == 0);
    }

    @Test
    public void organicCatShouldBeAbleToDrink() {
        int initialThirst = underTest.getThirst();
        underTest.drink();
        assertTrue(underTest.getThirst() < initialThirst);
    }

    @Test
    public void organicCatThirstShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.drink();
            }
        underTest.tick();
        assertTrue(underTest.getThirst() == 0);
    }

    @Test
    public void organicCatBathroomLevelShouldGoDownWhenItPotties(){
        int initialBathroom = underTest.getBathroom();
        underTest.potty();
        assertTrue(underTest.getBathroom() < initialBathroom);
    }

    @Test
    public void organicCatBathroomShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.potty();
        }
        underTest.tick();
        assertTrue(underTest.getBathroom() == 0);
    }

    @Test
    public void organicCatCleanlinessShouldGoDownWhenTicked(){
        int initialCleanliness = underTest.getCleanliness();
        underTest.tick();
        assertTrue(underTest.getCleanliness() < initialCleanliness);
    }

}