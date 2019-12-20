
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

/**
 * Basandosi su un triangolo rettangolo con angoli 30 60 90 si occupa di
 * ridimensionarlo e di ridimensionare il poligono al suo interno. Il triangolo
 * ha sempre la dimensione del 50% della finestra.
 *
 * @author Matteo Arena
 */
public class TriangleModel {

    //=========================== VARIABILI PRIVATE ============================
    /**
     * Triangolo corrente dell'utente.
     */
    private Polygon userTriangle = new Polygon();

    /**
     * Lista contenente i punti del poligono personalizzato.
     */
    private List<Point> customPolygonDots = new ArrayList<>();
    //=========================== COSTANTI =====================================
    /**
     * Larghezza del triangolo.
     */
    public static final double TRIANGLE_WIDTH = 500;

    /**
     * Ipotenusa del triangolo.
     */
    public static final double TRIANGLE_IPO = TRIANGLE_WIDTH * 2;

    /**
     * Altezza del triangolo.
     */
    public static final double TRIANGLE_HEIGHT
            = Math.sqrt(
                    Math.pow(TRIANGLE_IPO, 2) - Math.pow(TRIANGLE_WIDTH, 2
            )
            );

    //=========================== COSTRUTTORI ==================================
    /**
     * Metodo costruttore.
     */
    public TriangleModel() {
    }

    //=========================== METODI PUBBLICI ==============================
    /**
     * Ritorna il triangolo ridimensionato in base alla grandezza della
     * finestra.
     *
     * @param windowWidth Larghezza della finestra.
     * @param windowHeight Altezza della finestra.
     *
     * @return Il Triangolo pronto da disegnare.
     */
    public Polygon getTriangle(int windowWidth, int windowHeight) {
        calculateTriangleFromWindowSize(windowWidth, windowHeight);
        return userTriangle;
    }

    /**
     * Aggiunge un punto al modello.
     *
     * @param dot Punto da aggiungere.
     * @param width Larghezza della finestra.
     * @param height Altezza della finestra.
     */
    public void addDotToCustomPolygon(Point dot, int width, int height) {
        customPolygonDots.add(getModelPoint(dot, width, height));
    }

    /**
     * Calcola e ritorna il poligono personalizzato.
     *
     * @param windowWidth Larghezza della finestra.
     * @param windowHeight Altezza della finestra.
     * @return Il poligono già pronto da disegnare.
     */
    public Polygon getCustomPolygon(int windowWidth, int windowHeight) {
        calculateTriangleFromWindowSize(windowWidth, windowHeight);
        int[] xCoordinates = new int[customPolygonDots.size()];
        int[] yCoordinates = new int[customPolygonDots.size()];
        for (int i = 0; i < customPolygonDots.size(); i++) {
            xCoordinates[i] = userTriangle.getBounds().x + (int) (customPolygonDots.get(i).getX() * userTriangle.getBounds().width / TRIANGLE_WIDTH);
            yCoordinates[i] = userTriangle.getBounds().y + (int) (customPolygonDots.get(i).getY() * userTriangle.getBounds().height / TRIANGLE_HEIGHT);
        }
        return new Polygon(xCoordinates, yCoordinates, customPolygonDots.size());
    }

    /**
     * Ritorna tutti i punti del poligono.
     *
     * @param width Larghezza della finestra.
     * @param height Altezza della finestra.
     * @return Lista di punti.
     */
    public List<Point> getCustomPolygonDots(int width, int height) {
        calculateTriangleFromWindowSize(width, height);
        Point resultDot = new Point();
        List<Point> result = new ArrayList<>();
        for (Point dot : customPolygonDots) {
            resultDot.x = userTriangle.getBounds().x + (int) (dot.getX() * userTriangle.getBounds().getWidth() / TRIANGLE_WIDTH);
            resultDot.y = userTriangle.getBounds().y + (int) (dot.getY() * userTriangle.getBounds().getHeight() / TRIANGLE_HEIGHT);
            result.add(resultDot);
            resultDot = new Point();
        }
        return result;
    }

    public List<Point> getModelDots() {
        return customPolygonDots;
    }

    /**
     * Rimuove il punto che si passa come parametro.
     *
     * @param dot Punto da rimuovere.
     * @param width Larghezza della finestra.
     * @param height Altezza della finestra.
     */
    public void removeDotFromPolygon(Point dot, int width, int height) {
        Point dotToRemove = getModelPoint(dot, width, height);
        customPolygonDots.remove(getInteressedPoint(dotToRemove));
    }

    /**
     * Dato un punto lo muove.
     *
     * @param dotToMove Punto da muovere.
     * @param newPosition Nuova posizione del punto.
     * @param width Larghezza della finestra.
     * @param height Altezza della finestra.
     */
    public void moveDot(Point dotToMove, Point newPosition, int width, int height) {
        dotToMove = getModelPoint(dotToMove, width, height);
        newPosition = getModelPoint(newPosition, width, height);

        int index = customPolygonDots.indexOf(getInteressedPoint(dotToMove));
        if (index >= 0) {
            customPolygonDots.set(
                    index,
                    newPosition
            );
        }
    }

    /**
     * Aggiunge un punto al modello, il punto non verrà scalato quindi fare
     * attenzione che sia giusto per il modello.
     *
     * @param dot Punto da aggiungere.
     */
    public void addDotToModelTriangle(Point dot) {
        customPolygonDots.add(dot);
    }
    //=========================== METODI PRIVATI ===============================

    /**
     * Ritorna il punto sul quale si è, se non esiste ritorna un punto 0,0.
     *
     * @param dotToCheck Il punto da controllare.
     * @return Il punto interessato o 0,0.
     */
    private Point getInteressedPoint(Point dotToCheck) {
        for (Point currentDot : customPolygonDots) {
            if (contains(currentDot, dotToCheck)) {
                return currentDot;
            }
        }
        return new Point(0, 0);
    }

    /**
     * Ritorna vero se un punto è dentro a un'altro.
     *
     * @param dot Punto originale.
     * @param dotToCheck Punto da controllare.
     * @return Vero se lo contiene, falso altrimenti.
     */
    private boolean contains(Point dot, Point dotToCheck) {
        if (dotToCheck.x > dot.x - 5
                && dotToCheck.x < dot.x + 5
                && dotToCheck.y > dot.y - 5
                && dotToCheck.y < dot.y + 5) {
            return true;
        }
        return false;
    }

    /**
     * Date le dimensioni della finestra ricalcola un punto in modo da adattarlo
     * al triangolo di modello.
     *
     * @param dot Punto da adattare.
     * @param width Larghezza della finestra.
     * @param height Altezza della finestra.
     * @return Il punto adattato.
     */
    private Point getModelPoint(Point dot, int width, int height) {
        calculateTriangleFromWindowSize(width, height);
        double x = dot.getX() - userTriangle.xpoints[0];
        double y = dot.getY() - userTriangle.ypoints[0];

        double finalX = x * TRIANGLE_WIDTH / userTriangle.getBounds().width;
        double finalY = y * TRIANGLE_HEIGHT / userTriangle.getBounds().height;

        return new Point((int) finalX, (int) finalY);
    }

    /**
     * Calcola il triangolo ridimensionato in base alla grandezza della
     * finestra.
     *
     * @param windowWidth Larghezza della finestra.
     * @param windowHeight Altezza della finestra.
     */
    private void calculateTriangleFromWindowSize(int windowWidth, int windowHeight) {
        double minimumWidthMargin = windowWidth * 1 / 3;
        double minimumHeightMargin = windowHeight * 1 / 4;
        double maximumWidth = windowWidth - minimumWidthMargin * 2.0;
        double maximumHeight = windowHeight - minimumHeightMargin * 2.0;

        double finalWidth = TRIANGLE_WIDTH * maximumHeight / TRIANGLE_HEIGHT;
        double finalHeight = maximumHeight;
        double startX = minimumWidthMargin;
        double startY = minimumHeightMargin;
        if (finalWidth > maximumWidth) {
            finalHeight = maximumWidth * TRIANGLE_HEIGHT / TRIANGLE_WIDTH;
            finalWidth = maximumWidth;
            startX = minimumWidthMargin + (maximumWidth - finalWidth) / 2.0;
        } else {
            startY = minimumHeightMargin + (maximumHeight - finalHeight) / 2.0;
        }

        int[] xCoordinates = new int[3];
        int[] yCoordinates = new int[3];
        xCoordinates[0] = (int) startX;
        xCoordinates[1] = xCoordinates[0] + (int) finalWidth;
        xCoordinates[2] = xCoordinates[1];
        yCoordinates[0] = (int) startY;
        yCoordinates[1] = yCoordinates[0];
        yCoordinates[2] = yCoordinates[0] + (int) finalHeight;

        userTriangle = new Polygon(xCoordinates, yCoordinates, 3);
    }
}
