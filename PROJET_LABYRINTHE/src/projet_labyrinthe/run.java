
package projet_labyrinthe;

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
        Partie partie = new Partie();
    }
    
}
