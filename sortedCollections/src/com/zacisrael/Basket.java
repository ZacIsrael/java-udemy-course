package com.zacisrael;

import java.util.*;

public class Basket {

    private final String  name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if((item != null) && quantity > 0){
            int inBasket = list.getOrDefault(item, 0);
            // checks to see if the item is already in the basket
            list.put(item, inBasket + quantity );
        }
            return 0;
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    public void clearBasket(){
        this.list.clear();
        // clears everything from the basket list
    }

    public int removeFromBasket(StockItem item, int quantity){
        if((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item,0);
            // checks to see if we already have the item in the basket
            int newQuantity = inBasket - quantity;

            if(newQuantity > 0){
                list.put(item, newQuantity);
                return quantity;
            } else if(newQuantity == 0){
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "\nShopping Basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item " : " items") + "\n";
        double totalCost = 0.0;

        for(Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + String.format("%.2f" ,totalCost);
    }
}
