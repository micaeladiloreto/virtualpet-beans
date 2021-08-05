import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrganicDogTest {
    private OrganicDog underTest;

    @BeforeEach
    public void setup() {
        underTest = new OrganicDog("TestDog", "description", 50,50,50,50,50,50);
    }

    @Test
    public void organicDogHasName() {
        assertEquals("TestDog", underTest.getName());
    }

    @Test
    public void organicDogHasDescription() {
        assertEquals("description", underTest.getDescription());
    }

    @Test
    public void organicDogShouldBeWalkable() {
        int initialBoredomLevel = underTest.getBoredom();
        int initialBathroomLevel = underTest.getBathroom();
        underTest.walk();
        assertTrue(underTest.getBoredom() < initialBoredomLevel);
        assertTrue(underTest.getBathroom() < initialBathroomLevel);
    }

    @Test
    public void organicDogShouldBeAbleToEat() {
        int initialHungerLevel = underTest.getHunger();
        underTest.eat();
        assertTrue(underTest.getHunger() < initialHungerLevel);
    }

    @Test
    public void organicDogHungerLevelShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.eat();
        }
        underTest.tick();
        assertTrue(underTest.getHunger() == 0);
    }

    @Test
    public void organicDogShouldBeAbleToSleep() {
        int initialTirednessLevel = underTest.getTiredness();
        underTest.sleep();
        assertTrue(underTest.getTiredness() < initialTirednessLevel);

    }

    @Test
    public void organicDogTirednessShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.sleep();
        }
        underTest.tick();
        assertTrue(underTest.getTiredness() == 0);
    }

    @Test
    public void organicDogShouldBeAbleToPlay() {
        int initialBoredom = underTest.getBoredom();
        underTest.play();
        assertTrue(underTest.getBoredom() < initialBoredom);
    }

    @Test
    public void organicDogBoredomShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.play();
        }
        underTest.tick();
        assertTrue(underTest.getBoredom() == 0);
    }

    @Test
    public void organicDogShouldBeAbleToDrink() {
        int initialThirst = underTest.getThirst();
        underTest.drink();
        assertTrue(underTest.getThirst() < initialThirst);
    }

    @Test
    public void organicDogThirstShouldNeverGoBelowZero() {
        for (int i = 0; i < 20; i++) {
            underTest.drink();
        }
        underTest.tick();
        assertTrue(underTest.getThirst() == 0);
    }

    @Test
    public void organicDogBathroomLevelShouldGoDownWhenItPotties(){
        int initialBathroom = underTest.getBathroom();
        underTest.potty();
        assertTrue(underTest.getBathroom() < initialBathroom);
    }

    @Test
    public void organicDogBathroomShouldNeverGoBelowZero() {
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
