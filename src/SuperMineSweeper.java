/**
 * Created by franck on 6/2/16.
 */

import javafx.application.Application;
import javafx.stage.*;
import view.MenuFrame;

public class SuperMineSweeper extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        MenuFrame mf = new MenuFrame(600, 600, "SuperMineSweeper Deluxe Ultimate Edition v2.15.1.45");
        mf.display(stage);

        //test
    }
}
