//Created by T. Xia

import java.awt.*;
import javax.swing.*;


public class testAWT_1 extends JFrame
{
	private JButton[] buttons;
	private JLabel label1;
	
	public testAWT_1 () {
		super("Flowlayout Demo");
		setLayout(new FlowLayout());
		
		buttons = new JButton[5];
		
		for(int i=0; i<5; i++) {
			buttons[i] = new JButton("Button"+(i+1));
			add(buttons[i]);
		}
		label1 = new JLabel("Name:");
		add(label1);
	}
	
	public static void main(String[] args) {
		testAWT_1 t1 = new testAWT_1();
		t1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t1.setSize(200, 200);
		t1.setVisible(true);
	}
}