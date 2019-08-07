package rpg_tests;

import fakes.StubTarget;
import fakes.StubWeapon;
import interfaces.Target;
import interfaces.Weapon;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import rpg_lab.AxeImpl;
import rpg_lab.Dummy;
import rpg_lab.Hero;
import utils.Constants;

import java.util.ArrayList;

import static utils.Constants.*;

import static org.junit.Assert.assertEquals;

public class HeroTests {
    @Test
    public void shouldGainExperienceIfTargetIsDied(){
        Target mockedTarget = Mockito.mock(Target.class);
        // when this method is called it always returns true
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.getHealth()).thenReturn(0);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(DUMMY_XP);
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Mockito.when(mockedWeapon.getAttackPoints()).thenReturn(10);
        Mockito.when(mockedWeapon.getDurabilityPoints()).thenReturn(0);

        Hero hero = new Hero("name",mockedWeapon,new ArrayList<>());
        hero.attack(mockedTarget);
        assertEquals("Wrong experience",DUMMY_XP,hero.getExperience());
    }
    @Test
    public void shouldReceiveWeaponIfTargetIsDied(){
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.releaseLoot()).thenReturn(new AxeImpl(AXE_ATTACK,AXE_DURABILITY));
        Mockito.when(target.isDead()).thenReturn(true);
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Mockito.when(mockedWeapon.getAttackPoints()).thenReturn(10);
        Mockito.when(mockedWeapon.getDurabilityPoints()).thenReturn(0);

        Hero hero = new Hero("name",mockedWeapon,new ArrayList<>());
        hero.attack(target);

        assertEquals(1,hero.getInventory().size());
    }
}
