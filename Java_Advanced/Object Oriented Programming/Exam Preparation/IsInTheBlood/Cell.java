package IsInTheBlood;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
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
    public abstract int getEnergy();
    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]%n",this.getId(),this.getPositionRow(),this.getPositionCol());
    }
}
