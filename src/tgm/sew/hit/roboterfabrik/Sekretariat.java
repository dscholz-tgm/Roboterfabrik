package tgm.sew.hit.roboterfabrik;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Stellt das Sekretariat dar, welches eindeutige ID's 
 * für die Threadees und Mitarbeiter bereitstellt
 * 
 * @author Dominik
 * @version 0.3
 */
public class Sekretariat {
    
    private int mitarbeiterID;
    private int threadeeID;
    
    private static final Logger logger = Logger.getLogger("Fabriklog");
    
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
    public synchronized int nextMitarbeiterID() {
        logger.log(Level.INFO, "Mitarbeiter ID " + mitarbeiterID + " vergeben");
        return mitarbeiterID++;
    }
    
    /**
     * Gibt die nächste ThreadeeID aus
     * @return die nächste ThreadeeID
     */
    public synchronized int nextThreadeeID() {
        logger.log(Level.INFO, "Threadee ID " + threadeeID + " vergeben");
        return threadeeID++;
    }
}
