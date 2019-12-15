
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Gestisce il triangleModel.
 *
 * @author Matteo Arena
 */
public class TrianglePanel extends JPanel implements MouseListener, MouseMotionListener {

    //========================== VARIABILI PRIVATE =============================
    /**
     * Punto sul quale si trova il mouse, se non c'è è -1.
     */
    private int dotInteressed = -1;
    /**
     * Lista di listener.
     */
    private List<TrianglePanelListener> listeners = new ArrayList<>();
    /**
     * Posizione attuale del mouse.
     */
    private Point mousePosition;
    /**
     * Vero quando bisogna visualizzare la preview.
     */
    private boolean seePreview = false;
    /**
     * Nome del triangolo.
     */
    private String triangleName = "Triangolo senza nome";
    /**
     * Modello del triangolo.
     */
    private TriangleModel triangleModel = new TriangleModel();

    /**
     * Triangolo da disegnare.
     */
    private Polygon triangle;

    /**
     * Area di taglio.
     */
    private Polygon cuttedArea;

    /**
     * Vero quando è selezionata l'opzione add.
     */
    private boolean addPoint = true;

    /**
     * Lista dei punti da disegnare.
     */
    private List<Point> dots;
    //========================== COSTANTI ======================================
    /**
     * Raggio di un punto.
     */
    public static final int POINT_RADIUS = 7;

    //========================== COSTRUTTORI ===================================
    public TrianglePanel() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    //========================== METODI PUBBLICI ===============================
    /**
     * Aggiunge un listener alla lista di listener registrati.
     */
    public void addTrianglePanelListener(TrianglePanelListener listener) {
        listeners.add(listener);
    }

    /**
     * Rimuove un listener dalla lista di listener registrati.
     */
    public void removeTrianglePanelListener(TrianglePanelListener listener) {
        listeners.remove(listener);
    }

    /**
     * Permette di impostare l'opzione di aggiunta dei punti.
     */
    public void setAddOption() {
        addPoint = true;
    }

    /**
     * Permette di impostare l'opzione di rimozione dei punti.
     */
    public void setCutOption() {
        addPoint = false;
    }

    /**
     * Permette di avere il nome del triangolo.
     *
     * @return Il nome del triangolo.
     */
    public String getTriangleName() {
        return triangleName;
    }

    /**
     * Resetta i punti del triangolo.
     */
    public void resetTriangle() {
        triangleModel = new TriangleModel();
        repaint();
    }

    /**
     * Elimina l'ultimo punto.
     */
    public void cutLastPoint() {
        if (dots.size() > 0) {
            int last = dots.size() - 1;
            triangleModel.removeDotFromPolygon(dots.get(last), this.getWidth(), this.getHeight());
            repaint();
        }

    }

    /**
     * Permette di visualizzare la preview dell'area di taglio.
     */
    public void seePreview() {
        seePreview = true;
        repaint();
    }

    /**
     * Disabilità la preview.
     */
    public void disablePreview() {
        seePreview = false;
        repaint();
    }

    /**
     * Permette di ricavare il triangolo utilizzato.
     *
     * @return il triangolo di modello.
     */
    public TriangleModel getTriangleModel() {
        return triangleModel;
    }
    //========================== METODI PRIVATI ================================

    /**
     * Aggiorna tutti i valori.
     */
    private void updateArea() {
        triangle = triangleModel.getTriangle(this.getWidth(), this.getHeight());
        cuttedArea = triangleModel.getCustomPolygon(this.getWidth(), this.getHeight());
        dots = triangleModel.getCustomPolygonDots(this.getWidth(), this.getHeight());
    }

    /**
     * Dice se un punto esiste nella lista di punti già presenti.
     *
     * @param position Punto da controllare.
     * @return Punto esistente, altrimenti 0,0.
     */
    private Point getPointInteressed(Point position) {
        Point res = new Point(0, 0);
        for (Point dot : dots) {
            if (dot.distance(position) <= POINT_RADIUS * 2) {
                return dot;
            }
        }
        return res;
    }

    private void addedAPoint() {
        for (TrianglePanelListener listener : listeners) {
            listener.modifiedTriangle();
        }
    }

    //========================== OVERRIDE ======================================
    /**
     * Disegna sul Panel.
     *
     * @param g Contesto grafico.
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        updateArea();
        g.setColor(Color.cyan);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.white);
        g.fillPolygon(triangle);
        if (!seePreview) {
            g.setColor(Color.black);
            g.drawPolygon(cuttedArea);
            for (int i = 0; i < dots.size(); i++) {
                g.setColor(Color.red);
                if (i == dotInteressed) {
                    g.setColor(Color.magenta);
                }
                g.fillOval(
                        dots.get(i).x - POINT_RADIUS,
                        dots.get(i).y - POINT_RADIUS,
                        POINT_RADIUS * 2,
                        POINT_RADIUS * 2
                );
            }
        } else {
            g.setColor(Color.cyan);
            g.fillPolygon(cuttedArea);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (addPoint) {
            Point p = e.getPoint();
            triangleModel.addDotToCustomPolygon(p, this.getWidth(), this.getHeight());
            dotInteressed = dots.size();
            repaint();
            addedAPoint();
        } else {
            Point p = getPointInteressed(e.getPoint());
            if (p.x != 0 && p.y != 0) {
                triangleModel.removeDotFromPolygon(p, this.getWidth(), this.getHeight());
                repaint();
                addedAPoint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = getPointInteressed(e.getPoint());
        if (p.x != 0 && p.y != 0) {
            triangleModel.moveDot(p, e.getPoint(), this.getWidth(), this.getHeight());
            repaint();
            addedAPoint();
        }
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        dotInteressed = dots.indexOf(getPointInteressed(e.getPoint()));
        mousePosition = e.getPoint();
        String text = "x: " + mousePosition.x + ", y: " + mousePosition.y;
        for (TrianglePanelListener listener : listeners) {
            listener.mouseMoved(text);
        }
    }
}
