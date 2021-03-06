package IsInTheBlood;

public class Bacteria extends Microbe {
    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }
    public int getEnergy(){
        return (this.getVirulence()+this.getHealth())/3;
    }
    @Override
    public String toString() {
        return String.format("%s--------Health %d | Virulence %d | Energy %d",super.toString(),this.getHealth(),this.getVirulence(),this.getEnergy());
    }
}
