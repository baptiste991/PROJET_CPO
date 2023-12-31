package projet_labyrinthe;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe qui s'occupe de la génération du plateau et de sa gestion
 *
 * @author Ody
 * @version 1.0
 */
public class Plateau extends Settings {

    /**
     * Le plateau est défini comme un array de carte à 2 dimensions
     *
     * @see plateau
     */
    private ArrayList<ArrayList<Carte>> plateau = new ArrayList<>();

    /**
     * Getter Plateau
     *
     * @return
     */
    protected ArrayList<ArrayList<Carte>> getPlateau() {
        return plateau;
    }

    /**
     * L'instance de random
     */
    Random random = new Random();

    /**
     * Toutes les cartes qui sont actuellement sur le plateau
     */
    private ArrayList<Carte> deckCardOnBoard = new ArrayList();

    /**
     * Toutes les cartes qui peuvent être déplacées
     */
    private ArrayList<Carte> deckCartesDeplacables = new ArrayList<Carte>();

    /**
     * La taille du plateau est définie par la variable size
     *
     * @see size
     */
    int size;

    Carte carteAttente;
    
    int nbcardsperplayer;

    /**
     * Constructeur de la classe Plateau
     *
     */
    public Plateau() {
        this.size = 7;
        this.gen1DeckCarteDeplacable();
        this.initialiserPlateau();
        this.carteAttente = genRandomCard();

    }

    /**
     * initialiserPlateau est la méthode qui réserve l'emplacement de toutes les
     * cartes et donc initialise les coordonnées de chaque carte par le
     * constructeur de la classe Carte.
     *
     * On initialise aussi les variables "movable" des cartes en fonction de
     * leur position sur le plateau.
     *
     * On initialise aussi les directions possibles des cartes non déplacables
     * i.e la variable allowingDirections
     *
     * Les cartes déplacables sont placées aléatoirement sur le plateau.
     */
    public void initialiserPlateau() {

        //Creation d'une copie 
        ArrayList<Carte> cartesDeplacablesRestantesAPlacer = new ArrayList();
        for (int i = 0; i < this.deckCartesDeplacables.size(); i++) {
            cartesDeplacablesRestantesAPlacer.add(deckCartesDeplacables.get(i));
        }

        for (int i = 0; i < size; i++) {
            this.getPlateau().add(new ArrayList<Carte>());
            for (int j = 0; j < size; j++) {
                Carte carte = new Carte(i, j);

                // Initialisation de la variable Movable des cartes en fonction de leur position
                if (j % 2 == 0) { // Carte est sur une colonne non déplacable
                    if (i % 2 == 0) {//Carte sur une ligne non déplacable
                        carte.setMovable(false);
                    } else {
                        carte.setMovable(true);
                        int indexRandom = random.nextInt(cartesDeplacablesRestantesAPlacer.size());
                        carte.setAllowingDirections(cartesDeplacablesRestantesAPlacer.get(indexRandom).getAllowingDirections());
                        carte.setType(cartesDeplacablesRestantesAPlacer.get(indexRandom).getType());
                        cartesDeplacablesRestantesAPlacer.remove(indexRandom);
                    }
                } else {
                    carte.setMovable(true);
                    int indexRandom = random.nextInt(cartesDeplacablesRestantesAPlacer.size());
                    carte.setAllowingDirections(cartesDeplacablesRestantesAPlacer.get(indexRandom).getAllowingDirections());
                    carte.setType(cartesDeplacablesRestantesAPlacer.get(indexRandom).getType());
                    cartesDeplacablesRestantesAPlacer.remove(indexRandom);
                }

                this.getPlateau().get(i).add(carte);
                deckCardOnBoard.add(carte);
            }

        }
        // Initialisation de la variable allowingDirections des cartes non déplacables en fonction de leur position
        // --> Pour un plateau de taille 7

        //Angles
        this.getPlateau().get(0).get(0).gen1CornerUpLeft();
        this.getPlateau().get(0).get(0).setType("SpawnUpLeft");
        this.getPlateau().get(0).get(size - 1).gen1CornerUpRight();
        this.getPlateau().get(0).get(size - 1).setType("SpawnUpRight");
        this.getPlateau().get(size - 1).get(0).gen1CornerDownLeft();
        this.getPlateau().get(size - 1).get(0).setType("SpawnDownLeft");
        this.getPlateau().get(size - 1).get(size - 1).gen1CornerDownRight();
        this.getPlateau().get(size - 1).get(size - 1).setType("SpawnDownRight");


        //Colonnes non déplacables colonnes extrêmes
        this.getPlateau().get(2).get(0).gen1TRight();
        this.getPlateau().get(4).get(0).gen1TRight();
        this.getPlateau().get(2).get(size - 1).gen1TLeft();
        this.getPlateau().get(4).get(size - 1).gen1TLeft();

        //Lignes non déplacables extrèmes
        this.getPlateau().get(0).get(2).gen1TDown();
        this.getPlateau().get(0).get(4).gen1TDown();
        this.getPlateau().get(size - 1).get(2).gen1TUp();
        this.getPlateau().get(size - 1).get(4).gen1TUp();
        //Cartes non déplacables centrales
        this.getPlateau().get(2).get(2).gen1TRight();
        this.getPlateau().get(2).get(4).gen1TDown();
        this.getPlateau().get(4).get(2).gen1TUp();
        this.getPlateau().get(4).get(4).gen1TLeft();

    }

        /**
     * Methode qui initialise toutes les missions  i.e associe à chaque objet
     * (représenté par une chaine de caractère) un joueur pour le récupérer
     * 
     * C'est à dire que l'array d'objet type "Mission" contient 16 Missions :
     * Pour rappel une mission est un objet qui comporte deux attributs :
     * un obet et un joueur. Ces 16 missions sont donc uniques.
     */
    public void setAllMissions(){
        
        // Remarque : Le switch suivant fait apparaitre beaucoup de code surement factorisable 
        // en créant une méthode sous jacente, il serait interessant de le faire mais
        // actuellement on l'utilisera comme tel.
        switch(this.getListeDeJoueurs().size()){
            
            case 1->{
                for(int i=0;i<this.nbcardsperplayer;i++){
                    Mission mission = new Mission(this.getListeDeJoueurs().get(0), this.getListeDesObjets()[i]);
                    this.getAllMissions().add(mission);
                }
            }
            
            case 2 ->{
                Random random = new Random();
                
                ArrayList<String> objetsRestants = new ArrayList();
                for(int i=0;i<this.nbcardsperplayer*2;i++){
                    objetsRestants.add(this.getListeDesObjets()[i]);
                }
                                
                for(int j=0;j<2;j++){
                    for(int i=0;i<this.nbcardsperplayer;i++){
                        int indexRandom = random.nextInt(objetsRestants.size());
                        Mission mission = new Mission(this.getListeDeJoueurs().get(j), objetsRestants.get(indexRandom));
                         this.getAllMissions().add(mission);
                        objetsRestants.remove(indexRandom);
                    }
                }
            }    
            
            case 3 ->{
                Random random = new Random();
                
                ArrayList<String> objetsRestants = new ArrayList();
                for(int i=0;i<this.nbcardsperplayer*3;i++){
                    objetsRestants.add(this.getListeDesObjets()[i]);
                }

                
                for(int j=0;j<3;j++){
                    for(int i=0;i<this.nbcardsperplayer;i++){
                        int indexRandom = random.nextInt(objetsRestants.size());
                        Mission mission = new Mission(this.getListeDeJoueurs().get(j), objetsRestants.get(indexRandom));
                        this.getAllMissions().add(mission);
                        objetsRestants.remove(indexRandom);
                    }
                }
               
            }
            
            case 4->{
                Random random = new Random();
                
                ArrayList<String> objetsRestants = new ArrayList();
                for(int i=0;i<this.nbcardsperplayer*4;i++){
                    objetsRestants.add(this.getListeDesObjets()[i]);
                }
                
                for(int j=0;j<4;j++){
                    for(int i=0;i<this.nbcardsperplayer;i++){
                        int indexRandom = random.nextInt(objetsRestants.size());
                        Mission mission = new Mission(this.getListeDeJoueurs().get(j), objetsRestants.get(indexRandom));
                        this.getAllMissions().add(mission);
                        objetsRestants.remove(indexRandom);
                    }
                }
            }
            
            
        }

    }
    
    /**
     * Methode qui permet de générer l'ensemble des cartes déplacables sous
     * forme d'ArrayList de Carte.
     */
    public void gen1DeckCarteDeplacable() {

        //Besoin de 33 Cartes pour combler le plateau : On en a donc besoin de 34 : génération aléatoire
        for (int i = 0; i < 34; i++) {

            deckCartesDeplacables.add(genRandomCard());
        }
    }

    /**
     * méthode qui génère aléatoirement une carte du plateau
     *
     * @return une carte
     */
    public Carte genRandomCard() {
        Carte carte = new Carte();
        int j = random.nextInt(10);
        switch (j) {
            case 0 -> {
                carte.gen1TDown();
            }
            case 1 -> {
                carte.gen1TLeft();
            }
            case 2 -> {
                carte.gen1TRight();
            }
            case 3 -> {
                carte.gen1TUp();
            }
            case 4 -> {
                carte.gen1I();
            }
            case 5 -> {
                carte.gen1_();
            }
            case 6 -> {
                carte.gen1CornerDownLeft();
            }
            case 7 -> {
                carte.gen1CornerDownRight();
            }
            case 8 -> {
                carte.gen1CornerUpLeft();
            }
            case 9 -> {
                carte.gen1CornerUpRight();
            }
        }
        return carte;
    }



    /**
     * Methode qui permet de retrouver une mission en fonction du nom de l'objet
     * qui est concerné par la mission (principalement utilisée dans la méthode
     * gen1DeckCarteDeplacable)
     *
     * @param objectName Le nom de l'objet concerné par la mission
     * @return
     */
    public Mission findMissionInAllbyObject(String objectName) {
        Mission mission = new Mission(new Joueur(), "name");
        for (int j = 0; j < this.getAllMissions().size(); j++) {
            if (objectName.equals(this.getAllMissions().get(j).objet)) {
                mission = this.getAllMissions().get(j);
            }
        }
        return mission;
    }

    /**
     * Getter DeckCardOnBoard
     *
     * @return
     */
    public ArrayList<Carte> getDeckCardOnBoard() {
        return deckCardOnBoard;
    }

    /**
     * Methode qui set les coordonnées correcte de chaque carte en fonction
     * de leur position sur le plateau
     */
    public void setCorrectCardsCoordinates(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                this.plateau.get(i).get(j).setPosx(i);
                this.plateau.get(i).get(j).setPosy(j);
            }
        }
    }
    
    /**
     * Methode qui attribue aux joueurs tous les objets à récupérer
     */
    public void setListMissionOfPlayers(){
        for(int p=0;p<this.getListeDeJoueurs().size();p++){
            
            for(int missions=0;missions<this.getAllMissions().size();missions++){
                if(this.getListeDeJoueurs().get(p).equals(getAllMissions().get(missions).player) ){
                    this.getListeDeJoueurs().get(p).addObjets(getAllMissions().get(missions).getObjet());
                }
            }


        }
    }
    


    /**
     * Méthode qui injecte la carteAttente en prmière place d'une ligne
     *
     * @param x ligne en question à injecter
     * @param gauche boolean permettant d'injecter à gauche en true ou à droite en false
     */
    public void injectXPlayer(int x, boolean gauche) {
        
        int playerontheline =0;
        ArrayList<Joueur> playeronthelineList= new ArrayList<Joueur>();
        // Y a-t-il des joueurs sur cette ligne ? si oui on les supprime de la carte
        for(int y=0;y<7;y++){
                if(this.plateau.get(x).get(y).isRidedByPlayers.size()!=0){
                    playerontheline += this.plateau.get(x).get(y).isRidedByPlayers.size();
                    for(int nb=0;nb<this.plateau.get(x).get(y).isRidedByPlayers.size();nb++){
                         playeronthelineList.add(this.plateau.get(x).get(y).isRidedByPlayers.get(nb));
                         this.plateau.get(x).get(y).isRidedByPlayers.remove(playeronthelineList.get(playeronthelineList.size()-1));
                    }
            }
        }
        
        // Si il y a des gens sur la ligne à modifier
        if(playerontheline!=0){
            
            ArrayList<Integer> saveposy = new ArrayList<Integer>();
            
            // Pour chaque joueur
            for (int p=0;p<playerontheline;p++){
                
                // Si le joueur est à un extreme
                //Gauche
                if(playeronthelineList.get(p).getPosy()== 0){
                    saveposy.add(playeronthelineList.get(p).getPosy());
                    
                } else if (playeronthelineList.get(p).getPosy()== 6){
                //Droite     
                    saveposy.add(playeronthelineList.get(p).getPosy());
                  // Le joueur n'est pas à un extreme
                } else {
                    if(gauche){
                        saveposy.add(playeronthelineList.get(p).getPosy());
                        playeronthelineList.get(p).deplacementEst();
                    } else {
                        saveposy.add(playeronthelineList.get(p).getPosy());
                        playeronthelineList.get(p).deplacementOuest();
                    }
                    
                }
                
            }
            
            injectXCards(x, gauche);
            
            // On update les coordonnées des joueurs sur la ligne
            for(int i=0;i<saveposy.size();i++){
                // Si extreme gauche & gauche -> Deplacement gauche
                if(saveposy.get(i)==0 && gauche){
                    playeronthelineList.get(i).setPosy(1);
                    this.plateau.get(x).get(playeronthelineList.get(i).getPosy()).isRidedByPlayers.add(playeronthelineList.get(i));
                    
                  // Si extreme droite et gauche --> Change d'extreme
                } else if(saveposy.get(i)==6 && gauche){
                    playeronthelineList.get(i).setPosy(0);
                    this.plateau.get(x).get(playeronthelineList.get(i).getPosy()).isRidedByPlayers.add(playeronthelineList.get(i));
                    
                 // Si extreme gauche et droite --> Deplacement droite
                } else if(saveposy.get(i)==0 && (!gauche)){
                    playeronthelineList.get(i).setPosy(6);
                    this.plateau.get(x).get(playeronthelineList.get(i).getPosy()).isRidedByPlayers.add(playeronthelineList.get(i));
                    
                 // si extreme droite et droite -> Change d'extreme
                } else if(saveposy.get(i)==6 && (!gauche)){
                    playeronthelineList.get(i).setPosy(5);
                    this.plateau.get(x).get(playeronthelineList.get(i).getPosy()).isRidedByPlayers.add(playeronthelineList.get(i));
                  
                 // Pas à l'extreme   
                } else if(saveposy.get(i)!= 0 || saveposy.get(i)!=6){
                    this.plateau.get(x).get(playeronthelineList.get(i).getPosy()).isRidedByPlayers.add(playeronthelineList.get(i));
                }
            }
            
        
        
        // Si il n'y a personne sur la ligne a modifier 
        } else {
            injectXCards(x, gauche);
            
        }
        
    }
    
    public void injectXCards(int x, boolean gauche){
        
        if (gauche) {
            // Ajouter la carteAttente en tant que première carte de la ligne
            getPlateau().get(x).add(0, carteAttente);

            // Mettre à jour la carteAttente avec la dernière carte de la ligne
            int lastIndex = getPlateau().get(x).size() - 1;
            carteAttente = getPlateau().get(x).get(lastIndex);

            // Supprimer la dernière carte de la ligne
            getPlateau().get(x).remove(lastIndex);
        }
        else{
           // Ajouter la carteAttente en tant que denière carte de la ligne
            getPlateau().get(x).add(size , carteAttente);

            // Mettre à jour la carteAttente avec la première carte de la ligne
            carteAttente = getPlateau().get(x).get(0);

            // Supprimer la première carte de la ligne
            getPlateau().get(x).remove(0); 
        }
        
        
    }

    public void injectYCards(int y, boolean haut){
        
        Carte temp1 = null;
        Carte temp2;

        //En fonction de l'injection
        if (haut) {
            Carte lastCard = getPlateau().get(size - 1).get(y);

            for (int i = 0; i < size; i++) {
                // Si c'est la première colonne, ajouter la carteAttente en tant que première carte
                if (i == 0) {
                    temp1 = getPlateau().get(i).get(y);
                    getPlateau().get(i).remove(y);
                    getPlateau().get(i).add(y, carteAttente);
                } else {
                    // Sinon, réorganiser les cartes dans la colonne
                    temp2 = getPlateau().get(i).get(y);
                    getPlateau().get(i).remove(y);
                    getPlateau().get(i).add(y, temp1);
                    temp1 = temp2;
                }

                carteAttente = lastCard;
            }
        } else {
            // Récupérer la première carte de la colonne
                Carte firstCard = getPlateau().get(0).get(y);
            for (int i = size - 1; i >= 0; i--) {

                if (i == size - 1) {
                    temp1 = getPlateau().get(i).get(y);
                    getPlateau().get(i).remove(y);
                    getPlateau().get(i).add(y, carteAttente);
                } else {
                    // Sinon, réorganiser les cartes dans la colonne
                    temp2 = getPlateau().get(i).get(y);
                    getPlateau().get(i).remove(y);
                    getPlateau().get(i).add(y, temp1);
                    temp1 = temp2;
                }
            }
            carteAttente = firstCard;
        }
        
    }
    
    /**
     * Méthode qui permet d'injecter la carteAttente dans une grille et qui met à jour la carteAttente
     * @param y numéro de colonne à injecter
     * @param haut boolean permettant d'injectant en haut si true ou en bas si false
     */
    public void InjectYPlayer(int y, boolean haut) {
        
        int playeronthecol =0;
        ArrayList<Joueur> playeronthecolList= new ArrayList<Joueur>();
        
        // Y a-t-il des joueurs sur cette colonne ? si oui on les supprime de la carte
        for(int x=0;x<7;x++){
                if(this.plateau.get(x).get(y).isRidedByPlayers.size()!=0){
                    playeronthecol += this.plateau.get(x).get(y).isRidedByPlayers.size();
                    for(int nb=0;nb<this.plateau.get(x).get(y).isRidedByPlayers.size();nb++){
                         playeronthecolList.add(this.plateau.get(x).get(y).isRidedByPlayers.get(nb));
                         this.plateau.get(x).get(y).isRidedByPlayers.remove(playeronthecolList.get(playeronthecolList.size()-1));
                    }
                }
        }
        
        // Si il y a des gens sur la colonne à modifier
        if(playeronthecol!=0){
            
            ArrayList<Integer> saveposx = new ArrayList<Integer>();
            
            // Pour chaque joueur
            for (int p=0;p<playeronthecol;p++){
                
                // Si le joueur est à un extreme
                //Haut
                if(playeronthecolList.get(p).getPosx()== 0){
                    saveposx.add(playeronthecolList.get(p).getPosx());
                    
                } else if (playeronthecolList.get(p).getPosx()== 6){
                //Bas     
                    saveposx.add(playeronthecolList.get(p).getPosx());
                  // Le joueur n'est pas à un extreme
                } else {
                    if(haut){
                        saveposx.add(playeronthecolList.get(p).getPosx());
                        playeronthecolList.get(p).deplacementSud();
                    } else {
                        saveposx.add(playeronthecolList.get(p).getPosx());
                        playeronthecolList.get(p).deplacementNord();
                    }
                    
                }
                
            }
        
            injectYCards(y, haut);

            // On update les coordonnées des joueurs sur la ligne
            for(int i=0;i<saveposx.size();i++){
                // Si extreme haut & haut -> Deplacement bas
                if(saveposx.get(i)==0 && haut){
                    playeronthecolList.get(i).setPosx(1);
                    this.plateau.get(playeronthecolList.get(i).getPosx()).get(y).isRidedByPlayers.add(playeronthecolList.get(i));

                  // Si extreme bas et haut --> Change d'extreme
                } else if(saveposx.get(i)==6 && haut){
                    playeronthecolList.get(i).setPosx(0);
                    this.plateau.get(playeronthecolList.get(i).getPosx()).get(y).isRidedByPlayers.add(playeronthecolList.get(i));

                 // Si extreme haut et bas --> Change d'extreme
                } else if(saveposx.get(i)==0 && (!haut)){
                    playeronthecolList.get(i).setPosx(6);
                    this.plateau.get(playeronthecolList.get(i).getPosx()).get(y).isRidedByPlayers.add(playeronthecolList.get(i));

                 // si extreme bas et bas -> Déplacement haut
                } else if(saveposx.get(i)==6 && (!haut)){
                    playeronthecolList.get(i).setPosx(5);
                    this.plateau.get(playeronthecolList.get(i).getPosx()).get(y).isRidedByPlayers.add(playeronthecolList.get(i));

                 // Pas à l'extreme   
                } else if(saveposx.get(i)!= 0 || saveposx.get(i)!=6){
                    this.plateau.get(playeronthecolList.get(i).getPosx()).get(y).isRidedByPlayers.add(playeronthecolList.get(i));
                }
                
            }
        
        // Si il n'y a personne sur la colonne a modifier 
        } else {
            injectYCards(y, haut);
            
        }
    }

        
    
    
    /**
     * Methode qui a pour but de placer les joueurs sur leur spawn
     */
    public void placeAllPlayers(){

        ArrayList<String> spawn = new ArrayList<String>();
        spawn.add("SpawnUpLeft");
        spawn.add("SpawnUpRight");
        spawn.add("SpawnDownLeft");
        spawn.add("SpawnDownRight");

        // Boucle sur le nombre de joueurs de la partie
        for(int p=0;p<this.getListeDeJoueurs().size();p++){
            
            //Tirage aléatoire du spawn
            int randomint = random.nextInt(spawn.size());
            int out=0;
            
            // Parcourt de toutes les cartes du plateau pour trouver le spawn
            for(int i=0;i<7;i++){
                if(out==1){
                    out=0;
                    break;
                }
                for(int j=0;j<7;j++){

                    Carte carte = this.plateau.get(i).get(j);

                    if(carte.getType()==spawn.get(randomint)){
                        carte.isRidedByPlayers.add(this.getListeDeJoueurs().get(p));
                        this.getListeDeJoueurs().get(p).setPosx(carte.getPosx());
                        this.getListeDeJoueurs().get(p).setPosy(carte.getPosy());
                        spawn.remove(spawn.get(randomint));
                        out++;
                        break;
                    }
                }
            }
        }  
    }

    /**
     * Methode qui va attribuer toutes les missions à toutes les cartes Les
     * positions des trésors sont choisies aléatoirement
     */
    public void setAllMissionsToCards() {

        //Reproduction d'un ArrayList de cartes semblables à celles du plateau dont la taille va rétrécir et tendre à 49 - 16 = 33
        ArrayList<ArrayList<Carte>> cartesRestantes = new ArrayList<>();
        for (int x = 0; x < 7; x++) {
            cartesRestantes.add(new ArrayList<Carte>());
            for (int y = 0; y < 7; y++) {
                Carte carte = new Carte(x, y);
                cartesRestantes.get(x).add(carte);
            }
        }
        //49 Cartes du plateau copiées en 2D 

        //Randomisation des missions sur les cartes
        
        int [][] coordsMissions = new int [this.getAllMissions().size()][2];
        boolean coordsalreadyused;
        
        for (int i = 0; i < this.getAllMissions().size(); i++) {
            //on itère sur le nombre de missions soit 16

            int indexRandomX, indexRandomY;
            //On choisit des coordonnées aléatoires
            do {
                coordsalreadyused = false;
                indexRandomX = random.nextInt(7);
                indexRandomY = random.nextInt(7);
                
                for(int coords=0;coords<this.getAllMissions().size();coords++){
                    if(indexRandomX == coordsMissions[coords][0] && indexRandomY == coordsMissions[coords][1]){
                        coordsalreadyused = true;
                        break;
                    }
                }
                
                if(!coordsalreadyused){
                    coordsMissions[i][0] = indexRandomX;
                    coordsMissions[i][1] = indexRandomY;
                }
                
            } while (coordsalreadyused);
            

            //La carte d'indice indexRandomX,indexRandomY doit donner sa mission a la carte de mêmes coordonnées
            this.getPlateau().get(indexRandomX).get(indexRandomY).setMission(this.getAllMissions().get(i));
           
        }

        
    }

}
