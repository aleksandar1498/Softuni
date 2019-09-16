package spaceStation.models.planets;

import java.util.Collection;
import java.util.List;

public interface Planet {
    Collection<String> getItems();
    void setItems(List<String> items);
    String getName();
}
