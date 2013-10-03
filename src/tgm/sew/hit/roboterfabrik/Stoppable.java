package tgm.sew.hit.roboterfabrik;

/**
 * Ein einfaches Stoppable Interface, welches 
 * das saubere Beenden der Threads gewährleistet
 * 
 * @author Dominik
 * @version 0.2
 */
public interface Stoppable extends Runnable{
    public void stop();
    public boolean isStopped();
}
