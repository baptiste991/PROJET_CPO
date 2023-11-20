
package projet_labyrinthe;

/**
 *
 * @author Ody
 */
public class Partie {
        
    /**
     * Constructeur Partie
     */
    public Partie() {
        
        Plateau plateau = new Plateau();
        Joueur player1 = new Joueur();
        plateau.setPlayerList(player1);
        plateau.setAllMissions();
        FenetrePrincipale gamewindow = new FenetrePrincipale(plateau);
    }
        
        
}
