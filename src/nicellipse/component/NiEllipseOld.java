package nicellipse.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NiEllipseOld extends JComponent implements NiBorderedComponent {
	private static final long serialVersionUID = -8346296675140338192L;
	private Color borderColor;
	private Stroke stroke;
	private boolean withBorder;
	private Ellipse2D ellipse;
	private boolean fixedToScreen = false;  // Nouveau champ

	public NiEllipseOld() {
		this.defaultSetup();
		this.ellipse = new Ellipse2D.Double(0, 0, 5, 5);
		this.setBounds(this.ellipse.getBounds());
		this.withBorder = true;
		this.stroke = this.defaultStroke();
		this.borderColor = this.defaultBorderColor();
	}

	public Border defaultBorder() {
		return BorderFactory.createEmptyBorder();
	}

	public void setBounds(int x, int y, int w, int h) {
		super.setBounds(x, y, w, h);
		this.ellipse = new Ellipse2D.Double(0, 0, w, h);
	}
	
	public Shape getClipShape() {
		return this.ellipse;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.clip(this.getClipShape());
		super.paint(g2d);
		g2d.dispose();
	}

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

	public void setFixedToScreen(boolean fixed) {
		this.fixedToScreen = fixed;
	}

	public boolean isFixedToScreen() {
		return fixedToScreen;
	}
}
