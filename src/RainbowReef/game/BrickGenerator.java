package RainbowReef.game;

//import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public class BrickGenerator
{
    // public int map[][];
   // public int brickWidth;
  //  public int brickHeight;
    private BufferedImage img;
    private int x;
    private int y;

    public BrickGenerator(int x, int y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
       // width = img.getWidth(null);
    }


    void setX(int x){ this.x = x; }

    void setY(int y) { this. y = y;}




    /*
    public BrickGenerator(int row, int col)
    {


        map = new int[row][col];
        for(int i = 0; i < map.length; i++)
        {
            for(int j =0; j < map[0].length; j++)
            {
                map[i][j] = 1;
            }
        }

        brickWidth = 620 / col;
        brickHeight = 100 / row;

    }
  */

    void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        //rotation.rotate(Math.toRadians(speed), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, rotation, null);

    }

}
        /*
        public void draw(Graphics2D g)

        for(int i = 0; i < map.length; i++)
        {
            for(int j =0; j < map[0].length; j++)
            {
                if(map[i][j] > 0)
                {
                    g.setColor(Color.red);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    // this is just to show separate brick, game can still run without it
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
   */

