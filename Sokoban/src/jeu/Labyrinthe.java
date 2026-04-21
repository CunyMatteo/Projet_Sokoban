package jeu;

public class Labyrinthe {
    final static char MUR = '#';
    final static char CAISSE = '$';
    final static char PJ = '@';
    final static char DEPOT = '.';
    final static char VIDE = ' ';
    boolean [][] murs;

    public Labyrinthe(int x, int y) {
        this.murs = new boolean[x][y];
    }

    public void ajouterMur(int x, int y) {
        this.murs[x][y] = true;
    }

    public boolean etreMur(int x, int y) {
        return this.murs[x][y];
    }
}
