/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_labyrinthe;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author bapti
 */
public class FenetreFinPartie extends javax.swing.JFrame {

    ArrayList<Joueur> podium;

    /**
     * Creates new form FenetreFinPartie
     *
     * @param podium
     */
    public FenetreFinPartie(ArrayList<Joueur> podium) {
        this.podium = podium;
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        affichageSkins();

    }

    private void affichageSkins() {
        for (int i = 0; i < podium.size(); i++) {
            switch (i) {
                case 0:
                    skin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/" + podium.get(i).skinpath + ".png")));
                    lbl_joueur1.setText(podium.get(i).name);
                    break;
                case 1:
                    skin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/" + podium.get(i).skinpath + ".png")));
                    lbl_joueur2.setText(podium.get(i).name);
                    break;

                case 2:
                    skin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/" + podium.get(i).skinpath + ".png")));
                    lbl_joueur3.setText(podium.get(i).name);
                    break;
            }

        }
        System.out.println(podium.get(0).skinpath);
    }

    public FenetreFinPartie() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_podium = new javax.swing.JPanel();
        lbl_joueur2 = new javax.swing.JLabel();
        lbl_joueur1 = new javax.swing.JLabel();
        lbl_joueur3 = new javax.swing.JLabel();
        skin1 = new javax.swing.JLabel();
        skin2 = new javax.swing.JLabel();
        skin3 = new javax.swing.JLabel();
        fond_podium = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_podium.setOpaque(false);
        panel_podium.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_joueur2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lbl_joueur2.setText("    ");
        panel_podium.add(lbl_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        lbl_joueur1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lbl_joueur1.setText("    ");
        panel_podium.add(lbl_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        lbl_joueur3.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lbl_joueur3.setText("    ");
        panel_podium.add(lbl_joueur3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        panel_podium.add(skin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 126, 201));
        panel_podium.add(skin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 126, 201));
        panel_podium.add(skin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 126, 201));

        fond_podium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/podium.png"))); // NOI18N
        panel_podium.add(fond_podium, new org.netbeans.lib.awtextra.AbsoluteConstraints(-340, -10, 860, -1));

        getContentPane().add(panel_podium, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 530, 600));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/sunset.png"))); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FenetreFinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreFinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreFinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreFinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FenetreFinPartie().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel fond_podium;
    private javax.swing.JLabel lbl_joueur1;
    private javax.swing.JLabel lbl_joueur2;
    private javax.swing.JLabel lbl_joueur3;
    private javax.swing.JPanel panel_podium;
    private javax.swing.JLabel skin1;
    private javax.swing.JLabel skin2;
    private javax.swing.JLabel skin3;
    // End of variables declaration//GEN-END:variables
}