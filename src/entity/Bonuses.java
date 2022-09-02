package entity;

import java.awt.*;


public class Bonuses extends Abstract2DDrawing {

    // The state of the bonuses
    public int bonusesX;
    public int bonusesY;
    public Constant bonusesCategory;  // 1-Multi-ball, 2-widely-paddle, 3-sticky-paddle, 4-laser
    public double bonusesYV;


    private boolean ok;

    private boolean multiBallOk;
    private boolean widePaddleOk;
    private boolean stickyPaddleOk;
    private boolean laserOk;

    public Long effectiveTime;

    public boolean isWidePaddleOk() {
        return widePaddleOk;
    }

    public void setWidePaddleOk(boolean widePaddleOk) {
        this.widePaddleOk = widePaddleOk;
    }

    public boolean isStickyPaddleOk() {
        return stickyPaddleOk;
    }

    public void setStickyPaddleOk(boolean stickyPaddleOk) {
        this.stickyPaddleOk = stickyPaddleOk;
    }

    public boolean isLaserOk() {
        return laserOk;
    }

    public void setLaserOk(boolean laserOk) {
        this.laserOk = laserOk;
    }

    public boolean isMultiBallOk() {
        return multiBallOk;
    }

    public void setMultiBallOk(boolean multiBallOk) {
        this.multiBallOk = multiBallOk;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Bonuses() {
        ok = false;
        bonusesYV = 3;
        multiBallOk = false;
        widePaddleOk = false;
        stickyPaddleOk = false;
        laserOk = false;
        effectiveTime = System.currentTimeMillis();
    }

    public void setBonuses(int x, int y, Constant state) {
        bonusesX = x;
        bonusesY = y;
        ok = true;
        bonusesCategory = state;
    }

    public void move() {
        if (ok) {
            bonusesY += bonusesYV;
            if (bonusesY > 800) {
                ok = false;
            }
        }
    }
    @Override
    public void draw(Graphics g) {
        if (ok) {
            switch (bonusesCategory) {
                case MULTI_BALL:
                    g.setColor(Color.CYAN);
                    break;
                case WIDE_PADDLE:
                    g.setColor(Color.MAGENTA);
                    break;
                case STICKY_PADDLE:
                    g.setColor(Color.ORANGE);
                    break;
                case LASER:
                    g.setColor(Color.red);
                    break;
                default:
                    g.setColor(Color.white);
                    break;
            }
            g.fillOval(bonusesX, bonusesY, 20, 20);
        }
    }
}
