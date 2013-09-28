package tgm.sew.hit.roboterfabrik;

/**
 * Stellt einen MontageMitarbeiter dar, welcher sich
 * um den Zusammenbau der Threadees kümmert
 * 
 * @author Dominik
 * @version 0.2
 */
public class MontageMitarbeiter implements Stoppable {
    
    private int id;
    private Fabrik fabrik;
    private boolean stop = false;
    
    private Threadee threadee;
    
    /**
     * Konstruktor des MontageMitarbeiters
     * @param id die ID des MontageMitarbeiters
     * @param fabrik die Referenz auf die Fabrik,
     * welcher der Mitarbeiter zugeordnet ist
     */
    public MontageMitarbeiter(int id, Fabrik fabrik) {
        this.id = id;
        this.fabrik = fabrik;
    }

    @Override
    public void run() {
        while(!stop) {
            //Baue Threadees Zusammen
        }
    }

    /**
     * Stop Methode aus dem Stoppable Interface
     * zum sauberen Beenden des Threads
     */
    @Override
    public void stop() {
        stop = true;
    }
    
}
