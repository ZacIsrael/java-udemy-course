package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
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

                return employees;
            }
        };
    }
}
