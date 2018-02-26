/*
 * here comes the rain again falling to my self like a tragedy
 */
package escuchas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author SYC10
 */
public class Ventana {

    private JFrame ventana;
    private JPanel center;
    private JLabel label, sur;
    private MoverseSolo mov;
    private CenterMouseListener mouseL;
    public Ventana() {
        ventana = new JFrame();
        center = new JPanel();
        label = new JLabel();
        sur = new JLabel();
        mouseL = new CenterMouseListener();
        mov = new MoverseSolo();
        atributos();
        armar();
        mostrar();
    }

    public void atributos() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(640, 480);
        ventana.setTitle("Eventos");
        ventana.setLayout(new BorderLayout());
        label.setText("Practica de eventos");
        center.addMouseListener(mouseL);
        center.addMouseMotionListener(mouseL);
        center.setBackground(Color.red);
    }

    public void armar() {
        
        ventana.add(label, BorderLayout.NORTH);
        ventana.add(center, BorderLayout.CENTER);
        ventana.add(sur, BorderLayout.SOUTH);
    }

    public void mostrar() {
        ventana.setVisible(true);
        //mov.start();
    }

    private void colorRandom() {
        Random r = new Random();
        int red, green, blue;
        red = Math.abs(r.nextInt()) % 256;
        green = Math.abs(r.nextInt()) % 256;
        blue = Math.abs(r.nextInt()) % 256;
        center.setBackground(new Color(red, green, blue));
    }

    private void posicionRandom() {
        int x, y;
        Random r = new Random();
        x = Math.abs(r.nextInt()) % 700;
        y = Math.abs(r.nextInt()) % 700;
        ventana.setLocation(x, y);
    }

    private class CenterMouseListener implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();
            sur.setText("Has clickado tío, coordenadas: (" + p.x + ", " + p.y + " )");
            colorRandom();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            sur.setText("Has presionado tío, coordenadas: (" + p.x + ", " + p.y + " )");
            colorRandom();
            //posicionRandom();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point p = e.getPoint();
            sur.setText("Que lo has soltado ahora tío: (" + p.x + ", " + p.y + ")");
            colorRandom();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Point p = e.getPoint();
            sur.setText("Has entrado en el panel tío: (" + p.x + ", " + p.y + ")");
            colorRandom();
            //posicionRandom();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            sur.setText("Parece que ahora has salido");
            colorRandom();
            //posicionRandom();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            sur.setText("Draggedo tío");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            sur.setText("Moved");
        }
    }

    private class MoverseSolo extends Thread {

        public void run() {
            int x = (ventana.getLocation().x + 2) % 800;
            while (true) {
                x+=2;
                ventana.setLocation(x, (ventana.getLocation().y + 2) % 800);
                try {
                    Thread.sleep(20);
                    
                } catch(Exception ex) {
                    
                }
            }
        }
    }
}
