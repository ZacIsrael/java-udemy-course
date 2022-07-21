package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;


public class Controller {

   // private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;

    public void initialize() {
        // used my javafx to initialize
/*
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
               String[] names = {
                       "Tim Buchalka",
                       "Bill Rogers",
                       "Jack Jill",
                       "John Andrews",
                       "Mary Johnson",
                       "Bob McDonald"
               };

                 ObservableList<String> employees = FXCollections.observableArrayList();
                for (int i = 0; i < 6; i++) {
                    employees.add(names[i]);
                    // add the current string in name to the employees observableArrayList

                    updateMessage("Added " + names[i] + " to the list.");
                    //Will display this message below the progressBar

                    updateProgress(i+1, 6);
                    // update the progressBar, on the last iteration, i = 5 so the progressBar will be full

                    Thread.sleep(200);
                    // Thread sleeps for .2 seconds
                }

                return employees; // employees will appear in the listView
            }
            // returns 6 records
        }; */

        service = new EmployeeService();
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());
      /*  service.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                progressBar.setVisible(true);
                progressLabel.setVisible(true);
            }
        });

        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                progressBar.setVisible(false);
                progressLabel.setVisible(false);
                // If the button has been pressed and the code has finished executing,
                //do not show the progressBar or progressLabel on the window
            }
        });

        progressBar.setVisible(false);
        progressLabel.setVisible(false); */

      progressBar.visibleProperty().bind(service.runningProperty());
      progressLabel.visibleProperty().bind(service.runningProperty());
    }

    @FXML
    public void buttonPressed() {

        if(service.getState() == Service.State.SUCCEEDED){
            // if the code has already executed, reset it and start it over.
            // This allows us to press the button multiple times without an error
            service.reset();
            service.start();
        } else if(service.getState() == Service.State.READY){
            service.start();
        }

    }
}
