package ressources;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.Cell;

/**
 * Created by franck on 6/9/16.
 */
public class Flag extends Parent {

    public Flag (){
        ImageView flag = new ImageView(new Image(Cell.class.getResourceAsStream("ressources/flag.png")));
        flag.setFitHeight(50);
        flag.setPreserveRatio(true);
        this.getChildren().add(flag);
    }

}
