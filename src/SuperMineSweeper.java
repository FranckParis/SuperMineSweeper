/**
 * Created by franck on 6/2/16.
 */

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import view.MainFrame;

public class SuperMineSweeper extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainFrame mf = new MainFrame(600, 600, 40, "SuperMineSweeper Deluxe Ultimate Edition v2.15.1.45");
        mf.display(stage);
    }
}
