package Main;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Created by Nukeboy666 on 8/31/2015.
 */
public abstract class Section {

    private static Stage languageStage = null;
    private static Scene languageScene = null;
    private static TextArea ta = null;

    public abstract void run();

    public abstract BorderPane displayLanguageWindow(TextArea ta);

    public abstract Button[] displayButtons(TextArea ta);

    public static Stage getLanguageStage() {
        return languageStage;
    }

    public static void setLanguageStage(Stage languageStage) {
        Section.languageStage = languageStage;
    }

    public static Scene getLanguageScene() {
        return languageScene;
    }

    public static void setLanguageScene(Scene languageScene) {
        Section.languageScene = languageScene;
    }

    public static TextArea getTa() {
        return ta;
    }

    public static void setTa(TextArea ta) {
        Section.ta = ta;
    }


}
