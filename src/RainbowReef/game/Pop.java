package RainbowReef.game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Pop {

    private BufferedImage img;
    private int x;
    private int y;
    private int vx;
    private double vy;
    private float speed;


    public Pop(int x, int y, int speed, BufferedImage img){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.img = img;
        // The rate of speed the ball falls in y direction
        vy = 0.01;
        // The rate of the speed the ball falls in x direction
        vx = 4;
    }

    void setX(int x){ this.x = x; }

    void setY(int y) { this. y = y;}

        // updates the i
    public void update() {

        vy+= .001;

    x+= Math.round(vx);
    y+= (int) Math.round(vy);

    if( x < 0){
        vx = -vx;

    }

    if (y < 0){
        y = -y;
    }
    // Contains the game in the x direction
    if (x >= RainbowReef.GameConstants.GAME_SCREEN_WIDTH - 88) {
        x = RainbowReef.GameConstants.GAME_SCREEN_WIDTH - 88;
    }
    // contains the game in the y direction
    if (y >= RainbowReef.GameConstants.GAME_SCREEN_HEIGHT - 80) {
        y = RainbowReef.GameConstants.GAME_SCREEN_HEIGHT - 80;
        }

    }

    // Draws the images of pop to game
    void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(speed), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, rotation, null);

    }
}
