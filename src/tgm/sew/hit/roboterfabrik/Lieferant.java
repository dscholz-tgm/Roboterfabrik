package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generiert zufällige Teile und liefert sie der Fabrik
 * 
 * @author Dominik
 * @version 0.2
 */
public class Lieferant implements Stoppable {
    
    private static final int LIST_SIZE = 20;
    private static final int MAX_NUMBER = 100;
    
    private Fabrik fabrik;
    private int speed;
    private boolean stop = false;
    
    private Random rand;
    
    /**
     * Konstruktor des Lieferanten
     * @param fabrik die Referenz auf die Fabrik,
     * welcher der Mitarbeiter zugeordnet ist
     * @param speed in welcher Geschwindigkeit die Threadees gebaut werden
     */
    public Lieferant (Fabrik fabrik, int speed) {
        this.fabrik = fabrik;
        this.speed = speed;
        rand = new Random(System.currentTimeMillis());
    }
    
    /**
     * Run Methode von Runnable
     */
    @Override
    public void run() {
        while(!stop) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
            }
            fabrik.lieferTeil(randomTeil(),randomIntList());
        }
    }
    
    /**
     * Sucht einen Zufälligen Teil aus
     * @return einen zufäligen TeilType
     */
    public TeilType randomTeil() {
        return TeilType.values()[rand.nextInt(TeilType.values().length)];
    }
    
    /**
     * Generiert Eine Liste mit 20 zufälligen Integer Werten
     * @return eine Liste mit 20 (pseudo)zufälligen Integer Werten
     */
    public List<Integer> randomIntList() {
        List<Integer> ar = new ArrayList<Integer>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) ar.add(rand.nextInt(MAX_NUMBER)+1);
        return ar;
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
