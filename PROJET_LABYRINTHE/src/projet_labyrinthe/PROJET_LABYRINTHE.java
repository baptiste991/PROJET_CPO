/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_labyrinthe;

/**
 *
 * @author bapti
 */
public class PROJET_LABYRINTHE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int size = 7;
        int line =6;
        Plateau plato = new Plateau(size);
        plato.initialiserPlateau();
            for(int i=0;i<size;i++){
            System.out.println("x="+plato.plateau.get(line).get(i).getPosx()+" y="+plato.plateau.get(line).get(i).getPosy());
            if(plato.plateau.get(line).get(i).isMovable()==true){
                System.out.println("Déplacable");
            } else System.out.println("Non Déplacable");
            System.out.println(plato.plateau.get(line).get(i));
            
            // Incohérent donc à Revoir
        }

    }
    
}
