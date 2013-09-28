package tgm.sew.hit.roboterfabrik;

/**
 * Enums für die unterschiedlichen 
 * Bestandteile des Threadees
 * 
 * @author Dominik
 * @version 0.1
 */
public enum TeilTyp {
    AUGE,
    RUMPF,
    KETTENANTRIEB,
    ARM;
    
    /**
     * Gibt den Dateiname zum dazugehörigen TeilTyp zurück
     * @return der Dateiname zum TeilTyp
     */
    public String filename() {
        return this.toString().toLowerCase();
    }
}
