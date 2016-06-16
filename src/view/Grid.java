
package view;

import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.CellModel;
import model.GameModel;
import model.GridModel;
import model.Timer;


public final class Grid extends GridPane {


    public Grid(int r, int c, int n, Dimension2D d, GameModel gm) {
        super();
        build(r, c, n, d, gm);
    }

    public void build(int r, int c, int n, Dimension2D d, GameModel gm)
    {

        GridPane pan = new GridPane ();
        GridModel gridmodel = new GridModel(r, c, n, gm);
        gm.setGridModel(gridmodel);
        gm.setNbFlagsRemaining(gridmodel.getNbMines());
        Timer timer = new Timer(gm);
        gm.setTimer(timer);

        for(int i = 0; i<r;i++){
            for(int j = 0; j<c; j++){
                Cell cell = new Cell("", i, j, this );
                CellModel m = new CellModel(gridmodel, gm);

                gridmodel.addCell(m, i, j);

                pan.getChildren().add(cell);
                m.addObserver(cell);

                cell.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent me){
                        if(me.getButton()== MouseButton.SECONDARY){
                            m.toggleFlag();
                        }
                        //if(me.getButton()==MouseEvent.){
                        else{
                            m.discover();
                        }
                    }
                });

            }

        }
        getChildren().add(pan);
        gridmodel.setMines();
        gridmodel.findMines();
        timer.start();
    }

}

