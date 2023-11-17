//Created by T. Xia

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class testAWT_13 extends JFrame implements ActionListener
{
	private JLabel label1, label2;
	private JList<String> color1, color2;
	private DefaultListModel<String> list1, list2;
	private JButton copyTo, copyFrom;
	private Container container;
	private FlowLayout layout;
	private String[] names = {"White", "Black", "Blue", "Cyan", "Gray", "Green"};

	
	public testAWT_13 () {
		super("Multiple List Demo");
		
		container = getContentPane();
		
		layout = new FlowLayout();

		container.setLayout(layout);
		
		//Add a lable and a list, 
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		label1 = new JLabel("Left colors");
		panel.add(label1);
		
		list1 = new DefaultListModel<>();
		for(int i=0; i<names.length; i++)
			list1.addElement(names[i]);
		color1 = new JList<>(list1);
		color1.setVisibleRowCount(5);
		color1.setFixedCellWidth(80);				
		color1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//color1.addListSelectionListener(this);
		panel.add(new JScrollPane(color1));
		
		//Add the panel to the north
		container.add(panel);
		
		//Add two buttons
		copyTo = new JButton("To >>");
		copyTo.addActionListener(this);
		copyFrom = new JButton("From <<");
		copyFrom.addActionListener(this);
		
		panel = new JPanel(new GridLayout(2, 1));
		panel.add(copyTo);
		panel.add(copyFrom);
		
		container.add(panel);
		
		//Add a label and a list
		panel = new JPanel(new GridLayout(2, 1));
		
		label2 = new JLabel("Right colors");
		panel.add(label2);
		
		list2 = new DefaultListModel<>();
		color2 = new JList<>(list2);
		color2.setVisibleRowCount(5);
		color2.setFixedCellWidth(80);		
		color2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//color2.addListSelectionListener(this);
		panel.add(new JScrollPane(color2));
		
		//Add the panel to the north
		container.add(panel);	
	}
	
	//Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == copyTo) {//Copy to
			Object[] elements = color1.getSelectedValuesList().toArray();
			for(int i = 0; i < elements.length; i++)
				if(elements[i] instanceof String) {
					list2.addElement((String)elements[i]);
				}
		}
		else if(event.getSource() == copyFrom) {//Remove from
			Object[] elements = color2.getSelectedValuesList().toArray();
			for(int i = 0; i < elements.length; i++)
				if(elements[i] instanceof String) {
					list1.addElement((String)elements[i]);
					list2.remove(i);
				}
		}
	}
			
	public static void main(String[] args) {
		testAWT_13 t13 = new testAWT_13();
		t13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t13.setSize(500, 400);

		t13.setVisible(true);
	}
}