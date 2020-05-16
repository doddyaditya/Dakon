import java.awt.event.*;  
import javax.swing.*;    
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.imageio.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class GUIDakon extends JFrame{
    public JLabel p = new JLabel();
    public Border border = BorderFactory.createLineBorder(Color.black,2);
    public ImageIcon background = new ImageIcon("res/mancala hole 2/Dakon2.png");
    public Hole[] ArrHole;
    public JLabel BigHoleP1 = new JLabel("0");
    public JLabel BigHoleP2 = new JLabel("0");
    public JLabel TurnLabel = new JLabel("Player 1 Turn");
    public JLabel ResultLabel = new JLabel("0");

    public GUIDakon(int[] ArrayHole){
        super("Dakon");
        setSize(820,600);
        getContentPane().setLayout(null);
        setResizable(false);
        p.setBounds(0,0,820,600);
        p.setIcon(background);
        ArrHole = new Hole[16];
        /*Inisialisasi ArrayHole*/
        for (int i=0; i<16;i++){
            if(i!=7 && i!= 15){
                ArrHole[i] = new Hole(i,ArrayHole[i]);
                onClick(ArrHole[i],7);
                add(ArrHole[i]);
            } else if (i==7){
                setBigHoleP1Label(Integer.toString(ArrayHole[i]));
            } else if (i==15){
                setBigHoleP2Label(Integer.toString(ArrayHole[i]));
            }
        }
        // Inisialisasi BigHole
        Font f = new Font("Verdana",Font.BOLD,26);
        BigHoleP1.setFont(f);
        BigHoleP1.setBounds(38,230,80,80);
        BigHoleP2.setFont(f);
        BigHoleP2.setBounds(736,230,80,80);
        TurnLabel.setFont(f);
        TurnLabel.setBounds(300,100,340,40);
        TurnLabel.setForeground(Color.decode("#e4c88f"));
        ResultLabel.setFont(f);
        ResultLabel.setBounds(300,400,340,40);
        ResultLabel.setForeground(Color.decode("#e4c88f"));

        add(TurnLabel);
        add(BigHoleP1);
        add(BigHoleP2);
        add(p); 
        setVisible(true);
    }

    public static void main(String args[]){
    }

    public static void onClick(Hole Button, final int position){
        Button.addMouseListener(new MouseAdapter() {     
            public void mouseClicked(MouseEvent e)  
            {  
            // you can open a new frame here as
            // i have assumed you have declared "frame" as instance variable
                System.out.println(position);
            }  
        });
    }

     

    public void refreshGUI(int[] ArrayHole){
        for (int i = 0; i < 16 ; i++){
            if(i==7){
                setBigHoleP1Label(Integer.toString(ArrayHole[i]));
            } else if (i==15){
                setBigHoleP2Label(Integer.toString(ArrayHole[i]));
            } else {
                ArrHole[i].setSeedCount(ArrayHole[i]);
            }
        }
    }
    public void setBigHoleP1Label(String text){
        BigHoleP1.setText(text);
    }
    public void setBigHoleP2Label(String text){
        BigHoleP2.setText(text);
    }
    public void setTurnLabel(String text){
        TurnLabel.setText(text);
    }
    public void setResultLabel(String text){
        ResultLabel.setText(text);
    }
}