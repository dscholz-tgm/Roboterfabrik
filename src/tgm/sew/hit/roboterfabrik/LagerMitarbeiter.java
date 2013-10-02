package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

/**
 * Stellt einen Lager Mitarbeiter dar,
 * welcher sich um die Lagerung der Teile kümmert
 * 
 * @author Dominik
 * @version 0.1
 */
public class LagerMitarbeiter {
    
    /**
     * Konstrutor des LagerMitarbeiters
     */
    public LagerMitarbeiter() {
        
    }
    
    /**
     * Liest ein Teil ein
     * @param teilType welche Art von Teil geladen werden soll
     * @return ein Teil des entsprechenden TeilTypes aus dem Lager
     */
    public Teil leseTeil(TeilType teilType) {
        List<Integer> li = new ArrayList<>();
        return new Teil(teilType,li);
    }
    
}
