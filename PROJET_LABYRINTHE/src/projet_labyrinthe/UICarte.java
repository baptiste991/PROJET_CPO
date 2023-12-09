package projet_labyrinthe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Classe qui génère une carte UI a partir des modifications éffectuées sur 
 * un JLABEL.
 * @author Ody
 * @version 1.0
 */
public class UICarte extends JLabel {

    Carte carte;
    BufferedImage image=null;
    BufferedImage mission=null;

    public UICarte(Carte carte) {
        this.carte = carte;
    }
    
    
    // On repeint visuellement la carte
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        // On récupère le path de l'image
        try {
            String type = carte.getType() ;
            if((type== "SpawnUpLeft") ||( type == "SpawnUpRight" )|| (type == "SpawnDownLeft" )||( type== "SpawnDownRight")){
                // Charge l'image du spawn depuis le chemin spécifié
                image = ImageIO.read(new File("./src/SpawnCards/"+carte.getType()+".png"));
            } else {
                // Charge les autres images 
                image = ImageIO.read(new File("./src/Cards/"+carte.getType()+".png"));
            }
                        
            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
            g.drawImage(image, 0, 0, 90, 90, null);
            
        //Recherche de mission
        if(carte.getMission()!=null){
            
           //Récupération du path de l'image correspondante
            try { 
                mission = ImageIO.read(new File("./src/Missions/"+carte.getMission().getObjet()+".png"));
            } catch (IOException e) {
                    System.out.println(e.getCause());
                    e.printStackTrace();
                }
            
            // Display de l'image de la mission
            g.drawImage(mission, 17, 12, 55, 55, null);
        }
        //Recherche de joeuurs
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
                System.out.println("Image peinte du joueur "+carte.isRidedByPlayers.get(i).name);
                }
          }
   
               

    }
}