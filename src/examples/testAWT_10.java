//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class testAWT_10 extends JFrame implements ItemListener
{
	private JLabel label;
	private JTextField text;
	private JRadioButton bold;
	private JRadioButton italic;
	private JRadioButton plain;
	private JRadioButton bolditalic;
	private ButtonGroup radioGroup;
	private Container container;
	private BorderLayout layout;

	
	public testAWT_10 () {
		super("Radio Button Demo");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		//Add a label and a text field to a panel
		JPanel panel = new JPanel(new FlowLayout());
		
		label = new JLabel("Text:");
		panel.add(label);
		
		text = new JTextField("Hello", 20);
		text.setFont(new Font("Hello", Font.PLAIN, 14));
		panel.add(text);
		
		//Add the panel to the north
		container.add(panel, BorderLayout.NORTH);
		
		//Add the radio buttons
		panel = new JPanel(new FlowLayout());
		
		plain = new JRadioButton("Plain", true);
		bold = new JRadioButton("Bold", false);
		italic = new JRadioButton("Italic", false);
		bolditalic = new JRadioButton("Bold & Italic", false);
		
		panel.add(plain);
		panel.add(bold);
		panel.add(italic);	
		panel.add(bolditalic);

		//Add item listener
		plain.addItemListener(this);		
		bold.addItemListener(this);
		italic.addItemListener(this);
		bolditalic.addItemListener(this);
		
		//Put radio buttons in a group
		radioGroup = new ButtonGroup();
		radioGroup.add(plain);
		radioGroup.add(bold);
		radioGroup.add(italic);
		radioGroup.add(bolditalic);
		
		container.add(panel, BorderLayout.CENTER);	
	}
	
	//Override
	public void itemStateChanged(ItemEvent event) {
		Font font = null;
		if(plain.isSelected())
			font = new Font("Hello", Font.PLAIN, 14);
		else if(bold.isSelected())
			font = new Font("Hello", Font.BOLD, 14);
		else if(italic.isSelected())
			font = new Font("Hello", Font.ITALIC, 14);
		else
			font = new Font("Hello", Font.BOLD + Font.ITALIC, 14);
		
		text.setFont(font);
	}
			
	public static void main(String[] args) {
		testAWT_10 t10 = new testAWT_10();
		t10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t10.setSize(400, 200);

		t10.setVisible(true);
	}
}