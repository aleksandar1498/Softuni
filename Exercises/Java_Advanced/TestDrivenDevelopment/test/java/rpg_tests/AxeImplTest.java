package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.AxeImpl;
import rpg_lab.Dummy;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
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
        assertEquals(EXPECTED_DURABILITY, axeImpl.getDurabilityPoints());
    }
    @Test(expected = IllegalStateException.class)
    public void shouldTrowIllegalStateExceptionOnAttackWithBrokenWeapon(){
        AxeImpl axeImpl = new AxeImpl(AXE_ATTACK,-1);
        axeImpl.attack(dummy);
    }

}
