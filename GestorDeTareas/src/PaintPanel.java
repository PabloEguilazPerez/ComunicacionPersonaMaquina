import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

// Req (4;3) Implementar un PaintPanel extendiendo JPanel 
public class PaintPanel extends JPanel {
    private List<Point> puntos = new ArrayList<>();

    public PaintPanel() {
        this.setBackground(Color.WHITE);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));

        // Req (4;4) Permitir dibujo interactivo mediante eventos del ratón 
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                puntos.add(e.getPoint()); // Guardamos la posición del ratón
                repaint(); // Forzamos al panel a redibujarse
            }
        });
    }

    // Req (4;3) Sobrescribir el método paint para renderizar figuras 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        
        // Dibujamos la línea uniendo los puntos
        for (int i = 1; i < puntos.size(); i++) {
            Point p1 = puntos.get(i - 1);
            Point p2 = puntos.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        
        // Ejemplo de figura geométrica fija (Requisito extra de Req 4;3) 
        g.setColor(Color.RED);
        g.drawRect(5, 5, 20, 20); // Un pequeño cuadrado decorativo
        g.fillOval(25, 25, 10, 10);
    }
    
    public void limpiar() {
        puntos.clear();
        repaint();
    }
}