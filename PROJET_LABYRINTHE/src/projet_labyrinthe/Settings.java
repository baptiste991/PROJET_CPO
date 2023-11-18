package projet_labyrinthe;

import java.util.ArrayList;

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
    
}
