package DavideScrivano.Es1IngSwCode;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Main {
	
	private static Color getColor(String color) {
		if(color.equals("Rosso"))
			return Color.RED;
		else if (color.equals("Blu"))
			return Color.BLUE;
		else if (color.equals("Giallo"))
			return Color.YELLOW;
		else if(color.equals("Verde"))
			return Color.GREEN;
		else if(color.equals("Arancione"))
			return Color.ORANGE;
		else if(color.equals("Magenta"))
			return Color.MAGENTA;
		return Color.BLACK;
	}
	
    public static void main(String[] args) {
   
        // Pannello delle opzioni
    	GridLayout grid = new GridLayout(2,3);
        JPanel panel1 = new JPanel(grid);
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        grid.setHgap(20);
        grid.setVgap(20);
        
        // Labels
        panel1.add(new JLabel("Tipo della forma"));
        panel1.add(new JLabel("Riempimento"));
        panel1.add(new JLabel("Colore"));
        //panel1.add(new JLabel("Width"));
        //panel1.add(new JLabel("Height"));
        //panel1.add(new JLabel("x coordinate"));
        //panel1.add(new JLabel("y coordinate"));
       
        // Opzioni
        String[] shapeType = {"Ovale", "Rettangolo", "Cerchio"};
        JComboBox<String> shapeDD = new JComboBox<>(shapeType);
        panel1.add(shapeDD);
        
        String[] fillType = {"Pieno", "Vuoto"};
        JComboBox<String> fillDD = new JComboBox<>(fillType);
        panel1.add(fillDD);
        
        String[] colors = {"Nero", "Rosso", "Arancione", "Giallo", "Verde", "Blu", "Magenta"};
        JComboBox<String> colorDD = new JComboBox<>(colors);
        panel1.add(colorDD);
        
        /*
        JTextField widthTF = new JTextField();
        panel1.add(widthTF);
        JTextField heightTF = new JTextField();
        panel1.add(heightTF);
        JTextField xTF = new JTextField();
        panel1.add(xTF);
        JTextField yTF = new JTextField();
        panel1.add(yTF);
        */
        
        // Area del disegno
        JPanel panel2 = new JPanel();
        //panel2.setPreferredSize(new Dimension(220, 240));
        panel2.setBorder(new TitledBorder("Area di disegno "));         
        Drawing d = new Drawing();
        panel2.add(d);
        panel2.setVisible(true);
        
        // Unione delle due aree
        JPanel panel3 = new JPanel();   
        panel3.setLayout(new BorderLayout());
        panel3.add(panel1, BorderLayout.PAGE_START);
        panel3.add(panel2, BorderLayout.CENTER);
        
        // Instanziazione della fabbrica
        ShapesFactory shapesFactory = ShapesFactory.getInstance();
        
        // Pulsante
        JButton b = new JButton("Disegna");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	 try {
                     String shape = String.valueOf(shapeDD.getSelectedItem());
                     String fill = String.valueOf(fillDD.getSelectedItem());
                     boolean isSolid = false;
                     if (fill.equals("Pieno")) isSolid = true;  
                     else isSolid = false;
                     String colorStr = String.valueOf(colorDD.getSelectedItem());
                     Color color = getColor(colorStr);
                     /*int width = Integer.parseInt(widthTF.getText());
                     int height = Integer.parseInt(heightTF.getText());
                     int x = Integer.parseInt(xTF.getText());
                     int y = Integer.parseInt(yTF.getText());
                     */
                     
                     // USO dell'ABSTRACT FACTORY
                     if (shape.equals("Rettangolo")) {
                    	 // Factory Method
                    	 Shape myRect = shapesFactory.makeRect(color, isSolid, 20, 10);
                    	 d.drawShape(myRect);              	
                     } else if (shape.equals("Ovale")) {
                    	 // Factory Method
                    	 Shape myOval = shapesFactory.makeOval(color, isSolid, 20, 10);
                    	 d.drawShape(myOval);
                     } else if (shape.equals("Cerchio")) {
                    	 // Factory Method
                    	 Shape myCircle = shapesFactory.makeCircle(color, isSolid, 20, 10);
                    	 d.drawShape(myCircle);
                     } else
                         throw new Exception();
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "Error input.");
                 }
            }
        });

        class MousePressListener implements MouseListener{
            public void mousePressed(MouseEvent event){
                int x = event.getX() ; 
                int y = event.getY() ;
                // REDO
                try {
                    String shape = String.valueOf(shapeDD.getSelectedItem());
                    String fill = String.valueOf(fillDD.getSelectedItem());
                    boolean isSolid = false;
                    if (fill.equals("Pieno")) isSolid = true;  
                    else isSolid = false;
                    String colorStr = String.valueOf(colorDD.getSelectedItem());
                    Color color = getColor(colorStr);
                    /*int width = Integer.parseInt(widthTF.getText());
                    int height = Integer.parseInt(heightTF.getText());
                    int x = Integer.parseInt(xTF.getText());
                    int y = Integer.parseInt(yTF.getText());
                    */
                    
                    // USO dell'ABSTRACT FACTORY
                    if (shape.equals("Rettangolo")) {
                   	 // Factory Method
                   	 Shape myRect = shapesFactory.makeRect(color, isSolid, x, y);
                   	 d.drawShape(myRect);              	
                    } else if (shape.equals("Ovale")) {
                   	 // Factory Method
                   	 Shape myOval = shapesFactory.makeOval(color, isSolid, x, y);
                   	 d.drawShape(myOval);
                    } else if (shape.equals("Cerchio")) {
                   	 // Factory Method
                   	 Shape myCircle = shapesFactory.makeCircle(color, isSolid, x, y);
                   	 d.drawShape(myCircle);
                    } else
                        throw new Exception();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error input.");
                }
                
            }

            public void mouseReleased(MouseEvent event){}
            public void mouseClicked(MouseEvent event){}
            public void mouseEntered(MouseEvent event){}
            public void mouseExited(MouseEvent event){}
        }

        MousePressListener mListener = new MousePressListener();
        panel2.addMouseListener(mListener);
        
        JPanel panel4 = new JPanel();
        panel4.add(b);
      
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(panel3);
        panel.add(panel4);
        
        // FINESTRA
    	JFrame frame = new JFrame("Esercizio 1 - INGSW di Davide Scrivano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);  
        frame.setSize(1000, 600);  
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);  
        
        // LOOK AND FEEL
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException |
				 IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
     
    }
}
