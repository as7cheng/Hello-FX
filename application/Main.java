//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: HelloFX.java
// Files: HelloFX.java
// Course: Comp Sci 400, section 002
//
// Author: Shihan Cheng
// Email: scheng93@wisc.edu
// Lecturer's Name: Debra Deppeler
// Description: A sinmple version of JavaFX with running a small application
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

package application;

import java.util.EventListener;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main class to run the application
 *
 * @author Debra Deppeler
 */
public class Main extends Application {
  // store any command-line arguments that were entered.
  // NOTE: this.getParameters().getRaw() will get these also
  private List<String> args;

  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;
  private static final String APP_TITLE = "CS400 P6";

  /**
   * Class to set the stage
   */
  @Override
  public void start(Stage stage) throws Exception {
    // save args example
    args = this.getParameters().getRaw();

    // Create a vertical box
    VBox vbox = new VBox();

    // Main layout is Border Pane example (top,left,center,right,bottom)
    BorderPane borderPane = new BorderPane();

    // Set the top of the border pane
    borderPane.setTop(new Label("CS400 MyFirstJavaFX"));

    // Set the left of the border pane with a combo box
    ComboBox<String> combo = new ComboBox<String>();
    combo.getItems().addAll("Radio Head", "Pink Floyd", "Sonic Youth",
        "Nirvana", "Spiritualized");
    combo.setPromptText("select a band");
    borderPane.setLeft(combo);

    // Set the center of the border pane with a picture
    ImageView view = new ImageView("charm.png");
    borderPane.setCenter(view);

    // Set the bottom with a button
    Button bottom = new Button("Done");
    borderPane.setBottom(bottom);

    // Set the right of the pane with a clickable butoon
    Button clickButton = new Button("know me?");
    MyHandler handler = new MyHandler(clickButton);
    clickButton.setOnAction(handler);
    borderPane.setRight(clickButton);

    // Set the scene
    Scene mainScene = new Scene(borderPane, WINDOW_WIDTH, WINDOW_HEIGHT);

    // Add the stuff and set the primary stage
    stage.setTitle(APP_TITLE);
    stage.setScene(mainScene);
    stage.show();
  }

  /**
   * A functional interface to create a event handler of a button
   *
   * @param <T> A event
   */
  @FunctionalInterface
  public interface EventHandler<T extends Event> extends EventListener {
    public void handler(T event); // The only one abstact method
  }

  /**
   * Inner Class to implements the functional interface eventHandler
   * 
   * @author shihan
   *
   */
  class MyHandler implements javafx.event.EventHandler<ActionEvent> {
    // The only field is a button
    Button button;

    /**
     * Construct
     * 
     * @param button
     */
    MyHandler(Button button) {
      this.button = button;
    }

    /**
     * Action of the handler
     */
    @Override
    public void handle(ActionEvent arg0) {
      if (button.getText().equals("know me?"))
        button.setText("Yes kindof!");
      else
        button.setText("know me?");
    }
  }



  /**
   * @param args
   */
  public static void main(String[] args) {
    launch(args);
  }
}
