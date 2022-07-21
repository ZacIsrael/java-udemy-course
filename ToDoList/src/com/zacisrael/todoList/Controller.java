package com.zacisrael.todoList;

// Controller handles the interaction between the user interface and the datamodel

import com.zacisrael.todoList.datamodel.ToDoData;
import com.zacisrael.todoList.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;




    public void initialize(){
//        ToDoItem item1 = new ToDoItem("Mail birthday card", "Buy a 30th birthday card for John",
//                LocalDate.of(2020, Month.APRIL,25));
//        ToDoItem item2 = new ToDoItem("Doctors's Appointment", "See Dr. McKnight at 3047 13th St N.W",
//                LocalDate.of(2019, Month.AUGUST,1));
//        ToDoItem item3 = new ToDoItem("School shopping", "Go to the mall to buy clothes for next semester",
//                LocalDate.of(2019, Month.AUGUST,17));
//        ToDoItem item4 = new ToDoItem("Dinner date", "Take Cairo out to eat for her birthday",
//                LocalDate.of(2019, Month.AUGUST,7));
//        ToDoItem item5 = new ToDoItem("20th Birthday", "Get a ticket to go to Bliss Night Club",
//                LocalDate.of(2020, Month.JUNE,29));
//
//        toDoItems = new ArrayList<ToDoItem>();
//
//        toDoItems.add(item1);
//        toDoItems.add(item2);
//        toDoItems.add(item3);
//        toDoItems.add(item4);
//        toDoItems.add(item5);
//
//        ToDoData.getInstance().setToDoItems(toDoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem toDoItem, ToDoItem newValue) {
                if(newValue != null){
                    ToDoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    // Formats the date in the String of the month, the numerical day and the numerical year
                    deadlineLabel.setText(df.format(item.getDeadLine()));
                }
            }
        });

        // eventHandlers are also known as eventListeners because an application will listen for
        // an event and when that event is raised, the associated eventHandler will run.

        todoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // Only allows us to select one option at a time
        todoListView.getSelectionModel().selectFirst();
        // Automatically selects the first option when the UI first opens
    }


    @FXML
    public void handleClickListView(){
        ToDoItem item =  todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadLine().toString());
       // System.out.println("The selected item is " + item);
//
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        // gets the details for the short description
//        sb.append("\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadLine().toString());
//        itemDetailsTextArea.setText(sb.toString());

    }



}
