package projet_labyrinthe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Methode qui gère l'affichage du joueur sur l'emplacement prochain tour
 * @author Ody
 */
public class UIPlayerCard extends JLabel {
    Carte carte;
    BufferedImage image=null;
    
    public UIPlayerCard(Carte carte) {
        this.carte = carte;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

    // On récupère le joueur
        try {
            String path = carte.isRidedByPlayers.get(0).skinpath ;

            image = ImageIO.read(new File("./src/Players/"+path+".png"));

            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
            g.drawImage(image, 0, 0, 90, 90, null);
    }
}
