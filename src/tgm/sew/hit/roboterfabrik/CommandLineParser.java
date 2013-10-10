package tgm.sew.hit.roboterfabrik;

import java.io.File;

/**
 * Parsed die CommandLine, Hardgecoded weil ich CLI nicht mag
 * 
 * @author Dominik
 * @version 0.6
 */
public class CommandLineParser {
    
    private int maxLieferanten, maxMonteure, maxLaufzeit;
    private int lieferanten, monteure, laufzeit;
    private File lagerFolder, logFolder;
    
    /**
     * Konstruktor des CommandLineParsers
     * @param maxLieferanten die maximal mögliche Anzahl an Lieferanten
     * @param maxMonteure die maximal mögliche Anzahl an Monteuren
     * @param maxLaufzeit  die maximal mögliche Anzahl an Laufzeit
     */
    public CommandLineParser(int maxLieferanten, int maxMonteure, int maxLaufzeit) {
        this.maxLieferanten = maxLieferanten;
        this.maxMonteure = maxMonteure;
        this.maxLaufzeit = maxLaufzeit;
    }
    
    /**
     * Parsed ein Argument Array
     * @param args Das Array aller Argumente
     * @return ob die Eingabe valid ist
     */
    public boolean parse(String[] args) {
        
        if (args.length >= 10 &&
                args[0].equals("--lager") &&
                args[2].equals("--logs") &&
                args[4].equals("--lieferanten") &&
                args[6].equals("--monteure") &&
                args[8].equals("--laufzeit")) {
            
            int aLieferanten = 0;
            int aMonteure = 0;
            int aLaufzeit = 0;
            
            try {
                aLieferanten = Integer.parseInt(args[5]);
                aMonteure = Integer.parseInt(args[7]);
                aLaufzeit = Integer.parseInt(args[9]);
            } catch (Exception ex) {
            }
            if (aLieferanten > 0 && aLieferanten <= maxLieferanten &&
                    aMonteure > 0 && aMonteure <= maxMonteure &&
                    aLaufzeit > 0 && aLaufzeit <= maxLaufzeit) {
                
                lieferanten = aLieferanten;
                monteure = aMonteure;
                laufzeit = aLaufzeit;
                
                lagerFolder = new File(args[1]);
                logFolder = new File(args[3]);
                
                //if (lagerFolder.isDirectory() && logFolder.isDirectory()) return true;
                lagerFolder.mkdirs();
                logFolder.mkdirs();
                return true;
            }
        }
        System.out.println("Fehler bei der Eingabe des Commands, Synopsis:");
        System.out.println("--lager (verzeichnis) "
                + "--logs (verzeichnis) "
                + "--lieferanten [0-" + maxLieferanten + "] "
                + "--monteure [0-" + maxMonteure + "] "
                + "--laufzeit [0-" + maxLaufzeit + "] ");
        return false;
    }
    
    /**
     * Gibt den Ordner zurück, indem das Lager gespeichert ist
     * @return der Ordner, indem das Lager gespeichert ist
     */
    public File lagerFolder() {
        return lagerFolder;
    }
    
    /**
     * Gibt den Ordner zurück, indem der Log gespeichert ist
     * @return der Ordner, indem der Log gespeichert ist
     */
    public File logFolder() {
        return logFolder;
    }
    
    /**
     * Gibt die angegebenen Lieferanten zurück
     * @return die Anzahl der Lieferanten
     */
    public int getLieferanten() {
        return lieferanten;
    }
    
    /**
     * Gibt die angegebenen Monteure zurück
     * @return die Anzahl der Monteure
     */
    public int getMonteure() {
        return monteure;
    }
    
    /**
     * Gibt die angegebene Laufzeit zurück
     * @return die Laufzeit
     */
    public int getLaufzeit() {
        return laufzeit;
    }
    
}