package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.awt.SystemColor.text;

/**
 * Created by franck on 6/2/16.
 */
public class MainFrame {

    //Attributes

    private int width;
    private int height;
    private String title;
    private Grid grid;

    private int timerValue;
    private int minesLeftValue;

    //Constructor

    public MainFrame (int w, int h, int m, String s) {
        this.width = w;
        this.height = h;
        this.title = s;

        this.timerValue = 0;
        this.minesLeftValue = m;

        this.grid = new Grid();
    }

    //Methods

    public void display (Stage stage){

        stage.setTitle(this.title);
        stage.setWidth(this.width);
        stage.setHeight(this.height);

        //Root
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.GREY);

        //Group
        Group frameGroup = new Group();
        frameGroup.setTranslateX(100);
        frameGroup.setTranslateY(100);

        //Text
        Text textTimer = new Text(10, 10, "Timer");
        textTimer.setFont(new Font(20));
        textTimer.setFill(Color.WHITE);

        Text textTimerValue = new Text(10, 60, Integer.toString(this.timerValue));
        textTimerValue.setFont(new Font(20));
        textTimerValue.setFill(Color.WHITE);

        Text textMinesLeft = new Text(300, 10, "Mines left");
        textMinesLeft.setFont(new Font(20));
        textMinesLeft.setFill(Color.WHITE);

        Text textMinesLeftValue = new Text(300, 60, Integer.toString(this.minesLeftValue));
        textMinesLeftValue.setFont(new Font(20));
        textMinesLeftValue.setFill(Color.WHITE);

        //Grid
        Rectangle gridPanel = new Rectangle(100, 100, 200, 200);
        gridPanel.setFill(Color.BLACK);

        //Composition
        frameGroup.getChildren().add(gridPanel);
        frameGroup.getChildren().add(textTimer);
        frameGroup.getChildren().add(textTimerValue);
        frameGroup.getChildren().add(textMinesLeft);
        frameGroup.getChildren().add(textMinesLeftValue);

        //Add to scene
        root.getChildren().add(frameGroup);

        //Adding scene
        stage.setScene(scene);

        //Showing scene
        stage.show();
    }
}
