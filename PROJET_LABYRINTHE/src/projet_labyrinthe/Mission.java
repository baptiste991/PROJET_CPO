package projet_labyrinthe;

/**
 * Classe qui représente une mission i.e un objet à récupérer par un joueur
 * propre à ce joueur
 * @author Ody
 * @version 1.0
 */
public class Mission {
    /**
     * Un joueur qui doit récupérer un objet
     */
    Joueur player = new Joueur();
    
    /**
     * Un objet qui doit être récupéré par le joueur
     */
    String objet;
    
    /**
     * Constructeur par joueur et object.
     * @param player
     *      Le joueur en question
     * @param objet
     *      L'objet que ce joueur doit récupérer
     */
    public Mission(Joueur player, String objet){
        this.player = player;
        this.objet = objet;
    }
    
    /**
     * Methode qui retourne l'objet que doit trouver le joueur sous forme de str
     * @return
     */
    public String getObjectToFind(){
        return objet;
    }
    
    /**
     * Methode qui retourne le joueur associé à l'objet à chercher.
     * @return
     */
    public Joueur getPlayerLookingForObject(){
        return player;
    }
}
