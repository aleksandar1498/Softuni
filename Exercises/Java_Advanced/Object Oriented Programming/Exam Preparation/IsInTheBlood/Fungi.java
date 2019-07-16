package IsInTheBlood;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }
    public int getEnergy(){
        return (this.getVirulence()+this.getHealth())/4;
    }
    @Override
    public String toString() {
        return String.format("%s%n--------Health %d | Virulence %d | Energy %d",super.toString(),this.getHealth(),this.getVirulence(),this.getEnergy());
    }
}
