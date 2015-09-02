package Main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Nukeboy666 on 8/31/2015.
 */
public class CommonLanguage extends Section{

    @Override
    public  Button[] displayButtons(TextArea ta){
        final TextArea finalTa = ta;

        Button save = new Button("Save Editor");
        save.setVisible(false);

        Button loops = new Button("Loops");

        Button switchs = new Button("Switch");                     //Create new button

        Button exceptions = new Button("Exceptions");

        Button[] btnGroup = {loops,switchs,exceptions,save};           //Assign buttons to array

        for(Button allBtn : btnGroup){                                   //iterate through array and set width
            allBtn.setPrefWidth(250);                                    //and button style
            allBtn.setStyle("-fx-background-color: #000000,\n" +
                    "           linear-gradient(#7ebcea, #2f4b8f),\n" +
                    "           linear-gradient(#426ab7, #263e75),\n" +
                    "           linear-gradient(#395cab, #223768);\n" +
                    "           -fx-background-insets: 0,1,2,3;\n" +
                    "           -fx-background-radius: 3,2,2,2;\n" +
                    "           -fx-padding: 12 30 12 30;\n" +
                    "           -fx-text-fill: black;\n" +
                    "           -fx-font-size: 12px;\n" +
                    "}");
        }
        loops.setOnAction(e -> {                                         //set action
            final String dataFilename = "Loops.txt";
            FileIO.run(finalTa, save, dataFilename);                             //Call run method for dataType section
        });

        switchs.setOnAction(e -> {
            final String operatorFilename = "Switchs.txt";
            FileIO.run(finalTa, save, operatorFilename);
        });

        exceptions.setOnAction(e -> {
            final String conditionsFilename = "Exceptions.txt";
            FileIO.run(finalTa, save, conditionsFilename);
        });

        return btnGroup;
    }

    @Override
    public BorderPane displayLanguageWindow(TextArea ta){
        BorderPane languageBP = new BorderPane();                             //Create new pane

        HBox outerBox = new HBox(15);                                           //Create HBox set padding to 15
        outerBox.setPadding(new Insets(15, 15, 15, 15));

        ta.setWrapText(true);                                                   //set parameters for textarea

        ta.setPrefColumnCount(35);
        ta.setPrefRowCount(45);
        ScrollPane sp = new ScrollPane(ta);                                     //Add the textArea to the scrollpane

        outerBox.getChildren().add(sp);                                         //Add the scrollpane to the HBox

        VBox leftBox = new VBox(15);                                            //Create VBox and set padding to 15
        leftBox.setPadding(new Insets(15, 5, 5, 5));
        leftBox.getChildren().add(new Label("Common Java Programming"));    //Label the VBox and display label

        Button[] btnMenu = displayButtons(ta);                                  //Return and store buttons in Button[]


        for(int i = 0; i < btnMenu.length;i++){                                 //Add Buttons to the VBox
            leftBox.getChildren().add(btnMenu[i]);
        }


        languageBP.setLeft(leftBox);                                          //Set the left column of BP =  VBox
        languageBP.setCenter(outerBox);                                       //Set the center column of BP = VBox

        return languageBP;
    }
    /******/
    @Override
    public void run(){
        super.setTa(new TextArea());                                        //Set ta area to new
        super.getTa().setText(new CommonLanguage().toString());
        super.setLanguageStage(new Stage());                            //Create new stage
        BorderPane elementaryBP = displayLanguageWindow(super.getTa());      //Return new window pane from displayElementaryWindow
        super.getLanguageStage().setTitle("Snippets");
        super.setLanguageScene(new Scene(elementaryBP, 720, 400));         //create a new Scene
        super.getLanguageStage().setScene(super.getLanguageScene());                  //Set the scene to the stage
        super.getLanguageStage().show();
    }

    @Override
    public String toString(){
        return "Common Java Programming\n" +
                "\n" +
                "This section contains more common Java techniques";
    }
}
