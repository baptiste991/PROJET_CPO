package projet_labyrinthe;

import java.awt.Component;
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

    /**
     * Constructeur de la fenêtre Cette fenetre représente graphiquement le
     * plateau ainsi que l'interface graphique du jeu.
     *
     * @param plateau Le plateau de jeu qui comprend les missions, cartes, et
     * joueurs
     */
    public FenetrePrincipale(Plateau plateau) {
        this.plateau = plateau;
        initComponents();
        genUIBoard();
        genUIWaitingCard(this.plateau.carteAttente);
        this.setVisible(true);

        //addMissionCards();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private FenetrePrincipale() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Methode qui place graphiquement les cartes du plateau
     *
     * @param posx Coordonnée x
     * @param posy Coordonnée y
     */
    public void gen1UIcard(int posx, int posy) {


        // Assignation graphique du type de carte
        switch (this.plateau.getPlateau().get(posx).get(posy).getType()) {
            case "I" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/I.png")));
            }
            case "_" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/_.png")));
            }
            case "TUp" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TUp.png")));
            }
            case "TDown" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TDown.png")));
            }
            case "TRight" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TRight.png")));
            }
            case "TLeft" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TLeft.png")));
            }
            case "UpRightC" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/UpRightC.png")));
            }
            case "UpLeftC" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/UpLeftC.png")));
            }
            case "DownRightC" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/DownRightC.png")));
            }
            case "DownLeftC" -> {
                getLabelByName("x" + String.valueOf(posx) + "y" + String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/DownLeftC.png")));
            }
        }

        //Points de départs
        getLabelByName("x0y0").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/blue.png")));
        getLabelByName("x0y6").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/green.png")));
        getLabelByName("x6y0").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/yellow.png")));
        getLabelByName("x6y6").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/red.png")));
    }

    /**
     * méthode qui affiche une carte dans l'emplacement de la carte à injecter
     * dans le plateau
     *
     * @param carte carte à afficher en tant que carte à injecter
     */
    public void genUIWaitingCard(Carte carte) {

        //assignation graphique de la carte
        switch (carte.getType()) {
            case "I" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/I.png")));
            }
            case "_" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/_.png")));
            }
            case "TUp" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TUp.png")));
            }
            case "TDown" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TDown.png")));
            }
            case "TRight" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TRight.png")));
            }
            case "TLeft" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TLeft.png")));
            }
            case "UpRightC" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/UpRightC.png")));
            }
            case "UpLeftC" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/UpLeftC.png")));
            }
            case "DownRightC" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/DownRightC.png")));
            }
            case "DownLeftC" -> {
                lbl_carteAttente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/DownLeftC.png")));
            }
        }
    }

    /**
     * Methode qui assigne graphiquement a l'ensemble des cartes leur image
     * respective.
     */
    public void genUICards() {

        //On parcours toutes les cartes du plateau
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                gen1UIcard(x, y);
            }
        }
    }

    /**
     * Methode qui génère graphiquement une mission sur le plateau : Associe à
     * une mission sa représentation graphique
     */
    public void genUIMissions() {

        //On parcourt toutes les missions pour les représenter
        for (int i = 0; i < 16; i++) {
            gen1UIMission(this.plateau.getAllMissions().get(i));
        }
    }

    /**
     * Methode qui génère graphiquement toutes les missions sur le plateau :
     * Associe a toutes les missions leur représentation graphique
     *
     * @param mission La mission que l'on va représenter graphiquement
     */
    public void gen1UIMission(Mission mission) {

    }

    /**
     * Méthode qui ajoute les missions sur les cartes du plateau ayant des
     * missions
     */
    public void addMissionCards() {

        // on définit les missions + les attribus sur des cartes spécifiques
        this.plateau.setAllMissions();
        this.plateau.setAllMissionsToCards();

        // on parcourt le plateau pour afficher les missions sur les cartes
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                // test si la carte possède une mission
                if (this.plateau.getPlateau().get(i).get(j).getMission() != null) {
                    // Obtenez la mission associée à la carte
                    Mission mission = this.plateau.getPlateau().get(i).get(j).getMission();

                    // Obtenez le nom de l'objet de la mission
                    String objectName = mission.getObjet();

                    // Obtenez le chemin de l'image correspondante à la mission
                    String imagePath = "/images/Cards/mission/" + objectName + ".png";

                    // Créez un nouvel ImageIcon à partir du chemin de l'image
                    ImageIcon missionIcon = new ImageIcon(getClass().getResource(imagePath));

                    // Affectez l'icône à l'étiquette de la carte
                    getLabelByName("x" + i + "y" + j).setIcon(missionIcon);
                }
            }

        }
    }

    /**
     * Methode qui représente graphiquement un joueur
     *
     * @param player Le joueur a afficher sur le plateau
     */
    public void gen1UIPlayer(Joueur player) {

    }

    /**
     * Methode qui affiche l'ensemble des joueurs sur le plateau
     */
    public void genUIPlayers() {

        //On parcourt le nombre de joueurs
        for (int i = 0; i < this.plateau.getListeDeJoueurs().size(); i++) {
            gen1UIPlayer(this.plateau.getListeDeJoueurs().get(i));
        }
    }

    /**
     * Methode qui génère graphiquement tout le plateau : Les cartes, les
     * missions, et les joueurs
     */
    public void genUIBoard() {

        genUIMissions();
        genUICards();
        genUIPlayers();
        genUIWaitingCard(plateau.carteAttente);

        //Une fois toutes les images assignées on re déssine le layout
        // Affichage des JLabel
        Plateau.revalidate();
        Plateau.repaint();
    }

    /**
     * Methode qui permet d'accéder à un Jlabel en fonction de son nom
     *
     * @param labelName Le nom du label
     * @return
     */
    public JLabel getLabelByName(String labelName) {
        Component[] components = this.Plateau.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel && component.getName().equals(labelName)) {
                return (JLabel) component;
            }
        }
        return null; // Aucun JLabel trouvé avec le nom spécifié
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Plateau = new javax.swing.JPanel();
        x0y0 = new javax.swing.JLabel();
        x0y2 = new javax.swing.JLabel();
        x0y4 = new javax.swing.JLabel();
        x0y6 = new javax.swing.JLabel();
        x2y0 = new javax.swing.JLabel();
        x2y2 = new javax.swing.JLabel();
        x2y4 = new javax.swing.JLabel();
        x2y6 = new javax.swing.JLabel();
        x4y0 = new javax.swing.JLabel();
        x4y2 = new javax.swing.JLabel();
        x4y4 = new javax.swing.JLabel();
        x4y6 = new javax.swing.JLabel();
        x6y0 = new javax.swing.JLabel();
        x6y2 = new javax.swing.JLabel();
        x6y4 = new javax.swing.JLabel();
        x6y6 = new javax.swing.JLabel();
        x0y1 = new javax.swing.JLabel();
        x0y3 = new javax.swing.JLabel();
        x0y5 = new javax.swing.JLabel();
        x1y0 = new javax.swing.JLabel();
        x1y1 = new javax.swing.JLabel();
        x1y2 = new javax.swing.JLabel();
        x1y3 = new javax.swing.JLabel();
        x1y4 = new javax.swing.JLabel();
        x1y5 = new javax.swing.JLabel();
        x1y6 = new javax.swing.JLabel();
        x2y1 = new javax.swing.JLabel();
        x2y3 = new javax.swing.JLabel();
        x2y5 = new javax.swing.JLabel();
        x3y0 = new javax.swing.JLabel();
        x3y1 = new javax.swing.JLabel();
        x3y2 = new javax.swing.JLabel();
        x3y3 = new javax.swing.JLabel();
        x3y4 = new javax.swing.JLabel();
        x3y5 = new javax.swing.JLabel();
        x3y6 = new javax.swing.JLabel();
        x4y1 = new javax.swing.JLabel();
        x4y3 = new javax.swing.JLabel();
        x4y5 = new javax.swing.JLabel();
        x5y0 = new javax.swing.JLabel();
        x5y1 = new javax.swing.JLabel();
        x5y2 = new javax.swing.JLabel();
        x5y3 = new javax.swing.JLabel();
        x5y4 = new javax.swing.JLabel();
        x5y6 = new javax.swing.JLabel();
        x5y5 = new javax.swing.JLabel();
        x6y1 = new javax.swing.JLabel();
        x6y3 = new javax.swing.JLabel();
        x6y5 = new javax.swing.JLabel();
        panneau_carte_attente = new javax.swing.JPanel();
        lbl_carteAttente = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1515, 750));
        setName("Labyrinthe"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Plateau.setBackground(new java.awt.Color(204, 204, 255));

        x0y0.setText("0");
        x0y0.setName("x0y0"); // NOI18N

        x0y2.setName("x0y2"); // NOI18N

        x0y4.setName("x0y4"); // NOI18N

        x0y6.setName("x0y6"); // NOI18N

        x2y0.setName("x2y0"); // NOI18N

        x2y2.setName("x2y2"); // NOI18N

        x2y4.setName("x2y4"); // NOI18N

        x2y6.setName("x2y6"); // NOI18N

        x4y0.setName("x4y0"); // NOI18N

        x4y2.setName("x4y2"); // NOI18N

        x4y4.setName("x4y4"); // NOI18N

        x4y6.setName("x4y6"); // NOI18N

        x6y0.setName("x6y0"); // NOI18N

        x6y2.setName("x6y2"); // NOI18N

        x6y4.setName("x6y4"); // NOI18N

        x6y6.setName("x6y6"); // NOI18N

        x0y1.setName("x0y1"); // NOI18N

        x0y3.setName("x0y3"); // NOI18N

        x0y5.setName("x0y5"); // NOI18N

        x1y0.setName("x1y0"); // NOI18N

        x1y1.setName("x1y1"); // NOI18N

        x1y2.setName("x1y2"); // NOI18N

        x1y3.setName("x1y3"); // NOI18N

        x1y4.setName("x1y4"); // NOI18N

        x1y5.setName("x1y5"); // NOI18N

        x1y6.setName("x1y6"); // NOI18N

        x2y1.setName("x2y1"); // NOI18N

        x2y3.setName("x2y3"); // NOI18N

        x2y5.setName("x2y5"); // NOI18N

        x3y0.setName("x3y0"); // NOI18N

        x3y1.setName("x3y1"); // NOI18N

        x3y2.setName("x3y2"); // NOI18N

        x3y3.setName("x3y3"); // NOI18N

        x3y4.setName("x3y4"); // NOI18N

        x3y5.setName("x3y5"); // NOI18N

        x3y6.setName("x3y6"); // NOI18N

        x4y1.setName("x4y1"); // NOI18N

        x4y3.setName("x4y3"); // NOI18N

        x4y5.setName("x4y5"); // NOI18N

        x5y0.setName("x5y0"); // NOI18N

        x5y1.setName("x5y1"); // NOI18N

        x5y2.setName("x5y2"); // NOI18N

        x5y3.setName("x5y3"); // NOI18N

        x5y4.setName("x5y4"); // NOI18N

        x5y6.setName("x5y6"); // NOI18N

        x5y5.setName("x5y5"); // NOI18N

        x6y1.setName("x6y1"); // NOI18N

        x6y3.setName("x6y3"); // NOI18N

        x6y5.setName("x6y5"); // NOI18N

        javax.swing.GroupLayout PlateauLayout = new javax.swing.GroupLayout(Plateau);
        Plateau.setLayout(PlateauLayout);
        PlateauLayout.setHorizontalGroup(
            PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlateauLayout.createSequentialGroup()
                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addComponent(x4y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x4y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x4y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addComponent(x0y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x0y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x0y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(x3y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(x3y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addComponent(x2y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x2y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(x2y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x3y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addComponent(x2y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x2y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addComponent(x4y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x4y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addComponent(x0y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x0y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(x2y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x2y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(x0y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x0y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x4y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addComponent(x3y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x3y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x3y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x3y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PlateauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addComponent(x1y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x1y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x1y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x1y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x1y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x1y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x1y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(x4y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PlateauLayout.createSequentialGroup()
                                    .addComponent(x5y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(x5y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(x5y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(x5y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(x5y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(x5y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(x5y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addComponent(x6y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x6y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x6y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x6y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x6y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x6y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x6y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PlateauLayout.setVerticalGroup(
            PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlateauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PlateauLayout.createSequentialGroup()
                                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(x0y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x0y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(x0y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x0y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x0y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x0y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x0y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(x1y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x1y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x1y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x1y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x1y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x1y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x1y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(x2y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x2y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x2y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(x2y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x2y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x2y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(x2y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(x3y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x3y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x3y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x3y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x3y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x3y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x3y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(x4y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(x4y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(x4y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(x4y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x4y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x4y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(x4y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x5y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x5y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x5y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x5y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x5y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x5y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x5y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(x6y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(x6y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(x6y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(x6y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(x6y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x6y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x6y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(Plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 48, 620, 620));

        panneau_carte_attente.setBackground(new java.awt.Color(153, 153, 255));

        lbl_carteAttente.setName("lbl_carteAttente"); // NOI18N

        javax.swing.GroupLayout panneau_carte_attenteLayout = new javax.swing.GroupLayout(panneau_carte_attente);
        panneau_carte_attente.setLayout(panneau_carte_attenteLayout);
        panneau_carte_attenteLayout.setHorizontalGroup(
            panneau_carte_attenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_carte_attenteLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lbl_carteAttente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        panneau_carte_attenteLayout.setVerticalGroup(
            panneau_carte_attenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneau_carte_attenteLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(lbl_carteAttente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        getContentPane().add(panneau_carte_attente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 260, 280));

        btn_x1g.setText("▶");
        btn_x1g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x1gActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x1g, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        btn_x1d.setText("◀");
        btn_x1d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x1dActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x1d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 170, -1, -1));

        btn_x5g.setText("▶");
        btn_x5g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x5gActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x5g, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, -1));

        btn_x3g.setText("▶");
        btn_x3g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x3gActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x3g, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        btn_x3d.setText("◀");
        btn_x3d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x3dActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x3d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 340, -1, -1));

        btn_x5d.setText("◀");
        btn_x5d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_x5dActionPerformed(evt);
            }
        });
        getContentPane().add(btn_x5d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 510, -1, -1));

        btn_y1h.setText("▼");
        btn_y1h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y1hActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y1h, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        btn_y3h.setText("▼");
        btn_y3h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y3hActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y3h, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

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
        getContentPane().add(btn_y1b, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 670, -1, -1));

        btn_y3b.setText("▲");
        btn_y3b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y3bActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y3b, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 670, -1, -1));

        btn_y5b.setText("▲");
        btn_y5b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_y5bActionPerformed(evt);
            }
        });
        getContentPane().add(btn_y5b, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 670, -1, -1));

        getAccessibleContext().setAccessibleName("Labyrinthe");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_x1gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x1gActionPerformed
        plateau.injectX(1, true);
        genUIBoard();
    }//GEN-LAST:event_btn_x1gActionPerformed

    private void btn_x1dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x1dActionPerformed
        plateau.injectX(1, false);
        genUIBoard();
    }//GEN-LAST:event_btn_x1dActionPerformed

    private void btn_x3gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x3gActionPerformed
        plateau.injectX(3, true);
        genUIBoard();
    }//GEN-LAST:event_btn_x3gActionPerformed

    private void btn_x5gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x5gActionPerformed
        plateau.injectX(5, true);
        genUIBoard();
    }//GEN-LAST:event_btn_x5gActionPerformed

    private void btn_x3dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x3dActionPerformed
        plateau.injectX(3, false);
        genUIBoard();
    }//GEN-LAST:event_btn_x3dActionPerformed

    private void btn_x5dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x5dActionPerformed
        plateau.injectX(5, false);
        genUIBoard();
    }//GEN-LAST:event_btn_x5dActionPerformed

    private void btn_y1hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y1hActionPerformed
        plateau.injectY(1, true);
        genUIBoard();
    }//GEN-LAST:event_btn_y1hActionPerformed

    private void btn_y5hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y5hActionPerformed
        plateau.injectY(5, true);
        genUIBoard();
    }//GEN-LAST:event_btn_y5hActionPerformed

    private void btn_y3hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y3hActionPerformed
        plateau.injectY(3, true);
        genUIBoard();
    }//GEN-LAST:event_btn_y3hActionPerformed

    private void btn_y1bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y1bActionPerformed
        plateau.injectY(1, false);
        genUIBoard();
    }//GEN-LAST:event_btn_y1bActionPerformed

    private void btn_y3bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y3bActionPerformed
        plateau.injectY(3, false);
        genUIBoard();
    }//GEN-LAST:event_btn_y3bActionPerformed

    private void btn_y5bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y5bActionPerformed
        plateau.injectY(5, false);
        genUIBoard();
    }//GEN-LAST:event_btn_y5bActionPerformed

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
    private javax.swing.JPanel Plateau;
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
    private javax.swing.JLabel lbl_carteAttente;
    private javax.swing.JPanel panneau_carte_attente;
    private javax.swing.JLabel x0y0;
    private javax.swing.JLabel x0y1;
    private javax.swing.JLabel x0y2;
    private javax.swing.JLabel x0y3;
    private javax.swing.JLabel x0y4;
    private javax.swing.JLabel x0y5;
    private javax.swing.JLabel x0y6;
    private javax.swing.JLabel x1y0;
    private javax.swing.JLabel x1y1;
    private javax.swing.JLabel x1y2;
    private javax.swing.JLabel x1y3;
    private javax.swing.JLabel x1y4;
    private javax.swing.JLabel x1y5;
    private javax.swing.JLabel x1y6;
    private javax.swing.JLabel x2y0;
    private javax.swing.JLabel x2y1;
    private javax.swing.JLabel x2y2;
    private javax.swing.JLabel x2y3;
    private javax.swing.JLabel x2y4;
    private javax.swing.JLabel x2y5;
    private javax.swing.JLabel x2y6;
    private javax.swing.JLabel x3y0;
    private javax.swing.JLabel x3y1;
    private javax.swing.JLabel x3y2;
    private javax.swing.JLabel x3y3;
    private javax.swing.JLabel x3y4;
    private javax.swing.JLabel x3y5;
    private javax.swing.JLabel x3y6;
    private javax.swing.JLabel x4y0;
    private javax.swing.JLabel x4y1;
    private javax.swing.JLabel x4y2;
    private javax.swing.JLabel x4y3;
    private javax.swing.JLabel x4y4;
    private javax.swing.JLabel x4y5;
    private javax.swing.JLabel x4y6;
    private javax.swing.JLabel x5y0;
    private javax.swing.JLabel x5y1;
    private javax.swing.JLabel x5y2;
    private javax.swing.JLabel x5y3;
    private javax.swing.JLabel x5y4;
    private javax.swing.JLabel x5y5;
    private javax.swing.JLabel x5y6;
    private javax.swing.JLabel x6y0;
    private javax.swing.JLabel x6y1;
    private javax.swing.JLabel x6y2;
    private javax.swing.JLabel x6y3;
    private javax.swing.JLabel x6y4;
    private javax.swing.JLabel x6y5;
    private javax.swing.JLabel x6y6;
    // End of variables declaration//GEN-END:variables
}
