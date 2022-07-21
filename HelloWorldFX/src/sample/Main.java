package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    // The stage is the window

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10); // grid width
//        root.setHgap(10); // grid height
//
//
//        Label greeting = new Label("Welcome to JavaFX!");
//        greeting.setTextFill(Color.GREEN); // sets the color of the text to green
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));
//        root.getChildren().add(greeting);
        primaryStage.setTitle("Hello JavaFX"); // gives the window a title

        primaryStage.setScene(new Scene(root, 700, 275));
        // The scene is te graph that contains the user interface(UI) nodes

        primaryStage.show();
        // shows the user interface (UI)
    }


    public static void main(String[] args) {
        launch(args);
    }
}
