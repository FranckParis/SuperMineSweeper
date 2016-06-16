package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GameModel;

import java.util.Observable;
import java.util.Observer;

import static java.awt.SystemColor.text;

/**
 * Created by franck on 6/2/16.
 */
public class MenuFrame extends Parent implements Observer {

    //Attributes

    private int width;
    private int height;

    private int gridWidth;
    private int gridHeight;

    private String title;
    private Grid grid;
    private int timerValue;
    private int minesLeftValue;
    private GameModel gm;

    private int gameStatus; // 0:no game, 1:game started, 2:win, 3:loose

    //Constructor

    public MenuFrame(int w, int h, String s) {
        this.width = w;
        this.height = h;
        this.title = s;

        this.gridHeight = 9;
        this.gridWidth = 9;

        this.timerValue = 0;
        this.minesLeftValue = 10;
        this.gameStatus = 0;

        this.gm = new GameModel();
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

            this.gridHeight = 9;
            this.gridWidth = 9;
            this.minesLeftValue = 10;
        });

        buttonMedium.setOnAction(e -> {
            mines.setText("40");
            gridWidth.setText("16");
            gridHeight.setText("16");

            this.gridHeight = 16;
            this.gridWidth = 16;
            this.minesLeftValue = 40;
        });

        buttonHard.setOnAction(e -> {
            mines.setText("99");
            gridWidth.setText("30");
            gridHeight.setText("16");

            this.gridHeight = 16;
            this.gridWidth = 30;
            this.minesLeftValue = 99;
        });

        buttonPlay.setOnAction(e -> {
            this.gameStatus = 1;
            build();
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

        if(this.grid != null){
            root.getChildren().add(grid);
        }

        root.getChildren().add(screen);

        //Adding scene
        stage.setScene(scene);

        //Showing scene
        stage.show();
    }

    public void build() {
        System.out.println("Building Grid");
        Dimension2D d = new Dimension2D(0,0);
        this.gm.addObserver(this);
        this.grid = new Grid(this.gridHeight, this.gridWidth, this.minesLeftValue, d, gm);

        this.getChildren().add(grid);
    }


    @Override
    public void update(Observable o, Object arg) {
        GameModel gm = (GameModel) o;
        if(gm.getGameStatus() == 1){

        }
        else if(gm.getGameStatus() == 2){

        }
        if(gm.getVal()>this.timerValue+1){
            gm.setRunning(false);
        }

        this.timerValue = gm.getVal();
        this.minesLeftValue = gm.getNbFlagsRemaining();
    }
}
