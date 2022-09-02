package entity;

import java.awt.*;


public class Laser extends Abstract2DDrawing {

    public int laserX;
    public int laserY;

    public int width;
    public int height;

    public boolean ok;

    public Laser() {
        ok = false;
        width = 20;
        height = 100;
    }

    @Override
    public void draw(Graphics g) {
        if (ok) {
            g.setColor(Color.PINK);
            g.fill3DRect(laserX, laserY, width, height, true);
        }
    }
}
