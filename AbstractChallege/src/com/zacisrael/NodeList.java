package com.zacisrael;

import java.util.List;

public interface NodeList {
    // Methods for interface
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
