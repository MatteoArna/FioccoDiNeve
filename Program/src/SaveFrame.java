
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Frame di salvataggio del triangolo.
 *
 * @author Matteo Arena
 */
public class SaveFrame extends javax.swing.JFrame {

    /**
     * triangolo da prendere come modello.
     */
    private TriangleModel triangleModel;

    /**
     * Metodo costruttore
     */
    public SaveFrame() {
        initComponents();
        setIcon();
    }

    /**
     * Permette di impostare il triangolo di modello con i rispettivi punti di
     * taglio.
     *
     * @param triangleModel Il modello del triangolo.
     */
    public void setTriangle(TriangleModel triangleModel) {
        preview.setTriangle(triangleModel);
        this.triangleModel = triangleModel;
    }

    /**
     * Permette di mostrare il fiocco di neve nella pagina di salvataggio (al
     * posto del triangolo tagliato).
     */
    public void saveImage() {
        preview.seeSnowFlake();
    }

    /**
     * INizializza i componenti.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preview = new Preview();
        jFileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Save");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout previewLayout = new javax.swing.GroupLayout(preview);
        preview.setLayout(previewLayout);
        previewLayout.setHorizontalGroup(
            previewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        previewLayout.setVerticalGroup(
            previewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        getContentPane().add(preview);

        jFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metood che viene invocato quando si clicca sul File Chooser.
     *
     * @param evt L'evento.
     */
    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed
        File file = new File("");
        try {
            file = jFileChooser.getSelectedFile();
            file.createNewFile();
            if (preview.isSavePage()) {
                preview.save(file.getAbsolutePath(), file.getName(), true);
            } else {
                createSnapshot(file.getAbsolutePath());
            }
        } catch (Exception e) {
        }
        this.setVisible(false);
    }//GEN-LAST:event_jFileChooserActionPerformed

    /**
     * Permette di creare uno snapshot.
     *
     * @param path Path dove si vuole creare.
     * @throws IOException
     */
    private void createSnapshot(String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        List<Point> dots = triangleModel.getModelDots();
        for (Point dot : dots) {
            fw.append(dot.x + "");
            fw.append(",");
            fw.append(dot.y + "");
            fw.append("\n");
        }
        fw.close();
    }

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
            java.util.logging.Logger.getLogger(SaveFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaveFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaveFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaveFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaveFrame().setVisible(true);
            }
        });
    }

    /**
     * Imposta l'icona del Frame.
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("snowFlake.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser;
    private Preview preview;
    // End of variables declaration//GEN-END:variables
}
