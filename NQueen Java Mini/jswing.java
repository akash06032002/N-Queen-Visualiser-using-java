import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.*;
public class jswing {
    
    public static void GUIframe()
    {
        //lec 1
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when popup window closed execution stops
        // frame.setSize(700,600);
        // frame.setLocation(100,80);
        frame.setBounds(100, 80, 800, 700);
        frame.setTitle("N Queen Visualizer");

        ImageIcon queenPic = new ImageIcon("QueenPhoto.jpg");
        frame.setIconImage(queenPic.getImage());  //sets icon 
        
        Container C = frame.getContentPane(); //targets  the contents
        Color color = new Color(245, 213, 174);
        C.setBackground(color);

        //lec 2-jLabel
        C.setLayout(null);
        JLabel label = new JLabel("UserName");
        label.setBounds(100,50,200,200);
        // label.setText("Password");

        Font font = new Font("Ariel",Font.BOLD,18);
        label.setFont(font);
       
        JLabel image =new JLabel(queenPic);
        image.setBounds(200,300,queenPic.getIconWidth(),queenPic.getIconHeight());

        JLabel label2 = new JLabel("Text", queenPic, JLabel.RIGHT );
        label2.setBounds(0,100,200,100);
        C.add(label);
        C.add(image);
        C.add(label2);




    }

    // public void nQueenGui(){
        
    // }
    public static void main(String[] args) {
        GUIframe();
    }
}
