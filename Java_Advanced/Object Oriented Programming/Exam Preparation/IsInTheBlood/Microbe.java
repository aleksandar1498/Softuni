package IsInTheBlood;

public abstract class Microbe extends Cell {
    private int virulence  ;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence  ) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public void setVirulence(int virulence) {
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }
}
