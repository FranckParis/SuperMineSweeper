package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

    private int gameStatus; // 0:no game, 1:game started, 2:win, 3:loose

    //Constructor

    public MainFrame (int w, int h, int m, String s) {
        this.width = w;
        this.height = h;
        this.title = s;

        this.timerValue = 0;
        this.minesLeftValue = m;
        this.gameStatus = 0;

        this.grid = new Grid();
    }

    //Methods

    public BorderPane setTopBorder() {
        BorderPane border = new BorderPane();
        //border.setPrefWidth(this.width);

        HBox hboxLeft = new HBox();
        HBox hboxRight = new HBox();
        HBox hboxCenter = new HBox();

        hboxLeft.setPadding(new Insets(10, 12, 10, 12));
        hboxLeft.setSpacing(10);
        hboxLeft.setStyle("-fx-background-color: #336699;");
        hboxRight.setPadding(new Insets(10, 12, 10, 12));
        hboxRight.setSpacing(10);
        hboxRight.setStyle("-fx-background-color: #336699;");
        hboxCenter.setPadding(new Insets(2, 12, 2, 12));
        hboxCenter.setStyle("-fx-background-color: #336699;");

        Button buttonEasy = new Button("Facile");
        buttonEasy.setPrefSize(70, 20);

        Button buttonMedium = new Button("Moyen");
        buttonMedium.setPrefSize(70, 20);

        Button buttonHard = new Button("Difficile");
        buttonHard.setPrefSize(70, 20);

        Image imgSmiley;
        ImageView ivSmiley = new ImageView();
        switch(this.gameStatus){
            case 0:
                imgSmiley = new Image("/ressources/sleep.png");
                ivSmiley.setImage(imgSmiley);
                break;
            case 1:
                imgSmiley = new Image("/ressources/normal.png");
                ivSmiley.setImage(imgSmiley);
                break;
            case 2:
                imgSmiley = new Image("/ressources/win.png");
                ivSmiley.setImage(imgSmiley);
                break;
            case 3:
                imgSmiley = new Image("/ressources/loose.png");
                ivSmiley.setImage(imgSmiley);
                break;
        }
        ivSmiley.setFitWidth(45);
        ivSmiley.setPreserveRatio(true);
        ivSmiley.setSmooth(true);
        ivSmiley.setCache(true);

        TextField gridWidth = new TextField("9");
        gridWidth.setPrefSize(40, 20);

        TextField gridHeight = new TextField("9");
        gridHeight.setPrefSize(40, 20);

        TextField mines = new TextField("10");
        mines.setPrefSize(40, 20);

        Button buttonPlay = new Button("Jouer !");
        buttonPlay.setPrefSize(70, 20);

        //actions

        buttonEasy.setOnAction(e -> {
            mines.setText("10");
            gridWidth.setText("9");
            gridHeight.setText("9");
        });

        buttonMedium.setOnAction(e -> {
            mines.setText("40");
            gridWidth.setText("16");
            gridHeight.setText("16");
        });

        buttonHard.setOnAction(e -> {
            mines.setText("99");
            gridWidth.setText("30");
            gridHeight.setText("16");
        });

        buttonPlay.setOnAction(e -> {
            this.gameStatus = 1;
        });

        hboxLeft.getChildren().addAll(buttonEasy, buttonMedium, buttonHard);
        hboxRight.getChildren().addAll(gridWidth, gridHeight, mines, buttonPlay);
        hboxCenter.getChildren().addAll(ivSmiley);

        border.setLeft(hboxLeft);
        border.setRight(hboxRight);
        border.setCenter(hboxCenter);

        return border;
    }

    public GridPane setPlate(){
        GridPane plate = new GridPane();

        return plate;
    }


    public BorderPane setBottomBorder() {
        BorderPane border = new BorderPane();
        //border.setPrefWidth(this.width);

        HBox hboxLeft = new HBox();
        HBox hboxRight = new HBox();
        HBox hboxCenter = new HBox();

        hboxLeft.setPadding(new Insets(3, 0, 3, 60));
        hboxRight.setPadding(new Insets(3, 60, 3, 0));
        hboxCenter.setPadding(new Insets(0, 0, 0, 0));

        Image imgMine = new Image("/ressources/bomb.png");
        ImageView ivMine = new ImageView();
        ivMine.setImage(imgMine);
        ivMine.setFitWidth(15);
        ivMine.setPreserveRatio(true);
        ivMine.setSmooth(true);
        ivMine.setCache(true);
        Label minesLeft = new Label(" : "+this.minesLeftValue);

        Image imgTime = new Image("/ressources/timer.png");
        ImageView ivTime = new ImageView();
        ivTime.setImage(imgTime);
        ivTime.setFitWidth(15);
        ivTime.setPreserveRatio(true);
        ivTime.setSmooth(true);
        ivTime.setCache(true);
        Label time = new Label(" : "+this.timerValue);

        hboxLeft.getChildren().addAll(ivMine, minesLeft);
        hboxRight.getChildren().addAll(ivTime, time);
        hboxCenter.getChildren().addAll();

        border.setLeft(hboxLeft);
        border.setRight(hboxRight);
        border.setCenter(hboxCenter);

        return border;
    }


    public void display (Stage stage){

        stage.setTitle(this.title);
        /*stage.setWidth(this.width);
        stage.setHeight(this.height);*/

        //Root
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.GREY);


        BorderPane screen = new BorderPane();
        BorderPane topBorder = setTopBorder();
        BorderPane bottomBorder = setBottomBorder();

        GridPane plate = setPlate();

        screen.setTop(topBorder);
        if(this.gameStatus != 0) screen.setBottom(bottomBorder);
        screen.setCenter(plate);


        root.getChildren().add(screen);

        //Adding scene
        stage.setScene(scene);

        //Showing scene
        stage.show();
    }
}
