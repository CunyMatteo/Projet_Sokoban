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

    public String jeuToString(){
        return "";
    }
}
