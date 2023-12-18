/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_labyrinthe;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author bapti
 */
public class FenetreAccueil extends javax.swing.JFrame {

    private final Image background;
    private int nbJoueurs;
    int numSkin1 = 1;
    int numSkin2 = 2;
    int numSkin3 = 3;
    int numSkin4 = 4;

    /**
     * Creates new form FenetreAccueil
     */
    public FenetreAccueil() {
        CustomInitComponents();
        this.background = new ImageIcon("./accueil.png").getImage();
    }

    private void CustomInitComponents() {

        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // on créé un fond noir
        getContentPane().add(fond_noir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, getWidth(), getHeight()));

        panel_noms.setVisible(false);

        panel_erreur.setVisible(false);

        panel_solo.setVisible(false);

        panel_multiplayer.setVisible(false);

        fond_menu.setVisible(false);

        pack();
        setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_home = new javax.swing.JButton();
        panel_noms = new javax.swing.JPanel();
        panel_j1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nomJoueur1 = new javax.swing.JTextField();
        skinJ1 = new javax.swing.JButton();
        panel_j4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nomJoueur4 = new javax.swing.JTextField();
        skinJ4 = new javax.swing.JButton();
        panel_j3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomJoueur3 = new javax.swing.JTextField();
        skinJ3 = new javax.swing.JButton();
        btn_start = new javax.swing.JButton();
        panel_erreur = new javax.swing.JPanel();
        panel_j2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nomJoueur2 = new javax.swing.JTextField();
        skinJ2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panel_multiplayer = new javax.swing.JPanel();
        panel_btn = new javax.swing.JPanel();
        btn_2j = new javax.swing.JButton();
        btn_4j = new javax.swing.JButton();
        btn_3j = new javax.swing.JButton();
        panel_solo = new javax.swing.JPanel();
        btn_solovs = new javax.swing.JButton();
        btn_solovsIA = new javax.swing.JButton();
        panel_modes = new javax.swing.JPanel();
        btn_solo = new javax.swing.JButton();
        btn_multiplayer = new javax.swing.JButton();
        img_labyrinthe = new javax.swing.JLabel();
        fond_menu = new javax.swing.JLabel();
        fond_noir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/bouton-daccueil-pour-linterface.png"))); // NOI18N
        btn_home.setContentAreaFilled(false);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 580, 70, 70));

        panel_noms.setOpaque(false);
        panel_noms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_j1.setOpaque(false);
        panel_j1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Joueur 1 :");
        panel_j1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        nomJoueur1.setToolTipText("");
        nomJoueur1.setPreferredSize(new java.awt.Dimension(100, 22));
        nomJoueur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomJoueur1ActionPerformed(evt);
            }
        });
        panel_j1.add(nomJoueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, 30));

        skinJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin1.png"))); // NOI18N
        skinJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinJ1ActionPerformed(evt);
            }
        });
        panel_j1.add(skinJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 126, -1));

        panel_noms.add(panel_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 250));

        panel_j4.setOpaque(false);
        panel_j4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Joueur 4 : ");
        panel_j4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        nomJoueur4.setToolTipText("");
        nomJoueur4.setPreferredSize(new java.awt.Dimension(100, 22));
        nomJoueur4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomJoueur4ActionPerformed(evt);
            }
        });
        panel_j4.add(nomJoueur4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, 30));

        skinJ4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin4.png"))); // NOI18N
        skinJ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinJ4ActionPerformed(evt);
            }
        });
        panel_j4.add(skinJ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 126, 201));

        panel_noms.add(panel_j4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 340, 240));

        panel_j3.setOpaque(false);
        panel_j3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Joueur 3 :");
        panel_j3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        nomJoueur3.setToolTipText("");
        nomJoueur3.setPreferredSize(new java.awt.Dimension(100, 22));
        nomJoueur3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomJoueur3ActionPerformed(evt);
            }
        });
        panel_j3.add(nomJoueur3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, 30));

        skinJ3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin3.png"))); // NOI18N
        skinJ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinJ3ActionPerformed(evt);
            }
        });
        panel_j3.add(skinJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 126, 201));

        panel_noms.add(panel_j3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 340, 240));

        btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/Play.png"))); // NOI18N
        btn_start.setToolTipText("");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panel_noms.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 300, 80));

        panel_erreur.setOpaque(false);
        panel_noms.add(panel_erreur, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 220, 40));

        panel_j2.setOpaque(false);
        panel_j2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Joueur 2 :");
        panel_j2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));
        panel_j2.add(nomJoueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 100, 30));

        skinJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin2.png"))); // NOI18N
        skinJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinJ2ActionPerformed(evt);
            }
        });
        panel_j2.add(skinJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 126, 201));

        panel_noms.add(panel_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 360, 220));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Veuillez entrer tous les noms. ");
        panel_noms.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        getContentPane().add(panel_noms, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 1080, 620));

        panel_multiplayer.setOpaque(false);
        panel_multiplayer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_btn.setBackground(new java.awt.Color(0, 0, 0));
        panel_btn.setOpaque(false);
        panel_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_2j.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btn_2j.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/button2players.png"))); // NOI18N
        btn_2j.setToolTipText("");
        btn_2j.setActionCommand("Start");
        btn_2j.setDoubleBuffered(true);
        btn_2j.setFocusCycleRoot(true);
        btn_2j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2jActionPerformed(evt);
            }
        });
        panel_btn.add(btn_2j, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 300, 80));

        btn_4j.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btn_4j.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/button4players.png"))); // NOI18N
        btn_4j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4jActionPerformed(evt);
            }
        });
        panel_btn.add(btn_4j, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 300, 80));

        btn_3j.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btn_3j.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/button3players.png"))); // NOI18N
        btn_3j.setDefaultCapable(false);
        btn_3j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3jActionPerformed(evt);
            }
        });
        panel_btn.add(btn_3j, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 300, 80));

        panel_multiplayer.add(panel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 110));

        getContentPane().add(panel_multiplayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 980, 130));

        panel_solo.setOpaque(false);
        panel_solo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_solovs.setText("Contre-la-montre");
        btn_solovs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_solovsActionPerformed(evt);
            }
        });
        panel_solo.add(btn_solovs, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 200, 40));

        btn_solovsIA.setText("Solo vs IA");
        btn_solovsIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_solovsIAActionPerformed(evt);
            }
        });
        panel_solo.add(btn_solovsIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 200, 40));

        getContentPane().add(panel_solo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 280, 140));

        panel_modes.setOpaque(false);
        panel_modes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_solo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/Singleplayer.png"))); // NOI18N
        btn_solo.setToolTipText("");
        btn_solo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_soloActionPerformed(evt);
            }
        });
        panel_modes.add(btn_solo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        btn_multiplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/Multiplayer.png"))); // NOI18N
        btn_multiplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_multiplayerActionPerformed(evt);
            }
        });
        panel_modes.add(btn_multiplayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 300, 80));

        getContentPane().add(panel_modes, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 610, 120));

        img_labyrinthe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/accueil.png"))); // NOI18N
        getContentPane().add(img_labyrinthe, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 910, 640));

        fond_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/landscape.png"))); // NOI18N
        getContentPane().add(fond_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -170, -1, -1));

        fond_noir.setBackground(new java.awt.Color(0, 51, 51));
        fond_noir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenus/fond_noir.png"))); // NOI18N
        getContentPane().add(fond_noir, new org.netbeans.lib.awtextra.AbsoluteConstraints(-620, 120, 1940, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_4jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4jActionPerformed
        clickBouton(true, 4);
    }//GEN-LAST:event_btn_4jActionPerformed

    private void btn_3jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3jActionPerformed
        clickBouton(true, 3);
    }//GEN-LAST:event_btn_3jActionPerformed

    private void btn_2jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2jActionPerformed
        clickBouton(true, 2);
    }//GEN-LAST:event_btn_2jActionPerformed

    private void nomJoueur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomJoueur1ActionPerformed
    }//GEN-LAST:event_nomJoueur1ActionPerformed

    private void nomJoueur3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomJoueur3ActionPerformed
    }//GEN-LAST:event_nomJoueur3ActionPerformed

    private void nomJoueur4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomJoueur4ActionPerformed
    }//GEN-LAST:event_nomJoueur4ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed

        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
        String nomJ1 = nomJoueur1.getText();
        String nomJ2 = nomJoueur2.getText();
        String nomJ3 = nomJoueur3.getText();
        String nomJ4 = nomJoueur4.getText();

        Joueur player1 = new Joueur(nomJ1, "skin1");
        Joueur player2 = new Joueur(nomJ2, "skin2");
        Joueur player3 = new Joueur(nomJ3, "skin3");
        Joueur player4 = new Joueur(nomJ4, "skin4");

        switch (nbJoueurs) {

            case 1:
                if (nomJoueur1.getText().isEmpty()) {
                    panel_erreur.setVisible(true);
                } else {
                    listeJoueur.add(player1);
                    Partie partie = new Partie(listeJoueur);
                    partie.startWindow();
                    this.dispose();
                }
            case 2:
                if (nomJoueur1.getText().isEmpty() || nomJoueur2.getText().isEmpty()) {
                    panel_erreur.setVisible(true);
                } else {
                    listeJoueur.add(player1);
                    listeJoueur.add(player2);
                    Partie partie = new Partie(listeJoueur);
                    partie.startWindow();
                    this.dispose();
                }
                break;
            case 3:
                if (nomJoueur1.getText().isEmpty() || nomJoueur2.getText().isEmpty() || nomJoueur3.getText().isEmpty()) {
                    panel_erreur.setVisible(true);
                } else {
                    listeJoueur.add(player1);
                    listeJoueur.add(player2);
                    listeJoueur.add(player3);
                    Partie partie = new Partie(listeJoueur);
                    partie.startWindow();
                    this.dispose();
                }
                break;
            case 4:
                if (nomJoueur1.getText().isEmpty() || nomJoueur2.getText().isEmpty() || nomJoueur3.getText().isEmpty() || nomJoueur4.getText().isEmpty()) {
                    panel_erreur.setVisible(true);
                } else {
                    listeJoueur.add(player1);
                    listeJoueur.add(player2);
                    listeJoueur.add(player3);
                    listeJoueur.add(player4);
                    Partie partie = new Partie(listeJoueur);
                    partie.startWindow();
                    this.dispose();
                }
                break;
        }
    }//GEN-LAST:event_btn_startActionPerformed

    private void btn_mode() {
        img_labyrinthe.setVisible(false);
        panel_modes.setVisible(false);
        fond_menu.setVisible(true);
        skinJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin1.png"))); // NOI18N

    }

    private void btn_soloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_soloActionPerformed
        btn_mode();
        panel_solo.setVisible(true);
    }//GEN-LAST:event_btn_soloActionPerformed

    private void btn_multiplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_multiplayerActionPerformed
        btn_mode();
        panel_multiplayer.setVisible(true);
    }//GEN-LAST:event_btn_multiplayerActionPerformed

    private void btn_solovsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_solovsActionPerformed
        clickBouton(true, 1);
    }//GEN-LAST:event_btn_solovsActionPerformed

    private void btn_solovsIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_solovsIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_solovsIAActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        home();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void skinJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinJ1ActionPerformed
        changeSkin(1);
    }//GEN-LAST:event_skinJ1ActionPerformed

    private void skinJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinJ2ActionPerformed
        changeSkin(2);
    }//GEN-LAST:event_skinJ2ActionPerformed

    private void skinJ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinJ3ActionPerformed
        changeSkin(3);
    }//GEN-LAST:event_skinJ3ActionPerformed

    private void skinJ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinJ4ActionPerformed
        changeSkin(4);
    }//GEN-LAST:event_skinJ4ActionPerformed

    private void changeSkin(int numPlayer) {
        switch (numPlayer) {
            case 1:
                if (numSkin1 == 5) {
                    numSkin1 = 1;
                } else {
                    numSkin1++;
                }
                skinJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin" + numSkin1 + ".png")));
                break;

            case 2:
                if (numSkin2 == 5) {
                    numSkin2 = 1;
                } else {
                    numSkin2++;
                }
                skinJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin" + numSkin2 + ".png")));
                break;

            case 3:
                if (numSkin3 == 5) {
                    numSkin3 = 1;
                } else {
                    numSkin3++;
                }
                skinJ3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin" + numSkin3 + ".png")));

                break;

            case 4:
                if (numSkin4 == 5) {
                    numSkin4 = 1;
                } else {
                    numSkin4++;
                }
                skinJ4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Players/skin" + numSkin4 + ".png")));
                break;
        }
    }

    private void home() {
        numSkin1 = 1;

        img_labyrinthe.setVisible(true);

        fond_menu.setVisible(false);

        panel_noms.setVisible(false);

        panel_erreur.setVisible(false);

        panel_solo.setVisible(false);

        panel_multiplayer.setVisible(false);

        panel_modes.setVisible(true);

        clickBouton(false, 5);

    }

    private void clickBouton(boolean cliqué, int nbJoueurs) {

        this.nbJoueurs = nbJoueurs;
        panel_btn.setVisible(!cliqué);
        panel_noms.setVisible(cliqué);
        panel_j1.setVisible(cliqué);
        panel_j2.setVisible(false);
        panel_j3.setVisible(false);
        panel_j4.setVisible(false);

        switch (nbJoueurs) {
            case 2:
                panel_j2.setVisible(cliqué);
                panel_solo.setVisible(false);
                break;
            case 3:
                panel_j2.setVisible(cliqué);
                panel_j3.setVisible(cliqué);
                break;
            case 4:
                panel_j2.setVisible(cliqué);
                panel_j3.setVisible(cliqué);
                panel_j4.setVisible(cliqué);
                break;
            default:
                panel_solo.setVisible(false);
                break;
        }

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
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FenetreAccueil fenetre = new FenetreAccueil();
            fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH); // Ouvrir en plein écran
            fenetre.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_2j;
    private javax.swing.JButton btn_3j;
    private javax.swing.JButton btn_4j;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_multiplayer;
    private javax.swing.JButton btn_solo;
    private javax.swing.JButton btn_solovs;
    private javax.swing.JButton btn_solovsIA;
    private javax.swing.JButton btn_start;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fond_menu;
    private javax.swing.JLabel fond_noir;
    private javax.swing.JLabel img_labyrinthe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nomJoueur1;
    private javax.swing.JTextField nomJoueur2;
    private javax.swing.JTextField nomJoueur3;
    private javax.swing.JTextField nomJoueur4;
    private javax.swing.JPanel panel_btn;
    private javax.swing.JPanel panel_erreur;
    private javax.swing.JPanel panel_j1;
    private javax.swing.JPanel panel_j2;
    private javax.swing.JPanel panel_j3;
    private javax.swing.JPanel panel_j4;
    private javax.swing.JPanel panel_modes;
    private javax.swing.JPanel panel_multiplayer;
    private javax.swing.JPanel panel_noms;
    private javax.swing.JPanel panel_solo;
    private javax.swing.JButton skinJ1;
    private javax.swing.JButton skinJ2;
    private javax.swing.JButton skinJ3;
    private javax.swing.JButton skinJ4;
    // End of variables declaration//GEN-END:variables
}
