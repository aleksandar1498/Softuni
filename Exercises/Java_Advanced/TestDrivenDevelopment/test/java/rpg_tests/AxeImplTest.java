package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.AxeImpl;
import rpg_lab.Dummy;

import static utils.Constants.*;


public class AxeImplTest {



    private Dummy dummy;
    @Before
    public void setUp(){
        this.dummy = new Dummy(DUMMY_HEALTH,DUMMY_XP);
    }
    @Test
    public void shouldLoseDurabilityOnAttach(){
        // 3A pattern
        // Arrange
        AxeImpl axeImpl = new AxeImpl(AXE_ATTACK,AXE_DURABILITY);
        // Act
        axeImpl.attack(dummy);
        // Assert
        Assert.assertEquals(EXPECTED_DURABILITY, axeImpl.getDurabilityPoints());
    }
    @Test(expected = IllegalStateException.class)
    public void shouldTrowIllegalStateExceptionOnAttackWithBrokenWeapon(){
        AxeImpl axeImpl = new AxeImpl(AXE_ATTACK,-1);
        axeImpl.attack(dummy);
    }
}
