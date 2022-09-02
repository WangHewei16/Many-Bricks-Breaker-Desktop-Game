package entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

import screen.PaddleMouseListener;
import screen.Picture;
import screen.WindowListenerImpl;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MyGame {

    public static void main(String[] args) {
        new MyGame().StartGame();
    }

    Picture pic;
    // write the highest score in the upper screen
    public void StartGame() {
        final String savePath = System.getProperty("user.dir") + "\\mark.txt";
        File file = new File(savePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        pic = new Picture();
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(savePath));
            Scanner scanner = new Scanner(inputStream);
            pic.highestScore = scanner.nextInt();
        } catch (Exception e) {
            pic.highestScore = 0;
        }

        JFrame window = new JFrame();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel caidan = new JPanel();
        JLabel zhuangtai = new JLabel("");

        JButton kaishi = new JButton("start");
        kaishi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(pic.isStart){
                    pic.iszanting = false;
                }else{
                    pic.isStart = true;
                    pic.isSticky = false;
                    pic.bonuses.setStickyPaddleOk(false);
                    pic.isFail = false;

                }

                pic.requestFocus();
            }
        });
        //pause and start
        caidan.add(kaishi);
        JButton pause = new JButton("pause");

        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pic.iszanting = true;
                pic.requestFocus();
            }
        });

        caidan.add(pause);
        JButton tomain = new JButton("back to menu");
        caidan.add(tomain);
        caidan.add(zhuangtai);
        tomain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.dispose();
            }
        });
        // add the label and color of window to the screen
        window.add(caidan, BorderLayout.SOUTH);
        Label tff = pic.gettf();
        tff.setBackground(Color.BLACK);
        tff.setForeground(Color.WHITE);
        tff.setFont(new Font("Arial", Font.BOLD, 40));
        pic.boLabel.setBackground(Color.BLACK);
        pic.boLabel.setForeground(Color.WHITE);
        pic.boLabel.setFont(new Font("Arial", Font.BOLD, 40));
        window.add(tff, BorderLayout.NORTH);

        window.add(pic);
        PaddleMouseListener pml = new PaddleMouseListener(pic);
        window.addMouseListener(pml);
        window.addMouseMotionListener(pml);
        window.addWindowListener(new WindowListenerImpl(pic, savePath));
        window.setVisible(true);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!pic.winThis) {
                    if (!pic.iszanting) {
                        pic.repaint();
                    }

                }
            }
        }).start();


    }
}
