package TankGame.game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class Bullet extends GameObject{
    int x, y, vx, vy, angle;
    int R = 7;
    BufferedImage bulletImage;
    Rectangle hitbox;

    public Bullet(int x, int y, int angle, BufferedImage bulletImage){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.bulletImage = bulletImage;
        this.hitbox = new Rectangle(x,y, this.bulletImage.getWidth(), this.bulletImage.getHeight());
    }

    public void moveForwards(){
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
        checkBorder();
        this.hitbox.setLocation(x,y);
    }

    public void checkBorder(){
        if (x < 30){
            x = 30;
        }
        if (x >= TankGame.GameConstants.GAME_SCREEN_WIDTH - 88){
            x = TankGame.GameConstants.GAME_SCREEN_WIDTH - 88;
        }
        if (y < 40){
            y = 40;
        }
        if (y >= TankGame.GameConstants.GAME_SCREEN_HEIGHT - 80){
            y = TankGame.GameConstants.GAME_SCREEN_HEIGHT - 80;
        }
    }

    public void update(){ moveForwards(); }



    public void drawImage(Graphics g){
        AffineTransform rotation = AffineTransform.getTranslateInstance(x , y);
        rotation.rotate(Math.toRadians(angle), bulletImage.getWidth() / 2.0, bulletImage.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.bulletImage, rotation, null);
        g2d.setColor(Color.blue);
        g2d.drawRect(x, y, this.bulletImage.getWidth(), this.bulletImage.getHeight());




    }
}
