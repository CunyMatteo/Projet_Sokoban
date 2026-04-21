package jeu;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainJeu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez votre jeu : ");
        System.out.println("1 - Niveau facile");
        System.out.println("2 - Niveau moyen");
        System.out.println("3 - Niveau difficile");

        int choix = Integer.parseInt(sc.nextLine());
        String lab = "";

        if (choix == 1) lab = "laby/laby_simple.txt";
        else if (choix == 2) lab = "laby/laby.txt";
        else if (choix == 3) lab = "laby/laby_test.txt";
        else {
            System.out.println("Choix invalide.");
            return;
        }

        try {
            Jeu jeu = Chargement.chargerJeu(lab);
            int nbCoups = 0;

            while (!jeu.etreFini()) {
                System.out.println("\n" + jeu.jeuToString());
                System.out.println("Déplacements : " + nbCoups);
                System.out.print("Action (" + Jeu.HAUT + ", " + Jeu.BAS + ", " + Jeu.GAUCHE + ", " + Jeu.DROITE + ") : ");
                String action = sc.nextLine();

                try {
                    jeu.deplacerPerso(action);
                    nbCoups++;
                } catch (ActionInconnueException e) {
                    System.out.println("ERREUR : " + e.getMessage());
                }
            }

            // MESSAGE DE VICTOIRE
            System.out.println("\n" + jeu.jeuToString());
            System.out.println("BRAVO ! Vous avez gagné en " + nbCoups + " coups.");

        } catch (FichierIncorrectException e) {
            System.out.println("Erreur dans le contenu du labyrinthe : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fichier introuvable ou inaccessible (" + lab + "). Vérifiez le dossier /laby.");
        } finally {
            sc.close();
        }
    }
}
