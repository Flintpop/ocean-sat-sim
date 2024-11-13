package nicellipse.component;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.SwingUtilities;

public class NiRectangle extends JPanel implements NiBorderedComponent, NiFixedComponent {
	private static final long serialVersionUID = 128422045550852289L;
	private boolean fixedToScreen = false;
	private Point screenPosition;

	public NiRectangle() {
		this.defaultSetup();
		this.setDimension(new Dimension(20,20));
		this.setLayout(null);
	}

	@Override
	public boolean isFixedToScreen() {
		return fixedToScreen;
	}

	@Override
	public Point getScreenPosition() {
		return screenPosition;
	}

	@Override
	public void setScreenPosition(Point p) {
		this.screenPosition = p;
	}

	public void setFixedToScreen(boolean fixed) {
		this.fixedToScreen = fixed;
		if (fixed && isShowing()) {
			screenPosition = getLocation();
			SwingUtilities.convertPointToScreen(screenPosition, getParent());
		}
	}
}