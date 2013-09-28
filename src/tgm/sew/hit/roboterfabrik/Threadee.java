package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

/**
 * Stellt einen Threadee dar
 * 
 * @author Dominik
 * @version 0.3
 */
public class Threadee {
    
    private List<Teil> teilListe = new ArrayList<>();
    private List<TeilType> fehlendeTeile = new ArrayList<>();
    private int id;
    private boolean istGebaut = false;
    
    /**
     * Threadee Konstruktor
     * @param id die ID des Threadees
     */
    public Threadee(int id) {
        this.id = id;
        for (TeilType tt : TeilType.values()) {
            for (int i = 0; i < tt.getAmount(); i++) fehlendeTeile.add(tt);
        }
    }
    
    /**
     * Gibt eine Liste von fehlenden Teilen zurück
     * @return Eine Liste von Teilen die dem Threadee noch fehlen
     */
    public List<TeilType> fehlendeTeile() {
        return fehlendeTeile;
    }
    
    /**
     * Gibt zurück, ob der Threadee bereits
     * zusammengebaut ist
     * @return ob der Threadee zusammengebaut ist
     */
    public boolean istGebaut() {
        return istGebaut();
    }
    
    /**
     * Fügt ein Teil hinzu
     * @return ob das Teil erfolgreich hinzugefügt wurde
     */
    public boolean addTeil(Teil teil) {
        if (fehlendeTeile.remove(teil.getType())) {
            teilListe.add(teil);
            return true;
        }
        return false;
    }
    
    /**
     * "Baut" den Threadee zusammen
     * @return ob der Threadee erfolgreich zusammen gebaut wurde,
     * false wenn nicht und zb Teile fehlen
     */
    public boolean zusammenbauen() {
        if(!fehlendeTeile.isEmpty()) return false;
        for (Teil teil : teilListe) teil.zusammenbauen();
        istGebaut = true;
        return true;
    }
}
