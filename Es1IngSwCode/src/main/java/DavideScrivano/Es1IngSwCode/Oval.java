package DavideScrivano.Es1IngSwCode;

import java.awt.*;

public class Oval extends Shape {
	private static final long serialVersionUID = 42L;
	
	public Oval(Rectangle rect, Color color, boolean isSolid) {
		super(rect, color, isSolid);
	}
	
	public void draw (Graphics g) {
		g.setColor(color); 
		int x = super.x;
		int y = super.y;
		int width = super.width;
		int height = super.height;
		if (getSolid())
			g.fillOval(x, y, width, height);
		else {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));
			g.drawOval(x, y, width, height);
		} 
	}
}
