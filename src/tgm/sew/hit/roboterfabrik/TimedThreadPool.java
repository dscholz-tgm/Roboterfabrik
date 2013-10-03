package tgm.sew.hit.roboterfabrik;

import java.util.Queue;

/**
 * Kümmert sich um ein ThreadPool und beendet dieses nach einiger Zeit
 * (I don't like ThreadPoolExecutor deshalb programmier ich meinen eigenen :P)
 * @author Dominik
 * @version 0.1
 */
public class TimedThreadPool implements Stoppable{
    
    private Queue<Stoppable> queue;
    private int poolSize, livingTime;
    
    private boolean stop = false;
    
    /**
     * Erstellt das TimedThreadPool
     * @param poolSize wie groß das Pool sein soll
     * @param livingTime wie lange die Threads laufen sollen, bis sie beendet werden
     */
    public TimedThreadPool(Queue<Stoppable> queue, int poolSize, int livingTime) {    
        this.queue = queue;
        this.poolSize = poolSize;
        this.livingTime = livingTime;
    }
    
    /**
     * Gibt die Größe des Pools zurück
     * @return die Größe des Pools
     */
    public int getPoolSize() {
        return poolSize;
    }
    
    /**
     * Gibt die Zeit bis zum beenden der Pools zurück
     * @return die Zeit bis zum beenden des Pools
     */
    public int getLivingTime() {
        return livingTime;
    }
    
    /**
     * Gibt die queue der Stoppable threads zurück
     * @return die Queue
     */
    public Queue<Stoppable> queue() {
        return queue;
    }

    /**
     * Läuft bis zur living Time und beendet dann die Threads
     */
    @Override
    public void run() {
        for(Stoppable thread : queue) new Thread(thread).start();
        try {
            Thread.sleep(livingTime);
        } catch (InterruptedException ex) {
        }
        for(Stoppable thread : queue) thread.stop();
    }
    
    /**
     * Stop Methode aus dem Stoppable Interface
     * zum sauberen Beenden des Threads
     */
    @Override
    public void stop() {
        stop = true;
        Thread.currentThread().interrupt();
    }

    /**
     * isStopped Methode aus dem Stoppable Interface
     * @return ob dieser Thread gestopped ist
     */
    @Override
    public boolean isStopped() {
        return stop;
    }
    
}