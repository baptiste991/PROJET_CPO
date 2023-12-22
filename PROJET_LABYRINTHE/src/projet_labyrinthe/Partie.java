
package projet_labyrinthe;

import java.util.ArrayList;
import java.util.Random;

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
     
    Plateau plateau = new Plateau(); 
    ArrayList<Joueur> ordre = new ArrayList<Joueur>();
    Random r = new Random();
    Joueur temp = new Joueur();
    FenetrePrincipale gamewindow;
    /**
     * Constructeur Partie
     * @param listeJoueurs
     */
    public Partie(ArrayList<Joueur> listeJoueurs, int nbcardsperplayer) {

       plateau.nbcardsperplayer = nbcardsperplayer;
       //On lance la bonne méthode setPlayerList en fonction du nb de joueur
       switch(listeJoueurs.size()){
           case 1->{
                plateau.setPlayerList(listeJoueurs.get(0));    
                ordre.add(listeJoueurs.get(0));
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
       
       ArrayList<Joueur> listetemp = new ArrayList<Joueur>();
       //copie dans un arraylist de la liste des joueurs
       for(int i=0;i<listeJoueurs.size();i++){
           listetemp.add(listeJoueurs.get(i));
       }


       //Etablissement de l'ordre de passage
       for(int p=0;p<listeJoueurs.size();p++){
           if(listeJoueurs.size()==1){
               break;
           } else{
           int indexrandom = r.nextInt(listetemp.size());
           ordre.add(listetemp.get(indexrandom));
           listetemp.remove(indexrandom);
           }
       }
    }

    /**
     * Constructeur vide permettant d'utiliser les methodes de la classe
     */
    public Partie() {
    }

    
    public void startWindow(){
        this.gamewindow = new FenetrePrincipale(plateau, ordre);
    }
    
    
    
        
        
}
