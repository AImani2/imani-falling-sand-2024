package imani.fallingsand;

import javax.swing.JComponent;

import java.awt.Graphics;

public class SandComponent extends JComponent {

    private final Sand sand;

    public SandComponent(Sand sand) {
        this.sand = sand;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // first I have to create the field
        sand = new Sand(1000, 1000);

        g.drawRect(0, 0, 1000, 1000);
        // then I have to use random sand to populate it
        // as it is being put, I have to call fall
        // mouse component?
        // do this using the methods I created
    }
}
