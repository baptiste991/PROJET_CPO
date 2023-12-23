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
public class UIWinPanelDroite extends JLabel {
    
    int place;

    public UIWinPanelDroite(int place){
        this.place = place+1;
        System.out.println(place+1);
    }
    
    BufferedImage background=null;
    BufferedImage first=null;
    BufferedImage second=null;


    // On repeint visuellement la carte
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        // On récupère le path de l'image
        try {
           
            background = ImageIO.read(new File("./src/imgMenus/won.png"));
            first = ImageIO.read(new File("./src/imgMenus/#1.png"));
            second = ImageIO.read(new File("./src/imgMenus/#2.png"));
                        
            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
        
        g.drawImage(background, 0, 0, 300, 60, null);
        switch(place){
            case 1->{
               g.drawImage(first, 100, 0, 300, 60, null);
               g.drawImage(first, -100, 0, 300, 60, null);
            }
            case 2->{
               g.drawImage(second, 100, 0, 300, 60, null);
               g.drawImage(second, -100, 0, 300, 60, null);

            }
        }
            
        }
}
