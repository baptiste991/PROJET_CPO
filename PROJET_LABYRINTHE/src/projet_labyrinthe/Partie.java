package projet_labyrinthe;




/**
 * Classe qui va représenter la partie du lancement à sa fin
 * @author Ody
 * @version 1.0
 */
public abstract class Partie {

    public void Partie(){
        
        Plateau plato = new Plateau(7);
        plato.initialiserPlateau();
        Joueur player1 = new Joueur();
        plato.setPlayerList(player1);
        plato.setAllMissions();
    }
    
    

    
}
