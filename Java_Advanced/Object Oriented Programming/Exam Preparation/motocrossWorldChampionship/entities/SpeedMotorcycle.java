package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class SpeedMotorcycle extends MotorcycleImpl {
    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, 125);
        this.setHorsePower(horsePower);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if(horsePower < 50 || horsePower > 69){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }

    }
}
