package tgm.sew.hit.roboterfabrik;

/**
 * Stellt einen MontageMitarbeiter dar, welcher sich
 * um den Zusammenbau der Threadees kümmert
 * 
 * @author Dominik
 * @version 0.3
 */
public class MontageMitarbeiter implements Stoppable {
    
    private int id;
    private Fabrik fabrik;
    private int time;
    private boolean stop = false;
    
    private Threadee threadee;
    
    /**
     * Konstruktor des MontageMitarbeiters
     * @param id die ID des MontageMitarbeiters
     * @param fabrik die Referenz auf die Fabrik,
     * welcher der Mitarbeiter zugeordnet ist
     * @param speed in welcher Geschwindigkeit die Threadees gebaut werden
     */
    public MontageMitarbeiter(int id, Fabrik fabrik, int speed) {
        this.id = id;
        this.fabrik = fabrik;
    }

    @Override
    public void run() {
        while(!stop) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
            }
            threadee = new Threadee(fabrik.getSekretariat().nextThreadeeID());
            while (threadee.addTeil(fabrik.getTeil(threadee.fehlendeTeile())));
            //Threadee speichern
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
