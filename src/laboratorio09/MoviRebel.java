/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio09;

import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Leonardo
 */
public class MoviRebel implements KeyListener{
   private JLabel label;
   private Juego juego;
   
   
   
   //DISPARO


    public MoviRebel(JLabel label, Juego juego) {
        this.label = label;
        this.juego = juego;

    }


    public void keyTyped(KeyEvent e) { 
    }


    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        int deltaX = 0;
        int deltaY = 0;

        
        if (key == KeyEvent.VK_W) {
            deltaY = -10;
        } else if (key == KeyEvent.VK_A) {
            deltaX = -10;
        } else if (key == KeyEvent.VK_S) {
            deltaY = 10;
        } else if (key == KeyEvent.VK_D) {
            deltaX = 10;
            
        }else if (key == KeyEvent.VK_SPACE) {
            juego.iniciarDisparo();
      
        }
            

       
        int currentX = label.getX();
        int currentY = label.getY();


        label.setLocation(currentX + deltaX, currentY + deltaY);
    }

  
    public void keyReleased(KeyEvent e) {
        // No es necesario implementar esto
    }
}
