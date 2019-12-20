
/**
 * Listener della classe TrianglePanel
 *
 * @author Matteo Arena
 */
public interface TrianglePanelListener {

    /**
     * Metodo che viene invocato quando il mouse cambia posizione sul Panel.
     * 
     * @param position Posizione del mouse già formattata.
     */
    public void mouseMoved(String position);

    /**
     * Metodo che viene invocato quando il triangolo viene modificato.
     */
    public void modifiedTriangle();
}
