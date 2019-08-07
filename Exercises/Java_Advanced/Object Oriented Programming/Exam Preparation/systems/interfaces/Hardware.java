package interfaces;

import java.util.List;

public interface Hardware {
    void register(Software software);
    void remove(Software software);
    int getCount();
    int getAvailableCapacity();
    int getAvailableMemory();
    int getMaximumCapacity();
    int getMaximumMemory();
    List<Software> getSoftwares();
    String getName();
}
