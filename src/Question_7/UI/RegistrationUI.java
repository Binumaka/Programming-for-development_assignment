package Question_7.UI;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Question_7.controller.RegistrationController;
import Question_7.model.*;
import java.awt.event.ActionListener;


public class RegistrationUI extends javax.swing.JFrame {

    RegistrationModel model;

    
    public RegistrationUI() {
        initComponents();

    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        txtconfirmpassword = new javax.swing.JTextField();
        signupbtn = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        combogender = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255,255,255));

        jLabel2.setText("First Name: ");

        jLabel3.setText("User Name:");

        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });

        jLabel4.setText("Password:");

        jLabel8.setText("Confirm password:");

        signupbtn.setText("Sign - Up");
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });

        // jLabel9.setText("Already have account?  ");

    //     loginbtn.setText("Log - In");
    //     // loginbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
    // loginbtn.setPreferredSize(new java.awt.Dimension(150, 100));
    //     loginbtn.addActionListener(new java.awt.event.ActionListener() {
    //         public void actionPerformed(java.awt.event.ActionEvent evt) {
    //             loginbtnActionPerformed(evt);
    //         }
    //     });

        jLabel6.setText("Last Name:");

        jLabel7.setText("Email:");

        jLabel5.setText("Gender:");

        txtlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlnameActionPerformed(evt);
            }
        });

        // Rolelabel.setText("Role:");

        // comborole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Seller", " " }));
        // comborole.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         comboroleActionPerformed(evt);
        //     }
        // });

        combogender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        combogender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtconfirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(36, 36, 36)
                                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        // .addComponent(Rolelabel)
                        // .addGap(60, 60, 60)
                        // .addComponent(comborole, 0, 129, Short.MAX_VALUE)
                        )
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtlname, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtemail)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(45, 45, 45)
                        .addComponent(combogender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 70, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(signupbtn))
                    // .addGroup(jPanel1Layout.createSequentialGroup()
                    //     .addGap(189, 189, 189)
                    //     .addComponent(jLabel9)
                    //     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    //     // .addComponent(loginbtn)
                    //     )
                        )
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combogender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtconfirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    // .addComponent(Rolelabel)
                    // .addComponent(comborole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    )
                .addGap(27, 27, 27)
                .addComponent(signupbtn)
                .addGap(18, 18, 18)
                // .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                //     .addComponent(jLabel9)
                //     .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                // .addContainerGap(72, Short.MAX_VALUE)
                )
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("REGISTRATION FORM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
       
    RegistrationController r = new RegistrationController(this);
        
    //    setVisible(false);
    //    HomeUI r = new HomeUI();
    //    r.setVisible(true);
    }//GEN-LAST:event_signupbtnActionPerformed
 
    private void txtlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlnameActionPerformed
        
    }//GEN-LAST:event_txtlnameActionPerformed

    private void combogenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogenderActionPerformed
       
    }//GEN-LAST:event_combogenderActionPerformed
    public RegistrationModel getUser() {
       
        model = new RegistrationModel(txtusername.getText(), txtpassword.getText(), txtfname.getText(), txtemail.getText(), txtemail.getText(), combogender.getSelectedItem().toString(), txtconfirmpassword.getText());
        return model;
    }

    public void setMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void addRegistrationListener(ActionListener log) {
        signupbtn.addActionListener(log);
    }

   
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JComboBox<String> combogender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton signupbtn;
    private javax.swing.JTextField txtconfirmpassword;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}