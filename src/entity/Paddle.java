package entity;

import java.awt.*;


public class Paddle extends Abstract2DDrawing {
    //The state of the mouse/Paddle
    public int Mouse_X;
    public int Mouse_Y;

    public int width;
    public int height;

    public Paddle() {
        //Board property Settings (mouse coordinates)
        Mouse_X = 0;
        Mouse_Y = 680;
        width = 200;
        height = 20;
    }

    public void paddleMove(int Mouse_X) {
        this.Mouse_X = Mouse_X - 45;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fill3DRect(Mouse_X, Mouse_Y, width, height, true);
    }
}
