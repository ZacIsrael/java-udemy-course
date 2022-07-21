package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
   // The controller is the part of the application that handles user input
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        // Will not allow the buttons to be pressed if nothing has been typed into the nameField
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e){
      if(e.getSource().equals(helloButton)){
          System.out.println("Hello, " + nameField.getText());
      } else if(e.getSource().equals(byeButton)){
          System.out.printf("Bye, " + nameField.getText());
      }

      Runnable task = new Runnable() {
          // runs this in a background thread so the user will not see this/ the loading signal
          @Override
          public void run() {
              try{
                  String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                  System.out.println("I'm going to sleep on the " + s);
                  Thread.sleep(1000); // puts the UI to sleep for 1 second ( makes it load )
                  Platform.runLater(new Runnable() {
                      // The label on the UI thread will be updated later
                      @Override
                      public void run() {
                          String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                          System.out.println("I'm updating the label on the: " + s);

                          ourLabel.setText("We did something");
                      }
                  });

                  // will show this text after the 10 seconds
              } catch (InterruptedException event){
                  // we do not care about this
              }
          }
      };

      new Thread(task).start();

      if(ourCheckBox.isSelected()){
          // If the checkBox has been selected & either button has already been, clicked &
          // the code has been executed , clear the nameField and do not allow the buttons
          // to be pclicked until something has been typed in the nameField again.

          nameField.clear();
          helloButton.setDisable(true);
          byeButton.setDisable(true);
      }
    }
    @FXML
    public void handleKeyReleased(){ // checks every time a user types a character into the field
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty(); // .trim() ignores any white spacs
        // returns whether or not the the text box is empty (true or false)
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);

    }

    public void handleChange(){
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }

}
