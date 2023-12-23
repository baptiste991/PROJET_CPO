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
public class UIPanelDroiteMissions extends JLabel {
    

    BufferedImage background=null;
    int nbplayer;
    
    public UIPanelDroiteMissions(int nbplayer){
        this.nbplayer = nbplayer;
    }


    // On repeint visuellement la carte
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        // On récupère le path de l'image
        try {
           
            background = ImageIO.read(new File("./src/imgMenus/missionbackground.png"));
          
                        
            } catch (IOException e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
        switch(nbplayer){
            case 34->{
                g.drawImage(background, 0, 0, 300, 120, null);
            }
            case 2->{
                g.drawImage(background, 0, 0, 300, 160, null);

            }
            case 1->{
                g.drawImage(background, 0, 0, 300, 310, null);
            }
        }
            
        }
}
