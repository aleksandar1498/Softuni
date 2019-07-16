package IsInTheBlood;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }
    public int getEnergy(){
        return (this.getVirulence()+this.getHealth());
    }
    @Override
    public String toString() {
        // ⦁	--------Health {health} | Size {size} | Energy {energy}
        return String.format("%s%n--------Health %d | Virulence %d | Energy %d",super.toString(),this.getHealth(),this.getVirulence(),this.getEnergy());
    }
}
