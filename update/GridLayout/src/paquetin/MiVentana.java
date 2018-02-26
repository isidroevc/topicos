/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetin;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author SYC10
 */
public class MiVentana {
    //Declarar
    private int medida;
    private JFrame ventana;
    private JPanel[][] paneles;
    //Constructor
    public MiVentana(int medida) {
        this.medida = medida;
        ventana = new JFrame("Ajedrez");
        this.paneles = new JPanel[medida][medida];
        for(int i =0; i < medida; i++)
            for(int j =0; j < medida; j++)
                paneles[i][j] = new JPanel();
        atributos();
        mostrar();
    }
    
    //Atributos
    public void atributos() {
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(640, 640);
        ventana.setLayout(new GridLayout(medida, medida,0,0));
        for(int i =0; i < medida; i++){
            for(int j =0; j < medida; j++) {
                if( i% 2 == 0) {
                    if(j % 2 != 0)
                        paneles[i][j].setBackground(Color.BLACK);
                } else {
                    if(j % 2 == 0)
                        paneles[i][j].setBackground(Color.BLACK);
                }
                ventana.add(paneles[i][j],i, j);
            }
        }
    }
    //Aramar
    //Mostrar
    public void mostrar() {
        ventana.setVisible(true);
    }
    
    public void random() {
        int i, j, red, green, blue;
        Random r = new Random();
        /*try {
            Thread.sleep(1000);
        } catch(Exception ex) {
            
        }*/
        j = Math.abs(r.nextInt()) % medida;
        i = Math.abs(r.nextInt()) % medida;
        red = Math.abs(r.nextInt()) % 256;
        green = Math.abs(r.nextInt()) % 256;
        blue = Math.abs(r.nextInt()) % 256;
        paneles[i][j].setBackground(new Color(red, green, blue));
    }
}
