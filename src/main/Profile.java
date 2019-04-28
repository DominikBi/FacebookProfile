package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Profile extends JComponent {
    Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
    private int BookHeight;
    private int BookWidth;
    private int pbHeight;
    private int pbWidth;

    public int getPbHeight() {
        return pbHeight;
    }

    public int getPbWidth() {
        return pbWidth;
    }

    private String name;
    File book = new File("data\\VesaliusBuch.jpg");
    File pbImageFile = new File("data/pbImage.jpg");
    private Image pbImage;
    private Image bookImage;

    {
        try {
            bookImage = ImageIO.read(book);
        } catch (IOException e) {
            System.err.println("Image not found " + e);
        }
        try {
            pbImage = ImageIO.read(pbImageFile);
        } catch (IOException e) {
            System.err.println("Image not found " + e);
        }
    }
    public int getBookHeight(){
        return BookHeight;
    }
    public int getBookWidth(){
        return BookWidth;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void paint(Graphics g) {
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        super.paint(g);
        g.setColor(Color.black);
        g.setFont(new Font("MyFont", Font.BOLD,36));
        g.drawString("Vesalius", Toolkit.getDefaultToolkit().getScreenSize().width/19,Toolkit.getDefaultToolkit().getScreenSize().height/24);
        g.setColor(Color.gray);
        for(int i = 0; i < 5; i++) {
            g.drawLine(0, (int) (Toolkit.getDefaultToolkit().getScreenSize().height/22.5882352941 + i), screenSize.width, (int) (Toolkit.getDefaultToolkit().getScreenSize().height/22.5882352941 + i));
        }
        g.setColor(Color.black);
        int maxWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int x1 = (int) (Toolkit.getDefaultToolkit().getScreenSize().width-Toolkit.getDefaultToolkit().getScreenSize().width/8.49557522124);
        g.drawImage(pbImage, x1,0,pbImage.getWidth((img, infoflags, x, y, width, height) -> false)/4,pbImage.getHeight((img, infoflags, x, y, width, height) -> false)/4,null);
        g.setColor(Color.decode("#C0C0C0"));

        for(int i = 0; i < 4; i++) {
            g.drawLine(x1 + i, 0, x1 + i, pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4 - 10);
            g.drawLine(x1 - i  , (pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4) +i -Toolkit.getDefaultToolkit().getScreenSize().width/192, x1 + Toolkit.getDefaultToolkit().getScreenSize().width/192 - i, (pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4) + i);
            g.drawLine(x1 + Toolkit.getDefaultToolkit().getScreenSize().width/192 ,(pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4) +i,maxWidth,(pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4) + i);
        }
        pbWidth = pbImage.getWidth((img, infoflags, x, y, width, height) -> false)/4;
        pbHeight = pbImage.getHeight((img, infoflags, x, y, width, height) -> false)/4;
        g.setFont(new Font("Description Font", Font.PLAIN, 24));
        g.setColor(Color.black);
        g.drawString("48 y.o.", (int) (Toolkit.getDefaultToolkit().getScreenSize().width/76.8), (int) (Toolkit.getDefaultToolkit().getScreenSize().height/8.30769230769));
        g.drawString("My book: ", (int) (Toolkit.getDefaultToolkit().getScreenSize().width/76.8), (int) (Toolkit.getDefaultToolkit().getScreenSize().height/5.14285714286));
        g.drawString("My fields of study are myology(muscles) and osteology(bones)", (int) (Toolkit.getDefaultToolkit().getScreenSize().width/76.8), (int) (Toolkit.getDefaultToolkit().getScreenSize().height/6.35294117647));
        g.setColor(Color.blue);
        g.setFont(new Font("LinkFont",Font.ITALIC,24).deriveFont(fontAttributes));
        g.drawString("https://amzn.to/2DCbQLA", (int) (Toolkit.getDefaultToolkit().getScreenSize().width/14.7692307692), (int) (Toolkit.getDefaultToolkit().getScreenSize().height/5.14285714286));
        g.setColor(Color.decode("#C0C0C0"));
        BookHeight = bookImage.getHeight((img, infoflags, x, y, width, height) -> false)/3;
        BookWidth = bookImage.getHeight((img, infoflags, x, y, width, height) -> false)/3;
        for(int i = 0; i<4;i++){
            g.drawLine(0,(pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4) +i, (int) (Toolkit.getDefaultToolkit().getScreenSize().width-Toolkit.getDefaultToolkit().getScreenSize().width/8.49557522124 + Toolkit.getDefaultToolkit().getScreenSize().width/128),(pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4) +i);
        }
        g.drawImage(bookImage,0,(pbImage.getHeight((img, infoflags, x, y, width, height) -> false) / 4) + 5, bookImage.getWidth((img, infoflags, x, y, width, height) -> false)/3,bookImage.getHeight((img, infoflags, x, y, width, height) -> false)/3,null);






    }
}
