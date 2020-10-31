package Proskurin_ja_a.line_drawers;

import Proskurin_ja_a.LineDrawer;

import java.awt.*;

public class GraphicsLineDrawer implements LineDrawer {
    private Graphics g;

    public GraphicsLineDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        g.setColor(Color.ORANGE);
        g.drawLine(x1,y1,x2,y2);
    }
}
