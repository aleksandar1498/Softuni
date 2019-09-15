package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    public Biologist(String name) {
        super(name, 70);
    }

    @Override
    public void breath() {

        if(this.getOxygen()-5 <= 0) {
            this.setOxygen(0);
            this.setCanBreath(false);
        }
    }
}
