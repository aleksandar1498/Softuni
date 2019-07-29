package trafficLight;

public class TrafficLight {
    Light light;

    public TrafficLight(Light light) {
        this.light = light;
    }
    public void changeLight(){
        switch (light){
            case GREEN:
                this.light=Light.YELLOW;
                break;
            case YELLOW:
                this.light=Light.RED;
                break;
            case RED:
                this.light=Light.GREEN;
                break;
        }
    }

    @Override
    public String toString() {
        return light+"";
    }
}
