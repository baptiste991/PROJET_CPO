/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_labyrinthe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author Ody
 */
public class UIWin extends JLabel {
    

    BufferedImage background=null;
    BufferedImage podiumUI=null;


    // On repeint visuellement la carte
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        // On récupère le path de l'image
        try {
           
            background = ImageIO.read(new File("./src/imgMenus/background.png"));
            podiumUI = ImageIO.read(new File("./src/imgMenus/podium.png"));
          
                        
            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
        
            g.drawImage(background, 0, 0, 1020, 750, null);
            g.drawImage(podiumUI, 5, 300, 1000, 420, null);
        }
}
