/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logic.PDFProcesses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 * @author judajocu
 */
public class MainVisual extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private File FilePath;
    Image log_image, execute_image, find_image;
    public MainVisual() {
        try{
            log_image = ImageIO.read(new File("resources/images/history.png"));
            execute_image = ImageIO.read(new File("resources/images/play-button.png"));
            find_image = ImageIO.read(new File("resources/images/research.png"));
            this.setIconImage(ImageIO.read(new File("resources/images/house.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        initComponents();
        this.setTitle("Ventana Principal");
        this.setResizable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Principal = new javax.swing.JPanel();
        Label_Buscar_Paper = new javax.swing.JLabel();
        Boton_Buscar_paper = new javax.swing.JButton(new ImageIcon(find_image));
        historybtn = new javax.swing.JButton(new ImageIcon(log_image));
        filePathTextField = new javax.swing.JTextField();
        executeAlgorithmbtn = new javax.swing.JButton(new ImageIcon(execute_image));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Label_Buscar_Paper.setText("Buscar paper");
        Label_Buscar_Paper.setName("Buscar_paper"); // NOI18N

        Boton_Buscar_paper.setText("Browse");
        Boton_Buscar_paper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Buscar_paperActionPerformed(evt);
            }
        });

        historybtn.setText("Historial");
        historybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historybtnActionPerformed(evt);
            }
        });

        executeAlgorithmbtn.setText("Ejecutar");
        executeAlgorithmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeAlgorithmbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_PrincipalLayout = new javax.swing.GroupLayout(Panel_Principal);
        Panel_Principal.setLayout(Panel_PrincipalLayout);
        Panel_PrincipalLayout.setHorizontalGroup(
            Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(historybtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_Buscar_Paper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_PrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filePathTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Buscar_paper))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_PrincipalLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(executeAlgorithmbtn)))
                .addContainerGap())
        );
        Panel_PrincipalLayout.setVerticalGroup(
            Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Buscar_Paper)
                    .addComponent(Boton_Buscar_paper)
                    .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(historybtn)
                    .addComponent(executeAlgorithmbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panel_Principal.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_Buscar_paperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_Buscar_paperActionPerformed
        // TODO add your handling code here:
        JFrame parent = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Buscar Archivo");

        int userSelection = fileChooser.showDialog(parent,"Seleccionar");
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileget = fileChooser.getSelectedFile();
            File filepath = new File(fileget.toString());
            FilePath = filepath;
            filePathTextField.setText(filepath.toString());
        }
    }//GEN-LAST:event_Boton_Buscar_paperActionPerformed

    private void historybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historybtnActionPerformed
        // TODO add your handling code here:
        History historyVisual = new History(null,true);
        historyVisual.setLocationRelativeTo(null);
        historyVisual.setVisible(true);
    }//GEN-LAST:event_historybtnActionPerformed

    private void executeAlgorithmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeAlgorithmbtnActionPerformed
        // TODO add your handling code here:
        PDFProcesses pdfProcesses = new PDFProcesses();
        pdfProcesses.OneDocumentToText(FilePath);



        ResultDialog resultDialog = new ResultDialog(null, false);
        resultDialog.setLocationRelativeTo(null);
        resultDialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_executeAlgorithmbtnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Buscar_paper;
    private javax.swing.JLabel Label_Buscar_Paper;
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JButton executeAlgorithmbtn;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JButton historybtn;
    // End of variables declaration//GEN-END:variables
}
