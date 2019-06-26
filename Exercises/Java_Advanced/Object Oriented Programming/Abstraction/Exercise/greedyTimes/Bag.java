package greedyTimes;

import java.util.*;
import java.util.function.Function;


public class Bag {
    private long capacity;
    private List<Item> cash;
    private long totCash;
    private List<Item> gem;
    private long totGem;
    private List<Item> gold;
    private long totGold;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.totCash = 0L;
        this.totGem = 0L;
        this.totGold = 0L;
        this.cash = new ArrayList<>();
        this.gold = new ArrayList<>();
        this.gem = new ArrayList<>();
    }


    public void addCash(Item item) {
        if (spaceIsNotEnough(item) || this.totGem < this.totCash + item.getQuantity()) {
            return;
        }
        totCash += item.getQuantity();
        if (this.cash.contains(item)) {
            int indexOfItem = this.cash.indexOf(item);
            Item item1 = this.cash.get(indexOfItem);
            this.cash.get(indexOfItem).setQuantity(item1.getQuantity() + item.getQuantity());
        } else {
            this.cash.add(item);
        }


    }

    public void addGem(Item item) {

        if (this.spaceIsNotEnough(item) || this.totGold < this.totGem+item.getQuantity()) {
            return;
        }
        this.totGem += item.getQuantity();
        if (this.gem.contains(item)) {
            int indexOfItem = this.gem.indexOf(item);
            Item item1 = this.gem.get(indexOfItem);
            this.gem.get(indexOfItem).setQuantity(item1.getQuantity()+item.getQuantity());
        } else {
            this.gem.add(item);
        }

    }

    public void addGold(Item item) {
        if (spaceIsNotEnough(item)) {
            return;
        }

        this.totGold += item.getQuantity();
        if (this.gold.contains(item)) {
            int indexOfItem = this.gold.indexOf(item);
            Item item1 = this.gold.get(indexOfItem);
            this.gold.get(indexOfItem).setQuantity(item1.getQuantity() + item.getQuantity());
        } else {
            this.gold.add(item);
        }

    }

    private boolean spaceIsNotEnough(Item item) {
        long currentCapacity = this.totGem + this.totGold + this.totCash;
        if (item.getQuantity() + currentCapacity > this.capacity) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Function<List<Item>,String> listStringFunction=(l) -> {
            StringBuilder builder = new StringBuilder();
            l.stream().sorted((c1, c2) -> {
                int sort = c2.getName().compareTo(c1.getName());
                if (sort == 0) {
                    sort = Long.compare(c1.getQuantity(), c2.getQuantity());
                }
                return sort;
            }).forEach(c -> builder.append(String.format("##%s - %d", c.getName(), c.getQuantity())).append(System.lineSeparator()));
            return builder.toString();
        };
        StringBuilder builder = new StringBuilder();
        if (this.gold.size() > 0) {

            builder.append(String.format("<Gold> $%d", this.totGold)).append(System.lineSeparator());

            builder.append(listStringFunction.apply(this.gold));
        }
        if (this.gem.size() > 0) {

            builder.append(String.format("<Gem> $%d", totGem)).append(System.lineSeparator());

            builder.append(listStringFunction.apply(this.gem));

        }
        if (this.cash.size() > 0) {

            builder.append(String.format("<Cash> $%d", totCash)).append(System.lineSeparator());

            builder.append(listStringFunction.apply(this.cash));
        }

        return builder.toString();
    }

}
