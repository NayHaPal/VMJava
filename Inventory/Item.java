package Inventory;

public class Item {
    private String name, barcode;
    Double price;

    public Item (String name, String barcode, Double price){
        this.name = name;
        this.price = price;
        this.barcode = barcode; 
    }

    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return barcode;

    }


}
