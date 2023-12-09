package projet_labyrinthe;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Fenetre Principale du Jeu
 *
 * @author Ody
 * @version 1.0
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    /**
     * Le plateau de jeu
     */
    Plateau plateau = new Plateau();
    
    Joueur turnOff = new Joueur();

    /**
     * Constructeur de la fenêtre Cette fenetre représente graphiquement le
     * plateau ainsi que l'interface graphique du jeu.
     *
     * @param plateau Le plateau de jeu qui comprend les missions, cartes, et
     * joueurs
     */
    public FenetrePrincipale(Plateau plateau, Joueur first) {
        this.plateau = plateau;
        this.turnOff = first;
        plateau.setAllMissions();
        plateau.setAllMissionsToCards();
        plateau.placeAllPlayers();
        initComponents();
        genUIBoard();
        genUIPlayerHasToPlay(first);
        genUIPossibleActions();
        this.setVisible(true);
        
        //addMissionCards();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private FenetrePrincipale() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    /**
     * méthode qui affiche une carte dans l'emplacement de la carte à injecter
     * dans le plateau
     *
     * @param carte carte à afficher en tant que carte à injecter
     */
    public void genUIWaitingCard(Carte carte) {

        //assignation graphique de la carte
        panneau_carte_attente.removeAll();
        panneau_carte_attente.add(new UICarteOut(carte));
    }

    public void genUIPlayerHasToPlay(Joueur player) {
        
        this.turnOff = player;
        Carte carte = new Carte();
        carte.isRidedByPlayers.add(player);
        //assignation graphique du panel
        PanelTour.removeAll();
        PanelTour.add(new UITurn(carte));
    }

    public void genUIPossibleActions(){
        
        //Recuperation des coordonnees du joueur dont c'est le tour
        int posx = turnOff.getPosx();
        int posy = turnOff.getPosy();
        
        // Temp est la variable qui représente la direction testée
        boolean temp;
        // Tempclose représente la direction de la carte conjuguée pour la vérif
        boolean tempclose = false;
        
        //Up -> 3 Conditions :
        // Il n'est pas en x=0 
        // Sa carte permet d'aller vers le haut
        // La carte du dessus permet d'aller vers le bas

        temp = this.plateau.getPlateau().get(posx).get(posy).getAllowingDirections()[0];
        if(posx!=0){tempclose = this.plateau.getPlateau().get(posx-1).get(posy).getAllowingDirections()[1];}
        
        if(posx !=0 && temp && tempclose){
            Up.setVisible(true);
        } else Up.setVisible(false);
        
        //Down -> 3 Conditions :
        // Il n'est pas en x=6
        // Sa carte permet d'aller vers le bas
        // La carte d'en dessous permet d'aller vers le haut
        
        temp = this.plateau.getPlateau().get(posx).get(posy).getAllowingDirections()[1];
        if(posx!=6){tempclose = this.plateau.getPlateau().get(posx+1).get(posy).getAllowingDirections()[0];}
        
        if(posx!=6 && temp && tempclose){
            Down.setVisible(true);
        } else Down.setVisible(false);
        
        //Right -> 3 conditions :
        // Il n'est pas en y=6
        // Sa carte permet d'aller vers la droite
        // La carte à sa droite permet d'aller vers la gauche
        
        temp = this.plateau.getPlateau().get(posx).get(posy).getAllowingDirections()[2];
        if(posy!=6){tempclose = this.plateau.getPlateau().get(posx).get(posy+1).getAllowingDirections()[3];}
        if(posx!=6 && temp && tempclose){
            Right.setVisible(true);
        } else Right.setVisible(false);
        
        //Left -> 3 conditions :
        // Il n'est pas en y=0
        // Sa carte permet d'aller à gauche
        // La carte à sa gauche permet d'aller vers la droite
        
        temp = this.plateau.getPlateau().get(posx).get(posy).getAllowingDirections()[3];
        if(posy!=0){tempclose = this.plateau.getPlateau().get(posx).get(posy-1).getAllowingDirections()[2];}
        if(posy!=0 && temp && tempclose){
            Left.setVisible(true);
        } else Left.setVisible(false);
        
    }


    /**
     * Methode qui génère graphiquement tout le plateau : Les cartes, les
     * missions, et les joueurs
     */
    public void genUIBoard() {
           //Generation de la grille dans le cas ou c'est la première génération
            for (int x=0;x < 7; x++ ){
                for(int y=0;y<7;y++){

                    GridPanel.add(new UICarte(this.plateau.getPlateau().get(x).get(y)));  
                } 
            }
        genUIWaitingCard(plateau.carteAttente);
    }
    
    public void injectUIX(int x, boolean gauche){
        plateau.injectX(x, gauche);
        GridPanel.removeAll();
        genUIBoard();
        revalidate();
        repaint();
        // On corrige les coordonnées des cartes
        this.plateau.setCorrectCoordinates();

    }
    
    public void injectUIY(int y, boolean haut){
        plateau.injectY(y, haut);
        GridPanel.removeAll();
        genUIBoard();
        revalidate();
        repaint();
        // On corrige les coordonnées des cartes
        this.plateau.setCorrectCoordinates();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_carte_attente = new javax.swing.JPanel();
        btn_x1g = new javax.swing.JButton();
        btn_x1d = new javax.swing.JButton();
        btn_x5g = new javax.swing.JButton();
        btn_x3g = new javax.swing.JButton();
        btn_x3d = new javax.swing.JButton();
        btn_x5d = new javax.swing.JButton();
        btn_y1h = new javax.swing.JButton();
        btn_y3h = new javax.swing.JButton();
        btn_y5h = new javax.swing.JButton();
        btn_y1b = new javax.swing.JButton();
        btn_y3b = new javax.swing.JButton();
        btn_y5b = new javax.swing.JButton();
        GridPanel = new javax.swing.JPanel();
        Text1 = new javax.swing.JLabel();
        RotateRight1 = new javax.swing.JButton();
        RotateRight = new javax.swing.JButton();
        Text2 = new javax.swing.JLabel();
        PanelTour = new javax.swing.JPanel();
        Text3 = new javax.swing.JLabel();
        Left = new javax.swing.JButton();
        Up = new javax.swing.JButton();
        Down = new javax.swing.JButton();
        Right = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1515, 750));
        setName("Labyrinthe"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_carte_attente.setBackground(new java.awt.Color(153, 153, 255));
        panneau_carte_attente.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panneau_carte_attente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 90, 90));

        btn_x1g.setText("▶");
        btn_x1g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x1gActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x1g, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        btn_x1d.setText("◀");
        btn_x1d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x1dActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x1d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 190, -1, -1));

        btn_x5g.setText("▶");
        btn_x5g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x5gActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x5g, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, -1, -1));

        btn_x3g.setText("▶");
        btn_x3g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x3gActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x3g, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        btn_x3d.setText("◀");
        btn_x3d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x3dActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x3d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 360, -1, -1));

        btn_x5d.setText("◀");
        btn_x5d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x5dActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x5d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, -1, -1));

        btn_y1h.setText("▼");
        btn_y1h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y1hActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y1h, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        btn_y3h.setText("▼");
        btn_y3h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y3hActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y3h, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        btn_y5h.setText("▼");
        btn_y5h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y5hActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y5h, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        btn_y1b.setText("▲");
        btn_y1b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y1bActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y1b, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 710, -1, -1));

        btn_y3b.setText("▲");
        btn_y3b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y3bActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y3b, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 710, -1, -1));

        btn_y5b.setText("▲");
        btn_y5b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y5bActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y5b, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 710, -1, -1));

        GridPanel.setBackground(new java.awt.Color(105, 55, 0));
        GridPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        GridPanel.setLayout(new java.awt.GridLayout(7, 7));
        getContentPane().add(GridPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 630, 630));

        Text1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Text1.setText("Carte en dehors du plateau :");
        getContentPane().add(Text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        RotateRight1.setText("↰");
        RotateRight1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RotateRight1ActionPerformed(evt);
            }
        });
        getContentPane().add(RotateRight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        RotateRight.setText("↱");
        RotateRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RotateRightActionPerformed(evt);
            }
        });
        getContentPane().add(RotateRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        Text2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Text2.setText("    C'est au tour de :");
        getContentPane().add(Text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        PanelTour.setBackground(new java.awt.Color(153, 255, 153));
        PanelTour.setForeground(new java.awt.Color(204, 204, 255));
        PanelTour.setPreferredSize(new java.awt.Dimension(90, 90));
        PanelTour.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanelTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, -1));

        Text3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Text3.setText("    Actions possibles :");
        getContentPane().add(Text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        Left.setText("←");
        getContentPane().add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 50, 40));

        Up.setText("↑");
        Up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpActionPerformed(evt);
            }
        });
        getContentPane().add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 50, 40));

        Down.setText("↓");
        getContentPane().add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 50, 40));

        Right.setText("→");
        getContentPane().add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 50, 40));

        getAccessibleContext().setAccessibleName("Labyrinthe");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_x1gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x1gActionPerformed

        injectUIX(1, true);
    }//GEN-LAST:event_btn_x1gActionPerformed

    private void btn_x1dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x1dActionPerformed
        injectUIX(1, false);
    }//GEN-LAST:event_btn_x1dActionPerformed

    private void btn_x3gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x3gActionPerformed
        injectUIX(3, true);
    }//GEN-LAST:event_btn_x3gActionPerformed

    private void btn_x5gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x5gActionPerformed
        injectUIX(5, true);
    }//GEN-LAST:event_btn_x5gActionPerformed

    private void btn_x3dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x3dActionPerformed
        injectUIX(3, false);
    }//GEN-LAST:event_btn_x3dActionPerformed

    private void btn_x5dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x5dActionPerformed
        injectUIX(5, false);
    }//GEN-LAST:event_btn_x5dActionPerformed

    private void btn_y1hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y1hActionPerformed
        injectUIY(1,true);
    }//GEN-LAST:event_btn_y1hActionPerformed

    private void btn_y5hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y5hActionPerformed
        injectUIY(5,true);
    }//GEN-LAST:event_btn_y5hActionPerformed

    private void btn_y3hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y3hActionPerformed
        injectUIY(3,true);
    }//GEN-LAST:event_btn_y3hActionPerformed

    private void btn_y1bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y1bActionPerformed
        injectUIY(1,false);
    }//GEN-LAST:event_btn_y1bActionPerformed

    private void btn_y3bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y3bActionPerformed
        injectUIY(3,false);
    }//GEN-LAST:event_btn_y3bActionPerformed

    private void btn_y5bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y5bActionPerformed
        injectUIY(5,false);
    }//GEN-LAST:event_btn_y5bActionPerformed

    private void RotateRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RotateRightActionPerformed
        // TODO add your handling code here:
        this.plateau.carteAttente.rotateRight();
        GridPanel.removeAll();
        genUIBoard();
        revalidate();
        repaint();
    }//GEN-LAST:event_RotateRightActionPerformed

    private void RotateRight1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RotateRight1ActionPerformed
        // TODO add your handling code here:
        this.plateau.carteAttente.rotateLeft();
        GridPanel.removeAll();
        genUIBoard();
        revalidate();
        repaint();
    }//GEN-LAST:event_RotateRight1ActionPerformed

    private void UpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpActionPerformed

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
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Down;
    private javax.swing.JPanel GridPanel;
    private javax.swing.JButton Left;
    private javax.swing.JPanel PanelTour;
    private javax.swing.JButton Right;
    private javax.swing.JButton RotateRight;
    private javax.swing.JButton RotateRight1;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text2;
    private javax.swing.JLabel Text3;
    private javax.swing.JButton Up;
    private javax.swing.JButton btn_x1d;
    private javax.swing.JButton btn_x1g;
    private javax.swing.JButton btn_x3d;
    private javax.swing.JButton btn_x3g;
    private javax.swing.JButton btn_x5d;
    private javax.swing.JButton btn_x5g;
    private javax.swing.JButton btn_y1b;
    private javax.swing.JButton btn_y1h;
    private javax.swing.JButton btn_y3b;
    private javax.swing.JButton btn_y3h;
    private javax.swing.JButton btn_y5b;
    private javax.swing.JButton btn_y5h;
    private javax.swing.JPanel panneau_carte_attente;
    // End of variables declaration//GEN-END:variables
}
