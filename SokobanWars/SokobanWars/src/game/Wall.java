package game;

import gui.ImageMatrixGUI;
import utils.Point2D;
import utils.Vector2D;
import utils.Direction;

public class Wall extends StaticObject {

    public Wall(Point2D initialPosition) {

        super(initialPosition, "Wall", 2);

    }

}
