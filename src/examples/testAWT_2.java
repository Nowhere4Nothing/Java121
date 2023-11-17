//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testAWT_2 extends JFrame implements ActionListener
{
	private JButton[] buttons;
	private String[] names = {"Hide North", "Hide South", "Hide East", "Hide West", "Hide Center"};
	private BorderLayout layout;
	
	public testAWT_2 () {
		super("Borderlayout Demo");
		layout = new BorderLayout(5,5);
		setLayout(layout);
		
		buttons = new JButton[names.length];
		
		for(int i=0; i<names.length; i++) {
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);
		}
		
		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.EAST);
		add(buttons[3], BorderLayout.WEST);
		add(buttons[4], BorderLayout.CENTER);
	}
	
	//Override
	public void actionPerformed(ActionEvent event) {
		for(JButton button:buttons) {
			if(event.getSource() == button)
				button.setVisible(false); //Hide the button
			else
				button.setVisible(true); //Show the button
		}
		layout.layoutContainer(getContentPane()); //Lay out content pane
	}
	
	public static void main(String[] args) {
		testAWT_2 t2 = new testAWT_2();
		t2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t2.setSize(300, 300);
		t2.setVisible(true);
	}
}