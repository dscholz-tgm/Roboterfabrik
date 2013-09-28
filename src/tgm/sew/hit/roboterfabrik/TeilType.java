package tgm.sew.hit.roboterfabrik;

/**
 * Enums für die unterschiedlichen 
 * Bestandteile des Threadees
 * 
 * @author Dominik
 * @version 0.2
 */
public enum TeilType {
    AUGE,
    RUMPF,
    KETTENANTRIEB,
    ARM;
    
    /**
     * Gibt den Dateiname zum dazugehörigen TeilType zurück
     * @return der Dateiname zum TeilType
     */
    public String filename() {
        return this.toString().toLowerCase();
    }
}
