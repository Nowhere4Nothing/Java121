//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class testAWT_9 extends JFrame implements ItemListener
{
	private JLabel label;
	private JTextField text;
	private JCheckBox bold;
	private JCheckBox italic;
	private Container container;
	private BorderLayout layout;

	
	public testAWT_9 () {
		super("Checkbox Demo");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		JPanel panel = new JPanel(new FlowLayout());
		
		label = new JLabel("Text:");
		panel.add(label);
		
		text = new JTextField("Hello", 20);
		text.setFont(new Font("Hello", Font.PLAIN, 14));
		panel.add(text);
		
		container.add(panel, BorderLayout.NORTH);

		panel = new JPanel(new FlowLayout());
		
		bold = new JCheckBox("Bold");
		italic = new JCheckBox("Italic");
		
		panel.add(bold);
		panel.add(italic);	
		bold.addItemListener(this);
		italic.addItemListener(this);
		
		container.add(panel, BorderLayout.CENTER);	
	}
	
	//Override
	public void itemStateChanged(ItemEvent event) {
		Font font = null;
		if(bold.isSelected() && italic.isSelected())
			font = new Font("Hello", Font.BOLD + Font.ITALIC, 14);
		else if(bold.isSelected())
			font = new Font("Hello", Font.BOLD, 14);
		else if(italic.isSelected())
			font = new Font("Hello", Font.ITALIC, 14);
		else
			font = new Font("Hello", Font.PLAIN, 14);
		
		text.setFont(font);
	}
			
	public static void main(String[] args) {
		testAWT_9 t9 = new testAWT_9();
		t9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t9.setSize(300, 200);

		t9.setVisible(true);
	}
}