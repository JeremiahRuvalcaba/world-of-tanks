package RainbowReef.menus;

import RainbowReef.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class StartMenuPanel extends JPanel {

    private BufferedImage menuBackground;
    private JButton start;
    private JButton exit;
    private Launcher lf;

    public StartMenuPanel(Launcher lf) {
        this.lf = lf;
        try {
           menuBackground = ImageIO.read(this.getClass().getClassLoader().getResource("Title.gif"));
        } catch (IOException e) {
            System.out.println("Error cant read menu background");
            e.printStackTrace();
            System.exit(-3);
        }
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        Icon startIcon = new ImageIcon("./resources/Button_start.png");
        start = new JButton(startIcon);
       // start.setFont(new Font("Courier New", Font.BOLD ,24));
        start.setBounds(200,400,100,40);
        start.addActionListener((actionEvent -> {
            this.lf.setFrame("game");
        }));

        Icon exitIcon = new ImageIcon("./resources/Button_quit.gif");
        exit = new JButton(exitIcon);
        exit.setSize(new Dimension(200,100));
        //exit.setFont(new Font("Courier New", Font.BOLD ,24));
        exit.setBounds(200,500,100,40);
        exit.addActionListener((actionEvent -> {
            this.lf.closeGame();
        }));


        this.add(start);
        this.add(exit);

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }



}
