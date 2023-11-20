
package projet_labyrinthe;

/**
 * Classe qui génère et gère une partie.
 * Elle est instancée dans la classe Run, i.e c'est la classe run qui lance 
 * le programme.
 * 
 * Cette classe commence par créer un plateau, de classe Plateau, qui hérite
 * de la classe Settigns : i.e qui crée un plateau correspondant aux paramètres
 * choisis : nombres de joueurs, et autres paramètres.
 * 
 * Elle initialise ce plateau, les missions, et crée la fenetre de jeu 
 * nommée gamewindow.
 * 
 * Par la suite il faudrait développer la boucle de jeu dans cette classe.
 * @author Ody
 * @version 1.0
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
