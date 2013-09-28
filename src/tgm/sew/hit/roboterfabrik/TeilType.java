package tgm.sew.hit.roboterfabrik;

/**
 * Enums für die unterschiedlichen 
 * Bestandteile des Threadees
 * 
 * @author Dominik
 * @version 0.3
 */
public enum TeilType {
    AUGE(2),
    RUMPF(1),
    KETTENANTRIEB(1),
    ARM(2);
    
    private int amount;
    
    /**
     * Erstellt den TeilType
     * @param amount Wie oft das Teil in einem Threadee vorkommt
     */
    private TeilType(int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        return amount;
    }
    
    /**
     * Gibt den Dateiname zum dazugehörigen TeilType zurück
     * @return der Dateiname zum TeilType
     */
    public String filename() {
        return this.toString().toLowerCase();
    }
}
