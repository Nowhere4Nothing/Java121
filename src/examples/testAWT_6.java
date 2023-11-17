//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testAWT_6 extends JFrame
{
	private JButton[] buttons1;
	private JButton[] buttons2;
	private JPanel panel1;
	private JPanel panel2;
	private Container container;
	private FlowLayout layout1;
	private GridLayout layout2;

	
	public testAWT_6 () {
		super("Composite Demo1");
		
		container = getContentPane();
		
		panel1 = new JPanel();
		layout1 = new FlowLayout();
		buttons1 = new JButton[3];
		panel1.setLayout(layout1);
		for(int i=0; i<3; i++) {
			buttons1[i] = new JButton("Button " + (i+1));
			panel1.add(buttons1[i]);
		}
		add(panel1, BorderLayout.NORTH);


	
		panel2 = new JPanel();
		layout2 = new GridLayout(3, 2);
		buttons2 = new JButton[5];
		panel2.setLayout(layout2);
		for(int i=0; i<5; i++) {
			buttons2[i] = new JButton("Button " + (i+1));
			panel2.add(buttons2[i]);
		}
		add(panel2, BorderLayout.SOUTH);	
	}
			
	public static void main(String[] args) {
		testAWT_6 t6 = new testAWT_6();
		t6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t6.setSize(300, 300);
		//t6.pack();
		t6.setVisible(true);
	}
}