package ressources;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.Cell;

/**
 * Created by franck on 6/9/16.
 */
public class Bomb extends Parent {

    public Bomb (){
        ImageView bomb = new ImageView(new Image(Cell.class.getResourceAsStream("ressources/bomb.png")));
        bomb.setFitHeight(50);
        bomb.setPreserveRatio(true);
        this.getChildren().add(bomb);
    }
}
