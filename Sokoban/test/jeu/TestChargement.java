package jeu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestChargement {
    @Test
    public void testChargementValide() throws IOException, FichierIncorrectException {
        Jeu jeu = Chargement.chargerJeu("laby/laby_simple.txt");
        assertNotNull(jeu); // Si le jeu n'est pas nul, c'est que le chargement a marché
    }
}
