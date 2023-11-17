//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testAWT_4 extends JFrame implements ActionListener
{
	private JButton[] buttons;
	private GridLayout layout1, layout2, layout3, layout4;
	private Container container;
	private int toggle;
	
	public testAWT_4 () {
		super("Gridlayout Demo1");
		toggle = 0;
		container = getContentPane();
		layout1 = new GridLayout(2, 3, 5, 5); //2 x 3, gaps 5
		layout2 = new GridLayout(2, 3); //No gap
		layout3 = new GridLayout(1, 6, 5, 5); //1 x 6
		layout4 = new GridLayout(6, 1, 5, 5); //6 x 1
		setLayout(layout1);
		
		buttons = new JButton[6];
		
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton("Button" + (i+1));
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}

	public void actionPerformed(ActionEvent event) {
		if(toggle == 0)
			container.setLayout(layout2);
		else if(toggle == 1)
			container.setLayout(layout3);
		else if(toggle == 2)
			container.setLayout(layout4);
		else
			container.setLayout(layout1);
		
		toggle = (toggle + 1) % 4;
		container.validate(); //Re-lay out the container
	}
			
	public static void main(String[] args) {
		testAWT_4 t4 = new testAWT_4();
		t4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t4.setSize(300, 200);
		t4.setVisible(true);
	}
}