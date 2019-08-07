package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.AxeImpl;
import rpg_lab.Dummy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    @Test
    public void shouldReleaseWeaponIfDead(){
        Target dummy = new Dummy(-DUMMY_HEALTH,DUMMY_XP);
        dummy.getWeapons().add(new AxeImpl(AXE_ATTACK,AXE_DURABILITY));
        dummy.getWeapons().add(new AxeImpl(AXE_ATTACK,AXE_DURABILITY));
        dummy.releaseLoot();
        assertEquals(1 ,dummy.getWeapons().size());
    }
}
