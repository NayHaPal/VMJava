package Inventory;

import java.util.Deque;
import java.util.LinkedList;

public class Aisle {
    Deque<Item> aisle;
    private int aisleSize = 0;
    private int maxSize = 0;
    public Aisle(int depth){
        this.aisle = new LinkedList<Item>();
        this.maxSize = depth;
    }
    
    public boolean addItem(Item item){
        if(aisleSize == maxSize) return false;
        aisle.add(item);
        aisleSize++;
        return true;
    }

    public Item removeItem(){
        if(aisleSize == 0) return null;
        Item currItem = aisle.removeFirst();
        aisleSize--;
        return currItem;
    }

    public Item getItem(){
        if(aisleSize == 0) return null;
        Item currItem = aisle.peekFirst();
        return currItem;
    }

}
