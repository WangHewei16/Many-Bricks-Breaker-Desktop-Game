package entity;

import java.awt.*;

//This class is designed to design the features of the ball and design the method make ball move
public class Ball extends Abstract2DDrawing {
    //The state of the Ball
    public int ballX;
    public int ballY;
    public double ballX_V;
    public double ballY_V;
    public double ball_V;
    public boolean ok;

    public Ball() {
        ballX = 670;
        ballY = 660;
        ballX_V = 6;
        ballY_V = -8;
        ball_V = Math.abs(Math.sqrt(Math.pow(ballX_V, 2) + Math.pow(ballY_V, 2)));
    }

    public void draw(Graphics g) {
        if (ok) {
            g.setColor(Color.GREEN);
            g.fillOval(ballX, ballY, 20, 20);
        }
    }

    public void ballMove() {
        ballX += ballX_V;
        ballY += ballY_V;
    }
}
