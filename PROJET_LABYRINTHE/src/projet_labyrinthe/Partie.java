
package projet_labyrinthe;

import java.util.ArrayList;

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
     
    
    Joueur firstturn = new Joueur();
    Plateau plateau = new Plateau(); 
    /**
     * Constructeur Partie
     * @param listeJoueurs
     */
    public Partie(ArrayList<Joueur> listeJoueurs) {
        
       //On lance la bonne méthode setPlayerList en fonction du nb de joueur
       switch(listeJoueurs.size()){
           case 1->{
                plateau.setPlayerList(listeJoueurs.get(0));    
           }
           case 2->{
                plateau.setPlayersList(listeJoueurs.get(0), listeJoueurs.get(1));
           }
           case 3->{
                plateau.setPlayerList(listeJoueurs.get(0), listeJoueurs.get(1), listeJoueurs.get(2));
           }
           case 4->{
                plateau.setPlayerList(listeJoueurs.get(0), listeJoueurs.get(1), listeJoueurs.get(2), listeJoueurs.get(3));
           }
       }
    }
    
    /**
     * Methode qui permet de définir la première personne à commencer à jouer
     * @param first
     */
    public void setFirstTurn(Joueur first){
        this.firstturn = first;
    }
    
    public void startWindow(){
        FenetrePrincipale gamewindow = new FenetrePrincipale(plateau);
        gamewindow.genUIPlayerHasToPlay(firstturn);
    }
    
    
        
        
}
