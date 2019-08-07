package greedyTimes;

import java.util.Objects;

public class Item {
    String name;
    long quantity;

    public Item(String name, long value) {
        this.name = name;
        this.quantity = value;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return this.name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }
}
