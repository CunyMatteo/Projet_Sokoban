package jeu;

public class Jeu {
    public final static String HAUT = "Haut";
    public final static String BAS = "Bas";
    public final static String GAUCHE = "Gauche";
    public final static String DROITE = "Droite";

    Perso perso;
    ListeElements caisses;
    ListeElements depots;
    Labyrinthe laby;

    public Jeu(Labyrinthe laby, Perso perso, ListeElements caisses, ListeElements depots) {
        this.laby = laby;
        this.perso = perso;
        this.caisses = caisses;
        this.depots = depots;
    }

    public char getChar(int x, int y) {
        if (this.perso.x == x && this.perso.y == y) {
            return Labyrinthe.PJ;
        }

        if (this.caisses.getElement(x,y) != null){
            return Labyrinthe.CAISSE;
        }

        if (this.depots.getElement(x,y) != null){
            return Labyrinthe.DEPOT;
        }

        if (this.laby.etreMur(x, y)){
            return Labyrinthe.MUR;
        }

        return Labyrinthe.VIDE;
    }

    public String jeuToString() {
        String res = "";
        int largeur = this.laby.murs.length;
        int hauteur = this.laby.murs[0].length;

        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                res += getChar(x, y);
            }
            res += "\n";
        }
        return res;
    }

    public boolean etreFini() {
        for (int i = 0; i < this.caisses.size(); i++) {
            Element cc = this.caisses.liste.get(i);

            if (this.depots.getElement(cc.x,cc.y) == null) {
                return false;
            }
        }
        return true;
    }

    public static int[] getSuivant(int x, int y, String action){
        switch (action){
            case HAUT:    return new int[]{x, y - 1}; // si action = HAUT, on va vers le haut
            case BAS:     return new int[]{x, y + 1};
            case GAUCHE:  return new int[]{x - 1, y};
            case DROITE:  return new int[]{x + 1, y};
            default:      return null;
        }
    }

    public void deplacerPerso(String action) throws ActionInconnueException {

        int[] destination = getSuivant(perso.x, perso.y, action);
        if (destination == null) {
            throw new ActionInconnueException("Action inconnue : " + action);
        }

        int nx = destination[0];
        int ny = destination[1];

        if (this.laby.etreMur(nx, ny)) { // s'il y a un mur on bouge pas
            return;
        }

        Element caisse = this.caisses.getElement(nx, ny); // on verifie s'il y a une caisse ou pas

        if (caisse != null) {

            int[] apresCaisse = getSuivant(nx, ny, action); // On calcule la case APRES la caisse pour pouvoir la pousser
            int ax = apresCaisse[0];
            int ay = apresCaisse[1];


            if (!this.laby.etreMur(ax, ay) && this.caisses.getElement(ax, ay) == null) { // On peut pousser si la case après n'est ni un mur ni une autre caisse
                caisse.x = ax; // là on déplace la caisse
                caisse.y = ay;
                this.perso.x = nx;  // puis le personnage
                this.perso.y = ny;
            }
        } else {    // et si la case est vide ou si c'est un dépôt, on déplace juste le perso
            this.perso.x = nx;
            this.perso.y = ny;
        }
    }

    public Perso getPerso() {
        return perso;
    }

    public ListeElements getCaisses() {
        return caisses;
    }

    public ListeElements getDepots() {
        return depots;
    }

    public Labyrinthe getLaby() {
        return laby;
    }
}
