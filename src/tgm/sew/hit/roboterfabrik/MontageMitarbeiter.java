package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;

/**
 * Stellt einen MontageMitarbeiter dar, welcher sich
 * um den Zusammenbau der Threadees kümmert
 * 
 * @author Dominik
 * @version 0.1
 */
public class MontageMitarbeiter implements Stoppable {
    
    private int id;
    private Fabrik fabrik;
    private boolean stop = false;
    
    private ArrayList<Integer> augeR;
    private ArrayList<Integer> augeL;
    private ArrayList<Integer> rumpf;
    private ArrayList<Integer> kettenAntrieb;
    private ArrayList<Integer> armR;
    private ArrayList<Integer> armL;
    
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
