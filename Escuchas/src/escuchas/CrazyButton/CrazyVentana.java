/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escuchas.CrazyButton;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author SYC10
 */
public class CrazyVentana {

    private JFrame ventana;
    private JButton boton, boton2;
    private JButton botones[];
    private JPanel panel;
    private int puntos;
    private int attempts;
    private int h, w, nbotones;
    private Sinusoidal sin;
    

    public CrazyVentana(int w, int h, int nbotones) {
        this.nbotones = nbotones;
        this.h = h;
        this.w = w;
        ventana = new JFrame("Crazy ventana");
        boton = new JButton("Aceptar");
        boton2 = new JButton("Aceptar 2");
        panel = new JPanel();
        sin = new Sinusoidal();
        botones = new  JButton[nbotones];
        for(int i = 0; i < nbotones; i++) {
            botones[i] = new JButton("Aceptar " + Integer.toString(i));
        }
        atributos();
        armar();
        escuchas();
        mostrar();
    }

    public void atributos() {
        ventana.setSize(w, h);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        panel.setLayout(null);

        boton2.setSize(100, 50);
        boton.setLocation(0, 0);
        boton.setLocation(150, 150);
    }

    public void armar() {
        
        for(int i = 0; i < nbotones; i++) {
            botones[i].setSize(100, 50);
            botones[i].setLocation(100 * i, 50 * i);
            botones[i].addMouseListener(new Escucha(botones[i]));
            panel.add(botones[i]);
        }
        //panel.add(boton);
        ventana.add(panel);
    }

    public void mostrar() {
        ventana.setVisible(true);
        sin.run();
    }

    private void escuchas() {
        this.boton.addMouseListener(new Escucha(boton));
    }

    private class Escucha implements MouseListener {
        private JButton b;
        public Escucha(JButton b) {
            this.b = b;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
            puntos++;
            ventana.setTitle("Crazy Button Points: " + puntos);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Random r = new Random();
            int x, y, z;
            x = Math.abs(r.nextInt()) % (w - 100);
            y = Math.abs(r.nextInt()) % (h - 50);

            b.setLocation(x, y);

            x = Math.abs(r.nextInt()) % 256;
            y = Math.abs(r.nextInt()) % 256;
            z = Math.abs(r.nextInt()) % 256;

            panel.setBackground(new Color(x, y, z));

            x = Math.abs(r.nextInt()) % 256;
            y = Math.abs(r.nextInt()) % 256;
            z = Math.abs(r.nextInt()) % 256;
            b.setBackground(new Color(x, y, z));

            attempts++;
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Sinusoidal extends Thread {

        public void run() {
            while (true) {
                int x, y, alt;
                Point location = ventana.getLocation();
                x = (location.x + 2) % 800;
                y = (int) Math.abs((300 * Math.sin(0.5 * x / Math.PI)));
                alt = (int) (h * Math.sin(x));
                ventana.setLocation(x, y);
                //ventana.setSize(w, alt);
                try {
                    Thread.sleep(50);
                } catch (Exception ex) {
                }
            }
        }
    }
}
