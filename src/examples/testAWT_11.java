//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class testAWT_11 extends JFrame implements ItemListener
{
	private JLabel label1, label2;
	private JComboBox image;
	private Container container;
	private BorderLayout layout;
	private String[] names;
	private ImageIcon[] icons;

	
	public testAWT_11 () {
		super("Combo Box Demo");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		//Add a label and a combo box to a panel
		JPanel panel = new JPanel(new FlowLayout());
		
		label1 = new JLabel("Select");
		panel.add(label1);
		
		names = new String[4];
		names[0] = "color1.png";
		names[1] = "color2.png";
		names[2] = "color3.png";
		names[3] = "color4.png";
		
		image = new JComboBox<String>(names);
		image.setMaximumRowCount(3);
		
		image.addItemListener(this);
		panel.add(image);
		
		//Add the panel to the north
		container.add(panel, BorderLayout.NORTH);
		
		//Add the image icon label
		icons = new ImageIcon[names.length];
		for(int i=0; i<names.length; i++) {
			icons[i] = new ImageIcon(getClass().getResource(names[i]));
		}
		
		panel = new JPanel(new FlowLayout());
		
		label2 = new JLabel(icons[0]);
		
		panel.add(label2);
		
		container.add(panel, BorderLayout.CENTER);	
	}
	
	//Override
	public void itemStateChanged(ItemEvent event) {
		if(event.getStateChange() == ItemEvent.SELECTED) {
			int i = image.getSelectedIndex();
			label2.setIcon(icons[i]);
		}
	}
			
	public static void main(String[] args) {
		testAWT_11 t11 = new testAWT_11();
		t11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t11.setSize(400, 400);

		t11.setVisible(true);
	}
}