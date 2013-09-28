package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

/**
 * Stellt einen Threadee dar
 * 
 * @author Dominik
 * @version 0.2
 */
public class Threadee {
    
    private List<Teil> teilListe = new ArrayList<>();
    private List<TeilType> fehlendeTeile = new ArrayList<>();
    private int id;
    
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
     * Überprüft welche Teile dem Threadee noch fehlen
     * @return Eine Liste von Teilen die dem Threadee noch fehlen
     */
    public List<TeilType> fehlendeTeile() {
        return fehlendeTeile;
    }
}
