package RainbowReef.game;

import RainbowReef.GameConstants;
import RainbowReef.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static javax.imageio.ImageIO.read;



public class GameWorld extends JPanel implements Runnable {
    private BufferedImage world;
    private Launcher lf;
    private Katch k;
    private Pop p;
    private BrickGenerator brick, brick2, brick3, brick4, brick5, brick6, brick7;
    private Image background, block1;
    static long tick = 0;

    ArrayList<BrickGenerator> bricks = new ArrayList<>();



    public GameWorld(Launcher lf) {
        this.lf = lf;
    }

    public void run() {
        try {
            this.resetGame();
            while (true) {
                this.tick++;
                this.k.update();
                this.p.update();
                this.repaint();   // redraw game
                Thread.sleep(1000 / 144);
            }
        } catch (InterruptedException ignored) {
            System.out.println(ignored);
        }
    }


    public void resetGame()
    {
        this.tick = 0;
        this.k.setX(380);
        this.k.setY(560);
        this.p.setX(380);
        this.p.setY(400);

        this.brick.setX(200);
        this.brick.setY(200);

        this.brick2.setX(225);
        this.brick2.setY(225);

        this.brick3.setX(250);
        this.brick3.setY(250);



    }



    public void gameInitialize() {
      this.world = new BufferedImage(GameConstants.GAME_SCREEN_WIDTH,
                GameConstants.GAME_SCREEN_HEIGHT,
                BufferedImage.TYPE_INT_RGB);
                BufferedImage kimg = null;
                BufferedImage pImg = null;
                BufferedImage bricks = null;
                BufferedImage bricks2 = null;
                BufferedImage bricks3 = null;

                //map = new BrickGenerator(3, 12);

        try {
            kimg = read(Objects.requireNonNull(GameWorld.class.getClassLoader().getResource("Katch.png")));
            pImg = read(Objects.requireNonNull(GameWorld.class.getClassLoader().getResource("Pop.png")));
            bricks = read(Objects.requireNonNull(GameWorld.class.getClassLoader().getResource("Block1.gif")));
            bricks2 = read(Objects.requireNonNull(GameWorld.class.getClassLoader().getResource("Block2.gif")));
            bricks3 = read(Objects.requireNonNull(GameWorld.class.getClassLoader().getResource("Block3.gif")));
            //background = ImageIO.read(new File("./resources/Background1.png"));
            //block1 = ImageIO.read(new File("resources/Block1.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        // Katch is displayed
        k = new Katch(0, 0,  kimg);
        // pop is displayed
        p = new Pop(0, 0, 0, pImg);

        GameControl k1 = new GameControl(k, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE);

        brick = new BrickGenerator(200, 200, bricks);
        brick2 = new BrickGenerator( 250,250, bricks2);
        brick3 = new BrickGenerator( 250,250, bricks3);
        for(int i = 0; i < 15; i ++) {


        }



        this.lf.getJf().addKeyListener(k1);


    }
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Graphics2D buffer = world.createGraphics();

            buffer.setColor(Color.BLACK);
            buffer.fillRect(0, 0, GameConstants.GAME_SCREEN_WIDTH, GameConstants.GAME_SCREEN_HEIGHT);

            this.k.drawImage(buffer);
            this.p.drawImage(buffer);

            this.brick.drawImage(buffer);
            this.brick2.drawImage(buffer);
            this.brick3.drawImage(buffer);
            //map.draw(buffer);


            g2.drawImage(world, null, 0, 0);


    }
    }