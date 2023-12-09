
package projet_labyrinthe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Classe qui a pour but de gérer l'affichage de la carte en dehors du plateau
 * @author Ody
 */
public class UICarteOut extends JLabel {

    BufferedImage mission=null;
    BufferedImage image=null;
    Carte carte;
    public UICarteOut(Carte carte) {
        this.carte = carte;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        // On récupère le path de l'image 
            try {
                String type = carte.getType() ;

                image = ImageIO.read(new File("./src/Cards/"+carte.getType()+".png"));

                } catch (IOException e) {
                    System.out.println(e.getCause());
                    e.printStackTrace();
                }
                g.drawImage(image, 0, 0, 90, 90, null);
        
        
        //Si Mission
        if(carte.getMission()!=null){
        //Récupération du path de l'image correspondante
        try { 
            mission = ImageIO.read(new File("./src/Missions/"+carte.getMission().getObjet()+".png"));
        } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }

        // Display de l'image de la mission
        g.drawImage(mission, 25, 10, 50, 50, null);
        
        }
        
        //Si joueur
        if( !carte.isRidedByPlayers.isEmpty()){
            
        for(int i=0;i<carte.isRidedByPlayers.size();i++){
            
            //Récupération du path de l'image correspondante
            try { 
                image = ImageIO.read(new File("./src/Players/"+carte.isRidedByPlayers.get(i).skinpath+".png"));
            } catch (IOException e) {
                    System.out.println(e.getCause());
                    e.printStackTrace();
                }

            // Display de l'image de la mission
            g.drawImage(image, 17, -8, 55, 65, null);
            }
        }
    }

}
