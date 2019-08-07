package ferrari;

public class Ferrari implements Car {
    private final static String DEFAULT_FERRARI_MODEL="488-Spider";
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.model=DEFAULT_FERRARI_MODEL;
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model,this.brakes(),this.gas(),this.driverName);
    }
}
