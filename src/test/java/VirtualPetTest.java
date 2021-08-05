import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetTest {
    private VirtualPet underTest;

    @BeforeEach
    public void setup() {
        underTest = new VirtualPet("TestPet", "description", 50);
    }

    @Test
    public void allPetsShouldHaveACageCleanliness() {
        assertEquals(50, underTest.getCleanliness());
    }

    @Test
    public void cagesShouldBeCleanedWhenCleanCagesIsRun() {
        int initialCageCleanliness = underTest.getCleanliness();
        underTest.cleanCages();
        assertTrue(underTest.getCleanliness() > initialCageCleanliness);
    }
}
