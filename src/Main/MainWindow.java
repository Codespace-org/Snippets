package Main;


import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by Nukeboy666 on 9/1/2015.
 */
public class MainWindow {

    /*******************************************************************
     * Method creates main window for application
     * Creates Menu bar for the top of the application window
     *
     * @return
     *******************************************************************/
    public static BorderPane displayMainWindow() {

        BorderPane root = new BorderPane();

        Menu file = displayFile();                      // Return file option
        Menu language = displayLanguage();
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

    /*******************************************************************
     * Pre:   Empty menu bar slot
     * Post:  Completed File menu list
     * @return - Complete file menu back to the menu bar
     *******************************************************************/

    private static Menu displayFile() {

        Menu fileOption = new Menu("File");
        MenuItem newOption = new MenuItem("New");
        MenuItem openOption = new MenuItem("Open");
        MenuItem saveOption = new MenuItem("Save");
        MenuItem saveAsOption = new MenuItem("Save As...");
        MenuItem closeOption = new MenuItem("Close");
        closeOption.setOnAction(e->System.exit(0));

        fileOption.getItems().addAll(newOption, openOption, saveOption, saveAsOption, closeOption);
        return fileOption;
    }

    /*******************************************************************
     * Pre:     Empty menu bar slot
     * Post:    Complete language menu list
     * @return - complete language menu option for the menu bar
     *******************************************************************/

    private static Menu displayLanguage() {

        Menu languageOption = new Menu("Language");                     // Create Language option

        Menu javaOption = new Menu("Java");                             // Create Java option
        final ToggleGroup tgJavaMenu = new ToggleGroup();               // Create toggle group for java options

        RadioMenuItem elementary = new RadioMenuItem("Elementary");     // Create new Java option
        elementary.setToggleGroup(tgJavaMenu);                          // Add option to Java toggle group

        //Process selected elementary toggle
        elementary.setOnAction(e -> {
            ElementaryLanguage el = new ElementaryLanguage();
            el.run();
        });

        RadioMenuItem common = new RadioMenuItem("Common");             //
        common.setToggleGroup(tgJavaMenu);
        common.setOnAction(e -> {
            CommonLanguage cl = new CommonLanguage();
            cl.run();

        });

        RadioMenuItem structure = new RadioMenuItem("Structures");      //
        structure.setToggleGroup(tgJavaMenu);
        structure.setOnAction(e ->{
            StructureLanguage sl = new StructureLanguage();
            sl.run();

        });

        javaOption.getItems().addAll(elementary,common,structure);      // Add options to java Menu
        languageOption.getItems().add(javaOption);                      // Add javOption to Language menu
        return languageOption;                                          // Return language option to menuBar
    }
}
