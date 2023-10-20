/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laboratorio09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Leonardo
 */
public class Juego extends javax.swing.JFrame {

    //DISPARO--------------------------
    private int disparoX; // Posición X del disparo
    private int disparoY; // Posición Y del disparo
    //---------------
    
    
    //MOVIMIENTO----------
    private MoviRebel moviRebel;
    //-------------------------
    /**
     * Creates new form Juego
     */
    public Juego() {
        initComponents();
        //MOVIMIENTO---------------------
        
        moviRebel = new MoviRebel(NaveRebelde, this);  
        addKeyListener(moviRebel);  
        setFocusable(true);
        //--------------------------------
        
        //DISPARO----------------
        disparoX = NaveRebelde.getX() + NaveRebelde.getWidth() / 2;  // Inicialmente, la posición X del disparo es en el centro de la NaveRebelde
        disparoY = NaveRebelde.getY();
        //------------------
        
        
        
        
        
        this.setLocationRelativeTo(null);
        
        moverNaveImperioHaciaNaveRebelde();
    }
    


// Método para iniciar el disparo
    public void iniciarDisparo() {
        disparoX = NaveRebelde.getX() + NaveRebelde.getWidth() / 2;
        disparoY = NaveRebelde.getY();
        DisparoRebel.setSize(10, 40);  // Ajusta el tamaño según tus necesidades
        DisparoRebel.setVisible(true);

        // Comienza un bucle para mover el disparo
        Timer timer = new Timer(50, e -> moverDisparo());
        timer.start();
    
    }

    private void moverDisparo() {
        disparoY -= 10;  // Puedes ajustar esta velocidad según lo necesites

        // Mueve el panel del disparo a la nueva posición
        DisparoRebel.setLocation(disparoX, disparoY);

        // Si el disparo ha salido de la pantalla, detén el movimiento y reinicia la posición
        if (disparoY < 0) {
            detenerDisparo();
        }
    }
    
    
    private void moverNaveImperioHaciaNaveRebelde() {
        Timer timer = new Timer(200, new ActionListener() {
            int steps = 20;
            int stepCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                int actualX = NaveImperio.getX();
                int actualY = NaveImperio.getY();
                int destinoX = NaveRebelde.getX();
                int destinoY = NaveRebelde.getY();

                int nuevoX = actualX + (destinoX - actualX) / steps;
                int nuevoY = actualY + (destinoY - actualY) / steps;

                NaveImperio.setLocation(nuevoX, nuevoY);

                stepCount++;

                if (stepCount == steps) {
                    // La NaveImperio ha llegado a la NaveRebelde
                    ImageIcon nuevaImagen = new ImageIcon(getClass().getResource("/Pictures/Explosion.png"));
                    NaveImperio.setIcon(nuevaImagen);
                }
            }
        });
        timer.start();
    }
    
    
    
// Método para detener el disparo
private void detenerDisparo() {
    DisparoRebel.setVisible(false);
    // Puedes reiniciar la posición del disparo o hacer cualquier otra acción necesaria
}
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NaveImperio = new javax.swing.JLabel();
        NaveRebelde = new javax.swing.JLabel();
        DisparoRebel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(540, 810));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NaveImperio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/113-1135381_transparent-tie-fighter-png-tie-fighter-pixel-art_preview_rev_1 (1).png"))); // NOI18N
        jPanel1.add(NaveImperio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        NaveRebelde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/static-assets-upload5379568246909147858_preview_rev_1 (2).png"))); // NOI18N
        jPanel1.add(NaveRebelde, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 700, -1, -1));

        DisparoRebel.setBackground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout DisparoRebelLayout = new javax.swing.GroupLayout(DisparoRebel);
        DisparoRebel.setLayout(DisparoRebelLayout);
        DisparoRebelLayout.setHorizontalGroup(
            DisparoRebelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        DisparoRebelLayout.setVerticalGroup(
            DisparoRebelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(DisparoRebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 730, 10, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/5e650c2211c4fbcc5dee1967fead7f09.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DisparoRebel;
    private javax.swing.JLabel NaveImperio;
    private javax.swing.JLabel NaveRebelde;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}