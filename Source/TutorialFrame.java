
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matte
 */
public class TutorialFrame extends javax.swing.JFrame {

    /**
     * Stringhe del tutorial.
     */
    private String[] text = new String[9];

    /**
     * Creates new form TutorialFrame
     */
    public TutorialFrame() {
        initComponents();
        text[0] = "Per iniziare a creare il tuo fiocco di neve non devi fare "
                + "altro che premere con il mouse sopra al triangolo bianco "
                + "che visualizzi a schermo, questo triangolo verrà poi specchiato"
                + "in modo da creare un fiocco di neve.";
        text[1] = "Con il mouse puoi cliccare sopra al triangolo per aggiungere"
                + "o rimuovere un punto (in base se hai selezionato add o cut)."
                + "Per muovere un punto bisogna spostarsi sopra ad uno, avere la"
                + "conferma dal colore viola e tenere premuto il tasto sinistro."
                + "In questa maniera potrai spostare i tuoi punti dove più desideri.";
        text[2] = "Con questo bottone puoi eliminare molto velocemente tutti "
                + "i punti che hai inserito sul triangolo, attenzione essi non "
                + "verrano salvati da alcuna parte quindi saranno irreperibili.";
        text[3] = "Add e Cut sono due opzioni che puoi scegliere, ma almeno una"
                + "delle due deve essere selezionata. Se selezioni add potrai "
                + "aggiungere i punti cliccando con il mouse, invece se è"
                + "selezionato cut potrai eliminare i punti esistenti. Per "
                + "essere sicuro di star eliminando il punto da te desiderato "
                + "esso verrà colorato di viola.";
        text[4] = "Il bottone generate ti genererà il fiocco di neve in base ai"
                + "tuoi tagli. Non c'è bisogno però che ogni volta lo riapri, se"
                + "c'è un punto che non ti convince puoi muoverlo sul triangolo"
                + "e in automatico la finestra contenente il fiocco si aggiornerà.";
        text[5] = "la modalità preview ti permette di visualizzare il triangolo"
                + "come se fosse tagliato ma non generato. In questa modalità"
                + "potrai in ogni caso eliminare punti, aggiungerli e muoverli.";
        text[6] = "Questi sono due bottoni molto semplici che ti aiuteranno a "
                + "fare il fiocco di neve perfetto. Con il secondo potrai "
                + "salvare tutti i punti che hai messo su un triangolo in modo "
                + "di poterli riaprire in seguito utilizzando il primo. Il file"
                + "lo puoi anche condividere con i tuoi amici che lo potranno "
                + "aprire tramite il bottone openSnapshot e vedere il tuo "
                + "capolavoro.";
        text[7] = "Tramite questo bottone potrai eliminare l'ultimo puinto che "
                + "hai inserito, senza dover per forza selezionare cut e andare "
                + "ad eliminarlo manualmente.";
        text[8] = "Per salvare il file devi premere su salva, una volta che hai"
                + "messo i tuoi punti, e salvare il fiocco nella directory che "
                + "vuoi aggiungendo .svg alla fine del nome. Ora potrai trovare"
                + "il tuo fiocco di neve generato e salvato perfettamente.";
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        functionsJList = new javax.swing.JList<>();
        descriptionJPanel = new javax.swing.JPanel();
        titleDescriptionJLabel = new javax.swing.JLabel();
        descriptionFunctionJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Documentazione SnowFlake");
        setMinimumSize(new java.awt.Dimension(500, 500));

        functionsJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Come iniziare", "Funzioni Mouse", "Reset", "Add e Cut", "Generate", "Preview", "Open e Create Snapshot", "Undo ", "Save " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        functionsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        functionsJList.setToolTipText("");
        functionsJList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        functionsJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                functionsJListMouseClicked(evt);
            }
        });
        functionsJList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                functionsJListKeyTyped(evt);
            }
        });
        jScrollPane.setViewportView(functionsJList);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.LINE_START);

        descriptionJPanel.setLayout(new java.awt.BorderLayout());

        titleDescriptionJLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        descriptionJPanel.add(titleDescriptionJLabel, java.awt.BorderLayout.PAGE_START);

        descriptionFunctionJLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        descriptionFunctionJLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descriptionJPanel.add(descriptionFunctionJLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(descriptionJPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo che viene invocato quando si clicca il mouse sopra alla lista di
     * voci sul Frame.
     *
     * @param evt L'evento.
     */
    private void functionsJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_functionsJListMouseClicked
        sendTextToLabel(text[functionsJList.getSelectedIndex()], functionsJList.getSelectedValue());
    }//GEN-LAST:event_functionsJListMouseClicked

    /**
     * Metodo che viene invocato quando si clicca un tasto sopra alla lista di
     * file (in modo che ci si possa navigare anche con le frecce della
     * tastiera).
     *
     * @param evt L'evento.
     */
    private void functionsJListKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_functionsJListKeyTyped
        sendTextToLabel(text[functionsJList.getSelectedIndex()], functionsJList.getSelectedValue());
    }//GEN-LAST:event_functionsJListKeyTyped
    
    /**
     * Imposta il titolo dela scheda e il relativo testo.
     * 
     * @param text Testo che si vuole visualizzare.
     * @param title Titolo della scheda.
     */
    private void sendTextToLabel(String text, String title) {
        titleDescriptionJLabel.setText(title);
        descriptionFunctionJLabel.setText("<html>" + text + "</html>");
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
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TutorialFrame().setVisible(true);
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
    private javax.swing.JLabel descriptionFunctionJLabel;
    private javax.swing.JPanel descriptionJPanel;
    private javax.swing.JList<String> functionsJList;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel titleDescriptionJLabel;
    // End of variables declaration//GEN-END:variables
}