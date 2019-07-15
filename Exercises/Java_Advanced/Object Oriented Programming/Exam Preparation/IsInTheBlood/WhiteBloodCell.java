public class WhiteBloodCell extends BloodCell {
    public int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        // ⦁	--------Health {health} | Size {size} | Energy {energy}
        return String.format("%s%n--------Health %d | Size %d | Energy %d");
    }
}
