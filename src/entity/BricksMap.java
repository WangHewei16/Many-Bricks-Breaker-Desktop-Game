package entity;

import java.awt.*;

public class BricksMap extends Abstract2DDrawing {

    //Brick class array
    public Brick[] bricks;
    public final int wide = 90;
    public final int high = 25;

    public BricksMap() {
        //Create a new BricksMap and set the location size
        bricks = new Brick[136];
        for (int j = 0, i = 0; j < 17; j++) {
            for (int k = 0; k < 8; k++) {
                Color BrickColor = new Color(0, 0, 0);
                if (k == 0) {
                	BrickColor = new Color(241, 36, 31);
                }
                if (k == 1) {
                	BrickColor = new Color(255, 128, 128);
                }
                if (k == 2) {
                	BrickColor = new Color(255, 0, 255);
                }
                if (k == 3) {
                	BrickColor = new Color(255, 128, 255);
                }
                if (k == 4) {
                	BrickColor = new Color(0, 255, 0);
                }
                if (k == 5) {
                	BrickColor = new Color(128, 255, 128);
                }
                if (k == 6) {
                	BrickColor = new Color(0, 255, 255);
                }
                if (k == 7) {
                	BrickColor = new Color(162, 255, 255);
                }
                bricks[i] = new Brick(true, BrickColor, j * 90, k * 25);
                i++;
            }
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < bricks.length; i++) {
            if (bricks[i].isOk()) {
                g.setColor(bricks[i].getColor());
                g.fill3DRect(bricks[i].getX(), bricks[i].getY(), wide, high, true);
            }
        }
    }
}
