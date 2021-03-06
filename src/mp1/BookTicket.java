/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import static mp1.Movies.Maddress;
import static mp1.Movies.Mname;
/**
 *
 * @author iis
 */
public class BookTicket extends javax.swing.JFrame {
    ResultSet rs;
    public static String FinalTime;
    public static String FinalDate;
    public static String FormatD;
    public static String LanguageEH;
    String MTimes[];
    String MDates[];

    /**
     * Creates new form BookTicket
     */
    public BookTicket() {
        String host = "jdbc:derby://localhost:1527/Users";

        
        String uName = "username";
        String uPass= "password";
        try {
            Connection con;
      con = DriverManager.getConnection( host,uName,uPass);
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      //String SQL = "SELECT * FROM Data";
      
      //Statement stmt = con.createStatement();
        String SQL = "SELECT DISTINCT DATE FROM SHOWS WHERE MOVIE='"+Mname+"'";
       
            try {
                 rs=stmt.executeQuery(SQL);
                 int count=0;
                 while(rs.next())
                     count++;
                 System.out.println("Size of Date Array: "+count);
                 rs=stmt.executeQuery(SQL);
                 MDates=new String[count];
                  count=0;
                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                  while(rs.next())
                  {
                      MDates[count++]=dateFormat.format(rs.getDate("Date"));
                  }
                  SQL = "SELECT DISTINCT TIME FROM SHOWS WHERE MOVIE='"+Mname+"' AND DATE='"+MDates[0]+"'";
                  rs=stmt.executeQuery(SQL);
                 count=0;
                 while(rs.next())
                     count++;
                 System.out.println("Size of Time Array: "+count);
                 rs=stmt.executeQuery(SQL);
                 MTimes=new String[count];
                  count=0;
                 dateFormat = new SimpleDateFormat("HH:mm:ss");  
                  while(rs.next())
                  {
                      MTimes[count++]=dateFormat.format(rs.getTime("Time"));
                  }
                 
                
                
                  
                    
            } 
            catch (SQLException ex) {
                Logger.getLogger(SignUP.class.getName()).log(Level.SEVERE, null, ex);
                
            }
      
                
        }
        catch(SQLException e){
                
        }
        
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

        Format = new javax.swing.ButtonGroup();
        Language = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        Format3d = new javax.swing.JRadioButton();
        Format2d = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LangE = new javax.swing.JRadioButton();
        LangH = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        BT = new javax.swing.JButton();
        jC2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        BackToMI = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jC1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Ticket");

        Format.add(Format3d);
        Format3d.setSelected(true);
        Format3d.setText("3D");
        Format3d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Format3dActionPerformed(evt);
            }
        });

        Format.add(Format2d);
        Format2d.setText("2D");
        Format2d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Format2dActionPerformed(evt);
            }
        });

        jLabel2.setText("Format : ");

        jLabel3.setText("Language :");

        Language.add(LangE);
        LangE.setSelected(true);
        LangE.setText("English");

        Language.add(LangH);
        LangH.setText("Hindi");
        LangH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LangHActionPerformed(evt);
            }
        });

        jLabel4.setText("Date :");

        BT.setBackground(new java.awt.Color(51, 255, 0));
        BT.setText("Book Ticket");
        BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTActionPerformed(evt);
            }
        });
        BT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTKeyPressed(evt);
            }
        });

        jC2.setModel(new javax.swing.DefaultComboBoxModel<>(MTimes));
        jC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Time :");

        BackToMI.setBackground(new java.awt.Color(255, 0, 0));
        BackToMI.setText("Back");
        BackToMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMIActionPerformed(evt);
            }
        });
        BackToMI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BackToMIKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText(Mname);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource(Maddress)));
        jLabel7.setPreferredSize(new java.awt.Dimension(33, 9));
        jLabel7.setRequestFocusEnabled(false);

        jC1.setModel(new javax.swing.DefaultComboBoxModel<>(MDates));
        jC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackToMI)
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Format3d)
                                    .addComponent(LangE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Format2d)
                                    .addComponent(LangH))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(BT)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackToMI)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BT)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Format3d)
                            .addComponent(Format2d))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LangE)
                            .addComponent(LangH)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jC2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Format3dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Format3dActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Format3dActionPerformed

    private void Format2dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Format2dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Format2dActionPerformed

    private void BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTActionPerformed
        // TODO add your handling code here:
        if(Format3d.isSelected())
            FormatD="3D";
        else
            FormatD="2D";
        if(LangE.isSelected())
            LanguageEH="English";
        else
            LanguageEH="Hindi";
        FinalDate=jC1.getSelectedItem().toString();
        FinalTime=jC2.getSelectedItem().toString();
        Seats s=new Seats();
        s.setVisible(true);
    }//GEN-LAST:event_BTActionPerformed

    private void BackToMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMIActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BackToMIActionPerformed

    private void jC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jC2ActionPerformed

    private void BTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            java.awt.event.ActionEvent e=null;
            BTActionPerformed(e);
        }
    }//GEN-LAST:event_BTKeyPressed

    private void BackToMIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BackToMIKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            java.awt.event.ActionEvent e=null;
            BackToMIActionPerformed(e);
        }
    }//GEN-LAST:event_BackToMIKeyPressed

    private void LangHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LangHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LangHActionPerformed

    private void jC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC1ActionPerformed
        // TODO add your handling code here:
        String host = "jdbc:derby://localhost:1527/Users";

        
        String uName = "username";
        String uPass= "password";
        try {
            Connection con;
      con = DriverManager.getConnection( host,uName,uPass);
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      //String SQL = "SELECT * FROM Data";
      
      //Statement stmt = con.createStatement();
       //String SQL = "SELECT DISTINCT DATE FROM SHOWS WHERE MOVIE='"+Mname+"'";
       
            try {
                 /*rs=stmt.executeQuery(SQL);
                 int count=0;
                 while(rs.next())
                     count++;
                 System.out.println("Size of Date Array: "+count);
                 rs=stmt.executeQuery(SQL);
                 MDates=new String[count];
                  count=0;
                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                  while(rs.next())
                  {
                      MDates[count++]=dateFormat.format(rs.getDate("Date"));
                  }*/
                 String date=jC1.getSelectedItem().toString();
                  String SQL = "SELECT DISTINCT TIME FROM SHOWS WHERE MOVIE='"+Mname+"' AND DATE='"+date+"'";
                  rs=stmt.executeQuery(SQL);
                 int count=0;
                 while(rs.next())
                     count++;
                 System.out.println("Size of Time Array: "+count);
                 rs=stmt.executeQuery(SQL);
                 MTimes=new String[count];
                  count=0;
                 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  
                  while(rs.next())
                  {
                      MTimes[count++]=dateFormat.format(rs.getTime("Time"));
                      System.out.println("Movie Time :  "+MTimes[count-1]);
                  }
                  DefaultComboBoxModel model = new DefaultComboBoxModel(MTimes);
                  jC2.setModel(model);
            } 
            catch (SQLException ex) {
                Logger.getLogger(SignUP.class.getName()).log(Level.SEVERE, null, ex);
                
            }
      
                
        }
        catch(SQLException e){
                
        }
    }//GEN-LAST:event_jC1ActionPerformed

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
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            BookTicket bt=new BookTicket();
            bt.setVisible(true);
            bt.setResizable(false);
            bt.setSize(new Dimension(517,454));
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT;
    private javax.swing.JButton BackToMI;
    private javax.swing.ButtonGroup Format;
    private javax.swing.JRadioButton Format2d;
    private javax.swing.JRadioButton Format3d;
    private javax.swing.JRadioButton LangE;
    private javax.swing.JRadioButton LangH;
    private javax.swing.ButtonGroup Language;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jC1;
    private javax.swing.JComboBox<String> jC2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
