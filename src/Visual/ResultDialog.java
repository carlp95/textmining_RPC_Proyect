/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author carlo
 */
public class ResultDialog extends javax.swing.JDialog {

    /**
     * Creates new form ResultDialog
     */
    public ResultDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SaveResult();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paperlbl = new javax.swing.JLabel();
        paperTextField = new javax.swing.JTextField();
        belongsTolbl = new javax.swing.JLabel();
        belongsToTextField = new javax.swing.JTextField();
        chooseOtherbtn = new javax.swing.JButton();
        backlogbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resultado");

        paperlbl.setText("Titulo Paper:");

        paperTextField.setEditable(false);

        belongsTolbl.setText("Pertenece a:");

        belongsToTextField.setEditable(false);

        chooseOtherbtn.setText("Choose Other");
        chooseOtherbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseOtherbtnActionPerformed(evt);
            }
        });

        backlogbtn.setText("BackLog");
        backlogbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backlogbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paperlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paperTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(belongsTolbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(belongsToTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backlogbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(chooseOtherbtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paperlbl)
                    .addComponent(paperTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(belongsTolbl)
                    .addComponent(belongsToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backlogbtn)
                    .addComponent(chooseOtherbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseOtherbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseOtherbtnActionPerformed
        // TODO add your handling code here:
        MainVisual mainVisual = new MainVisual();
        mainVisual.setLocationRelativeTo(null);
        mainVisual.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_chooseOtherbtnActionPerformed

    private void backlogbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backlogbtnActionPerformed
        // TODO add your handling code here:
        BackLog backLog = new BackLog(null,true);
        backLog.setLocationRelativeTo(null);
        backLog.setVisible(true);
    }//GEN-LAST:event_backlogbtnActionPerformed

    private void SaveResult(){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try{

            fw = new FileWriter("resources/results.txt",true);
            bw = new BufferedWriter(fw);

            bw.write("\n Paper: "+paperTextField.getText() + " Pertenece a: " + belongsToTextField.getText() + "\n");
            bw.write("-------------------------------------------------------------------------------------------");

        }catch (IOException e){
            e.printStackTrace();
        }finally
        {
            try
            {
                if (bw != null)
                {
                    bw.close();
                }
                if (fw != null)
                {
                    fw.close();
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }

        }
    }
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        *//* Set the Nimbus look and feel *//*
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        *//* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *//*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        *//* Create and display the dialog *//*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ResultDialog dialog = new ResultDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backlogbtn;
    public javax.swing.JTextField belongsToTextField;
    private javax.swing.JLabel belongsTolbl;
    private javax.swing.JButton chooseOtherbtn;
    public javax.swing.JTextField paperTextField;
    private javax.swing.JLabel paperlbl;
    // End of variables declaration//GEN-END:variables
}
