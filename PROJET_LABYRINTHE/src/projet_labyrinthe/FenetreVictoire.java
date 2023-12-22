/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_labyrinthe;

import java.util.ArrayList;

/**
 *
 * @author Ody
 */
public class FenetreVictoire extends javax.swing.JFrame {

     ArrayList<Joueur> podium;
    
    /**
     * Creates new form FenetreVictoire
     */
    public FenetreVictoire(ArrayList<Joueur> podium) {
        this.podium = podium;
        
        switch(podium.size()){
            case 1->{
                System.out.println("Première place pour "+podium.get(0).name);
                
            }
            case 2->{
                System.out.println("Première place pour "+podium.get(0).name);
                System.out.println("Deuxieme place pour "+podium.get(1).name);
            }
            case 3->{
                System.out.println("Première place pour "+podium.get(0).name);
                System.out.println("Deuxieme place pour "+podium.get(1).name);
                System.out.println("Troisième place pour "+podium.get(2).name);
            }
            case 4->{
                System.out.println("Première place pour "+podium.get(0).name);
                System.out.println("Deuxieme place pour "+podium.get(1).name);
                System.out.println("Troisième place pour "+podium.get(2).name);
                System.out.println("Dernière place pour "+podium.get(3).name);
            }
        }
        
        initComponents();
        this.setVisible(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
