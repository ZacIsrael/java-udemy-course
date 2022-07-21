package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import java.awt.*;

public class Controller {

    @FXML
    private Button clickMeButton;

    // Lambda expression
    public void initialize(){
        // when the button is clicked, the code after the "->" will be executed
        clickMeButton.setOnAction(event -> System.out.println("You clicked me"));
    }

    // Long way
//    public void initialize(){
//        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // once the button is clicked, this block of code will be executed
//                System.out.println("You clicked me.");
//            }
//        });
//    }
}


