//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testAWT_7 extends JFrame
{
	private JButton[] buttons;
	private JLabel[] labels;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private Container container;
	private FlowLayout layout1;
	private GridLayout layout2;
	private JTextArea text;

	
	public testAWT_7 () {
		super("Composite Demo2");
		
		container = getContentPane();
		
		panel1 = new JPanel();
		layout1 = new FlowLayout();
		buttons = new JButton[3];
		panel1.setLayout(layout1);
		for(int i=0; i<3; i++) {
			buttons[i] = new JButton("Button " + (i+1));
			panel1.add(buttons[i]);
		}
		add(panel1, BorderLayout.NORTH);


	
		panel2 = new JPanel();
		layout2 = new GridLayout(1, 4);
		panel2.setLayout(layout2);
		labels = new JLabel[4];
		for(int i=0; i<3; i++) {
			labels[i] = new JLabel("Label " + (i+1));
			panel2.add(labels[i]);
		}
		
		Icon c3 = new ImageIcon(getClass().getResource("color3.png"));
		labels[3] = new JLabel("Label 4");
		labels[3].setIcon(c3);
		labels[3].setHorizontalTextPosition(SwingConstants.LEFT);
		
		panel2.add(labels[3]);
		
		add(panel2, BorderLayout.SOUTH);	
		
		panel3 = new JPanel();
		text = new JTextArea("Put text here", 8, 40);
		panel3.add(text);
		add(panel3, BorderLayout.CENTER);
	}
			
	public static void main(String[] args) {
		testAWT_7 t7 = new testAWT_7();
		t7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t7.setSize(500, 400);
		//t6.pack();
		t7.setVisible(true);
	}
}