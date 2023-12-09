package projet_labyrinthe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Methode qui gère l'affichage du tour
 * @author Ody
 */
public class UITurn extends JLabel {
    Carte carte;
    BufferedImage image=null;
    
    public UITurn(Carte carte) {
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
