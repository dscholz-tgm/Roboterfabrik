package tgm.sew.hit.roboterfabrik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Stellt einen Lager Mitarbeiter dar,
 * welcher sich um die Lagerung der Teile kümmert
 * 
 * @author Dominik
 * @version 0.1
 */
public class LagerMitarbeiter {
    
    private File lagerFolder;
    private Map<TeilType,File> teilFiles = new HashMap<>();
    private File threadeeFile;
    
    private static final Logger logger = Logger.getLogger("Fabriklog");

    
    /**
     * Konstrutor des LagerMitarbeiters
     */
    public LagerMitarbeiter(File lagerFolder) {
        this.lagerFolder = lagerFolder;
        for (TeilType tt : TeilType.values()) {
            teilFiles.put(tt, new File(lagerFolder.getPath() + File.separator + tt.filename() + ".csv"));
        }
        threadeeFile = new File(lagerFolder.getPath() + File.separator + "threadee.csv");
        logger.log(Level.INFO, "Datein geladen");
    }
    
    /**
     * Lagert ein Teil ein
     * @param teil das Teil, welches gelagert werden soll
     */
    public void lagerTeil(Teil teil) {
        Writer w;
        try {
            w = new FileWriter(teilFiles.get(teil.getType()).getPath());
            StringBuilder sb = new StringBuilder(teil.getType().casename());
            for (int i : teil.getZahlenList()) sb.append(",").append(i);
            w.write(System.lineSeparator() + sb.toString());
        } catch (IOException ex) {
            /**
             * IO Fehler Loggen!
             * logger.log(Level.INFO, "ERROR: Daten konnten nicht gespeichert werden", ex);
             */
        }
    }
    
    /**
     * Liest ein Teil ein
     * @param teilType welche Art von Teil geladen werden soll
     * @return ein Teil des entsprechenden TeilTypes aus dem Lager
     */
    public Teil leseTeil(TeilType teilType) {
        File f = teilFiles.get(teilType);
        List<Integer> li = new ArrayList<>();
        return new Teil(teilType,li);
    }
    
}
