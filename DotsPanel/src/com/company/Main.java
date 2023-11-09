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

public class Main extends JPanel {
    private final int SIZE = 6;
    private ArrayList<Point> pointList;
    public Main()
    {
        pointList = new ArrayList<Point>();
        addMouseMotionListener(new DotsListener());
        setBackground(Color.black);
        setPreferredSize(new Dimension(300, 200));
    }
    private void setColor(Color color)
    {
    }
    public void paint(Graphics page)
    {
        super.paintComponent(page);
        SecureRandom randomNum = new SecureRandom();
        Color color = new Color(randomNum.nextInt(256), randomNum.nextInt(256),
                randomNum.nextInt(256));
        page.setColor(color);
        for (Point spot : pointList)
            page.fillOval(spot.x - SIZE, spot.y - SIZE, SIZE * 2, SIZE * 2);
        page.drawString("Count: " + pointList.size(), 5, 15);
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
        frame.add(new Main());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(20,20, 500,500);
        frame.setVisible(true);
    }
}