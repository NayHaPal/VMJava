package Inventory;

import java.util.ArrayList;

public class ItemsInventory {
    public static int itemCount = 0;
    private int rows;
    private int cols;

    ArrayList<ArrayList<Aisle>> inventory; 
    public ItemsInventory(int rows, int cols, int depth){
        this.rows = rows;
        this.cols = cols;
        inventory = new ArrayList<ArrayList<Aisle>>();
        for(int r = 0; r < rows; r++){
            if(r >= inventory.size()){
                inventory.add(new ArrayList<Aisle>());
            }
            for(int c = 0; c < cols; c++){
                inventory.get(r).add(new Aisle(depth));
            }
        }
    }

    public void addItemAtPosition(int row, int column, String name, String barcode, Double price){
        inventory.get(row).get(column).addItem(new Item(name, barcode, price));
    }

    public Item removeIteAtPosition(int row, int column){
        return inventory.get(row).get(column).removeItem();
    }

    public Item getItem(int row, int column){
        return inventory.get(row).get(column).getItem();
    }

    public boolean isValidSelection(String selection){
        if(selection.length() > 3) return false;
        if(Character.getNumericValue(selection.charAt(0)) >= rows || Character.getNumericValue(selection.charAt(1)) >= this.cols) return false;
        return true;
    }


}
