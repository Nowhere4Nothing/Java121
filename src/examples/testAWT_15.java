//Created by T. Xia

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class testAWT_15 extends JFrame
{
	private JLabel statusBar;
	private JPanel mousePanel;
	private Container container;
	private BorderLayout layout;

	
	public testAWT_15 () {
		super("Mouse adapter event handeling");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		MouseHandler handler = new MouseHandler();
		//Add a mouse panel and status bar 
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
		container.add(mousePanel, BorderLayout.CENTER);
		
		statusBar = new JLabel("Mouse outside");
		container.add(statusBar, BorderLayout.SOUTH);
	}
	
	class MouseHandler extends MouseAdapter
	{
		//Override
		public void mouseClicked(MouseEvent event) {
			int x = event.getX();
			int y = event.getY();
		
			String details = String.format("Clicked at [%d,%d], clicked %d time(s)", x, y, event.getClickCount());
			if(event.isMetaDown()) //Right mouse button down
				details += " with right mouse button";
			else if(event.isAltDown()) //Middle mouse button down
				details += " with center mouse button";
			else
				details += " with left mouse button";
		
			statusBar.setText(details);
		}
		
		//Override
		public void mouseMoved(MouseEvent event) {
			statusBar.setText(String.format("Mouse moved at [%d, %d]", event.getX(), event.getY()));
		}


/*
		//Override
		public void mousePressed(MouseEvent event) {
			statusBar.setText(String.format("Pressed at [%d, %d]", event.getX(), event.getY()));
		}
				
		//Override
		public void mouseExited(MouseEvent event) {
			statusBar.setText("Mouse outside");
			mousePanel.setBackground(Color.WHITE);
		}

		//Override
		public void mouseEntered(MouseEvent event) {
			statusBar.setText(String.format("Mouse entered at [%d, %d]", event.getX(), event.getY()));
			mousePanel.setBackground(Color.GREEN);
		}

		//Override
		public void mouseReleased(MouseEvent event) {
			statusBar.setText(String.format("Mouse released at [%d, %d]", event.getX(), event.getY()));
		}

		//Override
		public void mouseMoved(MouseEvent event) {
			statusBar.setText(String.format("Mouse released at [%d, %d]", event.getX(), event.getY()));
		}

		//Override
		public void mouseDragged(MouseEvent event) {
			statusBar.setText(String.format("Mouse dragged at [%d, %d]", event.getX(), event.getY()));
		}
*/
	
	}

	public static void main(String[] args) {
		testAWT_15 t15 = new testAWT_15();
		t15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t15.setSize(500, 400);

		t15.setVisible(true);
	}
}


