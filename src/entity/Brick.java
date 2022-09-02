package entity;

import java.awt.*;


public class Brick {

    private boolean ok;
    private Color SingleBrickColour;
    private int x;
    private int y;

    public Brick() {
    }

    public Brick(boolean ok, Color SingleBrickColour, int x, int y) {
        this.ok = ok;
        this.SingleBrickColour = SingleBrickColour;
        this.x = x;
        this.y = y;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Color getColor() {
        return SingleBrickColour;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
