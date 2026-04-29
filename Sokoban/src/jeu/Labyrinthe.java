package jeu;

public class Labyrinthe {
    public final static char MUR = '#';
    public final static char CAISSE = '$';
    public final static char PJ = '@';
    public final static char DEPOT = '.';
    public final static char VIDE = ' ';
    public boolean [][] murs;

    public Labyrinthe(int x, int y) {
        this.murs = new boolean[x][y];
    }

    public void ajouterMur(int x, int y) {
        this.murs[x][y] = true;
    }

    public boolean etreMur(int x, int y) {
        return this.murs[x][y];
    }

    public boolean[][] getMurs() {
        return murs;
    }
}
