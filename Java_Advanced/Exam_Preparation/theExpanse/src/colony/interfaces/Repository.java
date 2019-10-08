package colony.interfaces;

import java.util.List;

public interface Repository<T> {
    T find(String id);
    int count();
}
