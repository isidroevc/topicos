/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

/**
 *
 * @author SYC10
 */
public class Ventana {
    private JFrame ventana;
    private JButton[] horizontalAxis;
    private JButton[] verticalAxis;
    private JToggleButton[] random;
    private GridBagConstraints gbc;
    private ChangePosition change;
    private int x, y;
    int randomCount;
    private String[] abecedario = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z").split(" ");
    
    public Ventana(int x, int y, int randomCount) {
        this.x = x;
        this.y = y;
        this.randomCount = randomCount;
        ventana = new JFrame("Excel pero chido");
        change = new ChangePosition();
        horizontalAxis = new JButton[x];
        verticalAxis = new JButton[y];
        random = new JToggleButton[randomCount];
        gbc = new GridBagConstraints();
         for(int i = 0; i < x; i++) {
            horizontalAxis[i] = new JButton();
        }
         for(int i = 0; i < y; i++) {
            verticalAxis[i] = new JButton();
        }
         for(int i = 0; i < randomCount; i++) {
           random[i] = new JToggleButton();
        }
        atributos();
        armar();
        mostrar();
        
    }
    
    public void atributos() {
        ventana.setSize(640, 480);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridBagLayout());
        
    }
    
    public void armar() {
        //icpc.baylor.edu
        //urionline 
        for(int i = 0; i < x; i++) {
            gbc.gridx = i + 1;
            gbc.gridy = 0;
            //horizontalAxis[i].setText( "" + (char)('a' + i));
            horizontalAxis[i].setIcon(new ImageIcon(Ventana.class.getResource("si.png")));
            ventana.add(horizontalAxis[i], gbc);
        }
        for(int i = 0; i < y; i++) {
            gbc.gridx = 0;
            gbc.gridy = i +1;
            verticalAxis[i].setText(Integer.toString(i + 1));
            ventana.add(verticalAxis[i], gbc);
        }
    }
    
    public void mostrar() {
        ventana.setVisible(true);
        ventana.pack();
        change.start();
    }
    
    public void random() {
        Random r = new Random();
        int i, j, red ,green ,blue, k, heigth, width;
        int h,w;
        i = Math.abs(r.nextInt()) % (x -1) + 2;
        j = Math.abs(r.nextInt()) % (y -1) + 2;
        red = Math.abs(r.nextInt()) % 256;
        green = Math.abs(r.nextInt()) % 256;
        blue = Math.abs(r.nextInt()) % 256;
        k = Math.abs(r.nextInt()) % randomCount;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = i;
        gbc.gridy = j;
        gbc.gridheight = i;
        gbc.gridwidth = j;
        heigth = Math.abs(r.nextInt()) % 800 + 200;
        width = Math.abs(r.nextInt()) % 800 + 200;
        
        random[k].setBackground(new Color(red, green, blue));
        ventana.add(random[k], gbc);
        //ventana.setSize(width, heigth);
        ventana.pack();
        try { Thread.sleep(100);} catch(Exception ex) {};
    }
    
    class ChangePosition extends Thread {
        public ChangePosition() {
            
        }
        
       public void run() {
           while(true) {
               int xl, yl;
               Random r = new Random();
               xl = Math.abs(r.nextInt()) % 500;
               yl = Math.abs(r.nextInt()) % 500;
               ventana.setLocation(xl, yl);
           try { Thread.sleep(500);} catch(Exception ex) {};
           }
           
       }
    }
}
