package tgm.sew.hit.roboterfabrik;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Erstellt die Threads und stellt die Verbindung zwischen ihnen dar
 * 
 * @author Dominik
 * @version 0.4
 */
public class Fabrik {
    
    private int montageMitarbeiterPoolSize;
    private int lieferantenPoolSize;
    private int time;
    private Sekretariat sekretariat;
    private LagerMitarbeiter lagerMitarbeiter;
    
    private static final Logger logger = Logger.getLogger("Fabriklog");
    
    /**
     * Erstellt die Fabrik
     * 
     * @param montageMitarbeiterPoolSize Wie viele Montage Mitarbeiter erstellt werden sollen
     * @param lieferantenPoolSize Wie viele Lieferanten erstellt werden sollen
     * @param time Wie lange das Programm laufen soll
     */
    public Fabrik(int montageMitarbeiterPoolSize, int lieferantenPoolSize, int time) {
        logger.log(Level.INFO, "booting Fabrik");
        this.montageMitarbeiterPoolSize = montageMitarbeiterPoolSize;
        this.lieferantenPoolSize = lieferantenPoolSize;
        this.time = time;
        sekretariat = new Sekretariat();
    }
    
    /**
     * Gibt das Sekretariat zurück
     * @return das Sekretariat
     */
    public Sekretariat getSekretariat() {
        return sekretariat;
    }

    /**
     * Gibt ein Teil, welches in der fehlendenTeile Liste enthalten ist zurück
     * @param fehlendeTeile eine Liste von TeilTypen von denen ein Teil zurückgegeben werden soll
     * @return einer der benötigten Teile
     */
    public Teil getTeil(List<TeilType> fehlendeTeile) {
        //Mit Lager Mitarbeiter Teil suchen
        
        return new Teil(TeilType.ARM,Arrays.asList(1,2,3));
    }

    /**
     * Bekommt ein Teil geliefert, welches in das richige File gespeichert wird
     * @param randomTeil
     * @param randomIntList 
     */
    public void lieferTeil(TeilType randomTeil, List<Integer> randomIntList) {
        
    }

    /**
     * Lagert einen Threadee
     * @param threadee 
     */
    public void lagerThreadee(Threadee threadee) {
        lagerMitarbeiter.lagerThreadee(threadee);
    }
    
}