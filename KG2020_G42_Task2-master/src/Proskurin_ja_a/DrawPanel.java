package Proskurin_ja_a;

import Proskurin_ja_a.line_drawers.*;
import Proskurin_ja_a.pixel_drawers.GraphicsPixelDrawer;
import Proskurin_ja_a.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

//ctrl+o
public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.white);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld = new DDALineDrawer(pd);
        //LineDrawer gl = new GraphicsLineDrawer(bi_g);
        LineDrawer bl = new BresenhamLineDrawer(pd);
        LineDrawer wu = new WuLineDrawer(pd);
        /**/
        drawAll(ld, bl,wu);
        /**/
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose(); //убираемся
    }

    private void drawAll(LineDrawer ld, LineDrawer bl, LineDrawer wu) {
        int mouseX = position.x - 10;
        int mouseY = position.y - 10;
        //gl.drawLine(900, 600, mouseX, mouseY);
        DrawUtils.drawSnowflake(ld, 400,600, 40, 32);
        DrawUtils.drawSnowflake(bl, 900,100, 40, 32);
        DrawUtils.drawSnowflake(wu, 200,600, 40, 32);

        ld.drawLine(100, 200, mouseX, mouseY);
        bl.drawLine(800, 400, mouseX, mouseY);
        wu.drawLine(400, 300, mouseX, mouseY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();

    }
}
