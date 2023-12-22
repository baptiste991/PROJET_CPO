package projet_labyrinthe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Classe similaire à UIPlayerCard sauf qu'il n'est pas question de carte
 * Et la taille du draw est différente
 * @author Ody
 */
public class UIPlayerIcon extends JLabel {
    
    BufferedImage image=null;
    BufferedImage background=null;
    Joueur player = new Joueur();
    
    public UIPlayerIcon(Joueur player) {
        this.player = player;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

    // On récupère l'image du joueur
        try {
            image = ImageIO.read(new File("./src/Players/"+player.skinpath+".png"));
            background = ImageIO.read(new File("./src/imgMenus/PlayerBackground.png"));

            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
        

            g.drawImage(background,0 , 0, 58, 56, null);
            g.drawImage(image,0 , 0, 60, 55, null);
    }
    
}
