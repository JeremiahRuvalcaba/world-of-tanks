package RainbowReef.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControl implements KeyListener {
    private Katch k;
    private final int right;
    private final int left;
    private final int shoot;

    public GameControl(Katch k, int right, int left, int shoot) {
        this.k = k;
        this.right = right;
        this.left = left;
        this.shoot = shoot;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }
    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();

        if (keyPressed == left) {
            this.k.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.k.toggleRightPressed();
        }

    }
    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();

        if (keyReleased  == left) {
            this.k.unToggleLeftPressed();
        }
        if (keyReleased  == right) {
            this.k.unToggleRightPressed();
        }

    }
}
