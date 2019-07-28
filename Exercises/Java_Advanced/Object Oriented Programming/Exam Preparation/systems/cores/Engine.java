package cores;

import interfaces.Hardware;
import models.hardware.HeavyHardware;
import models.hardware.PowerHardware;
import models.software.ExpressSoftware;
import models.software.LightSoftware;

import java.util.Scanner;

public class Engine implements Runnable {
    @Override
    public void run() {
        //RegisterPowerHardware(HDD, 200, 200)
        //RegisterHeavyHardware(SSD, 400, 400)
        Hardware power = new PowerHardware("HDD",200,200);
        Hardware heavy = new HeavyHardware("SSD",400,400);
        power.register(new LightSoftware("Test",0,10));
        power.register(new ExpressSoftware("Test2",100,100));
        power.register(new ExpressSoftware("Test3",50,100));

        heavy.register(new LightSoftware("Windows",20,50));
        heavy.register(new ExpressSoftware("Linux",50,100));
        heavy.register(new LightSoftware("Unix",20,50));
    }
}
