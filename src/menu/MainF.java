package menu;

import entity.MyGame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainF {

    private JFrame frame;
    public static RecordManage recordManage;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainF window = new MainF();
                    recordManage = new RecordManage();
                    recordManage.readObj();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public MainF() {
        initialize();
    }
    // the content of "get help" and initialize the menu
    private void initialize() {
    	frame = new JFrame();
        frame.setBounds(100, 100, 718, 486);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel_main.setVisible(true);

        panel_help = new JPanel();
        frame.getContentPane().add(panel_help, BorderLayout.CENTER);
        panel_help.setLayout(null);
        
        JLabel label0 = new JLabel("Welcome To the Breakout Game !!! (Author: Wang Hewei)");
        label0.setFont(new Font("Arial", Font.BOLD, 16));
        label0.setBounds(90, 10, 561, 15);
        panel_help.add(label0);
        
        JLabel label = new JLabel("1. You can move the paddle using your mouse.");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(90, 49, 561, 15);
        panel_help.add(label);

        JLabel label_1 = new JLabel("2. Click the left mouse button to launch the ball.");
        label_1.setFont(new Font("Arial", Font.BOLD, 12));
        label_1.setBounds(90, 83, 561, 15);
        panel_help.add(label_1);

        JLabel label_1_1 = new JLabel("3. When you hit a brick, the brick will disappear and you will get two points. ");
        label_1_1.setFont(new Font("Arial", Font.BOLD, 12));
        label_1_1.setBounds(90, 117, 561, 15);
        panel_help.add(label_1_1);

        JLabel label_1_1_1 = new JLabel("4. You have three lives for a level of the game. Game will over if you lose three lives.");
        label_1_1_1.setBounds(90, 151, 561, 15);
        panel_help.add(label_1_1_1);
        
        JLabel label_1_1_10 = new JLabel("Then you need to click ¡°back to menu¡± to choose the level and play it again.");
        label_1_1_10.setBounds(90, 171, 561, 15);
        panel_help.add(label_1_1_10);
        
        JLabel label_1_1_1_1 = new JLabel("5. If you brick your history record, you should input your name and your score");
        label_1_1_1_1.setBounds(90, 188, 561, 15);
        panel_help.add(label_1_1_1_1);
        
        JLabel label_1_1_1_10 = new JLabel("will upload to the ¡°High Score¡±.");
        label_1_1_1_10.setBounds(90, 204, 561, 15);
        panel_help.add(label_1_1_1_10);
        
        JLabel label_1_1_1_2 = new JLabel("6. You can win a level of the game if you hit all the bricks on screen.");
        label_1_1_1_2.setBounds(90, 224, 561, 15);
        panel_help.add(label_1_1_1_2);

        JLabel label_1_1_1_3 = new JLabel("7. There are 5 levels in the game. You need to choose it after you click ¡°Play Game¡±.");
        label_1_1_1_3.setBounds(90, 253, 561, 15);
        panel_help.add(label_1_1_1_3);

        JLabel label_1_1_2 = new JLabel("8. There are four bonus: Multi-ball, Wide-Paddle, Sticky-Paddle, laser.");
        label_1_1_2.setFont(new Font("Arial", Font.BOLD, 12));
        label_1_1_2.setBounds(90, 287, 561, 15);
        panel_help.add(label_1_1_2);

        JButton btnNewButton_1 = new JButton("Back to Menu");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_help.setVisible(false);
                frame.setContentPane(panel_main);
                panel_main.setVisible(true);

            }
        });
        btnNewButton_1.setBounds(231, 392, 231, 23);
        panel_help.add(btnNewButton_1);

        panel_game = new JPanel();
        frame.getContentPane().add(panel_game, BorderLayout.CENTER);

        panel_rank = new JPanel();
        panel_rank.setLayout(null);

        frame.getContentPane().add(panel_rank, BorderLayout.CENTER);

        JLabel lblBreakouthallOfFrame = new JLabel("Hall Of Fame");
        lblBreakouthallOfFrame.setFont(new Font("Arial", Font.BOLD, 19));
        lblBreakouthallOfFrame.setBounds(241, 24, 248, 64);
        panel_rank.add(lblBreakouthallOfFrame);

        label_1_2 = new JLabel("player   10");
        label_1_2.setVerticalAlignment(SwingConstants.TOP);
        label_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        label_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
        label_1_2.setBounds(241, 98, 123, 287);
        panel_rank.add(label_1_2);

        JButton btnNewButton_1_1 = new JButton("Back to Menu");
        btnNewButton_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_rank.setVisible(false);
                frame.setContentPane(panel_main);
                panel_main.setVisible(true);
            }
        });
        btnNewButton_1_1.setBounds(231, 392, 231, 23);
        panel_rank.add(btnNewButton_1_1);

        label_1_2_1 = new JLabel("player   10");
        label_1_2_1.setVerticalAlignment(SwingConstants.TOP);
        label_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
        label_1_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
        label_1_2_1.setBounds(366, 98, 123, 287);
        panel_rank.add(label_1_2_1);

        panel_main = new JPanel();
        panel_main.setBackground(new Color(255, 255, 204));
        frame.getContentPane().add(panel_main, BorderLayout.CENTER);
        panel_main.setLayout(null);

        JButton btnNewButton = new JButton("Play Game");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                StartGame();


            }
        });
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
        btnNewButton.setBackground(SystemColor.controlLtHighlight);
        btnNewButton.setBounds(247, 29, 193, 49);
        panel_main.add(btnNewButton);

        JButton btnHigh = new JButton("High Scores");
        btnHigh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ToRank();
            }
        });
       
        btnHigh.setFont(new Font("Arial", Font.BOLD, 15));
        btnHigh.setBackground(Color.WHITE);
        btnHigh.setBounds(247, 129, 193, 49);
        panel_main.add(btnHigh);

        JButton btnGethelp = new JButton("GetHelp");
        btnGethelp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GetHelp();
            }
        });
        btnGethelp.setFont(new Font("Arial", Font.BOLD, 15));
        btnGethelp.setBackground(Color.WHITE);
        btnGethelp.setBounds(247, 229, 193, 49);
        panel_main.add(btnGethelp);

        JButton btnExit = new JButton("Exit");
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(247, 329, 193, 49);
        panel_main.add(btnExit);

        panel_main.setVisible(true);
        panel_rank.setVisible(false);
        panel_help.setVisible(false);
        panel_game.setVisible(false);


    }

    JPanel panel_main;
    JPanel panel_rank;
    JPanel panel_help;
    JPanel panel_game;
    JLabel label_1_2;
    JLabel label_1_2_1;

    private void StartGame() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new MyGame().StartGame();
            }
        }).start();


    }

    private void GetHelp() {
        panel_main.setVisible(false);

        frame.setContentPane(panel_help);
        panel_help.setVisible(true);

    }

    private void ToRank() {

        label_1_2.setText(recordManage.record.getAllName());
        label_1_2_1.setText(recordManage.record.getAllFenshu());

        panel_main.setVisible(false);

        frame.setContentPane(panel_rank);
        panel_rank.setVisible(true);

    }
}
