package mood;

public class Demon extends CharacterImpl<Integer> {
    private double energy;
    public Demon(String username, int level, double energy) {
        super(username,  level);
        super.setHashedPassword((Integer) this.hashPassword(username));
        this.energy = energy;
    }

    public double getEnergy() {
        return this.energy;
    }

    @Override
    public Object hashPassword(String username) {
        return super.getUsername().length()*217;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append(String.format("%f",this.getEnergy()*super.getLevel()));
        return builder.toString();
    }
}
