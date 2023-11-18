package projet_labyrinthe;

import java.util.ArrayList;


/**
 * Classe qui s'occupe de la génération du plateau et de sa gestion
 * @author Ody
 * @version 1.0
 */
public class Plateau {
    
    /**
     * Le plateau est défini comme un array de carte à 2 dimensions
     * @see plateau
     */
    ArrayList<ArrayList<Carte>> plateau = new ArrayList<>();    
    
    /** 
     * La taille du plateau est définie par la variable size
     * @see size
     */
    int size;
    
    /**
     * Constructeur de la classe Plateau
     * @param size
     *          La taille du plateau
     */
    public Plateau(int size) {
        if(size%2==0){
            displayError(1);
        } else this.size = size;
    }
    
    /**
     * Cette méthode permet d'afficher une erreur et son problème
     * 
     * Liste des erreurs en fonction de leur numéro :
     * 1 : La taille spécifiée ne correspond pas
     * @param i
     */
    public final void displayError(int i){
        switch(i){
            case 1->{
                System.out.println("Erreur : La taille du plateau doit être un nombre impaire.");
            }
        }
    }
     
    /**
     * initialiserPlateau est la méthode qui réserve l'emplacement de toutes
     * les cartes et donc initialise les coordonnées de chaque carte par le 
     * constructeur de la classe Carte.
     * 
     * On initialise aussi les variables "movable" des cartes en fonction de 
     * leur position sur le plateau.
     * 
     * On initialise aussi les directions possibles des cartes non déplacables
     * i.e la variable allowingDirections
     */
    
    public void initialiserPlateau(){
        for(int i=0;i<size;i++){ 

            for(int j=0;j<size;j++){
                
                plateau.add(new ArrayList<Carte>());
                Carte carte = new Carte(i,j);
                
                // Initialisation de la variable Movable des cartes en fonction de leur position
                if(j%2==0){ // Carte est sur une colonne non déplacable
                    if(i%2==0){//Carte sur une ligne non déplacable
                        carte.setMovable(false);
                    } else carte.setMovable(true);
                } else carte.setMovable(true);
             
                plateau.get(i).add(carte);
            }
            

        }
            // Initialisation de la variable allowingDirections des cartes non déplacables en fonction de leur position
            // --> Pour un plateau de taille 7
            
            //Angles
            plateau.get(0).get(0).gen1CornerUpLeft();
            plateau.get(0).get(size-1).gen1CornerUpRight();
            plateau.get(size-1).get(0).gen1CornerDownLeft();
            plateau.get(size-1).get(size-1).gen1CornerDownRight();
            
            //Colonnes non déplacables colonnes extrêmes
            plateau.get(2).get(0).gen1TRight();
            plateau.get(4).get(0).gen1TRight();
            plateau.get(2).get(size-1).gen1TLeft();
            plateau.get(4).get(size-1).gen1TLeft();
            
            //Lignes non déplacables extrèmes
            plateau.get(0).get(2).gen1TDown();
            plateau.get(0).get(4).gen1TDown();
            plateau.get(size-1).get(2).gen1TUp();
            plateau.get(size-1).get(4).gen1TUp();
            //Cartes non déplacables centrales
            plateau.get(2).get(2).gen1TRight();
            plateau.get(2).get(4).gen1TDown();
            plateau.get(4).get(2).gen1TUp();
            plateau.get(4).get(4).gen1TLeft();
    }
    
    
    
    
    
    
    
    
}
