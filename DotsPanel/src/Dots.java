import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Dots.java
// by Eldin Pita
// CSCI 1302
// Lab #2
// 02/01/2020

public class Dots extends JPanel {
    private final int SIZE = 8;
    private ArrayList<Point> pointList;
    public Dots()
    {
        pointList = new ArrayList<Point>();
        addMouseMotionListener(new DotsListener());
        setBackground(Color.black);
        setPreferredSize(new Dimension(350, 250));
    }
    private void setColor(Color color)
    {
    }
    public void paint(Graphics page)
    {
        super.paintComponent(page);
        SecureRandom randomNum = new SecureRandom();
        Color color = new Color(randomNum.nextInt(250), randomNum.nextInt(250),
                randomNum.nextInt(256));
        page.setColor(color);
        for (Point spot : pointList)
            page.fillOval(spot.x - SIZE, spot.y - SIZE, SIZE * 3, SIZE * 3);
        page.drawString("Count: " + pointList.size(), 6, 20);
    }
    private class DotsListener implements MouseMotionListener
    {
        public void mousePressed(MouseEvent event)
        {
            pointList.add(event.getPoint());
            repaint();
        }
        public void mouseMoved(MouseEvent event)
        {
        }
        public void mouseClicked(MouseEvent event)
        {
        }
        public void mouseReleased(MouseEvent event)
        {
        }
        public void mouseEntered(MouseEvent event)
        {
        }
        public void mouseExited(MouseEvent event)
        {
        }
        public void mouseDragged(MouseEvent event)
        {
            pointList.add(event.getPoint());
            repaint();
        }
    }
    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.add(new Dots());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(25,25, 550,550);
        frame.setVisible(true);
    }
}