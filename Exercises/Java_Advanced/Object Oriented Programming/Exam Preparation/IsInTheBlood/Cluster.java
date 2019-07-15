import java.util.ArrayList;
import java.util.List;

public class Cluster {
    public String id;
    public int rows;
    public int cols;
    Cell [][] cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }


}
