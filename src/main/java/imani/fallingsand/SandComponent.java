package imani.fallingsand;

import javax.swing.JComponent;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SandComponent extends JComponent {

    private final Sand sand;

    public SandComponent(Sand sand) {
        this.sand = sand;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sand.put(e.getX(), e.getY(), 10, 10, .30);
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

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                sand.put(e.getX(), e.getY(), 10, 10, .30);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        sand.resize(getWidth(), getHeight());

        sand.fall();
        g.setColor(Color.BLACK);
        g.drawRect(0,  0, getWidth(), getHeight());
        // then I have to use random sand to populate it
        int[][] field = sand.getField();
        for (int y = field.length - 1; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1)
                {
                    g.fillRect(x, y, 1, 1);
                }
            }
        }

        repaint(); //calls paint component again
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
