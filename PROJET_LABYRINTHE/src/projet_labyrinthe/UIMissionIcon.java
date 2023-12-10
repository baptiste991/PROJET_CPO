
package projet_labyrinthe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Peint l'image de la mission
 * @author Ody
 */
public class UIMissionIcon extends JLabel{
    
    BufferedImage image=null;
    String name;
    
    public UIMissionIcon(String name) {
        this.name = name;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

    // On récupère l'image du joueur
        try {
            image = ImageIO.read(new File("./src/Missions/"+name+".png"));

            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
            g.drawImage(image,0 , 0, 60, 55, null);
    }
}
