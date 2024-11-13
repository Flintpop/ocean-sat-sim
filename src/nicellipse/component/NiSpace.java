package nicellipse.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NiSpace extends JPanel implements NiBasicComponent {
	private static final long serialVersionUID = -7681440479994731039L;
	private final String name;
	public JFrame frame;

	public Color defaultBackground() {
		return Color.white;
	}

	public NiSpace(String name, Dimension dim) {
		this.defaultSetup();
		this.name = name;
		this.setPreferredSize(dim);
		this.setLayout(null);
	}

	@Override
	public Component add(Component comp) {
		if (comp instanceof NiFixedComponent && ((NiFixedComponent) comp).isFixedToScreen()) {
			Point screenPos = comp.getLocation();
			SwingUtilities.convertPointToScreen(screenPos, this);
			((NiFixedComponent) comp).setScreenPosition(screenPos);

			comp.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentMoved(ComponentEvent e) {
					updateFixedComponentPosition((NiFixedComponent) comp);
				}
			});
		}
		return super.add(comp);
	}

	private void updateFixedComponentPosition(NiFixedComponent comp) {
		if (frame != null && frame.isVisible()) {
			Point screenPos = comp.getScreenPosition();
			if (screenPos != null) {
				Point windowPoint = new Point(screenPos);
				SwingUtilities.convertPointFromScreen(windowPoint, this);

				Rectangle bounds = getBounds();
				Rectangle compBounds = new Rectangle(windowPoint.x, windowPoint.y,
					((Component)comp).getWidth(), ((Component)comp).getHeight());

				((Component)comp).setVisible(bounds.intersects(compBounds));
				if (bounds.intersects(compBounds)) {
					((Component)comp).setLocation(windowPoint.x, windowPoint.y);
				}
			}
		}
	}

	public void openInWindow() {
		frame = new JFrame(name);
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				updateAllFixedComponents();
			}

			@Override
			public void componentResized(ComponentEvent e) {
				updateAllFixedComponents();
			}
		});

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
		updateAllFixedComponents();
	}

	private void updateAllFixedComponents() {
		for (Component comp : getComponents()) {
			if (comp instanceof NiFixedComponent && ((NiFixedComponent) comp).isFixedToScreen()) {
				updateFixedComponentPosition((NiFixedComponent) comp);
			}
		}
	}
}
