package com.zacisrael;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("potatoes", 1.08, 43);
        stockList.addStock(temp);



        temp = new StockItem("turkey slab containers", 3.17, 53);
        stockList.addStock(temp);

        temp = new StockItem("chicken tender basket", 6.00, 15);
        stockList.addStock(temp);

        temp = new StockItem("cereal", 3.91, 37);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50,200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45,7);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.07, 71);
        stockList.addStock(temp);

        temp = new StockItem("ketchup", 4.02, 27);
        stockList.addStock(temp);


      //  System.out.println(stockList);


//        for(String s: stockList.Items().keySet()){
//            System.out.println(s);
//        }

        Basket zacsBasket = new Basket("Zac");
        sellItem(zacsBasket, "juice", 70);
        System.out.println(zacsBasket);

        sellItem(zacsBasket, "ketchup", 2);
        System.out.println(zacsBasket);

        sellItem(zacsBasket, "bread", 55);
        System.out.println(zacsBasket);

        sellItem(zacsBasket, "cup", 10);
        System.out.println(zacsBasket);

        removeItem(zacsBasket, "juice", 69);
        removeItem(zacsBasket, "bread", 54);
        removeItem(zacsBasket, "ketchup", 1);
        removeItem(zacsBasket, "cup", 9);

        System.out.println(zacsBasket);
        System.out.println(stockList);

//        Basket basket = new Basket("customer");
//        sellItem(basket, "ketchup", 15);
//        sellItem(basket, "cereal", 24);
//        sellItem(basket, "potatoes", 10);
//        System.out.println(basket);



//        removeItem(basket,"ketchup", 11 );
//        System.out.println(basket);




      //  System.out.println(stockList);

//        stockList.get("cup").adjustQuantityStock(2000);
//        stockList.get("cup").adjustQuantityStock(-1000);
//        System.out.println(stockList);
//        // The collections itself is unmodifiable, not the objects within in the collection
//
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()){
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }




    }
    public static int sellItem(Basket basket, String item, int quantity){
        // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);

        if(stockItem == null){
            System.out.println("We do not sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0){
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);

        if(stockItem == null){
            System.out.println("We do not sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreserveStock(item,quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem, Integer> item: basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
