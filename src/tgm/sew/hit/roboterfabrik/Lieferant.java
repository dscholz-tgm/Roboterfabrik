package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generiert zufällige Teile und liefert sie der Fabrik
 * 
 * @author Dominik
 * @version 0.3
 */
public class Lieferant implements Stoppable {
    
    private static final int LIST_SIZE = 20;
    private static final int MAX_NUMBER = 100;
    
    private Fabrik fabrik;
    private int speed;
    private boolean stop = false;
    
    private int teilIntervall;
    private Random rand;
    private TeilType type;
    
    /**
     * Konstruktor des Lieferanten
     * @param fabrik die Referenz auf die Fabrik,
     * welcher der Mitarbeiter zugeordnet ist
     * @param speed in welcher Geschwindigkeit die Threadees gebaut werden
     * @param teilIntervall nach welchem Zeitintervakll die Art der gelieferten Teile wechseln
     */
    public Lieferant (Fabrik fabrik, int speed, int teilIntervall) {
        this.fabrik = fabrik;
        this.speed = speed;
        this.teilIntervall = teilIntervall;
        rand = new Random(System.currentTimeMillis());
    }
    
    /**
     * Run Methode von Runnable
     */
    @Override
    public void run() {
        int intervallCounter = teilIntervall;
        while(!stop) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
            }
            intervallCounter-=speed;
            if(intervallCounter <= 0) {
                intervallCounter = teilIntervall;
                randomTeil();
            }
            fabrik.lieferTeil(type,randomIntList());
        }
    }
    
    /**
     * Sucht einen Zufälligen Teil aus
     */
    public void randomTeil() {
        type = TeilType.values()[rand.nextInt(TeilType.values().length)];
    }
    
    /**
     * Generiert Eine Liste mit LIST_SIZE zufälligen Integer Werten
     * @return eine Liste mit LIST_SIZE (pseudo)zufälligen Integer Werten
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
