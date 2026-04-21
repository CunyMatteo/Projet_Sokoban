package graphisme;

import jeu.ActionInconnueException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur extends JPanel implements ActionListener {

    /**
     * l'application controlee
     */
    Application app;

    public Controleur(Application pApp) {
        // recupere attribut application
        this.app = pApp;

        // creer des boutons
        JButton haut = new JButton(jeu.HAUT);
        JButton bas = new JButton(jeu.BAS);
        JButton gauche = new JButton(jeu.GAUCHE);
        JButton droite = new JButton(jeu.DROITE);

        // ajoute les reactions
        haut.addActionListener(this);
        bas.addActionListener(this);
        gauche.addActionListener(this);
        droite.addActionListener(this);

        this.add(haut);
        this.add(bas);
        this.add(gauche);
        this.add(droite);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // recupere le texte
        String action = ((JButton) e.getSource()).getText();

        // utilise cela comme action sur le jeu
        try {
            this.app.deplacerPerso(action);
        } catch (ActionInconnueException ex) {
            throw new RuntimeException(ex);
        }
    }
}


