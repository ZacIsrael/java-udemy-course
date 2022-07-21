package com.zacisrael;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // This List was empty, so this item will become the head of the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                // if the newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // There is no next item, so insert Item at the end of the list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // If the newItem is less, move to the left if possible
                if (currentItem.previous() != null) {
                    // if the current item is not equal to null, then
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                    // set the nextItem to the previous of the current Item
                } else {
                    newItem.setNext(this.root).setPrevious(newItem);
                    // we are setting the root to point to the previous newItem
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                if(currentItem == this.root){
                    this.root = currentItem.next();
                } else{
                    currentItem.previous().setNext(currentItem.next());
                    // Looking at the previous item and setting that to point to the currentItem's next

                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if(comparison < 0){
                currentItem = currentItem.next();
                // set the currentItem to the next item on the list
            } else{ // comparison >0
                //The item is not in the list
                return false;
            }
        }
        // We have reached the end of the list
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next(); // proceeds to the next entry
            }
        }
    }
}
