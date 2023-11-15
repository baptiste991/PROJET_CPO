package projet_labyrinthe;

import java.util.ArrayList;

/**
 * Classe qui représente une carte quelconque
 * @author Ody
 * @version 1.0
 */
public class Carte {
    
     /**
     * @see posx
     *    Un entier qui décrit la coordonnée sur x de la carte sur le plateau
     * @see posy
     *    Un entier qui décrit la coordonnée sur y de la carte sur le plateau
     */
    private int posx,posy;
    
     /**
     * @see north
     *      La direction Nord est accessible par la carte
     * @see south 
     *      La direction Sud est accessible par la carte
     * @see east
     *      La direction Est est accessible par la carte
     * @see west
     *      La direction Sud est accessible par la carte
     */
    private boolean north,south,east,west;
    
     /**
     * @see allowingDirections
     *      Un tableau de booléens qui représente les directions dans lequelles
     * la carte permet d'aller
     */
    private boolean [] allowingDirections = {north,south,east,west};
    
    /**
     * Un array de joueurs qui représente les joueurs qui sont sur la carte
     * @see isRidedByPlayers
     */
    ArrayList<Joueur> isRidedByPlayers = new ArrayList<>();
    
    /**
     * La mission de la carte. La carte n'a pas forcément de mission dans ce 
     * cas mission n'est jamais initialisé
     * @see mission
     */
    private Mission mission;
    

    /**
     * Constructeur par coodonnées
     * @param posx
     *      La position sur x du plateau
     * @param posy
     *      La position sur y du plateau
     */
    public Carte(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }
    
    /**
     * Methode qui décrit les directions sur lesquelles un joueur situé sur la 
     * carte peut aller
     * @param n
     *      booléen qui représente la direction Nord
     * @param s
     *      booléen qui représente la direction Sud
     * @param e
     *      booléen qui représente la direction Est
     * @param w
     *      booléen qui représente la diretion Ouest
     */
    public void setDirectionsAllowing(boolean n, boolean s, boolean e, boolean w){
        this.allowingDirections[0]=n;
        this.allowingDirections[1]=s;
        this.allowingDirections[2]=e;
        this.allowingDirections[3]=w;
    }
    
    /**
     * Methode qui permet d'ajouter un joueur sur la carte
     * @param player
     *         Le joueur qui se tient sur la carte
     */
    public void addPlayerRidingCard(Joueur player){
        this.isRidedByPlayers.add(player);
    }
    
    /**
     * Methode qui permet d'enlever un joueur sur la carte
     * @param player
     *         Le joueur qui ne se tient plus sur la carte
     */
    public void removePlayerRidingCard(Joueur player){
        this.isRidedByPlayers.remove(player);
    }
    
    /**
     * Setter Mission
     * @param mission
     *      La mission de la carte
     */
    public void setMission(Mission mission){
        this.mission = mission;
    }
    
    /**
     * Getter Mission
     * @return
     *      La mission de la carte
     */
    public Mission getMission(){
        return mission;
    }

    /**
     * Getter AllowingDirections
     * @return 
     *      Un tableau de booléens qui représente les directions permises par
     * la carte
     */
    public boolean[] getAllowingDirections() {
        return allowingDirections;
    }

    /**
     * Setter Posx
     * @param posx
     *          La position x sur le plateau
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * Setter Posy
     * @param posy
     *          La position y sur le plateau
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

    /**
     * Getter Posx
     * @return
     *          La position x sur le plateau
     */
    public int getPosx() {
        return posx;
    }

    /**
     * Getter Posy
     * @return
     *          La position y sur le plateua
     */
    public int getPosy() {
        return posy;
    }
    
    
    
    

    
}
