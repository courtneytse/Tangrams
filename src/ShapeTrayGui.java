import java.awt.*;
import javax.swing.*;
public class ShapeTrayGui extends JPanel {

	JFrame frame;
	Tangrams disp;
	Color[] colors;
	
	ShapeTrayGui(Tangrams state) {
		colors = new Color[] {Color.RED, Color.BLUE, Color.YELLOW, Color.PINK, Color.CYAN, Color.GREEN, Color.ORANGE, Color.MAGENTA};
		disp = state;
		frame = new JFrame("Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800, 800));
		frame.setSize(this.getSize());
		frame.setLocation(state.getPuzzle().getWidth()*50, 0);
		frame.setContentPane(this);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

	public void update(Tangrams state) {
		disp = state;
		paintComponent(this.getGraphics());
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int originX = 0, originY = 0, nextY = 0;
		int colornum = -1;
		for (Shape s : disp.getShapes()) {
			colornum++;
			if (colornum == colors.length) {
				colornum = 0;
			}
			if (s.getX() == -1 && s.getY() == -1) {
				if ((s.getWidth() + originX)*50 >= 800) {
					originY = nextY;
					originX = 0;
				}
				for (int y = 0; y < s.getHeight(); y++) {
					for (int x = 0; x < s.getWidth(); x++) {
						g.setColor(colors[colornum]);
						if (s.getGridComposition()[x][y].getAllFull()) {
							g.fillRect((x + originX)*50, (y + originY)*50, 50, 50);
							g.setColor(Color.BLACK);
							if (x == 0) {
								g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50, (y + originY)*50 + 50);
							}
							if (x == s.getWidth() - 1) {
								g.drawLine((x + originX)*50 + 50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							}
							if (y == 0) {
								g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50);
							}
							if (y == s.getHeight() - 1) {
								g.drawLine((x + originX)*50, (y + originY)*50 + 50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							}
						}
						if (s.getGridComposition()[x][y].getTopLeft()) {
							g.fillPolygon(new int[] {(x + originX)*50, (x + originX)*50 + 50, (x + originX)*50}, new int[] {(y + originY)*50, (y + originY)*50, (y + originY)*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + originX)*50, (y + originY)*50 + 50, (x + originX)*50 + 50, (y + originY)*50);
							if (x == 0) {
								g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50, (y + originY)*50 + 50);
							}
							if (y == 0) {
								g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50);
							}
						}
						if (s.getGridComposition()[x][y].getTopRight()) {
							g.fillPolygon(new int[] {(x + originX)*50 + 1, (x + originX)*50 + 50, (x + originX)*50 + 50}, new int[] {(y + originY)*50, (y + originY)*50, (y + originY)*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							if (x == s.getWidth() - 1) {
								g.drawLine((x + originX)*50 + 50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							}
							if (y == 0) {
								g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50);
							}
						}
						if (s.getGridComposition()[x][y].getBotLeft()) {
							g.fillPolygon(new int[] {(x + originX)*50, (x + originX)*50 + 50, (x + originX)*50}, new int[] {(y + originY)*50, (y + originY)*50 + 50, (y + originY)*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							if (x == 0) {
								g.drawLine((x + originX)*50, (y + originY)*50, (x + originX)*50, (y + originY)*50 + 50);
							}
							if (y == s.getHeight() - 1) {
								g.drawLine((x + originX)*50, (y + originY)*50 + 50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							}
						}
						if (s.getGridComposition()[x][y].getBotRight()) {
							g.fillPolygon(new int[] {(x + originX)*50 + 50, (x + originX)*50 + 50, (x + originX)*50}, new int[] {(y + originY)*50, (y + originY)*50 + 50, (y + originY)*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + originX)*50, (y + originY)*50 + 50, (x + originX)*50 + 50, (y + originY)*50);
							if (x == s.getWidth() - 1) {
								g.drawLine((x + originX)*50 + 50, (y + originY)*50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							}
							if (y == s.getHeight() - 1) {
								g.drawLine((x + originX)*50, (y + originY)*50 + 50, (x + originX)*50 + 50, (y + originY)*50 + 50);
							}
						}
					}
				}
				originX += s.getWidth() + 1;
				if (s.getHeight() > nextY - originY) {
					nextY = originY + s.getHeight();
				}
			}
		}
	}
}
