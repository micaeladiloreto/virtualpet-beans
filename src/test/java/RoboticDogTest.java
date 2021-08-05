import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoboticDogTest {
    private RoboticDog underTest;

    @BeforeEach
    public void setup() {
        underTest = new RoboticDog("TestDog", "description", 50,50,50);
    }

    @Test
    public void roboticDogHasName() {
        assertEquals("TestDog", underTest.getName());
    }

    @Test
    public void roboticDogHasDescription() {
        assertEquals("description", underTest.getDescription());
    }

    @Test
    public void roboticDogShouldCharge() {
        underTest.charge();
        assertEquals(100, underTest.getBattLevel());
    }

    @Test
    public void roboticDogShouldWalk() {
        int initialBattLevel = underTest.getBattLevel();
        int initialConditionLevel = underTest.getConditionLevel();
        underTest.walk();
        assertTrue(underTest.getBattLevel() < initialBattLevel);
        assertTrue(underTest.getConditionLevel() < initialConditionLevel);
    }

    @Test
    public void roboticDogShouldRequireMaintenance() {
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
    public void roboticDogShouldBeAbleToPlay(){
        int initialBatteryLevel = underTest.getBattLevel();
        int initialConditionLevel = underTest.getConditionLevel();
        underTest.play();
        assertTrue(underTest.getConditionLevel() < initialConditionLevel);
        assertTrue(underTest.getBattLevel() < initialBatteryLevel);
    }

    @Test
    public void roboticDogBatteryLevelShouldGoDownWhenPlayedWith(){
        int initialBatteryLevel = underTest.getBattLevel();
        underTest.play();
        assertTrue(underTest.getBattLevel() < initialBatteryLevel);
    }

    @Test
    public void roboticDogMaintenanceNeedsShouldIncreaseWhenWalked(){
        int initialBatteryLevel = underTest.getBattLevel();
        int initialConditionLevel = underTest.getConditionLevel();
        underTest.walk();
        assertTrue(underTest.getConditionLevel() < initialConditionLevel);
        assertTrue(underTest.getBattLevel() < initialBatteryLevel);
    }

   @Test
    public void roboticDogCleanlinessShouldGoDownWhenTicked(){
        int initialCleanliness = underTest.getCleanliness();
        underTest.tick();
        assertTrue(underTest.getCleanliness() < initialCleanliness);
   }

//    @Test
//    public void roboticDogCleanlinessShouldNeverBeOverOneHundred() {
//        for (int i = 0; i < 20; i++) {
//            underTest.cleanCages();
//        }
//        underTest.tick();
//        assertTrue(underTest.getConditionLevel() == 100);
//    }


}
