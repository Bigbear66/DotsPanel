package com.company;

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

public class DotsPanel extends JPanel {

    private final int SIZE = 8; // radius of each dot
    private ArrayList<Point> pointList;


    // DotsPanel.Java
    // Eldin Pita
    // CSCI 1302
    // Lab #2
    // 01/17/2020

    public DotsPanel() {
        pointList = new ArrayList<Point>();
        addMouseListener(new DotsListener());
        setBackground(Color.black);
        setPreferredSize(new Dimension(350, 250));
    }

    private void setColor(Color color) {
    }

    // Draws all the dots stored.

    // This Changes the Paint and Size.

    public void paint(Graphics page) {
        super.paintComponent(page);
        // Crates the Random Generator for this portion.

        SecureRandom randomNum = new SecureRandom();
        Color color = new Color(randomNum.nextInt(250), randomNum.nextInt(250),
                randomNum.nextInt(250));
        page.setColor(color);
        for (Point spot : pointList)
            page.fillOval(spot.x - SIZE, spot.y - SIZE, SIZE * 3, SIZE * 3);
        page.drawString("Count: " + pointList.size(), 6, 20);
    }

    private Point point1 = null, point2 = null;

    public void paintComponent(Graphics page)

    {
        super.paintComponent(page);

        page.setColor (Color.yellow);
        if (point1 != null && point2 != null)
            page.drawLine(point1.x, point1.y, point2.x, point2.y);
    }


    private class DotsListener implements MouseListener {

        // Every time you click the mouse button it changes the color.

        public void mousePressed(MouseEvent event) {
            pointList.add(event.getPoint());


            repaint();
        }

        public void mouseClicked(MouseEvent event) {
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
        }

        public void mouseExited(MouseEvent event) {
        }

    }


    public static void main(String args[]) {

        JFrame frame = new JFrame();
        frame.add(new DotsPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(25, 25, 550, 550);
        frame.setVisible(true);

    }

   }