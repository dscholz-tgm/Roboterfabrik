package tgm.sew.hit.roboterfabrik;

import java.io.File;

/**
 * Parsed die CommandLine, Hardgecoded weil ich CLI nicht mag
 * 
 * @author Dominik
 * @version 0.1
 */
public class CommandLineParser {
    
    private int lieferanten, monteure, laufzeit;
    private File lagerFolder, logFolder;
    
    /**
     * Konstruktor des CommandLineParsers
     * @param lieferanten die maximal mögliche Anzahl an Lieferanten
     * @param monteure die maximal mögliche Anzahl an Monteuren
     * @param laufzeit  die maximal mögliche Anzahl an Laufzeit
     */
    public CommandLineParser(int lieferanten, int monteure, int laufzeit) {
        this.lieferanten = lieferanten;
        this.monteure = monteure;
        this.laufzeit = laufzeit;
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
            if (aLieferanten > 0 && aLieferanten <= lieferanten &&
                    aMonteure > 0 && aMonteure <= monteure &&
                    aLaufzeit > 0 && aLaufzeit <= laufzeit) {
                
                lagerFolder = new File(args[1]);
                logFolder = new File(args[3]);
                
                if (lagerFolder.isDirectory() && logFolder.isDirectory()) return true;
            }
        }
        return false;
    }
}
