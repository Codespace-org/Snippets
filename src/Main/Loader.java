package Main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Author:              Aaron Knight
 * Date:                Aug 30 2015
 * Date Last Modified:  September 03 2015
 * Application Name:    Snippets
 *
 * Description:         The loader will create the mainStage for the
 *                      the application.
 * Version:             0.1
 *******************************************************************/
public class Loader extends Application{
    /*******************************************************************
     * pre:     empty javafx stage
     * post:    Main window displayed to the user
     * @param mainStage - JavaFX default stage
     *******************************************************************/

    @Override
    public void start(Stage mainStage){

        BorderPane newMain = MainWindow.displayMainWindow();       // Return pane displayMainWindow() in newMain pane
        Scene scene = new Scene(newMain,300,200);                  // Set newMain inside scene container
        mainStage.setTitle("Snippets");                            // Title for application
        mainStage.setScene(scene);                                 // Set the main scene for the application
        mainStage.setResizable(false);
        mainStage.show();                                          // Show containers within mainStage
    }

    //Launch the program
    //This line is only required by certain IDE's

    public static void main(String[] args){
        Application.launch(args);
    }
}
