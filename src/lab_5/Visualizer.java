package lab_5;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Visualizer {

    /**
     * Pokazuje w oknie listę figur z opisem w tytule.
     */
    public static void show(String title, List<Figur> figs) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(new DrawPanel(figs));
            frame.setSize(400, 400);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });
    }

    private static class DrawPanel extends JPanel {
        private final List<Figur> figs;
        private final double scale = 40;    // pikseli na jedną jednostkę

        DrawPanel(List<Figur> figs) {
            this.figs = new ArrayList<>(figs);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            // antyaliasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth(), h = getHeight();
            // punkt (0,0) przerzucamy na środek panelu
            double cx = w/2.0, cy = h/2.0;

            // narysuj osie
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawLine(0, (int)cy, w, (int)cy); // oś X
            g2.drawLine((int)cx, 0, (int)cx, h); // oś Y

            // każdą figurę w innej kolorystyce
            Color[] palette = { Color.RED, Color.BLUE, Color.GREEN.darker(), Color.MAGENTA };
            int idx = 0;
            for (Figur f : figs) {
                g2.setColor(palette[idx % palette.length]);
                drawFig(g2, f, cx, cy);
                idx++;
            }
        }

        private void drawFig(Graphics2D g2, Figur f, double cx, double cy) {
            if (f instanceof Point p) {
                drawPoint(g2, p, cx, cy);
            } else if (f instanceof Line l) {
                drawLine(g2, l, cx, cy);
            } else if (f instanceof Polygon poly) {
                drawPolygon(g2, poly, cx, cy);
            } else if (f instanceof Group g) {
                for (Figur sub : g.getFigures()) {
                    drawFig(g2, sub, cx, cy);
                }
            }
        }

        private void drawPoint(Graphics2D g2, Point p, double cx, double cy) {
            int x = (int)(cx + p.getX()*scale);
            int y = (int)(cy - p.getY()*scale);
            int r = 5;
            g2.fillOval(x-r, y-r, r*2, r*2);
        }

        private void drawLine(Graphics2D g2, Line l, double cx, double cy) {
            Point a = l.getStart(), b = l.getEnd();
            int x1 = (int)(cx + a.getX()*scale);
            int y1 = (int)(cy - a.getY()*scale);
            int x2 = (int)(cx + b.getX()*scale);
            int y2 = (int)(cy - b.getY()*scale);
            g2.drawLine(x1,y1,x2,y2);
        }

        private void drawPolygon(Graphics2D g2, Polygon poly, double cx, double cy) {
            java.util.List<Point> verts = poly.getVertices();
            int n = verts.size();
            int[] xs = new int[n], ys = new int[n];
            for (int i = 0; i < n; i++) {
                xs[i] = (int)(cx + verts.get(i).getX()*scale);
                ys[i] = (int)(cy - verts.get(i).getY()*scale);
            }
            g2.drawPolygon(xs, ys, n);
        }
    }
}
