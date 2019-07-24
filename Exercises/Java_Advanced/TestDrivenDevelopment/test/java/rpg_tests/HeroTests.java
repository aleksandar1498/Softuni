package rpg_tests;

import fakes.StubTarget;
import fakes.StubWeapon;
import interfaces.Target;
import interfaces.Weapon;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.Hero;
import static utils.Constants.*;

import static org.junit.Assert.assertEquals;

public class HeroTests {
    @Test
    public void shouldGainExperienceIfTargetIsDied(){
        Target target = new StubTarget();
        Weapon weapon = new StubWeapon();
        Hero hero = new Hero("name",weapon);
        hero.attack(target);
        assertEquals("Wrong experience",DUMMY_XP,hero.getExperience());
    }
}
