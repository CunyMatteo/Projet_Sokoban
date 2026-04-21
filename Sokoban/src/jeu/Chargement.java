package jeu;
import java.io.*;
import java.util.ArrayList;

public class Chargement {

    public static Jeu chargerJeu(String nomFichier) throws IOException, FichierIncorrectException {
        ArrayList<String> lignes = new ArrayList<>();
        int maxColonnes = 0;

        BufferedReader br = new BufferedReader(new FileReader(nomFichier));
        String ligne;
        while ((ligne = br.readLine()) != null) {
            lignes.add(ligne);
            if (ligne.length() > maxColonnes) {
                maxColonnes = ligne.length();
            }
        }
        br.close();

        int nbLignes = lignes.size();
        Labyrinthe laby = new Labyrinthe(maxColonnes, nbLignes);
        Perso perso = null;
        ListeElements caisses = new ListeElements();
        ListeElements depots = new ListeElements();

        for (int y = 0; y < nbLignes; y++) {
            String ligneTexte = lignes.get(y);
            for (int x = 0; x < ligneTexte.length(); x++) {
                char c = ligneTexte.charAt(x);

                if (c == Labyrinthe.MUR) {
                    laby.ajouterMur(x, y);
                } else if (c == Labyrinthe.PJ) {
                    perso = new Perso(x, y);
                } else if (c == Labyrinthe.CAISSE) {
                    caisses.ajouter(new Caisse(x, y));
                } else if (c == Labyrinthe.DEPOT) {
                    depots.ajouter(new Depot(x, y));
                } else if (c != Labyrinthe.VIDE) {
                    throw new FichierIncorrectException("Caractère inconnu : " + c);
                }
            }
        }

        if (perso == null) throw new FichierIncorrectException("personnage inconnu");
        if (caisses.size() == 0) throw new FichierIncorrectException("caisses inconnues");
        if (caisses.size() != depots.size()) {
            throw new FichierIncorrectException("Caisses (" + caisses.size() + ") Depots (" + depots.size() + ")");
        }
        return new Jeu(laby, perso, caisses, depots);
    }
}

