package projet_labyrinthe;

import java.util.ArrayList;
import java.util.Random;

/**
 * Cette classe a pour but d'initialiser les paramètres de la partie comme :
 * Le nombre de joueurs
 * @author Ody
 * @version 1.0
 */
public abstract class Settings {
    
    /**
     * La liste des joueurs de la partie
     * @see listeDeJoueurs
     */
    private ArrayList<Joueur> listeDeJoueurs = new ArrayList();
    
    /** 
     * La liste des objets sous forme de tableau de String
     * @see listeDesObjets
     */
    private String [] listeDesObjets = {"Princess","Gobelin","Helmet","Emerald",
        "Lizard","Trophy","Rat","Keys","Crown","Gold","Chest","Genius","Ghost",
        "Painting","Drake","Spider"};
    
    /**
     * Un arrayList de mission qui représente toutes les missions du plateau
     */
    private ArrayList<Mission> allMissions = new ArrayList();
    
    /**
     * Methode qui met à jour la liste des joueurs de la partie
     * @param player1
     *        Le joueur 1
     */
    public void setPlayerList(Joueur player1){
        this.listeDeJoueurs.add(player1);
    }
    
    /**
     * Methode qui met à jour la liste des joueurs de la partie
     * @param player1
     *        Le joueur 1
     * @param player2
     *        Le joueur 2
     */
    public void setPlayersList(Joueur player1, Joueur player2){
        this.listeDeJoueurs.add(player1);
        this.listeDeJoueurs.add(player2);
    }
    
    /**
     * Methode qui met à jour la liste des joueurs de la partie
     * @param player1
     *        Le joueur 1
     * @param player2
     *        Le joueur 2
     * @param player3
     *        Le joueur 3
     */
    public void setPlayerList(Joueur player1, Joueur player2, Joueur player3){
        this.listeDeJoueurs.add(player1);
        this.listeDeJoueurs.add(player2);
        this.listeDeJoueurs.add(player3);
    }
    
     /**
     * Methode qui met à jour la liste des joueurs de la partie
     * @param player1
     *        Le joueur 1
     * @param player2
     *        Le joueur 2
     * @param player3
     *        Le joueur 3
     * @param player4
     *        Le joueur 4
     */
    public void setPlayerList(Joueur player1, Joueur player2, Joueur player3, Joueur player4){
        this.listeDeJoueurs.add(player1);
        this.listeDeJoueurs.add(player2);
        this.listeDeJoueurs.add(player3);
        this.listeDeJoueurs.add(player4);
    }
    
    /**
     * Getter Liste de Joueurs
     * @return
     *          Liste des joueurs de la partie
     */
    public ArrayList<Joueur> getListeDeJoueurs(){
        return listeDeJoueurs;
    }
    
    /**
     * Methode qui initialise toutes les missions  i.e associe à chaque objet
     * (représenté par une chaine de caractère) un joueur pour le récupérer
     */
    public void setAllMissions(){
        
        // Remarque : Le switch suivant fait apparaitre beaucoup de code surement factorisable, il serait interessant
        // de trouver une façon de le condenser, mais actuellement on l'utilise.
        switch(this.listeDeJoueurs.size()){
            
            case 1->{
                for(int i=0;i<this.listeDesObjets.length;i++){
                    Mission mission = new Mission(this.listeDeJoueurs.get(0), this.listeDesObjets[i]);
                    allMissions.add(mission);
                }
            }
            
            case 2 ->{
                Random random = new Random();
                
                ArrayList<String> objetsRestants = new ArrayList();
                for(int i=0;i<this.listeDesObjets.length;i++){
                    objetsRestants.add(this.listeDesObjets[i]);
                }
                                
                for(int j=0;j<2;j++){
                    for(int i=0;i<this.listeDesObjets.length/2;i++){
                        int indexRandom = random.nextInt(objetsRestants.size());
                        Mission mission = new Mission(this.listeDeJoueurs.get(j), objetsRestants.get(indexRandom));
                        allMissions.add(mission);
                        objetsRestants.remove(indexRandom);
                    }
                }
            }    
            
            case 3 ->{
                Random random = new Random();
                
                ArrayList<String> objetsRestants = new ArrayList();
                for(int i=0;i<this.listeDesObjets.length;i++){
                    objetsRestants.add(this.listeDesObjets[i]);
                }
                
                objetsRestants.remove(random.nextInt(objetsRestants.size()));
                // On supprime un objet car 3 joueurs => this.listeDesObjets.length/3 pas entier
                
                for(int j=0;j<3;j++){
                    for(int i=0;i<objetsRestants.size()/3;j++){
                        int indexRandom = random.nextInt(objetsRestants.size());
                        Mission mission = new Mission(this.listeDeJoueurs.get(j), objetsRestants.get(indexRandom));
                        allMissions.add(mission);
                        objetsRestants.remove(indexRandom);
                    }
                }
            }
            
            case 4->{
                Random random = new Random();
                
                ArrayList<String> objetsRestants = new ArrayList();
                for(int i=0;i<this.listeDesObjets.length;i++){
                    objetsRestants.add(this.listeDesObjets[i]);
                }
                
                for(int j=0;j<4;j++){
                    for(int i=0;i<objetsRestants.size()/3;j++){
                        int indexRandom = random.nextInt(objetsRestants.size());
                        Mission mission = new Mission(this.listeDeJoueurs.get(j), objetsRestants.get(indexRandom));
                        allMissions.add(mission);
                        objetsRestants.remove(indexRandom);
                    }
                }
            }
            
        }
    }
    
    /**
     * Getter AllMissions
     * @return
     *       ArrayList de Mission qui représente toutes les missions du plateau
     */
    public ArrayList<Mission> getAllMissions(){
        return allMissions;
    }
    
}
