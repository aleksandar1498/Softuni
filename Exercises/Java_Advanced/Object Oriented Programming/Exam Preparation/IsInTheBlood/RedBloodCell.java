package IsInTheBlood;

public class RedBloodCell extends BloodCell {
    private int velocity ;

    public RedBloodCell(String id, int health, int positinRow, int positionCol, int velocity) {
        super(id, health, positinRow, positionCol);
        this.velocity = velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getVelocity() {
        return this.velocity;
    }
    @Override
    public int getEnergy(){
        return (this.getVelocity()+super.getHealth());
    }
    @Override
    public String toString() {
        return String.format("%s%n--------Health %d | Velocity %d | Energy %d",super.toString(),super.getHealth(),this.getVelocity(),this.getEnergy());
    }
}

