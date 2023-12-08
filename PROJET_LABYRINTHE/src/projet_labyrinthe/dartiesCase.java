/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_labyrinthe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author benoit
 */
public class dartiesCase extends JLabel {

    int i; 

    public dartiesCase(int i) {
        this.i = i;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        this.setText(i+"");
        
        if (i %2 ==0){
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/_.png")));
        }
        else {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cards/missionless/TUp.png")));
        }
        BufferedImage image=null;
         try {
            // Charge l'image depuis le chemin spécifié
            image = ImageIO.read(new File("./src/projet_labyrinthe/pikachu.png"));
        } catch (IOException e) {
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        g.fillOval(6, 6, 20, 20);
        
          this.setText(i+"");
        
        g.drawImage(image, 6, 35, 30, 30, null);
                g.setColor(Color.red);

     }
    
    
}
