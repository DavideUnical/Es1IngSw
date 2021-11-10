package DavideScrivano.Es1IngSwCode;

import java.awt.Color;
import java.awt.Rectangle;

public final class ShapesFactory {
	// final: non è possibile estendere questa classe
	
	// SINGLETON
    private ShapesFactory() {}
    
    private static ShapesFactory instance = null;
    
    public static ShapesFactory getInstance() {
    	if (instance == null) {
            instance = new ShapesFactory();
        }
        return instance;
    }
	
    // METODI FABBRICA
	public Oval makeOval(Color color, boolean isSolid, int x, int y) {
		Rectangle rect = new Rectangle(x, y, 150, 50);
		Oval myOval = new Oval(rect, color, isSolid);
		return myOval;
	}
	
	public Oval makeCircle(Color color, boolean isSolid, int x, int y) {
		Rectangle rect = new Rectangle(x, y, 100, 100);
		Oval myOval = new Oval(rect, color, isSolid);
		return myOval;
	}
	
	public Rectanglar makeRect(Color color, boolean isSolid, int x, int y) {
		Rectangle rect = new Rectangle(x, y, 100, 100);
		Rectanglar myRect = new Rectanglar(rect, color, isSolid);
		return myRect;
	}

}
