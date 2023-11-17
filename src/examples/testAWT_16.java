//Created by T. Xia

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class PaintPanel extends JPanel
{
	private ArrayList<Point> points;
	
	public PaintPanel() {
		points = new ArrayList<Point>();
		
		setBackground(Color.WHITE);
		
		addMouseMotionListener(new MouseMotionAdapter() {
			//Override
			public void mouseDragged(MouseEvent event) {
				points.add(event.getPoint()); //Add a new point to the array list, then repaint the panel
				repaint();
			}	
		});
		
		addMouseListener(new MouseAdapter() {
			//Override
			public void mouseClicked(MouseEvent event) {
				if(event.isMetaDown()) {//Right mouse button down, Clear the paint
					points.clear();
					repaint();
				}
			}
		});

	}
	
	//Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //Clear paint area
		for(Point point:points)
			g.fillOval(point.x, point.y, 5, 5);
	}
}

public class testAWT_16 extends JFrame
{
	private PaintPanel paint; 
	private JLabel statusBar;
	private Container container;
	private BorderLayout layout;
	
	public testAWT_16 () {
		super("JPanel drawing handeling");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		//Add PaintPanel instance
		paint = new PaintPanel();

		container.add(paint, BorderLayout.CENTER);
		
		statusBar = new JLabel("Drag the mouse to draw, right click to clear.");
		container.add(statusBar, BorderLayout.SOUTH);
	}
	

	public static void main(String[] args) {
		testAWT_16 t16 = new testAWT_16();
		t16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t16.setSize(500, 400);

		t16.setVisible(true);
	}
}


