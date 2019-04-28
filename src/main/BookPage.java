package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class BookPage extends JComponent {
    File pageFile = new File("data\\VesaliusBuch.jpg");
    File like = new File("data\\like.jpg");
    Image image;
    int x = (int)(Toolkit.getDefaultToolkit().getScreenSize().width/15.4285714286);
    {
        try {
            image = ImageIO.read(like);
        } catch (IOException e) {
            System.err.println("Could not read image: " + e);
        }
    }

    Rectangle r = new Rectangle();
    public String update(int i){
        return String.valueOf(i);
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("MyFont", Font.BOLD,24));
        g.drawString("Vesalius", Toolkit.getDefaultToolkit().getScreenSize().width/12,Toolkit.getDefaultToolkit().getScreenSize().height/24);
        g.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i < 5; i++){
            g.drawLine(0, Toolkit.getDefaultToolkit().getScreenSize().height/24  + 5 + i, Toolkit.getDefaultToolkit().getScreenSize().width/2 - image.getWidth((img, infoflags, x, y, width, height) -> false),Toolkit.getDefaultToolkit().getScreenSize().height/24  + 5 + i);
        }
        System.out.println((Toolkit.getDefaultToolkit().getScreenSize().width/3*2) - (int)(Toolkit.getDefaultToolkit().getScreenSize().width/27.4285714286));
        super.paint(g);
        try {
            Image image = ImageIO.read(pageFile);
            g.drawImage(image, Toolkit.getDefaultToolkit().getScreenSize().width/4 -10, 0, image.getWidth((img, infoflags, x, y, width, height) -> false) /2, image.getHeight((img, infoflags, x, y, width, height) -> false)/2,null);
        } catch (IOException e) {
            System.err.println("Could not read image " + e);
        }
            g.setFont(new Font ("Numbers", Font.PLAIN, 36));
            g.drawString("421",(Toolkit.getDefaultToolkit().getScreenSize().width/3*2) - x + image.getWidth((img, infoflags, x1, y, width, height) -> false) + Toolkit.getDefaultToolkit().getScreenSize().width/32, Toolkit.getDefaultToolkit().getScreenSize().height/2 - image.getHeight((img, infoflags, x12, y, width, height) -> false)/2);
            g.drawImage(image,  (Toolkit.getDefaultToolkit().getScreenSize().width/3*2) - x,Toolkit.getDefaultToolkit().getScreenSize().height/4,null);
            r.x = (Toolkit.getDefaultToolkit().getScreenSize().width/3*2) - x;
            r.y = Toolkit.getDefaultToolkit().getScreenSize().height/4;
            r.width = ((BufferedImage) image).getWidth();
            r.height = ((BufferedImage) image).getHeight();

    }
}
