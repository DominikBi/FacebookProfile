package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    int likeCounter;

    public static void main(String args[]){
        Main main = new Main();
        main.start();
    }
    public void start(){
        JFrame bookFrame = new JFrame();
        JFrame frame = new JFrame();
        Profile profile = new Profile();
        BookPage bookPage = new BookPage();
        JTextField textField = new JTextField();
        textField.setText("Write a comment");
        textField.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width-Toolkit.getDefaultToolkit().getScreenSize().width/8.49557522124),Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/28);
        textField.setSize(new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().width-Toolkit.getDefaultToolkit().getScreenSize().width/8.49557522124 + Toolkit.getDefaultToolkit().getScreenSize().width/128),20));
        System.out.println("x: " + (int) (Toolkit.getDefaultToolkit().getScreenSize().width-Toolkit.getDefaultToolkit().getScreenSize().width/8.49557522124) + "  y: "  + ((int) Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/28));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookFrame.add(bookPage);
        bookFrame.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height));
        profile.setName("Vesalius");
        frame.add(profile);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Rectangle r = new Rectangle();
                r.width = profile.getBookWidth();
                r.height = profile.getBookHeight();
                r.x = 0;
                r.y = profile.getPbHeight()+5;
                if(r.contains(e.getLocationOnScreen())){
                    frame.setVisible(false);
                    bookFrame.setVisible(true);
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
        });
        frame.setVisible(true);


    }
}
