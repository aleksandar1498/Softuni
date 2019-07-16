package IsInTheBlood;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }
    public int getEnergy(){
        return (this.getVirulence()+super.getHealth());
    }
    @Override
    public String toString() {
        return String.format("%s--------Health %d | Virulence %d | Energy %d",super.toString(),super.getHealth(),this.getVirulence(),this.getEnergy());
    }
}
