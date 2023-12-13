
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

    private int nbJoueurs;
    private String j1,j2,j3,j4;

    public run(int nbJoueurs, String j1, String j2, String j3, String j4) {
        this.nbJoueurs = nbJoueurs;
        this.j1 = j1;
        this.j2 = j2;
        this.j3 = j3;
        this.j4 = j4;
        
        Joueur player1 = new Joueur(j1,"skin1");
        Joueur player2 = new Joueur(j2,"skin2");     
        Joueur player3 = new Joueur(j3,"skin3");
        Joueur player4 = new Joueur(j4,"skin4");
        

       
        
        ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
        listejoueur.add(player1);
        listejoueur.add(player2);
        listejoueur.add(player3);
        listejoueur.add(player4);
        
        Partie partie = new Partie(listejoueur);
        partie.startWindow();
        
    }

    

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        // TODO code application logic here
        
        Joueur player1 = new Joueur(j1,"skin1");
        Joueur player2 = new Joueur(j2,"skin2");     
        Joueur player3 = new Joueur(j3,"skin3");
        Joueur player4 = new Joueur(j4,"skin4");
        

       
        
        ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
        listejoueur.add(player1);
        listejoueur.add(player2);
        listejoueur.add(player3);
        listejoueur.add(player4);
        
        Partie partie = new Partie(listejoueur);
        partie.startWindow();
    
        }
}
