package tgm.sew.hit.roboterfabrik;

import java.util.Collections;
import java.util.List;

/**
 * Repräsentiert ein Teil eines Threadees
 * 
 * @author Dominik
 * @version 0.1
 */
public class Teil {
    
    private TeilType type;
    private List<Integer> zahlen;
    private boolean istGebaut = false;
    
    /**
     * Erstellt ein Teil des Threadees
     * @param typ der Typ des Teils
     * @param zahlen die Zahlen zum zusammenbauen des Teils
     */
    public Teil(TeilType type,List<Integer> zahlen) {
        this.type = type;
        this.zahlen = zahlen;
    }
    
    /**
     * Gibt zurück, ob das Teil bereits
     * zusammengebaut ist
     * @return ob das Teil zusammengebaut ist
     */
    public boolean istGebaut() {
        return istGebaut();
    }
    
    /**
     * Gibt den TeilType dieses Teiles zurück
     * @return der TeilType dieses Teiles
     */
    public TeilType getType() {
        return type;
    }
    
    /**
     * Baut das Teil zusammen
     * @return die Sortierte Zahlenliste
     */
    public List<Integer> zusammenbauen() {
        Collections.sort(zahlen);
        istGebaut = true;
        return zahlen;
    }
}