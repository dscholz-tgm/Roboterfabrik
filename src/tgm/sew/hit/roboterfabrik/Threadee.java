package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

/**
 * Stellt einen Threadee dar
 * 
 * @author Dominik
 * @version 0.1
 */
public class Threadee {
    
    private List<Teil> teilliste = new ArrayList<>();
    private int id;
    
    /**
     * Threadee Konstruktor
     * @param id die ID des Threadees
     */
    public Threadee(int id) {
        this.id = id;
    }
    
    /**
     * Fügt ein Teil hinzu
     * @return das Teil welches hinzugefügt wurde
     * @exception wenn das Teil schon oft genug im Threadee eingebaut ist
     */
    public Teil addTeil(Teil teil) throws HatGenugTeileException {
        TeilType tt = teil.getType();
        int amount = tt.getAmount();
        for (Teil t : teilliste) if (t.getType() == tt) amount--;
        if (amount < 1) throw new HatGenugTeileException();
        teilliste.add(teil);
        return teil;
    }
    
    /**
     * Überprüft welche Teile dem Threadee noch fehlen
     * @return Eine Liste von Teilen die dem Threadee noch fehlen
     */
    public List<TeilType> fehlendeTeile() {
        List<TeilType> tl = new ArrayList<>();
        int amount;
        for(TeilType tt : TeilType.values()) {
            amount = tt.getAmount();
            for (Teil t : teilliste) if (t.getType() == tt) amount--;
            if (amount > 0) for (int i = 0; i < amount; i++) tl.add(tt);
        }
        return tl;
    }
}
