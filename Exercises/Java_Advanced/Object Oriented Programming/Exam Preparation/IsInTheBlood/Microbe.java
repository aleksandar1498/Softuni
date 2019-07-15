public abstract class Microbe extends Cell {
    public int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence  ) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }
}
