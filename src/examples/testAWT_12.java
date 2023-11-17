//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class testAWT_12 extends JFrame implements ListSelectionListener
{
	private JLabel label1, label2;
	private JList color;
	private Container container;
	private BorderLayout layout;
	private JPanel panel1, panel2;
	private String[] names = {"White", "Black", "Blue", "Cyan", "Gray", "Green"};
	private Color[] colors = {Color.WHITE, Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN};

	
	public testAWT_12 () {
		super("List Demo");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		//Add a label and a combo box to a panel
		panel1 = new JPanel();
		
		label1 = new JLabel("Select color  ");
		panel1.add(label1);
		
		color = new JList<String>(names);
		color.setVisibleRowCount(3);
		
		color.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		color.addListSelectionListener(this);
		panel1.add(new JScrollPane(color));
		
		//Add the panel to the north
		container.add(panel1, BorderLayout.NORTH);
		
		//Add the panel 2 for color
		
		panel2 = new JPanel(new FlowLayout());
		
		label2 = new JLabel("See the background color.");
		
		panel2.add(label2);
		
		container.add(panel2, BorderLayout.CENTER);	
	}
	
	//Override
	public void valueChanged(ListSelectionEvent event) {
		int i = color.getSelectedIndex();
		panel2.setBackground(colors[i]);
	}
			
	public static void main(String[] args) {
		testAWT_12 t12 = new testAWT_12();
		t12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t12.setSize(400, 400);

		t12.setVisible(true);
	}
}