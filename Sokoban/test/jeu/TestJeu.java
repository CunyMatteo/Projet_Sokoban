package jeu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestJeu {
    @Test
    public void testDeplacementEtCaisse() throws IOException, FichierIncorrectException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby_simple.txt");
        assertEquals(3, jeu.getPerso().getX());
        jeu.deplacerPerso(Jeu.HAUT);
        assertEquals(2, jeu.getPerso().getY());
    }
}