package com.zacisrael;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public int getReserved() {
        return reserved;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityStock - reserved;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void adjustQuantityStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }

    }
    public int reserveStock(int quantity){

        if(quantity <= availableQuantity()){
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity){
        if(quantity <= reserved){
            reserved -= quantity;
            return reserved;
        }
        return 0;
    }


    public int finalizeStock(int quantity){
        if(quantity <= reserved){
            quantityStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
     //   System.out.println("Entering StockItem.equals");
        if (obj == this) {
            return true;
            // x.equals(obj);
            // if object x  is equal to obj, return true
            // this means that x and obj are identical
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
            //x.equals(obj);
            // if obj is equal to nothing or the obj's class
            // is different from object x's class, return false.
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
        // x.equals(obj);
        // tests to see if the name of object x is equal
        // to the name of object obj
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 9;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if (this == o) {
            return 0;
            // The two objects are equals
        }
        if (o != null) {
            return this.name.compareTo(o.getName());
            // Compares the names of the two objects
        }

        throw new NullPointerException();

    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price + ". Reserved: " + this.reserved;

    }
}
