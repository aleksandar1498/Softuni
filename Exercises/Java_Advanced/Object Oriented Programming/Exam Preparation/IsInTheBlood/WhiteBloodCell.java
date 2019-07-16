package IsInTheBlood;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEnergy(){
        return (this.getSize()+super.getHealth())*2;
    }
    @Override
    public String toString() {
        return String.format("%s%n--------Health %d | Size %d | Energy %d",super.toString(),this.getHealth(),this.getSize(),this.getEnergy());
    }
}
