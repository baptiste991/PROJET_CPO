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
        this.getPlateau().get(0).get(size - 1).gen1CornerUpRight();
        this.getPlateau().get(size - 1).get(0).gen1CornerDownLeft();
        this.getPlateau().get(size - 1).get(size - 1).gen1CornerDownRight();

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
     * méthode qui créé une carte en plus du plateau à injecter au prochain tour
     */
    public void genWaitCard(){
        
        carteAttente = new Carte();
       
        // on set ses coordonnées en 10 10 pour qu'elle soit pas confondu avec une carte du plateau
        carteAttente.setPosx(10);
        carteAttente.setPosy(10);
        
    }

    /**
     * Methode qui permet de retrouver une mission en fonction du nom de l'objet
     * qui est concerné par la mission (principalement utilisée dans la méthode
     * gen1DeckCarteDeplacable)
     *
     * @param objectName Le nom de l'objet concerné par la mission
     * @return
     */
    public Mission findMissionInAllkbyObject(String objectName) {
        Mission mission = new Mission();
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
        for (int i = 0; i < this.getAllMissions().size(); i++) {
            //i itère sur le nombre de missions soit 16

            int indexRandomX, indexRandomY;
            //On choisit des coordonnées aléatoires
            do {
                indexRandomX = random.nextInt(7);
                indexRandomY = random.nextInt(7);
            } while (cartesRestantes.get(indexRandomX).get(indexRandomY).getPosx() < 0 && cartesRestantes.get(indexRandomX).get(indexRandomY).getPosy() < 0);
            // On vérifie que ces coordonnées n'aient pas déja été choisies

            //carte du plateau au hasard par ces coordonnées pour lui attribuer la mission
            cartesRestantes.get(indexRandomX).get(indexRandomY).setMission(this.getAllMissions().get(i));
            //La carte de carteRestante d'indice indexRandomX,indexRandomY doit donner sa mission a la carte de mêmes coordonnées
            this.getPlateau().get(indexRandomX).get(indexRandomY).setMission(this.getAllMissions().get(i));
            //Pour la suite on va opposer les coordonnées de la carte choisie 
            cartesRestantes.get(indexRandomX).get(indexRandomY).setPosx(-(cartesRestantes.get(indexRandomX).get(indexRandomY).getPosx()));
            cartesRestantes.get(indexRandomX).get(indexRandomY).setPosy(-(cartesRestantes.get(indexRandomX).get(indexRandomY).getPosy()));

        }

    }

}
