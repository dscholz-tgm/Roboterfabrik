package tgm.sew.hit.roboterfabrik;

/**
 * Stellt das Sekretariat dar, welches eindeutige ID's 
 * für die Threadees und Mitarbeiter bereitstellt
 * 
 * @author Dominik
 */
public class Sekretariat {
    
    private int mitarbeiterID;
    private int threadeeID;
    
    /**
     * Default Konstruktor
     * TODO: ID's aus config File weiterzählen lassen
     */
    public Sekretariat() {
    }
    
    /**
     * Konstruktor, bei dem die Startwerte der 
     * ID's mitgegeben werden können
     * @param mitarbeiterID der Anfangswert der MitarbeiterID
     * @param threadeeID der Anfangswert der ThreadeeID
     */
    public Sekretariat(int mitarbeiterID, int threadeeID) {
        this.mitarbeiterID = mitarbeiterID;
        this.threadeeID = threadeeID;
    }
    
    /**
     * Gibt die nächste MitarbeiterID aus
     * @return die nächste MitarbeiterID
     */
    public int nextMitarbeiterID() {
        return mitarbeiterID++;
    }
    
    /**
     * Gibt die nächste ThreadeeID aus
     * @return die nächste ThreadeeID
     */
    public int nextThreadeeID() {
        return threadeeID++;
    }
}
