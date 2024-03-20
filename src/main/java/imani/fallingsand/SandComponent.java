package imani.fallingsand;

import javax.swing.JComponent;

import java.awt.*;

public class SandComponent extends JComponent {

    private final Sand sand;

    public SandComponent(Sand sand) {
        this.sand = sand;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.translate(0, getHeight());
        // first I have to create the field
        // sand = new Sand(1000, 1000);
        g.setColor(Color.BLACK);
        g.drawRect(0,  0, getWidth(), getHeight());
        // then I have to use random sand to populate it
        int[][] field = sand.getField();
        for (int y = field.length - 1; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1)
                {
                    g.fillRect(x, y, 5, 5);
                }
            }
        }
    }
}
