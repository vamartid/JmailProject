/*
 * License Copyright © 2000 Vasileios Martidis vamartid@yandex.com 
 * This work is free. You can redistribute it and/or modify it under
 *  the terms of the Do What The Fuck You Want To Public License,
 *  Version 2, as published by Sam Hocevar.
 *  See http://www.wtfpl.net/ for more details.
 */
package vamartid.test1._email;

import java.awt.Frame;
import javax.swing.JFrame;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static vamartid.test1._email.MY_socket_CLIENT.PORT;

/**
 *
 * @author basilism
 */
public class Z_menu extends javax.swing.JFrame {

    int xmouse;
    int ymouse;
    private Socket SOCK;

    /**
     * 
     * @throws IOException  ___
     */
    public Z_menu() throws IOException {
        this.SOCK = new Socket("localhost", PORT);
        initComponents();
    }
    /**
     * 
     * @param a ___
     * @throws IOException  ___
     */
    public Z_menu(Socket a) throws IOException {
        this.SOCK = a;//
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        min1 = new javax.swing.JButton();
        close = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        singin = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        dragable = new javax.swing.JLabel();
        backround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(302, 342));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        min1.setToolTipText("Σμίκρυνση παραθύρου");
        min1.setBorder(null);
        min1.setBorderPainted(false);
        min1.setContentAreaFilled(false);
        min1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min1.setFocusPainted(false);
        min1.setPreferredSize(new java.awt.Dimension(32, 9));
        min1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                min1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                min1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                min1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                min1MouseReleased(evt);
            }
        });
        min1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                min1ActionPerformed(evt);
            }
        });
        getContentPane().add(min1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 0, 47, 32));

        close.setToolTipText("Κλείσιμο παραθύρου");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeMouseReleased(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 0, 47, 32));

        login.setToolTipText("Σύνδεση με υπάρχων λογαριασμό");
        login.setBorder(null);
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.setFocusPainted(false);
        login.setPreferredSize(new java.awt.Dimension(32, 9));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginMouseReleased(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 162, 102, 36));

        singin.setToolTipText("Δημιουργία νέου λογαριασμού");
        singin.setBorder(null);
        singin.setBorderPainted(false);
        singin.setContentAreaFilled(false);
        singin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        singin.setFocusPainted(false);
        singin.setPreferredSize(new java.awt.Dimension(32, 9));
        singin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                singinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                singinMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                singinMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                singinMouseReleased(evt);
            }
        });
        singin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singinActionPerformed(evt);
            }
        });
        getContentPane().add(singin, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 214, 120, 40));

        exit.setToolTipText("Έξοδος απο το JavaMail");
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.setPreferredSize(new java.awt.Dimension(32, 9));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitMouseReleased(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 270, 74, 40));

        dragable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragableMouseDragged(evt);
            }
        });
        dragable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragableMousePressed(evt);
            }
        });
        getContentPane().add(dragable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 32));

        backround.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        backround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vamartid/test1/images/menu.png"))); // NOI18N
        backround.setRequestFocusEnabled(false);
        getContentPane().add(backround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 302, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

        this.dispose();
        new Z_login(SOCK).setVisible(true); // Main Form to show after the Login Form..

    }//GEN-LAST:event_loginActionPerformed

    private void singinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singinActionPerformed
        this.dispose();
        new Z_singup(SOCK).setVisible(true); // Main Form to show after the Login Form..

    }//GEN-LAST:event_singinActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void min1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_min1ActionPerformed
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_min1ActionPerformed

    private void closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseReleased
        // TODO add your handling code here:
        close.setIcon(null);

        MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
        try {
            CLIENT.send_orders("exit", SOCK);
        } catch (Exception ex) {
            Logger.getLogger(Z_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_closeMouseReleased

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/xB.png"));
        close.setIcon(II);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        // TODO add your handling code here:
        close.setIcon(null);

    }//GEN-LAST:event_closeMouseExited

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/xA.png"));
        close.setIcon(II);
    }//GEN-LAST:event_closeMousePressed

    private void min1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/B.png"));
        min1.setIcon(II);
    }//GEN-LAST:event_min1MouseEntered

    private void min1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseExited
        // TODO add your handling code here:
        min1.setIcon(null);

    }//GEN-LAST:event_min1MouseExited

    private void min1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseReleased
        // TODO add your handling code here:
        min1.setIcon(null);

    }//GEN-LAST:event_min1MouseReleased

    private void min1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/C.png"));
        min1.setIcon(II);
    }//GEN-LAST:event_min1MousePressed

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/lB.png"));
        login.setIcon(II);
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        // TODO add your handling code here:
        login.setIcon(null);
    }//GEN-LAST:event_loginMouseExited

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/lC.png"));
        login.setIcon(II);
    }//GEN-LAST:event_loginMousePressed

    private void loginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseReleased
        // TODO add your handling code here:
        login.setIcon(null);

    }//GEN-LAST:event_loginMouseReleased

    private void singinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singinMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/sB.png"));
        singin.setIcon(II);
    }//GEN-LAST:event_singinMouseEntered

    private void singinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singinMouseExited
        // TODO add your handling code here:
        singin.setIcon(null);
    }//GEN-LAST:event_singinMouseExited

    private void singinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singinMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/sC.png"));
        singin.setIcon(II);
    }//GEN-LAST:event_singinMousePressed

    private void singinMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singinMouseReleased
        // TODO add your handling code here:
        singin.setIcon(null);

    }//GEN-LAST:event_singinMouseReleased

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/eB.png"));
        exit.setIcon(II);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        exit.setIcon(null);

    }//GEN-LAST:event_exitMouseExited

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/eC.png"));
        exit.setIcon(II);
    }//GEN-LAST:event_exitMousePressed

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        // TODO add your handling code here:
        exit.setIcon(null);

    }//GEN-LAST:event_exitMouseReleased

    private void dragableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragableMousePressed
        xmouse = evt.getX();

        ymouse = evt.getY();


    }//GEN-LAST:event_dragableMousePressed

    private void dragableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragableMouseDragged
        int x = evt.getXOnScreen();

        int y = evt.getYOnScreen();

//System.out.println(x+" "+y);
        this.setLocation(x - xmouse, y - ymouse);

    }//GEN-LAST:event_dragableMouseDragged

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Z_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Z_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Z_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Z_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Z_menu().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Z_menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backround;
    private javax.swing.JLabel close;
    private javax.swing.JLabel dragable;
    private javax.swing.JButton exit;
    private javax.swing.JButton login;
    private javax.swing.JButton min1;
    private javax.swing.JButton singin;
    // End of variables declaration//GEN-END:variables
}
