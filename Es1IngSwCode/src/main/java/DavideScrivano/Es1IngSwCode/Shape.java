package DavideScrivano.Es1IngSwCode;

import java.awt.*;

public abstract class Shape extends Rectangle {
	private static final long serialVersionUID = 42L;
	
	Color color;
	boolean isSolid;
	static int count = 0; 
	
	public Shape(Rectangle rect, Color color, boolean isSolid) {
		super(rect);
		this.color = color;
		this.isSolid = isSolid;
		count++;
	}
	
	public void setColor(Graphics g) {
		color = g.getColor();
	}
	
	public boolean getSolid() {
		return isSolid;
	}
	
	public int getNoOfShapes() {
		return count;
	}
	
	public abstract void draw (Graphics g);

}
