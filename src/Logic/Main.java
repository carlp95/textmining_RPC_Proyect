package Logic;

import Visual.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    private  static  Main singletonMain;

    private Main(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainVisual dialog = new MainVisual();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    public static Main getInstance(){
        if(singletonMain == null){
            singletonMain = new Main();
        }else {
            JOptionPane.showMessageDialog(null,"No puede tener más de una instancia de esta ventana, abierta","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        return singletonMain;
    }

    public static void main(String[] args) throws IOException {
        /*PDFProcesses procesarpdf = new PDFProcesses();
        procesarpdf.CleanDocumentText();*/
        /*Trainer leraner = new Trainer();
        leraner.loadDataset("resources/dataset.arff");
        leraner.evaluate();
        leraner.learn();
        leraner.saveModel("resources/dataset_model.dat");*/

        getInstance();




    }
}
