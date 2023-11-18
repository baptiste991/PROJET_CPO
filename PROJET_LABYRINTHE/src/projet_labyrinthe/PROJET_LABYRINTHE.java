/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_labyrinthe;

import java.util.ArrayList;

/**
 * Classe Brouillon pour tester la validité de toutes les autres classe
 * @author Ody
 */
public class PROJET_LABYRINTHE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Plateau plato = new Plateau(7);
        plato.initialiserPlateau();
        Joueur player1 = new Joueur();
        plato.setPlayerList(player1);
        plato.setAllMissions();
        ArrayList<Carte> cartesdép = plato.gen1DeckCarteDeplacable();
            
        for(int i=0;i<cartesdép.size();i++){
            System.out.println(cartesdép.get(i));
        }

    }
    
}
