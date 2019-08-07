package IsInTheBlood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Cell [][] cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append(String.format("----Cluster %s",this.getId()));
       List<Cell> cellList=new ArrayList<>();
        for (int i = 0; i < this.cells.length; i++) {
            for (int i1 = 0; i1 < this.cells[i].length; i1++) {
                if(this.cells[i][i1] != null){
                    cellList.add(this.cells[i][i1]);
                }
            }
        }
        cellList.stream().sorted(Comparator.comparingInt(Cell::getPositionRow).thenComparingInt(Cell::getPositionCol)).forEach(cell -> {
            builder.append(System.lineSeparator());
            builder.append(cell);
        });
        return builder.toString();
    }
}
