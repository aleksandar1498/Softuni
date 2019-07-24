package rpg_tests;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.AxeImpl;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

public class DummyTest {
    private AxeImpl axeImpl;

    @Before
    public void setUp() {
        this.axeImpl = new AxeImpl(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void shouldLoseHealthOnAttack() {
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        dummy.takeAttack(AXE_ATTACK);
        assertEquals(DUMMY_HEALTH-AXE_ATTACK, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionWhenDiedTargetIsAttacked() {
        Dummy dummy = new Dummy(-DUMMY_HEALTH, DUMMY_XP);
        dummy.takeAttack(AXE_ATTACK);
    }

    @Test
    public void shouldGiveXPIfDied() {
        Dummy dummy = new Dummy(-DUMMY_HEALTH, DUMMY_XP);
        assertEquals(DUMMY_XP, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotGiveXPIfAlive() {
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        dummy.giveExperience();
    }
}
