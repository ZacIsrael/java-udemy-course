package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {

    /* This is a simple application, so we want to use data binding.

        In Java, data binding is the connection between class and method,
        or class and field.
        Java handles binding either statically or dynamically.
        Static binding is done at compile time. This is for methods that can't be
        overridden, such as static or final methods. Dynamic binding is done
         at run-time.
       */

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;

    public Artist() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
