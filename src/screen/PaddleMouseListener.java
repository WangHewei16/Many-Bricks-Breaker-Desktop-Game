package screen;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import entity.Brick;

//use Mouse to control the state of game such as double click the screen to launch the ball
public class PaddleMouseListener implements MouseInputListener {
    private Picture pic;

    public PaddleMouseListener(Picture p) {
        pic = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            if (pic.bonuses.isLaserOk()) {
                for (int i = 0; i < pic.bricksMap.bricks.length; i++) {
                    Brick brick = pic.bricksMap.bricks[i];
                    if (brick.isOk() && brick.getX() <= pic.laser.laserX && pic.laser.laserX <= brick.getX() + pic.bricksMap.wide) {
                        pic.generateBonuses(brick);
                        pic.num--;
                        pic.mark += 2;
                        brick.setOk(false);
                    }
                }
                pic.laser.ok = false;
                pic.bonuses.setLaserOk(false);
            }
        }
        if (e.getClickCount() == 2) {
            pic.isStart = true;
            pic.isSticky = false;
            pic.bonuses.setStickyPaddleOk(false);
            pic.isFail = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {


    }

    public void mouseMoved(MouseEvent e) {
        pic.movePaddle(e.getX());
    }
}
