package RainbowReef.game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Katch {
    private BufferedImage img;
    private int x;
    private int y;
    private int vx;
    private int vy;
    private float angle;
    private final int R = 2;
    private Rectangle hitbox;;
    private boolean RightPressed;
    private boolean LeftPressed;
    private boolean ShootPressed;

    
    public Katch(int x, int y, BufferedImage kimg) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = kimg;
        this.angle = angle;

    }


    public Rectangle getHitbox(){ return hitbox.getBounds(); }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }


    void setX(int x){ this.x = x; }

    void setY(int y) { this. y = y;}

    void toggleRightPressed() {
        this.RightPressed = true;
    }

    void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    void unToggleRightPressed() {
        this.RightPressed = false;
    }

    void unToggleLeftPressed() {
        this.LeftPressed = false;
    }




    public void update() {
        if (this.LeftPressed) {
            this.moveForwards();
        }
        if (this.RightPressed) {
            this.moveBackwards();
        }

    }


    private void moveBackwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x -= vx;
        y -= vy;
        checkBorder();
    }

    private void moveForwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
        checkBorder();
    }




    private void checkBorder() {
        if (x < 30) {
            x = 30;
        }
        if (x >= RainbowReef.GameConstants.GAME_SCREEN_WIDTH - 88) {
            x = RainbowReef.GameConstants.GAME_SCREEN_WIDTH - 88;
        }
        if (y < 40) {
            y = 40;
        }
        if (y >= RainbowReef.GameConstants.GAME_SCREEN_HEIGHT - 80) {
            y = RainbowReef.GameConstants.GAME_SCREEN_HEIGHT - 80;
        }
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", angle=" + angle;
    }


    void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, rotation, null);
    }
}
