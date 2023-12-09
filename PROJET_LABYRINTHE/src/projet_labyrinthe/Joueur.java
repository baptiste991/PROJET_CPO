package projet_labyrinthe;

/**
 * Classe qui représente un joueur
 * @author Ody
 * @version 1.0
 */
public class Joueur {
    
    /**
     * @see posx
     *      Variable qui représente la position x sur le plateau du joueur
     * @see posy
     *      Variable qui représente la position y sur le plateau du joueur
     */
    
    private int posx, posy;
    String name;
    String skinpath;

    /**
     * Getter Posx
     * @return
     */
    public int getPosx() {
        return posx;
    }

    /**
     * Getter Posy
     * @return
     */
    public int getPosy() {
        return posy;
    }

    
    
    /**
     * Constructeur simple
     */
    public Joueur() {
        
    }

    
    /**
     * Constructeur qui prend un string type nom et un string type path
     * @param name
     * @param skinpath
     */
    public Joueur(String name, String skinpath) {
        this.name = name;
        this.skinpath = skinpath;
    }
    
    
    
    /**
     * Methode qui permet le déplacement d'un joueur au Nord de la carte
     * Il faudra rajouter des procédures pour vérifier si ce déplacement 
     * est possible
     * @see posy
     *          La position sur y du joueur sur le plateau
     */
    public void deplacementNord(){
        posy++;
    }
    
     /**
     * Methode qui permet le déplacement d'un joueur au Sud de la carte
     * Il faudra rajouter des procédures pour vérifier si ce déplacement 
     * est possible
     * @see posy
     *          La position sur y du joueur sur le plateau
     */
    public void deplacementSud(){
        posy--;
    }
    
     /**
     * Methode qui permet le déplacement d'un joueur à l'Est de la carte
     * Il faudra rajouter des procédures pour vérifier si ce déplacement 
     * est possible
     * @see posx
     *          La position sur x du joueur sur le plateau
     */
    public void deplacementEst(){
        posx++;
    }
    
     /**
     * Methode qui permet le déplacement d'un joueur à l'Ouest de la carte
     * Il faudra rajouter des procédures pour vérifier si ce déplacement 
     * est possible
     * @see posx
     *          La position sur x du joueur sur le plateau
     */
    public void deplacementOuest(){
        posx--;
    }

    /**
     * Setter posX
     * @param posx
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * Setter PosY
     * @param posy
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }
    
    
    
    
    

    
}
