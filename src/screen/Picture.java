package screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import entity.Ball;
import entity.Bonuses;
import entity.Brick;
import entity.BricksMap;
import entity.Constant;
import entity.Laser;
import entity.Paddle;
import menu.Score;
import menu.MainF;

public class Picture extends JComponent {
    public final BricksMap bricksMap;
    private Ball ball;
    private Ball bonusesBall;
    private Ball anotherBonusesBall;
    private Paddle paddle;
    public Bonuses bonuses;
    public Laser laser;
    public Label tf = new Label();
    public Label boLabel = new Label();
    //display in the upper screen
    public int life;
    public int num;
    public int mark;
    public int level;
    public int highestScore;
    //The game state
    public boolean isStart = false;
    public boolean isSticky = false;
    public boolean isFail = false;
    public boolean winThis = false;
    public boolean isInputName = true;
    public boolean iszanting =false;
    // the level menus that the player could choose which level they want to play
    public Picture() {
        String ageString = JOptionPane.showInputDialog(null, "1:Rainforest grid(Recommend to play first)\n2:Hill\n3:The diamond grid\n4:The entire grid\n5:Four stripes\n Enter the number of levels you want to play(1-5):");
        level = Integer.parseInt(ageString);
        if (level != 1 && level != 2 && level != 3 && level != 4 && level != 5) {
            do {
                String ageString2 = JOptionPane.showInputDialog(null, "1:Rainforest grid(Recommend to play first)\n2:Hill\n3:The diamond grid\n4:The entire grid\n5:Four stripes\n Incorrect input. Please re-enter(1-5):");
                level = Integer.parseInt(ageString2);
            } while (level != 1 && level != 2 && level != 3 && level != 4 && level != 5);
        }
        bricksMap = new BricksMap();
        ball = new Ball();
        ball.ok = true;
        bonusesBall = new Ball();
        bonusesBall.ok = false;
        anotherBonusesBall = new Ball();
        anotherBonusesBall.ok = false;
        paddle = new Paddle();
        bonuses = new Bonuses();
        laser = new Laser();
        life = 3;
        mark = 0;
        highestScore = 0;
        if (level == 1) {
            num = 68;
        } else if (level == 2) {
            num = 49;
        } else if (level == 3) {
            num = 32;
        } else if (level == 4) {
            num = 136;
        } else if (level == 5) {
            num = 68;
        }
    }

    private void checkBallCollision(Ball ball) {
        //Decision of collision between board and Ball
        if (ball.ballX > paddle.Mouse_X && ball.ballX < paddle.Mouse_X + paddle.width && ball.ballY_V > 0 && ball.ballY > paddle.Mouse_Y - paddle.height && ball.ballY < paddle.Mouse_Y + paddle.height) {
            if (bonuses.isStickyPaddleOk()) {
                isSticky = true;
            } else {
                double temp = Math.atan(Math.abs(ball.ballY_V) / Math.abs(ball.ballX_V));
                double a = temp * 180 / Math.PI;  //Radiant convert to angles
                double rtemp = 10 + Math.random() * 30 % (30 - 10 + 1);
                double r = Math.toRadians(rtemp);//number convert to angles
                if (ball.ballX_V > 0 && ball.ballX > paddle.Mouse_X && ball.ballX < paddle.Mouse_X + paddle.width * 0.23) {//d
                    ball.ballX_V = ball.ball_V * Math.cos(a + r);

                    ball.ballY_V = Math.sqrt(ball.ball_V * ball.ball_V - ball.ballX_V * ball.ballX_V);
                    if (ball.ballY_V < 1) {
                        ball.ballY_V = 1;
                    }
                    ball.ballY_V *= -1;

                } else if (ball.ballX_V < 0 && ball.ballX > paddle.Mouse_X && ball.ballX < paddle.Mouse_X + paddle.width * 0.23) {//a
                    ball.ballX_V = ball.ball_V * Math.cos(a - r);
                    ball.ballX_V *= -1;
                    ball.ballY_V = Math.sqrt(ball.ball_V * ball.ball_V - ball.ballX_V * ball.ballX_V);
                    if (ball.ballY_V < 1) {
                        ball.ballY_V = 1;
                    }
                    ball.ballY_V *= -1;

                } else if (ball.ballX_V > 0 && ball.ballX > paddle.Mouse_X + paddle.width * 0.57 && ball.ballX < paddle.Mouse_X + paddle.width) {//c
                    ball.ballX_V = ball.ball_V * Math.cos(a - r);
                    ball.ballY_V = Math.sqrt(ball.ball_V * ball.ball_V - ball.ballX_V * ball.ballX_V);
                    if (ball.ballY_V < 1) {
                        ball.ballY_V = 1;
                    }
                    ball.ballY_V *= -1;

                } else if (ball.ballX_V < 0 && ball.ballX > paddle.Mouse_X + paddle.width * 0.57 && ball.ballX < paddle.Mouse_X + paddle.width) {//f
                    ball.ballX_V = ball.ball_V * Math.cos(a + r);
                    ball.ballX_V *= -1;
                    ball.ballY_V = Math.sqrt(ball.ball_V * ball.ball_V - ball.ballX_V * ball.ballX_V);
                    if (ball.ballY_V < 1) {
                        ball.ballY_V = 1;
                    }
                    ball.ballY_V *= -1;

                } else {
                    ball.ballY_V *= -1;
                }
            }
        }

        // Bonuses and paddle collision decision
        if (bonuses.bonusesX > paddle.Mouse_X
                && bonuses.bonusesX < paddle.Mouse_X + paddle.width
                && bonuses.bonusesY > paddle.Mouse_Y - paddle.height
                && bonuses.bonusesY < paddle.Mouse_Y + paddle.height) {
            if (bonuses.isOk()) {
                switch (bonuses.bonusesCategory) {
                    case MULTI_BALL:
                        if (!bonuses.isMultiBallOk()) {
                            bonusesBall.ballX = ball.ballX;
                            bonusesBall.ballY = ball.ballY;
                            bonusesBall.ballX_V = ball.ballX_V;
                            bonusesBall.ballY_V = ball.ballY_V;
                            bonusesBall.ball_V = ball.ball_V;
                            bonusesBall.ok = true;

                            anotherBonusesBall.ballX = ball.ballX;
                            anotherBonusesBall.ballY = ball.ballY;
                            anotherBonusesBall.ballX_V = ball.ballX_V;
                            anotherBonusesBall.ballY_V = ball.ballY_V;
                            anotherBonusesBall.ball_V = ball.ball_V;
                            anotherBonusesBall.ok = true;

                            bonuses.setMultiBallOk(true);
                        }
                        break;
                    case WIDE_PADDLE:
                        if (!bonuses.isWidePaddleOk()) {
                            paddle.width += 100;
                            bonuses.effectiveTime = System.currentTimeMillis();
                            bonuses.setWidePaddleOk(true);
                        }
                        break;
                    case STICKY_PADDLE:
                        if (!bonuses.isStickyPaddleOk()) {
                            bonuses.setStickyPaddleOk(true);
                        }
                        break;
                    case LASER:
                        if (!bonuses.isLaserOk()) {
                            bonuses.setLaserOk(true);
                        }
                        break;
                }
            }
            bonuses.setOk(false);
        }

        //Brick and Ball collision decision
        int count = 0;
        for (int i = 0; i < bricksMap.bricks.length; i++) {
            if (bricksMap.bricks[i].isOk()) {
                if (ball.ballX >= bricksMap.bricks[i].getX() - 5 && ball.ballX <= bricksMap.bricks[i].getX() + bricksMap.wide + 5
                        && ((ball.ballY > bricksMap.bricks[i].getY() - 5 && ball.ballY < bricksMap.bricks[i].getY() + 5)
                        || (ball.ballY < bricksMap.bricks[i].getY() + bricksMap.high + 5 && ball.ballY > bricksMap.bricks[i].getY() + bricksMap.high - 5))) {
                    bricksMap.bricks[i].setOk(false);
                    generateBonuses(bricksMap.bricks[i]);
                    num--;
                    mark += 2;
                    count += 1;
                    ball.ballY_V *= -1;
                    if (count == 2) {
                        ball.ballY_V *= -1;
                        count = 0;
                    }
                } else if (ball.ballY >= bricksMap.bricks[i].getY() - 5 && ball.ballY <= bricksMap.bricks[i].getY() + bricksMap.high + 5
                        && ((ball.ballX < bricksMap.bricks[i].getX() + bricksMap.wide + 5 && ball.ballX > bricksMap.bricks[i].getX() + bricksMap.wide - 5)
                        || (ball.ballX < bricksMap.bricks[i].getX() + 5 && ball.ballX > bricksMap.bricks[i].getX() - 5))) {
                    bricksMap.bricks[i].setOk(false);
                    generateBonuses(bricksMap.bricks[i]);
                    num--;
                    mark += 2;
                    count += 1;
                    ball.ballX_V *= -1;
                    //ball.ballY_V *= -1;
                    if (count == 2) {
                        ball.ballX_V *= -1;
                        count = 0;
                    }
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String str = "Ball: " + life + "       Score: " + mark + "       Bricks: " + num + "       Highest Score:" + highestScore;
        tf.setText(str);

        boLabel.setText(str);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1540, 1000);
        if (bonuses.isWidePaddleOk()) {
            if (System.currentTimeMillis() > bonuses.effectiveTime + 10 * 1000L) {
                paddle.width -= 100;
                bonuses.setWidePaddleOk(false);
            }
        }
        bricksMap.draw(g);
        ball.draw(g);
        paddle.draw(g);
        bonuses.draw(g);
        laser.draw(g);
        bonusesBall.draw(g);
        anotherBonusesBall.draw(g);
        if (num <= 0  ) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Congratulations on completing this level!", 300, 300);
            g.drawString("You could back to the menu and choose to another level!", 300, 400);
            winThis = true;
            isStart = false;




            return;
        }
        if (!bonusesBall.ok && !anotherBonusesBall.ok) {
            bonuses.setMultiBallOk(false);
        }

        if (level == 1) {
            for (int j = 0; j < 18; j += 2) {
                for (int i = 8 * j; i < 8 + 8 * j; i += 2) {
                    bricksMap.bricks[i].setOk(false);
                }
            }
            for (int j = 1; j < 17; j += 2) {
                for (int i = 1 + 8 * j; i < 8 + 8 * j; i += 2) {
                    bricksMap.bricks[i].setOk(false);
                }
            }
        } else if (level == 2) {
            for (int j = 0; j < 24; j += 1) {
                bricksMap.bricks[j].setOk(false);
            }

            for (int i = 0; i <= 2; i++) {
                for (int j = 24 + i * 8; j < 31 + i * 8; j += 1) {
                    bricksMap.bricks[j].setOk(false);
                }
            }
            for (int i = 0; i <= 2; i++) {
                for (int j = 48 + i * 8; j < 54 + i * 8; j += 1) {
                    bricksMap.bricks[j].setOk(false);
                }
            }
            for (int i = 0; i <= 1; i++) {
                for (int j = 72 + i * 8; j < 77 + i * 8; j += 1) {
                    bricksMap.bricks[j].setOk(false);
                }
            }
            for (int i = 0; i <= 1; i++) {
                for (int j = 88 + i * 8; j < 92 + i * 8; j += 1) {
                    bricksMap.bricks[j].setOk(false);
                }
            }
            for (int i = 104; i <= 106; i++) {
                bricksMap.bricks[i].setOk(false);
            }
            for (int i = 112; i <= 113; i++) {
                bricksMap.bricks[i].setOk(false);
                bricksMap.bricks[120].setOk(false);
            }
        } else if (level == 3) {
            for (int i = 0; i < 43; i++) {
                bricksMap.bricks[i].setOk(false);
            }

            for (int i = 45; i < 50; i++) {
                bricksMap.bricks[i].setOk(false);
            }
            for (int i = 54; i < 57; i++) {
                bricksMap.bricks[i].setOk(false);
            }
            for (int i = 63; i < 64; i++) {
                bricksMap.bricks[i].setOk(false);
            }
            for (int i = 72; i < 73; i++) {
                bricksMap.bricks[i].setOk(false);
            }
            for (int i = 79; i < 82; i++) {
                bricksMap.bricks[i].setOk(false);
            }
            for (int i = 86; i < 91; i++) {
                bricksMap.bricks[i].setOk(false);
            }
            for (int i = 93; i < 136; i++) {
                bricksMap.bricks[i].setOk(false);
            }
        } else if (level == 4) {
        } else if (level == 5) {
            for (int j = 0; j < 17; j += 1) {
                for (int i = 8 * j; i < 8 + 8 * j; i += 2) {
                    bricksMap.bricks[i].setOk(false);
                }
            }
        }
        // launch ball again when sticky bonus happening or lose one or two life
        if ((!isStart || isSticky) && life > 0 && !winThis) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("double click the screen and begin the game", 600, 300);
            ball.ok = true;
            ball.ballX = paddle.Mouse_X + paddle.width / 2 - 10;
            ball.ballY = 660;


        }
        if (isStart) {
            bonuses.move();
            if (bonuses.isLaserOk()) {
                laser.laserX = paddle.Mouse_X + paddle.width / 2 - 10;
                laser.laserY = 660 - laser.height;
                laser.ok = true;
            }
            if (bonuses.isMultiBallOk()) {
                checkBounusesBall(bonusesBall);
                checkBounusesBall(anotherBonusesBall);
            }
        }
        if (isStart && !isSticky) {
            ball.ballMove();
            if (ball.ballX > 1520 || ball.ballX < 0) {
                ball.ballX_V *= -1;
            } else if (ball.ballY < 0) {
                //Upper and lower boundary
                ball.ballY_V *= -1;
            } else if (ball.ballY > 800) {
                //Failure to judge
                ball.ok = false;
            }
            if (!ball.ok && !bonusesBall.ok && !anotherBonusesBall.ok) {
                life -= 1;
                isStart = false;
            }

            checkBallCollision(ball);

            highestScore = Math.max(highestScore, mark);
        }
        if (life == 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over, Please Click 'back to menu'", 300, 300);

            if (isInputName) {
            	isInputName = false;

                if (MainF.recordManage.isjinru10(mark)) {


                    String input = JOptionPane.showInputDialog(null, "enter an input", "Input Dialog Demo", JOptionPane.QUESTION_MESSAGE);
                    if (!input.trim().equals("")) {
                        MainF.recordManage.record.getFenshus().add(new Score(input, mark));
                        MainF.recordManage.writeObj();

                    }
                    repaint();
                }
                repaint();  repaint();
            }

        }
    }
    //ball hit the wall
    private void checkBounusesBall(Ball bonusesBall) {
        if (bonusesBall.ok) {
            bonusesBall.ballMove();
            if (bonusesBall.ballX > 1520 || bonusesBall.ballX < 0) {
                bonusesBall.ballX_V *= -1;
            } else if (bonusesBall.ballY < 0) {
                //Upper and lower boundary
                bonusesBall.ballY_V *= -1;
            } else if (bonusesBall.ballY > 800) {
                bonusesBall.ok = false;
            }
            checkBallCollision(bonusesBall);
        }
    }
    //the rate of each bonuse, I set the each bonuse's rate is 5%
    public void generateBonuses(Brick brick) {
        if (bonuses.isOk()) {
            return;
        }
        int bonusesChance = new Random(System.currentTimeMillis()).nextInt(100);  // used to generate bonuses
        if (bonusesChance <= 5) {
            bonuses.setBonuses(brick.getX(), brick.getY(), Constant.MULTI_BALL);
        } else {
            if (bonusesChance <= 10) {
                bonuses.setBonuses(brick.getX(), brick.getY(), Constant.WIDE_PADDLE);
            } else {
                if (bonusesChance <= 15) {
                    bonuses.setBonuses(brick.getX(), brick.getY(), Constant.STICKY_PADDLE);
                } else {
                    if (bonusesChance <= 20) {
                        bonuses.setBonuses(brick.getX(), brick.getY(), Constant.LASER);
                    }
                }
            }
        }
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public BricksMap getBrick() {
        return bricksMap;
    }

    public void movePaddle(int x) {
        paddle.paddleMove(x);
    }

    public Label gettf() {
        return tf;
    }
}
