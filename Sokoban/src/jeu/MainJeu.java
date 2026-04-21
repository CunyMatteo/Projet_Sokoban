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

        } catch (FichierIncorrectException e) {
            System.out.println("Erreur dans le contenu du labyrinthe : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fichier introuvable ou illisible : " + e.getMessage());
        }
    }
}
