/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vamartid.test1._email;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static vamartid.test1._email.MY_socket_CLIENT.PORT;

/**
 *
 * @author basilism
 */
public class Z_user extends javax.swing.JFrame {
    boolean mnb=false;
    int xmouse;
    int ymouse;
    String user;
    Email[] MailsData = null;
    private TableRowSorter<TableModel> rowSorter;
    /**
     * Creates new form EmailMainGUI
     */
    //public SearchClass yoh=new SearchClass();
    //SearchClass yoh=new SearchClass();
    Socket SOCK=null;
    public Z_user(String lalal,Socket a) {
        SOCK=a;
        initComponents();
        
            rowSorter
            = new TableRowSorter<>(msg_table.getModel());
        msg_table.setRowSorter(rowSorter);

     search.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = search.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = search.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });        
        
        user = lalal;
        username.setText(user);

        //want access
        //username.setText();
//new SearchClass().setVisible(true);
        //kripse to ena
        //msg_table.setVisible(false);
        msg_scrollpane.getColumnHeader().setVisible(false);
        //add(yoh);
        //yoh.setSize(746,563);
        //yoh.setVisible(true);
        //msg_scrollpane.add(yoh);
        //yoh.setVisible(true);
////////////        DefaultTableModel model = (DefaultTableModel) msg_table.getModel();
////////////        JmailHelp a = new JmailHelp();
////////////        File[] s = a.find_the_mails("_javaMailData/userMails/"+user);
////////////        for (int i = 0; i < s.length; i++) {
////////////            //System.out.println(s[i]);
////////////            Email k = a.read_mail(s[i]);
////////////            model.addRow(new Object[]{i, k.get_sender(),k.get_subject()});
////////////            //new Z_Email(k.get_sender(), k.get_receiver(), k.get_subject(), k.get_mainbody()).setVisible(true);
////////////        }
        refresh();
        //na stelnw ena 2xfile.length pinaka ton opoio tha pernw sto table me ton panw tropo

        //na elenw stin if an oi sinthikes isxioun
        msg_table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
//                    System.out.println((msg_table.getValueAt(msg_table.getSelectedRow(), 0).toString())
//                            + "  " + (msg_table.getValueAt(msg_table.getSelectedRow(), 1).toString())
//                            + "  " + (msg_table.getValueAt(msg_table.getSelectedRow(), 2).toString()));
                    
                   
                    String b = (msg_table.getValueAt(msg_table.getSelectedRow(), 0).toString());
                    int foo = Integer.parseInt(b);
                    MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
                    try {
                        //Socket SOCK = new Socket("localhost", PORT);
                        CLIENT.send_orders("read",SOCK);
                        CLIENT.set_read(user, b,SOCK) ;
                    } catch (IOException ex) {
                        Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    
                    //Email k = a.read_mail(txt[foo], true);
                    new Z_Email(MailsData[foo].get_sender(),
                            MailsData[foo].get_receiver(),
                            MailsData[foo].get_subject(),
                            MailsData[foo].get_mainbody(),
                            false,
                            SOCK).setVisible(true);
                    // your valueChanged overridden method 
                    refresh();
                }
            }
            
        });

    }


        
    

    public void refresh() {
        DefaultTableModel model = (DefaultTableModel) msg_table.getModel();
        
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
            
            MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
            try {
                CLIENT.send_orders("refresh",SOCK);
               MailsData=CLIENT.want_mail_catalogue(user,SOCK) ;
            } catch (IOException ex) {
                Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
            }       
        for (int i = 0; i < MailsData.length; i++) {
            model.addRow(new Object[]{i, MailsData[i].get_sender(), MailsData[i].get_subject(), MailsData[i].get_isNew()});
            }
    }
    //old refresh
//////    public void refresh() {
//////        DefaultTableModel model = (DefaultTableModel) msg_table.getModel();
//////        JmailHelp a = new JmailHelp();
//////        int rowCount = model.getRowCount();
//////        //Remove rows one by one from the end of the table
//////        for (int i = rowCount - 1; i >= 0; i--) {
//////            model.removeRow(i);
//////        }
//////        File[] s = a.find_the_mails("_javaMailData/userMails/" + user);
//////        for (int i = 0; i < s.length; i++) {
//////            //System.out.println(s[i]);
//////            Email k = a.read_mail(s[i], false);
//////            //System.out.println(k.get_isNew());
//////            model.addRow(new Object[]{i, k.get_sender(), k.get_subject(), k.get_isNew()});
//////            if (!(k.get_isNew())) {}//new Z_Email(k.get_sender(), k.get_receiver(), k.get_subject(), k.get_mainbody()).setVisible(true);
//////        }
//////    }

    //  [229,137,45]

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        help = new javax.swing.JButton();
        hhelp = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        min1 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        compose = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        msg_scrollpane = new javax.swing.JScrollPane();
        msg_table = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, 3);
                if( !(getSelectedRow() == row)) {//MH EPILEGMENA
                    if (value.equals(false)) {//PALIA
                        comp.setBackground(new java.awt.Color(211, 84, 0));//(211,84,0)
                        comp.setForeground(Color.white);
                    } else if (value.equals(true)) {//KAINOURIA
                        comp.setBackground(new java.awt.Color(255, 153, 51));
                        comp.setForeground(Color.white);
                    } else {//AN EGINE LATHOS
                        comp.setBackground(new java.awt.Color(211, 84, 0));//(211,84,0)
                        comp.setForeground(Color.white);
                    }
                } else {//EPILEGMENA
                    comp.setBackground(Color.white);
                    comp.setForeground(Color.black);
                }
                return comp;
            }
        };
        dragable = new javax.swing.JLabel();
        backround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(302, 342));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        help.setToolTipText("Βοήθεια");
        help.setBorder(null);
        help.setBorderPainted(false);
        help.setContentAreaFilled(false);
        help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        help.setFocusPainted(false);
        help.setPreferredSize(new java.awt.Dimension(32, 9));
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                helpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                helpMouseReleased(evt);
            }
        });
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        getContentPane().add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 0, 80, 36));
        getContentPane().add(hhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 650));

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
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 0, 47, 32));

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
        getContentPane().add(min1, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 0, 47, 32));

        logout.setToolTipText("Αποσύνδεση απο τον λογαριασμό");
        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setFocusPainted(false);
        logout.setPreferredSize(new java.awt.Dimension(32, 9));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutMouseReleased(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 0, 105, 36));

        search.setColumns(1);
        search.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setToolTipText("Βάλτε μια λεξη κλειδί που να εχει να κάνει με την επαφή,το θέμα ή το περιεχόμενο");
        search.setBorder(null);
        search.setName(""); // NOI18N
        search.setOpaque(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 12, 255, 30));

        id.setColumns(1);
        id.setFont(new java.awt.Font("Calibri Light", 0, 26)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setToolTipText("Προσθέστε το id του μηνύματος που θέλετε να διαγράψετε");
        id.setBorder(null);
        id.setName(""); // NOI18N
        id.setOpaque(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 418, 49, 30));

        Delete.setToolTipText("Πατήστε για διαγραφή");
        Delete.setBorder(null);
        Delete.setBorderPainted(false);
        Delete.setContentAreaFilled(false);
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.setFocusPainted(false);
        Delete.setPreferredSize(new java.awt.Dimension(32, 9));
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DeleteMouseReleased(evt);
            }
        });
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 416, 75, 33));

        compose.setToolTipText("Σύνταξη νέου μηνύματος");
        compose.setBorder(null);
        compose.setBorderPainted(false);
        compose.setContentAreaFilled(false);
        compose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compose.setFocusPainted(false);
        compose.setPreferredSize(new java.awt.Dimension(32, 9));
        compose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                composeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                composeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                composeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                composeMouseReleased(evt);
            }
        });
        compose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composeActionPerformed(evt);
            }
        });
        getContentPane().add(compose, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 137, 103, 30));

        username.setEditable(false);
        username.setColumns(1);
        username.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Όνομα Χρήστη");
        username.setToolTipText("");
        username.setBorder(null);
        username.setName(""); // NOI18N
        username.setOpaque(false);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 90, 162, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vamartid/test1/buttons/refresh_null.png"))); // NOI18N
        jButton1.setToolTipText("Επαναφόρτωση λίστας μηνυμάτων");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 7, 40, 40));

        msg_scrollpane.setBackground(new java.awt.Color(255, 255, 255));
        msg_scrollpane.setToolTipText("");
        msg_scrollpane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        msg_scrollpane.setEnabled(false);
        msg_scrollpane.setHorizontalScrollBar(null);

        msg_table.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        msg_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "From", "To","IsNew"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class,java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        msg_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        msg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        msg_table.getColumnModel().getColumn(0).setPreferredWidth(74);
        msg_table.getColumnModel().getColumn(1).setPreferredWidth(270);
        msg_table.getColumnModel().getColumn(2).setPreferredWidth(384);
        msg_table.getColumnModel().getColumn(3).setPreferredWidth(100);
        msg_table.setColumnSelectionAllowed(false);
        msg_table.setRowSelectionAllowed(true);
        msg_table.getColumnModel().getColumn(3).setMinWidth(0);
        msg_table.getColumnModel().getColumn(3).setMaxWidth(0);
        msg_table.getColumnModel().getColumn(3).setWidth(0);
        msg_table.getColumnModel().getColumn(3).setPreferredWidth(0);
        msg_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        msg_table.setGridColor(new java.awt.Color(204, 204, 204));
        msg_table.setRowHeight(19);
        msg_table.setSelectionBackground(new java.awt.Color(255, 153, 51));
        msg_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        msg_table.getTableHeader().setReorderingAllowed(false);
        msg_table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                msg_tableFocusGained(evt);
            }
        });
        msg_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msg_tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                msg_tableMouseReleased(evt);
            }
        });
        msg_scrollpane.setViewportView(msg_table);
        msg_table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        msg_table.getAccessibleContext().setAccessibleName("");

        getContentPane().add(msg_scrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 82, 746, 563));

        dragable.setToolTipText("");
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
        getContentPane().add(dragable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        backround.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        backround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vamartid/test1/images/mailview.png"))); // NOI18N
        backround.setRequestFocusEnabled(false);
        getContentPane().add(backround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseReleased
        // TODO add your handling code here:
        close.setIcon(null);
//        MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
//        try {
//            CLIENT.send_orders("logout",SOCK);
//            CLIENT.logout(user,SOCK);
//            CLIENT.send_orders("exit",SOCK);
//             System.exit(0);
//        } catch (Exception ex) {
//            Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.exit(0);
    }//GEN-LAST:event_closeMouseReleased
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        //int w = Integer.parseInt(id.getText());
        if (Integer.parseInt(id.getText())>msg_table.getRowCount()) {
        getToolkit().beep();}
        else{
        MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
            try {
                CLIENT.send_orders("delete",SOCK);
                CLIENT.delet_mail(user, id.getText(),SOCK) ;
            } catch (Exception ex) {
                Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
            }
//        DefaultTableModel model = (DefaultTableModel) msg_table.getModel();
//        model.removeRow(w);
//        model.removeRow(w);
//        
//        JmailHelp a = new JmailHelp();
//        File[] s = a.find_the_mails("_javaMailData/userMails/" + user);
//        s[w].delete();
////        int rowCount = model.getRowCount();
////        //Remove rows one by one from the end of the table
////        for (int i = rowCount - 1; i >= 0; i--) {
////            model.removeRow(i);
////        }
        refresh();
        id.setText("");
//////        JmailHelp a = new JmailHelp();
//////        File[] s = a.find_the_mails("_javaMailData/userMails/qwe");
//////        for (int i = 0; i < 10; i++) {
//////            System.out.println(s[i]);
//////            Email k = a.read_mail(s[i]);
//////            model.addRow(new Object[]{i, k.get_receiver(), k.get_subject()});
//////            new Z_Email(k.get_sender(), k.get_receiver(), k.get_subject(), k.get_mainbody()).setVisible(true);
//////        }
//        DefaultTableModel model = (DefaultTableModel) msg_table.getModel();
//        model.addRow(new Object[]{"1", "aaa@csd", "kkkkkkkkkkkkkkkkkk"});
//        model.addRow(new Object[]{"2", "bbb@csd", "ooooooooooooooo"});
//        model.addRow(new Object[]{"3", "ccc@csd", "wwwwwwwwwwwwwwwwwwwwww"});
//        model.addRow(new Object[]{"4", "ddd@csd", "aaaaaaaaaaaaaa"});
//        model.addRow(new Object[]{"5", "eee@csd", "ssssssssssssssss"});
//        model.addRow(new Object[]{"6", "fff@csd", "cccccccccccccccccccc"});
//        model.addRow(new Object[]{"7", "ggg@csd", "vvvvvvvvvvvvvvvvvvvvv"});
//        model.addRow(new Object[]{"8", "hhh@csd", "bbbbbbbbbbbbbbb"});
//        model.addRow(new Object[]{"9", "iii@csd", "mmmmmmmmmmmmmmm"});

        }
    }//GEN-LAST:event_DeleteActionPerformed
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed
    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_idActionPerformed
    private void min1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_min1ActionPerformed
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_min1ActionPerformed
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
//a pio xalia gt menei ena array me null times
//        System.gc();
//        java.awt.Window win[] = java.awt.Window.getWindows();
//        for (int i = 0; i < win.length; i++) {
//            win[i].dispose();
//            win[i] = null;
//        }
        //logout
        MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
                    try {
                        //Socket SOCK = new Socket("localhost", PORT);
                        CLIENT.send_orders("logout",SOCK);
                        CLIENT.logout(user,SOCK);
                    } catch (IOException ex) {
                        Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
                    } 
//enw edw einai topiko        
        System.gc();
        for (Window window : Window.getWindows()) {
            window.dispose();
        }

        new Z_login(SOCK).setVisible(true); // Main Form to show after the Login Form..

    }//GEN-LAST:event_logoutActionPerformed
    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/images/help.png"));
        if (mnb==false) {
            hhelp.setIcon(II);
                mnb=true;
        } else {
            hhelp.setIcon(null);
            mnb=false;
        }
        
    }//GEN-LAST:event_helpActionPerformed
    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_usernameActionPerformed
    private void composeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composeActionPerformed
        //this.dispose();
        new Z_Email(username.getText(),SOCK).setVisible(true); // Main Form to show after the Login Form..

    }//GEN-LAST:event_composeActionPerformed
    private void min1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/B.png"));
        min1.setIcon(II);
    }//GEN-LAST:event_min1MouseEntered
    private void min1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseExited
        // TODO add your handling code here:
        //ImageIcon II= new ImageIcon(getClass().getResource(null);
        min1.setIcon(null);
    }//GEN-LAST:event_min1MouseExited
    private void min1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/C.png"));
        min1.setIcon(II);
    }//GEN-LAST:event_min1MousePressed
    private void min1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseReleased
        // TODO add your handling code here:
        min1.setIcon(null);
    }//GEN-LAST:event_min1MouseReleased
    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_helpMouseClicked
    private void helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/B.png"));
        help.setIcon(II);
    }//GEN-LAST:event_helpMouseEntered
    private void helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseExited
        // TODO add your handling code here:
        help.setIcon(null);
    }//GEN-LAST:event_helpMouseExited
    private void helpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/C.png"));
        help.setIcon(II);
    }//GEN-LAST:event_helpMousePressed
    private void helpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseReleased
        // TODO add your handling code here:
        help.setIcon(null);
    }//GEN-LAST:event_helpMouseReleased
    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutMouseClicked
    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/B.png"));
        logout.setIcon(II);
    }//GEN-LAST:event_logoutMouseEntered
    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        // TODO add your handling code here:
        logout.setIcon(null);

    }//GEN-LAST:event_logoutMouseExited
    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/C.png"));
        logout.setIcon(II);
    }//GEN-LAST:event_logoutMousePressed
    private void logoutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseReleased
        // TODO add your handling code here:
        logout.setIcon(null);

    }//GEN-LAST:event_logoutMouseReleased
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
        MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
        try {
            CLIENT.send_orders("logout",SOCK);
            CLIENT.logout(user,SOCK);
            CLIENT.send_orders("exit",SOCK);
            SOCK.close();
            this.dispose();
            System.exit(0);
        } catch (Exception ex) {
            Logger.getLogger(Z_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_closeMousePressed
    private void DeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/dB.png"));
        Delete.setIcon(II);
    }//GEN-LAST:event_DeleteMouseEntered
    private void DeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseExited
        // TODO add your handling code here:
        Delete.setIcon(null);
    }//GEN-LAST:event_DeleteMouseExited
    private void DeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/dC.png"));
        Delete.setIcon(II);
    }//GEN-LAST:event_DeleteMousePressed
    private void DeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseReleased
        // TODO add your handling code here:
        Delete.setIcon(null);
    }//GEN-LAST:event_DeleteMouseReleased
    private void composeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_composeMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/cB.png"));
        compose.setIcon(II);
    }//GEN-LAST:event_composeMouseEntered
    private void composeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_composeMouseExited
        // TODO add your handling code here:
        compose.setIcon(null);

    }//GEN-LAST:event_composeMouseExited
    private void composeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_composeMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/cC.png"));
        compose.setIcon(II);
    }//GEN-LAST:event_composeMousePressed
    private void composeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_composeMouseReleased
        // TODO add your handling code here:
        compose.setIcon(null);

    }//GEN-LAST:event_composeMouseReleased
    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        // TODO add your handling code here:
//        String text = search.getText();
//        if (text.trim().length() == 0) {
//            rowSorter.setRowFilter(null);
//        } else {
//            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//        }


    }//GEN-LAST:event_searchKeyTyped

    private void msg_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_tableMouseReleased
        // TODO add your handling code here:
        //        msg_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        //            public void valueChanged(ListSelectionEvent event) {
        //                // do some actions here, for example
        //                // print first column value from selected row
        //                //System.out.println( (msg_table.getValueAt(msg_table.getSelectedRow(),msg_table.getSelectedColumn()).toString()));
        //
        ////                    System.out.println( (msg_table.getValueAt(msg_table.getSelectedRow(),0).toString())+
        ////                    "  "+(msg_table.getValueAt(msg_table.getSelectedRow(),1).toString())+
        ////                    "  "+(msg_table.getValueAt(msg_table.getSelectedRow(),2).toString()) );
        //            }
        //        });
    }//GEN-LAST:event_msg_tableMouseReleased

    private void msg_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_tableMouseClicked

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

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        char c = evt.getKeyChar();
        if ((c >= 32 && c <= 47) || (c >= 58 && c <= 126)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_idKeyTyped

    private void msg_tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_msg_tableFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_msg_tableFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
                ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/refresh_1.png"));
            jButton1.setIcon(II);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
                        ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/refresh_null.png"));
            jButton1.setIcon(II);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
             ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/refresh_2.png"));
            jButton1.setIcon(II);
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
                      ImageIcon II = new ImageIcon(getClass().getResource("/vamartid/test1/buttons/refresh_null.png"));
            jButton1.setIcon(II);
    }//GEN-LAST:event_jButton1MouseReleased
//    class MyKeyListener extends KeyAdapter {
//        //nofucking need
//      public void keyPressed(KeyEvent evt) {
//        if ((evt.getKeyChar() == 'r')||(evt.getKeyChar() == 'R')||(evt.getKeyChar() == 'Ρ')||(evt.getKeyChar() == 'ρ')) {
//                              System.out.println( (msg_table.getValueAt(msg_table.getSelectedRow(),0).toString())+
//                                "  "+(msg_table.getValueAt(msg_table.getSelectedRow(),1).toString())+
//                                "  "+(msg_table.getValueAt(msg_table.getSelectedRow(),2).toString()) );
//        }
//      }
//    }

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
            java.util.logging.Logger.getLogger(Z_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Z_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Z_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Z_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
//                new Z_user().setVisible(true);
//                new Z_user().msg_table.setVisible(false);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JLabel backround;
    private javax.swing.JLabel close;
    private javax.swing.JButton compose;
    private javax.swing.JLabel dragable;
    private javax.swing.JButton help;
    private javax.swing.JLabel hhelp;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton logout;
    private javax.swing.JButton min1;
    private javax.swing.JScrollPane msg_scrollpane;
    private javax.swing.JTable msg_table;
    private javax.swing.JTextField search;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
    private static class DefaultTableMode {

        public DefaultTableMode() {
        }
    }
}
