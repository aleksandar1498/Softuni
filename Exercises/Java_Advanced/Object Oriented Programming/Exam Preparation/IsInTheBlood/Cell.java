public abstract class Cell {
    public String id;
    public int health;
    public int positionRow;
    public int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public String getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]",this.getId(),this.getPositionRow(),this.getPositionCol());
    }
}
