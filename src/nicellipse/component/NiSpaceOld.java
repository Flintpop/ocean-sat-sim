package nicellipse.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NiSpaceOld extends JPanel implements NiBasicComponent {
	private static final long serialVersionUID = -7681440479994731039L;
	private String name;
	
	
	public Color defaultBackground() {
		return Color.white;
	}
	
	public NiSpaceOld(String name, Dimension dim) {
		this.defaultSetup();
		this.name = name;
		this.setPreferredSize(dim);
		this.setLayout(null);
	}
		
	public void openInWindow() {
		JFrame frame = new JFrame(name);
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		frame.addWindowListener(wa);
		frame.getContentPane().setSize(this.getSize());
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		requestFocus();
	}


}