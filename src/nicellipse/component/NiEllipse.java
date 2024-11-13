package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class NiEllipse extends JComponent implements NiBorderedComponent, NiFixedComponent {
	private static final long serialVersionUID = -8346296675140338192L;
	Color borderColor;
	Stroke stroke;
	boolean withBorder;
	private Ellipse2D ellipse;
	private boolean fixedToScreen = false;
	private Point screenPosition;
	private boolean isMoving = false;

	@Override
	public void setLocation(int x, int y) {
		if (isMoving)
			return;
		isMoving = true;
		super.setLocation(x, y);
		if (fixedToScreen && isShowing()) {
			screenPosition = new Point(x, y);
			SwingUtilities.convertPointToScreen(screenPosition, getParent());
		}
		isMoving = false;
		repaint();
	}

	@Override
	public void setLocation(Point p) {
		setLocation(p.x, p.y);
	}

	public boolean isMoving() {
		return isMoving;
	}

	@Override
	public Border defaultBorder() {
		return BorderFactory.createEmptyBorder();
	}

	@Override
	public void setBounds(int x, int y, int w, int h) {
		super.setBounds(x, y, w, h);
		this.ellipse = new Ellipse2D.Double(0, 0, w, h);
	}

	public Shape getClipShape() {
		return this.ellipse;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.clip(this.getClipShape());
		super.paint(g2d);
		g2d.dispose();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(this.getBackground());
		super.paintComponent(g2d);
		g2d.fill(ellipse);
		if (this.withBorder) {
			g2d.setColor(this.borderColor);
			g2d.setStroke(this.stroke);
			g2d.draw(this.ellipse);
		}
		g2d.dispose();
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public void setStrokeWidth(float w) {
		this.setStroke(new BasicStroke(w, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	}

	public void setWithBorder(Boolean withBorder) {
		this.withBorder = withBorder;
	}

	public Boolean containsPoint(Point p) {
		return this.ellipse.contains(p);
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