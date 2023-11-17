//Created by T. Xia

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class testAWT_14 extends JFrame implements MouseListener, MouseMotionListener
{
	private JLabel statusBar;
	private JPanel mousePanel;
	private Container container;
	private BorderLayout layout;

	
	public testAWT_14 () {
		super("Mouse event handeling");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		//Add a mouse panel and status bar 
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		mousePanel.addMouseListener(this);
		mousePanel.addMouseMotionListener(this);
		container.add(mousePanel, BorderLayout.CENTER);
		
		statusBar = new JLabel("Mouse outside");
		container.add(statusBar, BorderLayout.SOUTH);
	}
	
	//Override
	public void mouseClicked(MouseEvent event) {
		statusBar.setText(String.format("Clicked at [%d, %d]", event.getX(), event.getY()));
	}

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
		statusBar.setText(String.format("Mouse moved at [%d, %d]", event.getX(), event.getY()));
	}

	//Override
	public void mouseDragged(MouseEvent event) {
		statusBar.setText(String.format("Mouse dragged at [%d, %d]", event.getX(), event.getY()));
	}

	public static void main(String[] args) {
		testAWT_14 t14 = new testAWT_14();
		t14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t14.setSize(500, 400);

		t14.setVisible(true);
	}
}