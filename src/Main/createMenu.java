package Main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

/**
 * Author:              Aaron Knight
 * Date:                Aug 30 2015
 * Date Last Modified:  September 03 2015
 * Application Name:    Snippets

 * Description:
 * Version:             0.1
 *******************************************************************/
public class createMenu {

    /*******************************************************************
     * Pre:   Empty menu bar slot
     * Post:  Completed File menu list
     * @return - Complete file menu back to the menu bar
     *******************************************************************/

    public static Menu displayFile() {

        Menu fileOption = new Menu("File");
        MenuItem newOption = new MenuItem("New");
        MenuItem openOption = new MenuItem("Open");
        MenuItem saveOption = new MenuItem("Save");
        MenuItem saveAsOption = new MenuItem("Save As...");
        MenuItem closeOption = new MenuItem("Close");
        closeOption.setOnAction(e -> System.exit(0));

        fileOption.getItems().addAll(newOption, openOption, saveOption, saveAsOption, closeOption);
        return fileOption;
    }

    /*******************************************************************
     * Pre:     Empty menu bar slot
     * Post:    Complete language menu list
     * @return - complete language menu option for the menu bar
     *******************************************************************/

    public static Menu displayLanguage() {

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
        structure.setOnAction(e -> {
            StructureLanguage sl = new StructureLanguage();
            sl.run();

        });

        javaOption.getItems().addAll(elementary, common, structure);      // Add options to java Menu
        languageOption.getItems().add(javaOption);                      // Add javOption to Language menu


        return languageOption;                                          // Return language option to menuBar
    }

    /*******************************************************************
     * Pre:     Empty menu bar slot
     * Post:    Complete help menu list
     * @return - complete help menu option for the menu bar
     *******************************************************************/

    public static Menu displayHelp() {

        Menu helpOption = new Menu("Help");

        MenuItem hOption = new MenuItem("Help");
        MenuItem aboutOption = new MenuItem("About");
        MenuItem versionOption = new MenuItem("Version");

        helpOption.getItems().addAll(hOption,aboutOption,versionOption);

        return helpOption;
    }
}
