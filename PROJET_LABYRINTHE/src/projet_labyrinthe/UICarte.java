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
                image = ImageIO.read(new File("./src/Cards/Spawn/"+carte.getType()+".png"));
            } else {
                // Charge les autres images 
                image = ImageIO.read(new File("./src/images/"+carte.getType()+".png"));
            }
                        
            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
            g.drawImage(image, 0, 0, 90, 90, null);
     }
    
    
}