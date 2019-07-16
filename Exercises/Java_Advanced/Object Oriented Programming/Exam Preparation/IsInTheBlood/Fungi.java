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
        return String.format("%s--------Health %d | Virulence %d | Energy %d",super.toString(),super.getHealth(),this.getVirulence(),this.getEnergy());
    }
}
