package luxuryautos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRound extends JPanel {

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    public PanelRound() {
        setOpaque(false);
    }

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());

        Area area = new Area(createRoundedRect());

        g2.fill(area);
        g2.dispose();

        super.paintComponent(grphcs);
    }

    private RoundRectangle2D createRoundedRect() {
        int width = getWidth();
        int height = getHeight();
        float arcw = 0;
        float arch = 0;

        if (roundTopLeft > 0) {
            arcw = roundTopLeft;
            arch = roundTopLeft;
        }

        if (roundTopRight > 0) {
            arcw = Math.max(arcw, roundTopRight);
            arch = Math.max(arch, roundTopRight);
        }

        if (roundBottomLeft > 0) {
            arcw = Math.max(arcw, roundBottomLeft);
            arch = Math.max(arch, roundBottomLeft);
        }

        if (roundBottomRight > 0) {
            arcw = Math.max(arcw, roundBottomRight);
            arch = Math.max(arch, roundBottomRight);
        }

        // Adjust for corners
        arcw = Math.min(arcw, width / 2f);
        arch = Math.min(arch, height / 2f);

        return new RoundRectangle2D.Float(0, 0, width, height, arcw, arch);
    }
}