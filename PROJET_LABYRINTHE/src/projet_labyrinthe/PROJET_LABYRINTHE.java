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
        plato.setAllMissionsToCards();
        ArrayList<Carte> cartesdép = plato.getDeckCardOnBoard();
        
        int line =6;
        for(int j=0;j<7;j++){
        for(int i=0;i<7;i++){
            System.out.println(plato.getPlateau().get(j).get(i));
        }
        }
        
    }
    
}
