package IsInTheBlood;

import java.util.*;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    public String getName() {
        return name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public int getClustersSize() {
        return this.clusters.size();
    }

    public int getCellsInClusters() {
        int count = 0;
        for (Cluster x : this.getClusters()) {
            {
                for (int i = 0; i < x.getCells().length; i++) {
                    for (int i1 = 0; i1 < x.getCells()[i].length; i1++) {
                        if (x.getCells()[i][i1] != null) {
                            count++;
                        }
                    }
                }
            }


        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Organism - %s",this.getName()));
        builder.append(System.lineSeparator());
        builder.append(String.format("--Clusters: %d",this.getClustersSize()));
        builder.append(System.lineSeparator());
        builder.append(String.format("--Cells: %d",this.getCellsInClusters()));
        for(Cluster cluster: this.getClusters()){
            builder.append(System.lineSeparator());
            builder.append(cluster);
        }
        return builder.toString();
    }
}
