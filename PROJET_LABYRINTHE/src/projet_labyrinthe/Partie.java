
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
        
        Joueur player1 = new Joueur("Ulysse","skin1");
        Joueur player2 = new Joueur("Baptiste","skin2");     
        Joueur player3 = new Joueur("Adrien","skin3");
        Joueur player4 = new Joueur("Gregory","skin4");
        plateau.setPlayerList(player1, player2, player3, player4);
        FenetrePrincipale gamewindow = new FenetrePrincipale(plateau);

    }
        
        
}
