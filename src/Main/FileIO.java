package Main;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Nukeboy666 on 8/31/2015.
 */
public abstract class FileIO {

    private static File saveFile = null;

    public static void run(TextArea ta, Button save, String filename){

        saveFile = new File(filename);
        openFile(ta);
        save.setVisible(true);
        save.setOnAction(e ->{
            writeFile(ta);
        });

    }

    private static void openFile(TextArea ta) {

        if(saveFile.exists()){
            try {

                Scanner s = new Scanner(saveFile);
                ta.clear();
                while (s.hasNextLine()) {
                    if(s.hasNextLine()) {
                        ta.appendText(s.nextLine() + "\n");
                    }else{
                        ta.appendText(s.next() + " ");
                    }

                }
            } catch (FileNotFoundException ex) {
                System.err.println(ex);
            }
        }


    }

    private static void writeFile(TextArea ta) {

        ObservableList<CharSequence> paragraph = ta.getParagraphs();
        Iterator<CharSequence> iter = paragraph.iterator();
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(saveFile));
            while(iter.hasNext())
            {
                CharSequence seq = iter.next();
                bf.append(seq);
                bf.newLine();
            }
            bf.flush();
            bf.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
