import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoboticCatTest {
    private RoboticCat underTest;

    @BeforeEach
    public void setup() {
        underTest = new RoboticCat("TestCat", "description", 50, 50,50);
    }


    @Test
    public void roboticCatHasName() {
        assertEquals("TestCat", underTest.getName());
    }

    @Test
    public void roboticCatHasDescription() {
        assertEquals("description", underTest.getDescription());
    }

    @Test
    public void roboticCatShouldCharge() {
        underTest.charge();
        assertEquals(100, underTest.getBattLevel());
    }

    @Test
    public void roboticCatShouldRequireMaintenance() {
        int initialConditionLevel = underTest.getConditionLevel();
        underTest.maintenance();
        assertTrue(underTest.getConditionLevel() > initialConditionLevel);
    }

    @Test
    public void roboticDogConditionShouldNeverBeOverOneHundred() {
        for (int i = 0; i < 20; i++) {
            underTest.maintenance();
        }
        underTest.tick();
        assertTrue(underTest.getConditionLevel() == 100);
    }

    @Test
    public void roboticCatShouldBeAbleToPlay(){
        int initialBatteryLevel = underTest.getBattLevel();
        int initialConditionLevel = underTest.getConditionLevel();
        underTest.play();
        assertTrue(underTest.getConditionLevel() < initialConditionLevel);
        assertTrue(underTest.getBattLevel() < initialBatteryLevel);
    }

    @Test
    public void roboticCatBatteryLevelGoesDownWhenPlayedWith(){
        int initialBatteryLevel = underTest.getBattLevel();
        underTest.play();
        assertTrue(underTest.getBattLevel() < initialBatteryLevel);
    }

    @Test
    public void roboticCatCleanlinessShouldGoDownWhenTicked(){
        int initialCleanliness = underTest.getCleanliness();
        underTest.tick();
        assertTrue(underTest.getCleanliness() < initialCleanliness);
    }

}