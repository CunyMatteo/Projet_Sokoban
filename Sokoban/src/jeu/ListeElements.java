package jeu;
import java.util.*;

public class ListeElements {

    ArrayList<Element> liste = new ArrayList<Element>();

    public ListeElements() {
        this.liste = new ArrayList<>();
    }

    public void ajouter(Element e) {
        this.liste.add(e);
    }

    public int size() {
        return this.liste.size();
    }
}
