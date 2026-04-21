package jeu;
import java.util.*;

public class ListeElements {

    ArrayList<Element> liste;

    public ListeElements() {
        this.liste = new ArrayList<>();
    }

    public void ajouter(Element e) {
        this.liste.add(e);
    }

    public int size() {
        return this.liste.size();
    }

    public Element getElement(int x, int y) {
        for (Element e : this.liste) {
            if (e.x == x && e.y == y) return e;
        }
        return null;
    }
}
