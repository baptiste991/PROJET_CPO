package projet_labyrinthe;

import java.util.ArrayList;


/**
 * Classe qui s'occupe de la génération du plateau et de sa gestion
 * @author Ody
 * @version 1.0
 */
public class Plateau extends Settings{
    
    /**
     * Le plateau est défini comme un array de carte à 2 dimensions
     * @see plateau
     */
    private ArrayList<ArrayList<Carte>> plateau = new ArrayList<>();    
    
    /**
     * Toutes les cartes qui sont actuellement sur le plateau
     */
    private ArrayList<Carte> deckCardOnBoard = new ArrayList();
    
    
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
            
            //Lorsque on aura d'autres erreurs à displayer on rajoutera des case
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
    
    /**
     * Methode qui permet de générer l'ensemble des cartes déplacables sous 
     * forme d'ArrayList de Carte.
     * @return
     *          Ensemble des cartes déplacables sous forme d'arrayList.
     */
    public ArrayList<Carte> gen1DeckCarteDeplacable(){
        
        ArrayList<Carte> carteDeplacable = new ArrayList();
        
        // Cartes angle bas droit
        for(int i=0;i<3;i++){
            Carte carte = new Carte();
            carte.gen1CornerDownRight();
            
            switch(i){
                case 1->{
                    carte.setMission(findMissionInAllDeckbyObject("Spider"));
                }
                case 2->{
                    carte.setMission(findMissionInAllDeckbyObject("Lizard"));
                }
            }
            carteDeplacable.add(carte);
        }
        
        // Cartes angle haut droit
        for(int i=0;i<3;i++){
            Carte carte = new Carte();
            carte.gen1CornerUpRight();
            
            if(i==2){
                carte.setMission(findMissionInAllDeckbyObject("Rat"));
            }
            carteDeplacable.add(carte);
        }
        
        // Cartes allowingPermission North & South (type I)
        for(int i=0;i<6;i++){
            Carte carte = new Carte();
            carte.gen1I();
            carteDeplacable.add(carte);
        }
        
        // Cartes Tup
        for(int i=0;i<3;i++){
            Carte carte = new Carte();
            carte.gen1TUp();
            switch (i) {
                case 0 -> carte.setMission(findMissionInAllDeckbyObject("Gobelin"));
                case 1 -> carte.setMission(findMissionInAllDeckbyObject("Ghost"));
                default -> carte.setMission(findMissionInAllDeckbyObject("Genius"));
            }
            carteDeplacable.add(carte);
        }
        
        // Cartes angle haut gauche
        for(int i=0;i<4;i++){
            Carte carte = new Carte();
            carte.gen1CornerUpLeft();
            carteDeplacable.add(carte);
        }
        
        // Cartes allowingDirections East West (type _)
        for(int i=0;i<4;i++){
            Carte carte = new Carte();
            carte.gen1_();
            carteDeplacable.add(carte);
        }
            
        return carteDeplacable;
    }
    
    /**
     * Methode qui permet de retrouver une mission en fonction du nom de l'objet
     * qui est concerné par la mission
     * (principalement utilisée dans la méthode gen1DeckCarteDeplacable)
     * @param objectName
     *          Le nom de l'objet concerné par la mission
     * @return
     */
    public Mission findMissionInAllDeckbyObject(String objectName){
        Mission mission = new Mission();
        for(int j=0;j<this.getAllMissions().size();j++){
                        if(objectName.equals(this.getAllMissions().get(j).objet)){
                            mission = this.getAllMissions().get(j);
                        }
                    }
        return mission;
    }
    
    
    
    
    
    
    
}
