//Created by T. Xia

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;



public class testAWT_17 extends JFrame implements KeyListener
{
	private String line1, line2, line3;
	private JTextArea text;
	private Container container;
	private BorderLayout layout;
	
	public testAWT_17 () {
		super("Key handeling");
		
		container = getContentPane();
		
		layout = new BorderLayout();

		container.setLayout(layout);
		
		//Add text area instance
		text = new JTextArea("Press any key on the keyboard", 10,15);
		text.setEnabled(false);
		text.setDisabledTextColor(Color.BLACK);
		
		container.add(text, BorderLayout.CENTER);
		
		addKeyListener(this);
	}
	
	//Override
	public void keyPressed(KeyEvent event) {
		line1 = String.format("Key pressed: %s", KeyEvent.getKeyText(event.getKeyCode()));
		setLines(event);
	}
	
	//Override
	public void keyReleased(KeyEvent event) {
		line1 = String.format("Key released: %s", KeyEvent.getKeyText(event.getKeyCode()));
		setLines(event);
	}

	//Override
	public void keyTyped(KeyEvent event) {
		line1 = String.format("Key typed: %s", KeyEvent.getKeyText(event.getKeyCode()));
		setLines(event);
	}
	
	private void setLines(KeyEvent event) {
		line2 = String.format("This key is %san action key", (event.isActionKey()? "" : "not "));
		
		String str = KeyEvent.getModifiersExText(event.getModifiersEx());
		
		
		line3 = String.format("Modifier key pressed: %s", (str.equals("")? "none" : str));
		
		text.setText(String.format("%s\n%s\n%s\n", line1, line2, line3));
	}

	public static void main(String[] args) {
		testAWT_17 t17 = new testAWT_17();
		t17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t17.setSize(500, 400);

		t17.setVisible(true);
	}
}


