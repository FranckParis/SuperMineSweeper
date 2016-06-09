package view;

import java.util.Observable;
import java.util.Observer;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import model.CellModel;
import ressources.Bomb;
import ressources.Flag;

import javax.swing.*;

/**
 *
 * @author Franck
 */
public class Cell extends Parent implements Observer{
    
    public final Grid grid;
    public String label;
    private int positionX = 0;
    private int positionY = 0;

    Rectangle fond_touche;
    Text lettre_touche;

    public Cell(String l, int posX, int posY, Grid g){
        label =  new String(l);
        positionX = posX;
        positionY = posY;

        fond_touche = new Rectangle(75,75, Color.WHITE);
        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        this.getChildren().add(fond_touche);//ajout du rectangle de fond de la touche

        lettre_touche = new Text(label);
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.GREY);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche);

        this.setTranslateX(positionX);
        this.setTranslateY(positionY);

        this.grid = g;
    }
    

    @Override
    public void update(Observable o, Object arg) {
        CellModel m = (CellModel) o;
        if(m.getFlagged() && !m.getDiscovered()){
            this.fond_touche.setFill(Color.WHITE);
            Flag f = new Flag();
            this.getChildren().add(f);
        }
        
        else if (m.getDiscovered() && !m.getTrapped()){
            if(m.getNbNeighMines() != 0){
                String s = Integer.toString(m.getNbNeighMines());
                this.label = s;
            }
            this.fond_touche.setFill(Color.LIGHTGRAY);
        }
        else if (m.getDiscovered() && m.getTrapped()){
            this.fond_touche.setFill(Color.RED);
            Bomb b = new Bomb();
            this.getChildren().add(b);}
        else {
            this.fond_touche.setFill(Color.GRAY);
        }
    }

    @Override
    protected NGNode impl_createPeer() {
        return null;
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return null;
    }

    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        return false;
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return null;
    }
}
