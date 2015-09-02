package Main;


import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Author:              Aaron Knight
 * Date:                Aug 30 2015
 * Date Last Modified:  September 02 2015
 * Application Name:    Snippets

 * Description:         This class will display the mainWindow called
 *                      from the loader.
 *                      This class will also create the menu bar for the
 *                      application
 * Version:             0.1
 *******************************************************************/
public class MainWindow {

    /*******************************************************************
     * Method creates main window for application
     * Creates Menu bar for the top of the application window
     *
     * @return
     *******************************************************************/
    public static BorderPane displayMainWindow() {

        BorderPane root = new BorderPane();

        Menu file = createMenu.displayFile();                      // Return file option
        Menu language = createMenu.displayLanguage();
        // Menu help = new Menu();

        VBox topContainer = new VBox();                 // Create topContainer to hold root

        MenuBar mainMenuBar = new MenuBar();            //  Create menu bar to hold options
        mainMenuBar.getMenus().addAll(file, language);   // Add options to menu bar

        Image i = new Image("Images/Javafx_logo_color.png");
        ImageView iv = new ImageView(i);

        topContainer.getChildren().addAll(mainMenuBar,iv);    // Add menu bar to topContainer

        root.setTop(topContainer);                      // Add conatiner to root pane

        return root;                                    // return root pane to caller
    }
}
