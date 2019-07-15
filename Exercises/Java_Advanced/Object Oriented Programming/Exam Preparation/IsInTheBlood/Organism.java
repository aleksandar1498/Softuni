import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Organism {
    public String name;
    public Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    public int getClustersSize() {
        return this.clusters.size();
    }

    public int getCellsInClusters() {
        int count = 0;
        for (Cluster x : clusters.values()) {
            {
                for (int i = 0; i < x.cells.length; i++) {
                    for (int i1 = 0; i1 < x.cells[i].length; i1++) {
                        if (x.cells[i][i1] != null) {
                            count++;
                        }
                    }
                }
            }


        }
        return count;
    }

}
