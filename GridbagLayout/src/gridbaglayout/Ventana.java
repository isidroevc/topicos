/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gridbaglayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JPanel;

public class Ventana {

    private JFrame ventana;
    private JButton[] botones;
    private JPanel panel;
    private int medida;
    private GridBagLayout bg;
    private GridBagConstraints gbc;
    private int contador;

    public Ventana(int medida) {
        this.medida = medida;
        ventana = new JFrame("");
        panel = new JPanel();
        botones = new JButton[medida];
        for (int i = 0; i < medida; i++) {
            botones[i] = new JButton(Integer.toString((i + 1)));
        }
        atributos();
        armar();
    }

    public void atributos() {
        bg = new GridBagLayout();
        gbc = new GridBagConstraints();
        //gbc.fill = GridBagConstraints.VERTICAL;
        //bg.setConstraints(panel, gbc);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(640, 640);
        panel.setLayout(bg);
    }

    public void armar() {
        Random r = new Random();
        ventana.add(panel);
        for(int i = 0; i < medida; i++) {
         gbc.gridheight = Math.abs(r.nextInt()) % 2 + 1;
         gbc.gridwidth = Math.abs(r.nextInt()) % 2 + 1;;
         gbc.gridx = Math.abs(r.nextInt()) % medida;
         gbc.gridy = Math.abs(r.nextInt()) % medida;
         botones[i].setVisible(false);
         botones[i].setForeground(Color.WHITE);
         //gbc.insets = new Insets(10,10,10,10);
         /*if(i == botones.length -1) {
             gbc.fill = GridBagConstraints.HORIZONTAL;
             gbc.gridx = 0;
             gbc.gridy = i;
             gbc.gridwidth = medida;
         }
         if(i == medida / 2) {
             gbc.gridx = i;
             gbc.gridy = i -1;
             gbc.fill = GridBagConstraints.BOTH;
             gbc.gridheight = 3;
             gbc.gridwidth = 3;
             //i += 2;
         }
         if(i == 0) {
             gbc.fill = GridBagConstraints.VERTICAL;
             gbc.gridheight = medida;
         }*/
         panel.add(botones[i],gbc);
         }

    }

    public void mostrar() {
        ventana.setVisible(true);
    }

    public void random() {
        Random r = new Random();
        int red, green, blue;
        red = Math.abs(r.nextInt()) % 256;
        green = Math.abs(r.nextInt()) % 256;
        blue = Math.abs(r.nextInt()) % 256;
        try {
            Thread.sleep(500);
        } catch (Exception ex) {
        }
        for(int i = 0; i < botones.length; i++) {
            red = Math.abs(r.nextInt()) % 256;
            green = Math.abs(r.nextInt()) % 256;
            blue = Math.abs(r.nextInt()) % 256;
            botones[i].setBackground(new Color(red, green, blue));
        }
        if(contador < botones.length) {
            botones[contador].setVisible(true);
            contador++;
            //ventana.pack();
        }
        
        
    }
}
