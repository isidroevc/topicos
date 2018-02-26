/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author SYC10
 */
public class Gato {
    private JFrame ventana;
    private JPanel panelCentral;
    private JButton[][] casillas;
    private JPanel panelInferior;
    private JLabel lblGato;
    private JButton btnSalir;
    private JButton btnJugar;
    private int contador = 1;
    public Gato() {
        ventana = new JFrame("Gato");
        casillas = new JButton[3][3];
        for(int i =0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                casillas[i][j] = new JButton(); 
            }
        }
        panelCentral = new JPanel();
        panelInferior = new JPanel();
        btnSalir = new JButton();
        btnJugar = new JButton();
        lblGato = new JLabel();
        atributos();
        armar();
    }
    
    public void atributos(){
        ventana.setSize(640, 680);
        ventana.setLayout(new BorderLayout());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelCentral.setLayout(new GridLayout(3,3,0,0));
        panelCentral.setSize(640, 480);
        panelInferior.setLayout(null);
        panelInferior.setLayout(new GridLayout(1,2,2,2));
        panelInferior.setSize(640, 100);
        btnSalir.setSize(320, 100);
        btnSalir.setText("Salir");
        btnJugar.setSize(320, 200);
        btnJugar.setText("Jugar");
        lblGato.setText("Gato");
        lblGato.setFont(new Font("Arial", 72, 80));
        lblGato.setAlignmentX(12);
    }
    
    public void armar() {
        ventana.add(lblGato, BorderLayout.NORTH);
        for(int i =0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                casillas[i][j].setBorder(new LineBorder(Color.BLUE));
                panelCentral.add(casillas[i][j], i, j);
                casillas[i][j].addActionListener(new ClickCasilla());
            }
        }
        ventana.add(panelCentral);
        panelInferior.add(btnJugar, 0,0);
        panelInferior.add(btnSalir, 1,0);
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(panelInferior, BorderLayout.SOUTH);
    }
    
    public void mostrar() {
        ventana.setVisible(true);
    }
    
    private class ClickCasilla implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            Graphics g = source.getGraphics();
            g = casillas[0][0].getGraphics();
            g.setColor(Color.BLACK);
            char[] x = {'X'};
            char[] o = {'O'};
            if(contador % 2 == 0)
                //g.drawLine(0, 0, source.getSize().width, source.getSize().height);
                //g.drawChars(x, 0, 0, source.getSize().width, source.getSize().height);
                source.setText("X");
            else 
                //g.drawChars(o, 0, 0, source.getSize().width, source.getSize().height);
                source.setText("O");
            contador++;
        }
    }
}
