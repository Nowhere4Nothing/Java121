//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AJFrame extends JFrame
{
		private JTextArea text;
		
		public AJFrame() {
			text = new JTextArea("Hello from AJFrame", 10, 30);
			add(text, BorderLayout.CENTER);
			add(new JLabel("A label"), BorderLayout.SOUTH);
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(300, 300);
			setVisible(true);
		}			
}

public class testAWT_18 extends JFrame implements ActionListener
{
	private JButton button;
	private AJFrame aframe;
	private BorderLayout layout;
	private Container container;
	
	public testAWT_18 () {
		super("A JFrame instance is a component in a JFrame instance Demo1");

		container = getContentPane();
		layout = new BorderLayout(); 
		container.setLayout(layout);
		
		//Add a label
		container. add(new JLabel("A JFrame is below"), BorderLayout.NORTH);
		
		//Add a frame
		aframe = new AJFrame();
		container.add(aframe, BorderLayout.CENTER);
		
		//Add a button
		button = new JButton("Ok");
		
		button.addActionListener(this);
		container.add(button, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent event) {
		container.validate(); //Re-lay out the container
		//aframe = new AJFrame();
	}
			
	public static void main(String[] args) {
		testAWT_18 t18 = new testAWT_18();
		t18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t18.setSize(600, 600);
		t18.setVisible(true);
	}
}