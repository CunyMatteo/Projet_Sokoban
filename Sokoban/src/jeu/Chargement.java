package jeu;
import java.io.*;
import java.util.ArrayList;

public class Chargement {

    public static Jeu chargerJeu(String nomFichier) throws IOException, FichierIncorrectException {
        ArrayList<String> lignes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(nomFichier));
        String l;
        int maxColonnes = 0;

        while ((l = br.readLine()) != null) {
            lignes.add(l);
            if (l.length() > maxColonnes) maxColonnes = l.length();
        }
        br.close();


        return new Jeu();
    }
}
