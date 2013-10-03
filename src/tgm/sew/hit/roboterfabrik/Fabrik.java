package tgm.sew.hit.roboterfabrik;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Erstellt die Threads und stellt die Verbindung zwischen ihnen dar
 * 
 * @author Dominik
 * @version 0.7
 */
public class Fabrik {
    
    private TimedThreadPool mitarbeiterPool;
    private TimedThreadPool lieferantenPool;
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
     * @param lager Das File als repräsentation des Lagers
     */
    public Fabrik(int montageMitarbeiterPoolSize, int lieferantenPoolSize, int time, File lager) {
        logger.log(Level.INFO, "booting Fabrik");
        this.time = time;
        sekretariat = new Sekretariat();
        lagerMitarbeiter = new LagerMitarbeiter(lager);
        
        Queue<Stoppable> montageMitarbeiter = new LinkedList<>();
        for (int i = 0; i < montageMitarbeiterPoolSize; i++)
            montageMitarbeiter.add(new MontageMitarbeiter(sekretariat.nextMitarbeiterID(),this,1000));
        Queue<Stoppable> lieferanten = new LinkedList<>();
        for (int i = 0; i < lieferantenPoolSize; i++)
            lieferanten.add(new Lieferant(this,4*1000,1*1000));
        
        mitarbeiterPool = new TimedThreadPool(montageMitarbeiter,montageMitarbeiterPoolSize,time);
        lieferantenPool = new TimedThreadPool(lieferanten,lieferantenPoolSize,time);
        
        startPools();
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
    public Teil getTeil(List<TeilType> fehlendeTeile) throws TeilNichtImLagerException {
        int i = 0;
        Teil t = lagerMitarbeiter.leseTeil(fehlendeTeile.get(i));
        while (t == null && i < fehlendeTeile.size()) {
            t = lagerMitarbeiter.leseTeil(fehlendeTeile.get(i));
            i++;
        }
        if (t == null) throw new TeilNichtImLagerException();
        return t;
    }

    /**
     * Bekommt ein Teil geliefert, welches in das richige File gespeichert wird
     * @param Teil das Teil Welches eingelagert werden soll
     */
    public void lieferTeil(Teil teil) {
        lagerMitarbeiter.lagerTeil(teil);
    }

    /**
     * Lagert einen Threadee
     * @param threadee 
     */
    public void lagerThreadee(Threadee threadee) {
        lagerMitarbeiter.lagerThreadee(threadee);
    }

    /**
     * Startet die Pools
     */
    private void startPools() {
        new Thread(mitarbeiterPool).start();
        new Thread(lieferantenPool).start();
    }
    
}