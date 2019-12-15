
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * Frame che contiene il panel che disegna il triangolo.
 *
 * @author Matteo Arena
 */
public class TriangleEditFrame extends javax.swing.JFrame implements TrianglePanelListener {

    /**
     * Frame di salvataggio del fiocco di neve e dei punti.
     */
    private SaveFrame sf;

    /**
     * Frame dove viene visualizzato il fiocco di neve.
     */
    private SnowFrame snowFrame = new SnowFrame();

    /**
     * Frame che mostra il tutorial del programma.
     */
    private TutorialFrame tf;

    /**
     * Metodo costruttore.
     */
    public TriangleEditFrame() {
        initComponents();
        trianglePanel.addTrianglePanelListener(this);
        setIcon();
    }

    /**
     * Inizializza tutti i componenti.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cutAndAdd = new javax.swing.ButtonGroup();
        editTriangleJPanel = new javax.swing.JPanel();
        addJRadioButton = new javax.swing.JRadioButton();
        cutJRadioButton = new javax.swing.JRadioButton();
        resetJButton = new javax.swing.JButton();
        deleteLastPointJButton = new javax.swing.JButton();
        previewJCheckBox = new javax.swing.JCheckBox();
        saveTriangleJPanel = new javax.swing.JPanel();
        createSnapshotJButton = new javax.swing.JButton();
        openSnapshotJButton = new javax.swing.JButton();
        generateJButton = new javax.swing.JButton();
        tutorialJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        infosJPanel = new javax.swing.JPanel();
        triangleNameJLabel = new javax.swing.JLabel();
        positionJLabel = new javax.swing.JLabel();
        trianglePanel = new TrianglePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snow Flake Generator");
        setMinimumSize(new java.awt.Dimension(1024, 768));

        editTriangleJPanel.setLayout(new java.awt.GridLayout(5, 0));

        cutAndAdd.add(addJRadioButton);
        addJRadioButton.setSelected(true);
        addJRadioButton.setText("Add");
        addJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJRadioButtonActionPerformed(evt);
            }
        });
        editTriangleJPanel.add(addJRadioButton);

        cutAndAdd.add(cutJRadioButton);
        cutJRadioButton.setText("Cut");
        cutJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutJRadioButtonActionPerformed(evt);
            }
        });
        editTriangleJPanel.add(cutJRadioButton);

        resetJButton.setText("Reset");
        resetJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetJButtonActionPerformed(evt);
            }
        });
        editTriangleJPanel.add(resetJButton);

        deleteLastPointJButton.setText("Undo");
        deleteLastPointJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLastPointJButtonActionPerformed(evt);
            }
        });
        editTriangleJPanel.add(deleteLastPointJButton);

        previewJCheckBox.setText("preview");
        previewJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewJCheckBoxActionPerformed(evt);
            }
        });
        editTriangleJPanel.add(previewJCheckBox);

        getContentPane().add(editTriangleJPanel, java.awt.BorderLayout.LINE_START);

        saveTriangleJPanel.setLayout(new java.awt.GridLayout(6, 0));

        createSnapshotJButton.setText("Create Snapshot");
        createSnapshotJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSnapshotJButtonActionPerformed(evt);
            }
        });
        saveTriangleJPanel.add(createSnapshotJButton);

        openSnapshotJButton.setText("Open Snapshot");
        openSnapshotJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSnapshotJButtonActionPerformed(evt);
            }
        });
        saveTriangleJPanel.add(openSnapshotJButton);

        generateJButton.setText("Generate");
        generateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateJButtonActionPerformed(evt);
            }
        });
        saveTriangleJPanel.add(generateJButton);

        tutorialJButton.setText("Tutorial");
        tutorialJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialJButtonActionPerformed(evt);
            }
        });
        saveTriangleJPanel.add(tutorialJButton);

        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        saveTriangleJPanel.add(saveJButton);

        getContentPane().add(saveTriangleJPanel, java.awt.BorderLayout.LINE_END);

        infosJPanel.setLayout(new java.awt.GridLayout(1, 0));

        triangleNameJLabel.setText("triangolo senza nome");
        infosJPanel.add(triangleNameJLabel);
        infosJPanel.add(positionJLabel);

        getContentPane().add(infosJPanel, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout trianglePanelLayout = new javax.swing.GroupLayout(trianglePanel);
        trianglePanel.setLayout(trianglePanelLayout);
        trianglePanelLayout.setHorizontalGroup(
            trianglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        trianglePanelLayout.setVerticalGroup(
            trianglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        getContentPane().add(trianglePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo che viene invocato quando viene premuto il radio button "Add".
     *
     * @param evt L'Evento.
     */
    private void addJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJRadioButtonActionPerformed
        if (addJRadioButton.isSelected()) {
            trianglePanel.setAddOption();
        }
    }//GEN-LAST:event_addJRadioButtonActionPerformed

    /**
     * Metodo che viene invocato quando viene premuto il radio button "Cut".
     *
     * @param evt L'Evento.
     */
    private void cutJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutJRadioButtonActionPerformed
        if (cutJRadioButton.isSelected()) {
            trianglePanel.setCutOption();
        }
    }//GEN-LAST:event_cutJRadioButtonActionPerformed

    /**
     * Metodo che viene invocato quando viene premuto il bottone "Reset".
     *
     * @param evt L'evento.
     */
    private void resetJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetJButtonActionPerformed
        trianglePanel.resetTriangle();
        modifiedTriangle();
    }//GEN-LAST:event_resetJButtonActionPerformed

    /**
     * Metodo che viene invocato quando si clicca sul bottone "Undo".
     *
     * @param evt L'evento.
     */
    private void deleteLastPointJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLastPointJButtonActionPerformed
        trianglePanel.cutLastPoint();
        modifiedTriangle();
    }//GEN-LAST:event_deleteLastPointJButtonActionPerformed

    /**
     * Metodo che viene invocato quando si mette o toglie la spunta dal checbox
     * "preview".
     *
     * @param evt L'evento.
     */
    private void previewJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewJCheckBoxActionPerformed
        if (previewJCheckBox.isSelected()) {
            trianglePanel.seePreview();
        } else {
            trianglePanel.disablePreview();
        }
    }//GEN-LAST:event_previewJCheckBoxActionPerformed

    /**
     * Metodo0 che viene invocato quando si crea uno snapshot.
     *
     * @param evt L'evento.
     */
    private void createSnapshotJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSnapshotJButtonActionPerformed
        if (sf != null) {
            if (sf.isVisible()) {
                sf.setVisible(false);
            }
        }
        sf = new SaveFrame();
        sf.setTriangle(trianglePanel.getTriangleModel());
        sf.setVisible(true);

    }//GEN-LAST:event_createSnapshotJButtonActionPerformed

    /**
     * Metodo che viene invocato quando si clicca sul bottone per aprire uno
     * snapshot.
     *
     * @param evt L'evento.
     */
    private void openSnapshotJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSnapshotJButtonActionPerformed
        File file = getFileFromFilechooser();
        System.out.println(file.getName());
        ArrayList csvDots = new ArrayList<>();

        try {
            csvDots = (ArrayList) Files.readAllLines(file.toPath());
        } catch (IOException ioe) {
            System.out.println("");
        }
        String[] data = new String[2];
        trianglePanel.resetTriangle();
        try {
            for (Object csvDot : csvDots) {
                data = csvDot.toString().split(",");
                trianglePanel.getTriangleModel().addDotToModelTriangle(new Point(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
            }
            triangleNameJLabel.setText(file.getName());
        } catch (NumberFormatException e) {
            System.out.println("Formato del file sconosciuto");
        }

    }//GEN-LAST:event_openSnapshotJButtonActionPerformed

    /**
     * Metodo che viene invocato quando si cliccas ul bottone "generate".
     *
     * @param evt L'evento.
     */
    private void generateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateJButtonActionPerformed
        if (snowFrame != null) {
            if (snowFrame.isVisible()) {
                snowFrame.setVisible(false);
            }
        }
        snowFrame = new SnowFrame();
        snowFrame.setTriangleModel(trianglePanel.getTriangleModel());
        snowFrame.setVisible(true);
    }//GEN-LAST:event_generateJButtonActionPerformed

    /**
     * Metodo che viene invocato quando si vuole aprire la finestra di tutorial.
     *
     * @param evt L'evento.
     */
    private void tutorialJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialJButtonActionPerformed
        if (tf != null) {
            if (tf.isVisible()) {
                tf.setVisible(false);
            }
        }
        tf = new TutorialFrame();
        tf.setVisible(true);
    }//GEN-LAST:event_tutorialJButtonActionPerformed

    /**
     * Metodo che viene invocato quando si vuole salvare il proprio fiocco di
     * neve.
     *
     * @param evt L'evento.
     */
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        if (sf != null) {
            if (sf.isVisible()) {
                sf.setVisible(false);
            }
        }
        sf = new SaveFrame();
        sf.setTriangle(trianglePanel.getTriangleModel());
        sf.setVisible(true);
        sf.saveImage();
    }//GEN-LAST:event_saveJButtonActionPerformed

    /**
     * Apre il file chooser e dice quale file si è selzionato.
     *
     * @return Il file selezionato.
     */
    private File getFileFromFilechooser() {
        File file = null;
        JFileChooser fc = new JFileChooser();
        SnowFrame mf = new SnowFrame();
        int returnVal = fc.showOpenDialog(mf);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        } else {
            System.out.println();
        }
        return file;
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
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //com.sun.java.swing.plaf.windows.WindowsLookAndFeel
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TriangleEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TriangleEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TriangleEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TriangleEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TriangleEditFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addJRadioButton;
    private javax.swing.JButton createSnapshotJButton;
    private javax.swing.ButtonGroup cutAndAdd;
    private javax.swing.JRadioButton cutJRadioButton;
    private javax.swing.JButton deleteLastPointJButton;
    private javax.swing.JPanel editTriangleJPanel;
    private javax.swing.JButton generateJButton;
    private javax.swing.JPanel infosJPanel;
    private javax.swing.JButton openSnapshotJButton;
    private javax.swing.JLabel positionJLabel;
    private javax.swing.JCheckBox previewJCheckBox;
    private javax.swing.JButton resetJButton;
    private javax.swing.JButton saveJButton;
    private javax.swing.JPanel saveTriangleJPanel;
    private javax.swing.JLabel triangleNameJLabel;
    private TrianglePanel trianglePanel;
    private javax.swing.JButton tutorialJButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseMoved(String position) {
        positionJLabel.setText(position);
        repaint();
    }

    @Override
    public void modifiedTriangle() {
        if (snowFrame.isVisible()) {
            snowFrame.setTriangleModel(trianglePanel.getTriangleModel());
        }
    }

    /**
     * Imposta l'icona del Frame.
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("snowFlake.png")));
    }

}
