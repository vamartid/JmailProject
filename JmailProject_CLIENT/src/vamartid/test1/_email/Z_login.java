/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vamartid.test1._email;

import java.awt.List;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static vamartid.test1._email.MY_socket_CLIENT.PORT;

/**
 *
 * @author basilism
 */
public class Z_login extends javax.swing.JFrame {

    int xmouse;
    int ymouse;
String pass = "";
Socket SOCK =null;
    /**
     * 
     * @param a  ___
     */
    public Z_login(Socket a) {
        SOCK=a;
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

        close = new javax.swing.JLabel();
        min1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        wor1 = new javax.swing.JLabel();
        wor2 = new javax.swing.JLabel();
        wor = new javax.swing.JLabel();
        dragable = new javax.swing.JLabel();
        backround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(302, 342));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        back.setToolTipText("Μετάβαση στο αρχικό μενού");
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.setFocusPainted(false);
        back.setPreferredSize(new java.awt.Dimension(32, 9));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backMouseReleased(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 47, 32));

        username.setColumns(1);
        username.setFont(new java.awt.Font("Calibri Light", 0, 26)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText(" Enter your username");
        username.setToolTipText("Εισαγωγή username");
        username.setBorder(null);
        username.setName(""); // NOI18N
        username.setOpaque(false);
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 183, 240, 30));

        password.setColumns(1);
        password.setFont(new java.awt.Font("Calibri Light", 0, 26)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText(" Enter your password");
        password.setToolTipText("Εισαγωγή κωδικού πρόσβασης");
        password.setBorder(null);
        password.setName(""); // NOI18N
        password.setOpaque(false);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 231, 240, 30));

        send.setToolTipText("Σύνδεση");
        send.setBorder(null);
        send.setBorderPainted(false);
        send.setContentAreaFilled(false);
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        send.setFocusPainted(false);
        send.setPreferredSize(new java.awt.Dimension(32, 9));
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sendMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sendMouseReleased(evt);
            }
        });
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        getContentPane().add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 282, 104, 40));

        wor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                wor1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                wor1MouseExited(evt);
            }
        });
        getContentPane().add(wor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 103, 250, 70));

        wor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                wor2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                wor2MouseExited(evt);
            }
        });
        getContentPane().add(wor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 109, 250, 70));

        wor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                worMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                worMouseExited(evt);
            }
        });
        getContentPane().add(wor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 250, 70));

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
        backround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vamartid/test1/images/login.png"))); // NOI18N
        backround.setRequestFocusEnabled(false);
        backround.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backroundMouseEntered(evt);
            }
        });
        getContentPane().add(backround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 302, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseReleased
        // TODO add your handling code here:
                MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
                    try {
                        //Socket SOCK = new Socket("localhost", PORT);
                        CLIENT.send_orders("exit",SOCK);
                    } catch (IOException ex) {
                        Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
                    }
        System.exit(0);
    }//GEN-LAST:event_closeMouseReleased

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        wor1.setIcon(null);
        String u = username.getText();
        String p = pass;
        //Steile to u kai to p ston Server
        //Dexou mia boolean
        
        //JmailHelp a = new JmailHelp();
        //a.login_compare(u, p);
        int k = 0;
        //if (!(a.login_compare(u, p))) {
        int done=150;
        MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
        try {
            CLIENT.send_orders("login",SOCK);
            //System.out.println("I sent the login order and i am going to send the U&P");
            
            done=CLIENT.login(u,p,SOCK) ;
            //System.out.println("I sent the U&P");
        } catch (IOException ex) {
            Logger.getLogger(Z_login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Z_login.class.getName()).log(Level.SEVERE, null, ex);
        }        
        if (done==0) {
            //not
            ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/images/not.png"));
            wor.setIcon(II);
            k = 0;
            //sleep
        } else if(done==1) {
            //yes
            ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/images/yest.png"));
            wor1.setIcon(II);

            k = 1;
        } else if(done==2) {
            //logged in already
            ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/images/not2.png"));
            wor2.setIcon(II);
        }
        if (k == 1) {
            dodashit(u);
        }

    }//GEN-LAST:event_sendActionPerformed

    private void dodashit(String u) {
        this.dispose();
        Z_user a = new Z_user(u,SOCK);
        a.setVisible(true);

    }

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void min1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_min1ActionPerformed
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_min1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        try {
            new Z_menu(SOCK).setVisible(true); // Main Form to show after the Login Form..
        } catch (IOException ex) {
            Logger.getLogger(Z_login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_backActionPerformed

    private void sendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/lB.png"));
        send.setIcon(II);
    }//GEN-LAST:event_sendMouseEntered

    private void sendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseExited
        // TODO add your handling code here:
        send.setIcon(null);

    }//GEN-LAST:event_sendMouseExited

    private void sendMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/lC.png"));
        send.setIcon(II);
    }//GEN-LAST:event_sendMousePressed

    private void sendMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseReleased
        // TODO add your handling code here:
        send.setIcon(null);

    }//GEN-LAST:event_sendMouseReleased

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/xA.png"));
        close.setIcon(II);

    }//GEN-LAST:event_closeMousePressed

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        // TODO add your handling code here:
        close.setIcon(null);

    }//GEN-LAST:event_closeMouseExited

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/xB.png"));
        close.setIcon(II);
    }//GEN-LAST:event_closeMouseEntered

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

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/B.png"));
        back.setIcon(II);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setIcon(null);

    }//GEN-LAST:event_backMouseExited

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/C.png"));
        back.setIcon(II);
    }//GEN-LAST:event_backMousePressed

    private void backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseReleased
        // TODO add your handling code here:
        back.setIcon(null);

    }//GEN-LAST:event_backMouseReleased

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        if (password.getText().equals(" Enter your password")) {
            password.setText("");
        }
        wor.setIcon(null);
        wor2.setIcon(null);
        wor1.setIcon(null);
    }//GEN-LAST:event_passwordFocusGained

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        // TODO add your handling code here:
        if (username.getText().equals(" Enter your username")) {
            username.setText("");
        }
        wor.setIcon(null);
        wor2.setIcon(null);
        wor1.setIcon(null);
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // TODO add your handling code here:
        if (username.getText().equals("")) {
            username.setText(" Enter your username");
        }
    }//GEN-LAST:event_usernameFocusLost

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().equals("")) {
            password.setText(" Enter your password");
        }
    }//GEN-LAST:event_passwordFocusLost

    private void backroundMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backroundMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_backroundMouseEntered

    private void worMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_worMouseEntered
        // TODO add your handling code here:
        //wor.setIcon(null);
    }//GEN-LAST:event_worMouseEntered

    private void worMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_worMouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_worMouseExited

    private void wor1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wor1MouseEntered
        // TODO add your handling code here:
        //yes


    }//GEN-LAST:event_wor1MouseEntered

    private void wor1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wor1MouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_wor1MouseExited

    private void dragableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragableMousePressed
        // TODO add your handling code here:
        xmouse = evt.getX();

        ymouse = evt.getY();
    }//GEN-LAST:event_dragableMousePressed

    private void dragableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragableMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();

        int y = evt.getYOnScreen();

//System.out.println(x+" "+y);
        this.setLocation(x - xmouse, y - ymouse);
    }//GEN-LAST:event_dragableMouseDragged

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
 char c = evt.getKeyChar();
        if (c == ':') {
            evt.consume();  // ignore event
        } else if (evt.getKeyChar() == VK_BACK_SPACE) {
            String abc = password.getText();
            if (!(abc.length() == 0)) {
                password.setText(abc.substring(0, abc.length() - 1));
                String stringValueOf = String.valueOf(c);
                pass = pass + stringValueOf;
                evt.consume();
                password.setText(password.getText() + "*");
                //System.out.println(pass);
            } else {
                password.setText("");
                pass = "";
            }
        } else {

            String stringValueOf = String.valueOf(c);
            pass = pass + stringValueOf;
            evt.consume();
            password.setText(password.getText() + "*");
            //System.out.println(pass);
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void wor2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wor2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_wor2MouseEntered

    private void wor2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wor2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_wor2MouseExited

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
            java.util.logging.Logger.getLogger(Z_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Z_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Z_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Z_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
               // new Z_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel backround;
    private javax.swing.JLabel close;
    private javax.swing.JLabel dragable;
    private javax.swing.JButton min1;
    private javax.swing.JTextField password;
    private javax.swing.JButton send;
    private javax.swing.JTextField username;
    private javax.swing.JLabel wor;
    private javax.swing.JLabel wor1;
    private javax.swing.JLabel wor2;
    // End of variables declaration//GEN-END:variables
}