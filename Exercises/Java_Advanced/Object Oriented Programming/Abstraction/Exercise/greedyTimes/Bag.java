package greedyTimes;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class Bag implements Iterable<Map.Entry<String, LinkedList<Item>>>{
    private Map<String, LinkedList<Item>> items;
    private long capacity;
    public Bag(long capacity) {
        this.capacity=capacity;
        items = new LinkedHashMap<>();
        items.put("Gem",new LinkedList<>());
        items.put("Gold",new LinkedList<>());
        items.put("Cash",new LinkedList<>());
    }
    public void add(String typeItem,Item item){
        if(item.getQuantity() > this.capacity){
            return;
        }
        switch (typeItem){
            case "Gem":
                if (cannotBeAdded(item, "Gold", "Gem")) return;
                break;
            case "Cash":
                if(cannotBeAdded(item,"Gem","Cash")){ return; }
                break;
        }
        if(!items.get(typeItem).contains(item)){
            items.get(typeItem).add(item);
        }else{
            int indexOfCurrent = items.get(typeItem).indexOf(item);
            Item current = items.get(typeItem).get(indexOfCurrent);
            items.get(typeItem).get(indexOfCurrent).setQuantity(current.getQuantity()+item.getQuantity());
        }

    }

    private boolean cannotBeAdded(Item item, String itemA, String itemB) {
        if (items.containsKey(itemA)) {
            long itemAQuantity = items.get(itemA).stream().mapToLong(Item::getQuantity).sum();
            long itemBQuantity = (items.containsKey(itemB)) ? items.get(itemB).stream().mapToLong(Item::getQuantity).sum() : item.getQuantity();
            if (itemAQuantity > itemBQuantity) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }


    @Override
    public Iterator<Map.Entry<String, LinkedList<Item>>> iterator() {
        return this.items.entrySet().stream().filter(x -> x.getValue().size() > 0).iterator();
    }


}
