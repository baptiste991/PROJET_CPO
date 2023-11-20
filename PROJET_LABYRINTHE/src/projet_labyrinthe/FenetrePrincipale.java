package projet_labyrinthe;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

/**
 * Fenetre Principale du Jeu
 * @author Ody
 * @version 1.0
 */
public class FenetrePrincipale extends javax.swing.JFrame  {

    /**
     * Le plateau de jeu
     */
 
    Plateau plateau = new Plateau();
    
    /**
     * Creates new form FenetrePrincipale
     */
    public FenetrePrincipale(Plateau plateau) {
        this.plateau = plateau;
        initComponents();
        genUIofBoard();
        this.setVisible(true);
}

    private FenetrePrincipale() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Methode qui place graphiquement les cartes du plateau 
     * @param posx
     *          Coordonnée x 
     * @param posy
     *          Coordonnée y 
     */
    public void UIcardPlacement(int posx,int posy){
        
        
        // Assignation graphique du type de carte
        switch(this.plateau.getPlateau().get(posx).get(posy).getType()){
            case "I" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/I.png")));
            }
            case "_" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/_.png")));
            }
            case "TUp" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TUp.png")));
            }
            case "TDown" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TDown.png")));
            }
            case "TRight" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TRight.png")));
            }
            case "TLeft" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TLeft.png")));
            }
            case "UpRightC" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/UpRightC.png")));
            }
            case "UpLeftC" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/UpLeftC.png")));
            }
            case "DownRightC" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/DownRightC.png")));
            }
            case "DownLeftC" ->{
                getLabelByName("x"+String.valueOf(posx)+"y"+String.valueOf(posy)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/DownLeftC.png")));
            } 
        }
    
        //Points de départs
        getLabelByName("x0y0").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/blue.png")));
        getLabelByName("x0y6").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/green.png")));
        getLabelByName("x6y0").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/yellow.png")));
        getLabelByName("x6y6").setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/Spawn/red.png")));

    }
    
    /**
     * Methode qui assigne graphiquement a l'ensemble des cartes leur 
     * image respective.
     */
    public void genUIofBoard(){
        
        //On parcout toutes les cartes du plateau
        for(int x=0;x<7;x++){
            for(int y=0;y<7;y++){
                UIcardPlacement(x,y);
            }
        }
        
        //Une fois toutes les images assignées on re déssine le layout
        // Affichage des JLabel
        Plateau.revalidate();
        Plateau.repaint();
    }
    
    /**
     * Methode qui permet d'accéder à un Jlabel en fonction de son nom
     * @param labelName
     *        Le nom du label
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1515, 750));
        setName("Labyrinthe"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Plateau.setBackground(new java.awt.Color(204, 204, 255));

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
                                .addComponent(x0y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x0y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlateauLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlateauLayout.createSequentialGroup()
                                        .addComponent(x2y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(x2y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlateauLayout.createSequentialGroup()
                                        .addComponent(x4y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(x4y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addComponent(x3y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x3y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x3y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(x3y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(x1y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PlateauLayout.createSequentialGroup()
                        .addContainerGap()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(x5y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(PlateauLayout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(0, 0, Short.MAX_VALUE))
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
                                        .addComponent(x0y0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x0y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x0y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x0y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x0y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(x0y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x0y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(x2y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x2y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x2y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(x2y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x2y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(x4y6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(x4y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(x4y4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(x4y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x4y5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 48, 600, 600));

        getAccessibleContext().setAccessibleName("Labyrinthe");

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

