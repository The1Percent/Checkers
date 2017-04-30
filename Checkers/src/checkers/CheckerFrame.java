package checkers;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class CheckerFrame extends JFrame implements ActionListener{
    JButton stB=new JButton("Start Game");
    JPanel gmP=new StartPanel();
  
    public CheckerFrame(){
        setupGUI();
        new PlaySound("/Start.wav").start();
    }

    private void setupGUI() {
        setLayout(null);
        gmP.setBounds(0,0,518,401);//400,401
        //gmP.imageUpdate(ne, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH)
        add(gmP);
        stB.setHorizontalAlignment(SwingConstants.LEADING);
        stB.setIcon(new ImageIcon(getClass().getResource("/checkersIcon.jpg")));
        stB.setBackground(Color.LIGHT_GRAY);
        stB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stB.setBounds(140,420,240,60);
        stB.setFont(new Font("Times new roman",Font.BOLD,20));
        stB.addActionListener(this);
        stB.setFocusPainted(false);
        add(stB);

        this.setIconImage(new ImageIcon(getClass().getResource("/icon.jpg")).getImage());

        setSize(520,520);

        setLocation((int)getToolkit().getScreenSize().getWidth()/2-254,(int)getToolkit().getScreenSize().getHeight()/2-310);
        setResizable(false);
        setVisible(true);
        setTitle("Play Checkers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Start Game")){
            ((JButton)e.getSource()).setText("New Game");
            new PlaySound("/button.wav").start();
            gmP=new Checkers();
            gmP.setBounds(0,0,518,401);
            this.setContentPane(gmP);
        }
    }
}
