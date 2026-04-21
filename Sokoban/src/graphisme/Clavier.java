package graphisme;

import jeu.ActionInconnueException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Clavier extends KeyAdapter {
    /**
     * lien vers le jeu (contenu dans application)
     */
    Application app;

    /**
     * constructeur
     *
     * @param pApp application a controler (pour MVC)
     */
    public Clavier(Application pApp) {
        this.app = pApp;
    }

    /**
     * appui d'une touche
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // mise a jour du jeu (qui appelle la mise a jour graphique)
        try {
            // gestion haut : z ou fleche
            if ((e.getKeyChar() == 'z') || (e.getKeyCode() == KeyEvent.VK_UP)) {
                this.app.deplacerPerso(jeu.Jeu.HAUT);
            }

            // gestion bas : s ou fleche
            else if ((e.getKeyChar() == 's') || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
                this.app.deplacerPerso(jeu.Jeu.BAS);
            }

            // gestion droite : d ou fleche
            else if ((e.getKeyChar() == 'd') || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
                this.app.deplacerPerso(jeu.Jeu.DROITE);
            }

            // gestion gauche : q ou fleche
            else if ((e.getKeyChar() == 'q') || (e.getKeyCode() == KeyEvent.VK_LEFT)) {
                this.app.deplacerPerso(jeu.Jeu.GAUCHE);
            }


        } catch (ActionInconnueException ex) {
            // erreur action inconnue
            throw new RuntimeException(ex);
        }

    }

}
