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


