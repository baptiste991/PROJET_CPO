package projet_labyrinthe;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
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
    
    Partie partie = new Partie();
    
    Joueur turnOff = new Joueur();
    
    ArrayList<Joueur> ordre;

    /**
     * Constructeur de la fenêtre Cette fenetre représente graphiquement le
     * plateau ainsi que l'interface graphique du jeu.
     *
     * @param plateau Le plateau de jeu qui comprend les missions, cartes, et
     * joueurs
     */
    public FenetrePrincipale(Plateau plateau, ArrayList<Joueur> ordre) {
        this.plateau = plateau;
        this.ordre = ordre;
        plateau.setAllMissions();
        plateau.setAllMissionsToCards();
        plateau.placeAllPlayers();
        plateau.setListMissionOfPlayers();
        initComponents();
        gen1UItour(ordre);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void gen1UItour(ArrayList<Joueur> ordre){
        turnOff = ordre.get(0);
        genUIBoard();
        genUIPlayerHasToPlay(turnOff);
        genUIPossibleActions();
        genUIRightSide();
        this.setVisible(true);
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
        PanelTour.add(new UIPlayerCard(carte));
    }

    public void verifFinDeTour(){
        
        //Si le joueur se trouve sur une mission
        if(this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).getMission()!=null){
            //Si cette mission est à faire par le joueur dont c'est le tour
            for(int missions=0;missions<turnOff.getObjets().size();missions++){
                if(this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).getMission().getObjet().equals(turnOff.getObjets().get(missions))){
                    // Suppression de cet objet à trouver
                    turnOff.getObjets().remove(this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).getMission().getObjet());
                    // On vérifie que ça n'a pas fait gagner le joueur
                    verifWin();
                }
            }
        }
    }
    
    public void verifWin(){
        // Pour tous les joueurs
        for(int players=0;players<this.plateau.getListeDeJoueurs().size();players++){
            //Si un d'eux n'a plus d'objets il gagne
            if(this.plateau.getListeDeJoueurs().get(players).getObjets().isEmpty()){
                System.out.println("Victoire de "+this.plateau.getListeDeJoueurs().get(players).name);
            }
        }
    }
    
    public void genUIRightSide(){
        switch(this.plateau.getListeDeJoueurs().size()){
            case 1->{
                
                MissionsView1.setVisible(true);
                MissionsView43.setVisible(false);
                MissionsView2.setVisible(false);
                
                Skin111.removeAll();
                Skin111.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(0)));
                MissionsP111.removeAll();
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(0).getObjets().size();i++){
                    MissionsP111.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(0).getObjets().get(i)));
                }
                Player1.setVisible(true);
            }
            
            case 2 ->{
                MissionsView43.setVisible(false);
                MissionsView2.setVisible(true);
                MissionsView1.setVisible(false);
                
                Skin21.removeAll();
                Skin22.removeAll();
                Skin21.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(0)));
                Skin22.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(1)));

                
                MissionsP21.removeAll();
                MissionsP22.removeAll();
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(0).getObjets().size();i++){
                    MissionsP21.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(0).getObjets().get(i)));
                }
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(1).getObjets().size();i++){
                    MissionsP22.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(1).getObjets().get(i)));
                }
                

                Player1.setVisible(true);
                Player2.setVisible(true);
                

            }
            
            case 3->{
                MissionsView2.setVisible(false);
                MissionsView1.setVisible(false);
                
                Skin1.removeAll();
                Skin2.removeAll();
                Skin3.removeAll();
                Skin1.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(0)));
                Skin2.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(1)));
                Skin3.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(2)));
                
                GridLayout MissionP1for3 = new GridLayout(1, 5);
                MissionP1.setLayout(MissionP1for3);
                GridLayout MissionP2for3 = new GridLayout(1, 5);
                MissionP1.setLayout(MissionP2for3);
                GridLayout MissionP3for3 = new GridLayout(1, 5);
                MissionP1.setLayout(MissionP3for3);
                
                MissionP1.removeAll();
                MissionP2.removeAll();
                MissionP3.removeAll();
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(0).getObjets().size();i++){
                    MissionP1.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(0).getObjets().get(i)));
                }
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(1).getObjets().size();i++){
                    MissionP2.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(1).getObjets().get(i)));
                }
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(2).getObjets().size();i++){
                    MissionP3.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(2).getObjets().get(i)));
                }
                Player1.setVisible(true);
                Player2.setVisible(true);
                Player3.setVisible(true);
                Player4.setVisible(false);
            }
            case 4->{
                MissionsView1.setVisible(false);
                MissionsView2.setVisible(false);
                
                Skin1.removeAll();
                Skin2.removeAll();
                Skin3.removeAll();
                Skin4.removeAll();
                Skin1.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(0)));
                Skin2.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(1)));
                Skin3.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(2)));
                Skin4.add(new UIPlayerIcon(this.plateau.getListeDeJoueurs().get(3)));
                
                MissionP1.removeAll();
                MissionP2.removeAll();
                MissionP3.removeAll();
                MissionP4.removeAll();
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(0).getObjets().size();i++){
                    MissionP1.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(0).getObjets().get(i)));
                }
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(1).getObjets().size();i++){
                    MissionP2.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(1).getObjets().get(i)));
                }
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(2).getObjets().size();i++){
                    MissionP3.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(2).getObjets().get(i)));
                }
                for(int i=0;i<this.plateau.getListeDeJoueurs().get(3).getObjets().size();i++){
                    MissionP4.add(new UIMissionIcon(this.plateau.getListeDeJoueurs().get(3).getObjets().get(i)));
                }
                
                Player1.setVisible(true);
                Player2.setVisible(true);
                Player3.setVisible(true);
                Player4.setVisible(true);
                
            }
        }
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
        if(posy!=6 && temp && tempclose){
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
            GridPanel.removeAll();
           //Generation de la grille dans le cas ou c'est la première génération
            for (int x=0;x < 7; x++ ){
                for(int y=0;y<7;y++){

                    GridPanel.add(new UICarte(this.plateau.getPlateau().get(x).get(y)));  
                } 
            }
        genUIWaitingCard(plateau.carteAttente);
        revalidate();
        repaint();
    }
    
    public void injectUIX(int x, boolean gauche){
        plateau.injectX(x, gauche);
        genUIBoard();
        // On corrige les coordonnées des cartes
        this.plateau.setCorrectCoordinates();

    }
    
    public void injectUIY(int y, boolean haut){
        plateau.injectY(y, haut);
        genUIBoard();
        // On corrige les coordonnées des cartes
        this.plateau.setCorrectCoordinates();
    }
    
    public void setInjectionButtonsVisible(boolean action){
        btn_x1g.setVisible(action);
        btn_x1d.setVisible(action);
        btn_x3g.setVisible(action);
        btn_x3d.setVisible(action);
        btn_x5g.setVisible(action);
        btn_x5d.setVisible(action);
        btn_y1h.setVisible(action);
        btn_y1b.setVisible(action);
        btn_y3h.setVisible(action);
        btn_y3b.setVisible(action);
        btn_y5h.setVisible(action);
        btn_y5b.setVisible(action);
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
        MissionsView1 = new javax.swing.JPanel();
        Player111 = new javax.swing.JPanel();
        Skin111 = new javax.swing.JPanel();
        MissionsP111 = new javax.swing.JPanel();
        MissionsView2 = new javax.swing.JPanel();
        Player21 = new javax.swing.JPanel();
        Skin21 = new javax.swing.JPanel();
        MissionsP21 = new javax.swing.JPanel();
        Player22 = new javax.swing.JPanel();
        Skin22 = new javax.swing.JPanel();
        MissionsP22 = new javax.swing.JPanel();
        MissionsView43 = new javax.swing.JPanel();
        Player1 = new javax.swing.JPanel();
        Skin1 = new javax.swing.JPanel();
        MissionP1 = new javax.swing.JPanel();
        Player3 = new javax.swing.JPanel();
        Skin3 = new javax.swing.JPanel();
        MissionP3 = new javax.swing.JPanel();
        Player2 = new javax.swing.JPanel();
        Skin2 = new javax.swing.JPanel();
        MissionP2 = new javax.swing.JPanel();
        Player4 = new javax.swing.JPanel();
        Skin4 = new javax.swing.JPanel();
        MissionP4 = new javax.swing.JPanel();
        Objets = new javax.swing.JLabel();
        Valider = new javax.swing.JButton();

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
        Left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftActionPerformed(evt);
            }
        });
        getContentPane().add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 50, 40));

        Up.setText("↑");
        Up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpActionPerformed(evt);
            }
        });
        getContentPane().add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 50, 40));

        Down.setText("↓");
        Down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownActionPerformed(evt);
            }
        });
        getContentPane().add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 50, 40));

        Right.setText("→");
        Right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightActionPerformed(evt);
            }
        });
        getContentPane().add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 50, 40));

        MissionsView1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player111.setBackground(new java.awt.Color(255, 204, 204));
        Player111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Skin111.setLayout(new java.awt.GridLayout(1, 1));
        Player111.add(Skin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 60));

        MissionsP111.setBackground(new java.awt.Color(153, 255, 204));
        MissionsP111.setLayout(new java.awt.GridLayout(4, 4));
        Player111.add(MissionsP111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 310));

        MissionsView1.add(Player111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 370));

        getContentPane().add(MissionsView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, 320, 560));

        MissionsView2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player21.setBackground(new java.awt.Color(255, 204, 204));
        Player21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Skin21.setLayout(new java.awt.GridLayout(1, 1));
        Player21.add(Skin21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 60));

        MissionsP21.setBackground(new java.awt.Color(153, 255, 204));
        MissionsP21.setLayout(new java.awt.GridLayout(2, 4));
        Player21.add(MissionsP21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 160));

        MissionsView2.add(Player21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, -1));

        Player22.setBackground(new java.awt.Color(204, 204, 255));
        Player22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Skin22.setLayout(new java.awt.GridLayout(1, 1));
        Player22.add(Skin22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 60));

        MissionsP22.setBackground(new java.awt.Color(102, 255, 153));
        MissionsP22.setLayout(new java.awt.GridLayout(2, 4));
        Player22.add(MissionsP22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 140));

        MissionsView2.add(Player22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 300, 200));

        getContentPane().add(MissionsView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, 320, 560));

        MissionsView43.setBackground(new java.awt.Color(255, 0, 255));
        MissionsView43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player1.setBackground(new java.awt.Color(255, 204, 204));
        Player1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Skin1.setLayout(new java.awt.GridLayout(1, 1));
        Player1.add(Skin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 60));

        MissionP1.setLayout(new java.awt.GridLayout(1, 4));
        Player1.add(MissionP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 60));

        MissionsView43.add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 120));

        Player3.setBackground(new java.awt.Color(204, 204, 255));
        Player3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Skin3.setLayout(new java.awt.GridLayout(1, 1));
        Player3.add(Skin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 60));

        MissionP3.setLayout(new java.awt.GridLayout(1, 4));
        Player3.add(MissionP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 60));

        MissionsView43.add(Player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 300, 120));

        Player2.setBackground(new java.awt.Color(204, 255, 204));
        Player2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Skin2.setLayout(new java.awt.GridLayout(1, 1));
        Player2.add(Skin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 60));

        MissionP2.setLayout(new java.awt.GridLayout(1, 4));
        Player2.add(MissionP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 60));

        MissionsView43.add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 300, 120));

        Player4.setBackground(new java.awt.Color(204, 204, 0));
        Player4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Skin4.setLayout(new java.awt.GridLayout(1, 1));
        Player4.add(Skin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 60));

        MissionP4.setLayout(new java.awt.GridLayout(1, 4));
        Player4.add(MissionP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 60));

        MissionsView43.add(Player4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 300, 120));

        getContentPane().add(MissionsView43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, 320, 560));

        Objets.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Objets.setText("Objets à récupérer");
        getContentPane().add(Objets, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 60, 170, -1));

        Valider.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        Valider.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        Valider.setText("Valider le tour");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        getContentPane().add(Valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 680, 160, 50));

        getAccessibleContext().setAccessibleName("Labyrinthe");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_x1gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x1gActionPerformed
        injectUIX(1, true);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_x1gActionPerformed

    private void btn_x1dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x1dActionPerformed
        injectUIX(1, false);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_x1dActionPerformed

    private void btn_x3gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x3gActionPerformed
        injectUIX(3, true);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_x3gActionPerformed

    private void btn_x5gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x5gActionPerformed
        injectUIX(5, true);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_x5gActionPerformed

    private void btn_x3dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x3dActionPerformed
        injectUIX(3, false);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_x3dActionPerformed

    private void btn_x5dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_x5dActionPerformed
        injectUIX(5, false);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_x5dActionPerformed

    private void btn_y1hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y1hActionPerformed
        injectUIY(1,true);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_y1hActionPerformed

    private void btn_y5hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y5hActionPerformed
        injectUIY(5,true);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_y5hActionPerformed

    private void btn_y3hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y3hActionPerformed
        injectUIY(3,true);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_y3hActionPerformed

    private void btn_y1bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y1bActionPerformed
        injectUIY(1,false);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_y1bActionPerformed

    private void btn_y3bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y3bActionPerformed
        injectUIY(3,false);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_y3bActionPerformed

    private void btn_y5bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_y5bActionPerformed
        injectUIY(5,false);
        genUIPossibleActions();
        setInjectionButtonsVisible(false);
    }//GEN-LAST:event_btn_y5bActionPerformed

    private void RotateRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RotateRightActionPerformed
        // TODO add your handling code here:
        this.plateau.carteAttente.rotateRight();
        genUIBoard();
    }//GEN-LAST:event_RotateRightActionPerformed

    private void RotateRight1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RotateRight1ActionPerformed
        // TODO add your handling code here:
        this.plateau.carteAttente.rotateLeft();
        genUIBoard();
    }//GEN-LAST:event_RotateRight1ActionPerformed

    private void UpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpActionPerformed
        // TODO add your handling code here:
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.remove(turnOff);
        turnOff.deplacementNord();
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.add(turnOff);
        genUIBoard();
        genUIPossibleActions();
    }//GEN-LAST:event_UpActionPerformed

    private void LeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftActionPerformed
        // TODO add your handling code here:
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.remove(turnOff);
        turnOff.deplacementOuest();
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.add(turnOff);
        genUIBoard();
        genUIPossibleActions();
    }//GEN-LAST:event_LeftActionPerformed

    private void RightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightActionPerformed
        // TODO add your handling code here:
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.remove(turnOff);
        turnOff.deplacementEst();
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.add(turnOff);
        genUIBoard();
        genUIPossibleActions();
    }//GEN-LAST:event_RightActionPerformed

    private void DownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownActionPerformed
        // TODO add your handling code here:
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.remove(turnOff);
        turnOff.deplacementSud();
        this.plateau.getPlateau().get(turnOff.getPosx()).get(turnOff.getPosy()).isRidedByPlayers.add(turnOff);
        genUIBoard();
        genUIPossibleActions();
    }//GEN-LAST:event_DownActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // TODO add your handling code here:
        // Le joueur a récupéré un objet?
        verifFinDeTour();
        // Reaffichage des boutons
        setInjectionButtonsVisible(true);
       
        // Changement de joueur
        Joueur temp = ordre.get(0);
        ordre.remove(0);
        ordre.add(temp);
        gen1UItour(ordre);
        
        
    }//GEN-LAST:event_ValiderActionPerformed

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
    private javax.swing.JPanel MissionP1;
    private javax.swing.JPanel MissionP2;
    private javax.swing.JPanel MissionP3;
    private javax.swing.JPanel MissionP4;
    private javax.swing.JPanel MissionsP111;
    private javax.swing.JPanel MissionsP21;
    private javax.swing.JPanel MissionsP22;
    private javax.swing.JPanel MissionsView1;
    private javax.swing.JPanel MissionsView2;
    private javax.swing.JPanel MissionsView43;
    private javax.swing.JLabel Objets;
    private javax.swing.JPanel PanelTour;
    private javax.swing.JPanel Player1;
    private javax.swing.JPanel Player111;
    private javax.swing.JPanel Player2;
    private javax.swing.JPanel Player21;
    private javax.swing.JPanel Player22;
    private javax.swing.JPanel Player3;
    private javax.swing.JPanel Player4;
    private javax.swing.JButton Right;
    private javax.swing.JButton RotateRight;
    private javax.swing.JButton RotateRight1;
    private javax.swing.JPanel Skin1;
    private javax.swing.JPanel Skin111;
    private javax.swing.JPanel Skin2;
    private javax.swing.JPanel Skin21;
    private javax.swing.JPanel Skin22;
    private javax.swing.JPanel Skin3;
    private javax.swing.JPanel Skin4;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text2;
    private javax.swing.JLabel Text3;
    private javax.swing.JButton Up;
    private javax.swing.JButton Valider;
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
