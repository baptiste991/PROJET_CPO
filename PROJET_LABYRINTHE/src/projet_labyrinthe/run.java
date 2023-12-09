
package projet_labyrinthe;

import java.util.ArrayList;

/**
 * Classe qui permet l'exécution du jeu. Elle crée une Partie. 
 * Ensuite comme la classe partie génère une instance de plateau.
 * La classe Plateau héritant de la classe Settings, elle execute donc 
 * le constructeur de la classe settings ce qui permet de générer un plateau
 * en fonction des réglages effectués comme par exemple le nombre de joueurs
 * voulus, IA, Skins, etc... (options à implémenter)
 * 
 * @author Ody
 * @version 1.0
 */
public class run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Joueur player1 = new Joueur("Ulysse","skin1");
        Joueur player2 = new Joueur("Baptiste","skin2");     
        Joueur player3 = new Joueur("Adrien","skin3");
        Joueur player4 = new Joueur("Gregory","skin4");
        
        ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
        listejoueur.add(player1);
        listejoueur.add(player2);
        listejoueur.add(player3);
        listejoueur.add(player4);
        
        Partie partie = new Partie(listejoueur);
        partie.setFirstTurn(player4);
        partie.startWindow();
    
        }
}
