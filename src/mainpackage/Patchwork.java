
package mainpackage;

import java.util.Random;

/**
 * Classe Patchwork, un patchwork est un ensemble de taches de couleurs différentes. 
 * Un patchwork numérique est un patchwork où les couleurs sont représentées par un nombre.
 * 
 * @author g37788 2014
 * @version 1.0 
 */
public class Patchwork {

    private int morceaux[][];
    /**
     * Constructeur de la classe Patchwork 
     * @param tab2d Un tableau à deux dimensions.
     * @exception IllegalArgumentException Si le tableau est null.
     * @exception IllegalArgumentException Si le tableau est carré, il doit être rectangulaire.
     */
    public Patchwork(int tab2d[][]) {
        if (tab2d == null) {
            throw new IllegalArgumentException("Le tableau doit être non null");
        }
        int saveSize = tab2d[0].length;
        int i = 1;
        boolean ok = true;
        //On vérifie que les tableaux ont tous la même dimension.
        while (ok && i < tab2d.length) {
            if (tab2d[i].length != saveSize) {
                ok = false;            //Ok passe à faux si les dimensions sont différentes.    
            }
            i++;
        }
        if (!ok || tab2d.length == tab2d[0].length) {
            throw new IllegalArgumentException("Le tableau doit être un rectangle !");
        }
        //On copie la tableau dans morceaux.
        morceaux = new int[tab2d.length][tab2d[0].length];
        for (i = 0; i < tab2d.length; i++) {
            System.arraycopy(tab2d[i], 0, morceaux[i], 0, tab2d[0].length);
        }
    }

    private int recursif(int x, int y, int val, boolean bitmap[][]) {
        int cpt = 0;
        if (isInside(x, y)) {
            if (morceaux[x][y] == val) {
                if (bitmap[x][y] == false) {
                    bitmap[x][y] = true;
                    cpt = cpt + recursif(x + 1, y, morceaux[x][y], bitmap);
                    cpt = cpt + recursif(x - 1, y, morceaux[x][y], bitmap);
                    cpt = cpt + recursif(x, y + 1, morceaux[x][y], bitmap);
                    cpt = cpt + recursif(x, y - 1, morceaux[x][y], bitmap);
                    cpt++;
                }
            }
        }
        return cpt;
    }
    /**
     * Methode isInside
     * Permet de savoir si une case dont les coordonnées sont passées en paramètres est dans le tableau. 
     * @param x, y, les coordonnées de la case.
     */
    public boolean isInside(int x, int y) {
        return ((x >= 0 && x < morceaux.length) && (y >= 0 && y < morceaux[x].length));
    }
    /**
     * Methode compterTaches de la classe Patchwork 
     * Elle permet de connaître le nombre de taches contenues dans le patchwork.
     * Elle fait appel à la méthode récursive, "recursif"
     */
    public int compterTaches() {
        int cpt = 0;
        boolean bitmap[][] = new boolean[morceaux.length][morceaux[0].length];
        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < bitmap[0].length; j++) {
                bitmap[i][j] = false;
            }
        }
        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < bitmap[0].length; j++) {
                if (recursif(i, j, morceaux[i][j], bitmap) > 1) {
                    cpt++;
                }
            }
        }
        return cpt;
    }
    /**
     * Methode affichageTableau2d
     * Permet d'afficher un tableau à 2 dimensions.
     * @param tab2d 
     */
    public void affichageTableau2d(int[][] tab2d) {
        for (int i = 0; i < tab2d.length; i++) {
            for (int j = 0; j < tab2d[i].length; j++) {
                System.out.print(tab2d[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int tab2d[][] = new int[8][9];
        Random rand = new Random();        
        for (int i = 0; i < tab2d.length; i++) {
            for (int j = 0; j < tab2d[i].length; j++) {
                tab2d[i][j] = rand.nextInt(tab2d[0].length);
            }
        }
        try {
            Patchwork p = new Patchwork(tab2d);
            p.affichageTableau2d(tab2d);
            System.out.println("Ce patchwork contient " + p.compterTaches() + " tache(s)");
            
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
