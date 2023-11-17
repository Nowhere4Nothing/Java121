//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testAWT_5 extends JFrame
{
	private JButton[] buttons;
	private GridBagConstraints c;
	private Container container;
	private GridBagLayout layout;
	private boolean shouldFill;
	private boolean shouldWeight;
	private boolean orientation;
	
	public testAWT_5 () {
		super("GridBaglayout Demo");
		shouldFill = true;
		shouldWeight = true;
		orientation = false;
		
		container = getContentPane();
		if(orientation)
			container.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		layout = new GridBagLayout();
		container.setLayout(layout);

		c = new GridBagConstraints();
		if(shouldFill)
			c.fill = GridBagConstraints.HORIZONTAL;
		
		buttons = new JButton[5];
		
		buttons[0] = new JButton("Button 1");
		if(shouldWeight)
			c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		container.add(buttons[0], c);

		buttons[1] = new JButton("Button 2");
		if(shouldWeight)
			c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		container.add(buttons[1], c);

		buttons[2] = new JButton("Button 3");
		if(shouldWeight)
			c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		container.add(buttons[2], c);

		buttons[3] = new JButton("Button 4");
		if(shouldWeight)
			c.weightx = 0.5;
		c.ipady = 40;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		container.add(buttons[3], c);
		
		buttons[4] = new JButton("Button 5");
		if(shouldWeight)
			c.weightx = 0.5;
		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		container.add(buttons[4], c);
		
	}
			
	public static void main(String[] args) {
		testAWT_5 t5 = new testAWT_5();
		t5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t5.setSize(300, 300);
		t5.pack();
		t5.setVisible(true);
	}
}