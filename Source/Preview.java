
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.io.Writer;
import javax.swing.JPanel;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2DIOException;

import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

/**
 * Visualizza la preview del triangolo o del fiocco nella schermata di
 * salvataggio.
 *
 * @author Matteo Arena
 */
public class Preview extends JPanel {

    //========================== VARIABILI PRIVATE =============================
    /**
     * Modello del triangolo.
     */
    private TriangleModel triangleModel;

    /**
     * Polygono contenente il triangolo.
     */
    private Polygon triangle;

    /**
     * Poligono dell'area da ritagliare.
     */
    private Polygon cuttedArea;

    /**
     * Vero se si deve visualizzare il fiocco.
     */
    private boolean seeSnowFlake = false;

    /**
     * Area con il triangolo e l'area sottratta.
     */
    private Area finalArea;

    /**
     * Fiocco di neve.
     */
    private Shape snowFlake;

    /**
     * Directory dove salvare il file.
     */
    private String saveDirectory;

    /**
     * Nome del fiocco.
     */
    private String snowName;

    //========================== COSTRUTTORI ===================================
    /**
     * Costruttore vuoto.
     */
    public Preview() {

    }
    //========================== METODI PUBBLICI ===============================

    /**
     * Imposta il modello del triangolo.
     *
     * @param triangleModel Il triangolo del modello.
     */
    public void setTriangle(TriangleModel triangleModel) {
        this.triangleModel = triangleModel;
        repaint();
    }

    /**
     * Permette di isulizzare il fiocco di neve
     */
    public void seeSnowFlake() {
        seeSnowFlake = true;
    }

    /**
     * Dice se ci si trova nella pagina di salvataggio del fiocco di neve.
     *
     * @return Vero se ci si trova nella pagina di salvataggio, altrimenti
     * false.
     */
    public boolean isSavePage() {
        return seeSnowFlake;
    }

    /**
     * Comando che dice di salvare il fiocco di neve.
     *
     * @param directory Directory dove salvare il fiocco.
     * @param name Nome che si vuole dare al file.
     * @param svg Vero se si vuole salvare in formato svg, altrimenti false.
     */
    public void save(String directory, String name, boolean svg) {
        this.saveDirectory = directory;
        this.snowName = name;
        if (svg) {
            // Get a DOMImplementation.
            DOMImplementation domImpl
                    = GenericDOMImplementation.getDOMImplementation();

            // Create an instance of org.w3c.dom.Document.
            String svgNS = "http://www.w3.org/2000/svg";
            Document document = domImpl.createDocument(svgNS, "svg", null);

            // Create an instance of the SVG Generator.
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

            // Ask the test to render into the SVG Graphics2D implementation.
            this.paint(svgGenerator);

            // Finally, stream out SVG to the standard output using
            // UTF-8 encoding.
            boolean useCSS = true; // we want to use CSS style attributes
            Writer out;
            try {
                svgGenerator.stream(saveDirectory);
            } catch (SVGGraphics2DIOException e) {
                System.out.println("errore");
            }
        } else {
            //Coming soon...
        }
    }

    //========================== METODI PRIVATI ================================
    private Shape rotateArea(int angle, Shape shape) {
        AffineTransform af = new AffineTransform();
        af.rotate(Math.toRadians(angle), triangle.xpoints[2], triangle.ypoints[2]);
        return af.createTransformedShape(shape);
    }

    /**
     * Permette di avere l'area specchiata.
     *
     * @return Il triangolo specchiato.
     */
    private Shape getFlippedArea(Area area) {
        AffineTransform first = new AffineTransform();
        first.scale(-1, 1);
        AffineTransform toCenter = new AffineTransform();
        toCenter.translate(-(triangle.xpoints[1]) * 2, 0);
        AffineTransform tot = new AffineTransform();
        tot.concatenate(first);
        tot.concatenate(toCenter);
        return tot.createTransformedShape(area);
    }

    /**
     * Aggiorna i dati.
     */
    private void updateData() {
        if (seeSnowFlake) {
            triangle = triangleModel.getTriangle(400, 400);
            cuttedArea = triangleModel.getCustomPolygon(400, 400);
            finalArea = new Area(triangle);
            finalArea.subtract(new Area(cuttedArea));
        } else {
            triangle = triangleModel.getTriangle(this.getWidth(), this.getHeight());
            cuttedArea = triangleModel.getCustomPolygon(this.getWidth(), this.getHeight());
        }

    }

    //========================== OVERRIDE ======================================
    /**
     * Disegna sul panel.
     *
     * @param g Contesto grafico.
     */
    @Override
    public void paint(Graphics g) {
        updateData();
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.cyan);
        if (!seeSnowFlake) {
            g.fillPolygon(triangle);
            g.setColor(Color.white);
            g.fillPolygon(cuttedArea);
        } else {
            Graphics2D g2 = (Graphics2D) g;
            g2.fill(finalArea);
            for (int i = 0; i < 6; i++) {
                g2.fill(rotateArea((i - 1) * 60, getFlippedArea(finalArea)));
                g2.fill(rotateArea(i * 60, finalArea));
            }
        }

    }
}
