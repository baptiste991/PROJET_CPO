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
        this.size = size;
        if(size%2==0){
            displayError(1);
        }
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
                System.out.println("Erreur : La taille du plateau doit être un nombre impair.");
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
     */
    
    public void initialiserPlateau(){
        for(int i=0;i<size;i++){
            
            plateau.add(new ArrayList<>());
            
            for(int j=0;j<size;j++){
                
                Carte carte = new Carte(i,j);
                
                // Initialisation de la vairiable Movable des cartes en fonction de leur position
                if(j%2==0){ // Carte est sur une colonne non déplacable
                    if(i%2==0){//Carte sur une ligne non déplacable
                        carte.setMovable(false);
                    } else carte.setMovable(true);
                } else carte.setMovable(true);
                
                plateau.get(i).add(carte);

            }
        }
    }
    
    
    
    
    
    
    
    
}
