//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testAWT_3 extends JFrame
{
	private JButton buttonL;
	private JButton buttonC;
	private JButton buttonR;
	private FlowLayout layout;
	private Container container;
	private JLabel label1;
	
	public testAWT_3 () {
		super("Flowlayout Demo2");
		container = getContentPane();
		layout = new FlowLayout();
		setLayout(layout);
		
		buttonL = new JButton("Left");
		add(buttonL);
		buttonL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.LEFT);
				layout.layoutContainer(container);
			}
		});
		
		buttonC = new JButton("Center");
		add(buttonC);
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.CENTER);
				layout.layoutContainer(container);
			}
		});
		
		buttonR = new JButton("Right");
		add(buttonR);
		buttonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.RIGHT);
				layout.layoutContainer(container);
			}
		});

	}

	
	public static void main(String[] args) {
		testAWT_3 t3 = new testAWT_3();
		t3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t3.setSize(300, 200);
		t3.setVisible(true);
	}
}