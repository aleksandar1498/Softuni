public class RedBloodCell extends BloodCell {
    public int velocity;

    public RedBloodCell(String id, int health, int positinRow, int positionCol, int velocity) {
        super(id, health, positinRow, positionCol);
        this.velocity = velocity;
    }
}

