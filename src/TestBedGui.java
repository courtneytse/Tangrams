import java.awt.*;
import javax.swing.*;
public class TestBedGui extends JPanel{

	Tangrams disp;
	JFrame frame, check;
	
	TestBedGui(Tangrams state) {
		disp = state;
		frame = new JFrame("Tangrams");
		frame.setSize(new Dimension(state.getEmptyPuzzle().getWidth() * 50 + 25, state.getEmptyPuzzle().getHeight() * 50 + 50));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.setVisible(true);
		check = new JFrame("Is Valid?");
		check.setContentPane(new JPanel());
		if (SolutionEvaluator.checkSoln(state)) {
			check.getContentPane().add(new JLabel("Solution is valid"));
		} else {
			check.getContentPane().add(new JLabel("Solution is not valid"));
		}
		check.pack();
		check.setLocation(frame.getWidth(), 0);
		check.setVisible(true);
	}
	
	public void update(Tangrams state) {
		disp = state;
		paintComponent(this.getGraphics());
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, disp.getEmptyPuzzle().getWidth() * 50, 0);
		g.drawLine(disp.getEmptyPuzzle().getWidth() * 50, 0, disp.getEmptyPuzzle().getWidth() * 50, disp.getEmptyPuzzle().getHeight() * 50);
		g.drawLine(disp.getEmptyPuzzle().getWidth() * 50, disp.getEmptyPuzzle().getHeight() * 50, 0, disp.getEmptyPuzzle().getHeight() * 50);
		g.drawLine(0, disp.getEmptyPuzzle().getHeight() * 50, 0, 0);
		for (int y = 0; y < disp.getPuzzle().getHeight(); y++) {
			for (int x = 0; x < disp.getPuzzle().getWidth(); x++) {
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getAllFull()) {
					g.fillRect(x * 50, y * 50, 50, 50);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getTopLeft()) {
					g.fillPolygon(new int[] {x*50, x*50 + 50, x*50}, new int[] {y*50, y*50, y*50 + 50}, 3);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getTopRight()) {
					g.fillPolygon(new int[] {x*50, x*50 + 50, x*50 + 50}, new int[] {y*50, y*50, y*50 + 50}, 3);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getBotLeft()) {
					g.fillPolygon(new int[] {x*50, x*50 + 50, x*50}, new int[] {y*50, y*50 + 50, y*50 + 50}, 3);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getBotRight()) {
					g.fillPolygon(new int[] {x*50 + 50, x*50 + 50, x*50}, new int[] {y*50, y*50 + 50, y*50 + 50}, 3);
				}
			}
		}
		for (Shape s : disp.getShapes()) {
			if (s.getX() != -1 && s.getY() != -1) {
				for (int y = 0; y < s.getHeight(); y++) {
					for (int x = 0; x < s.getWidth(); x++) {
						g.setColor(Color.RED);
						if (s.getGridComposition()[x][y].getAllFull()) {
							g.fillRect((x + s.getX())*50, (y + s.getY())*50, 50, 50);
							g.setColor(Color.BLACK);
							if (x == 0) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50, (y + s.getY())*50 + 50);
							}
							if (x == s.getWidth() - 1) {
								g.drawLine((x + s.getX())*50 + 50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							}
							if (y == 0) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50);
							}
							if (y == s.getHeight() - 1) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50 + 50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							}
						}
						if (s.getGridComposition()[x][y].getTopLeft()) {
							g.fillPolygon(new int[] {(x + s.getX())*50, (x + s.getX())*50 + 50, (x + s.getX())*50}, new int[] {(y + s.getY())*50, (y + s.getY())*50, (y + s.getY())*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + s.getX())*50, (y + s.getY())*50 + 50, (x + s.getX())*50 + 50, (y + s.getY())*50);
							if (x == 0) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50, (y + s.getY())*50 + 50);
							}
							if (y == 0) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50);
							}
						}
						if (s.getGridComposition()[x][y].getTopRight()) {
							g.fillPolygon(new int[] {(x + s.getX())*50 + 1, (x + s.getX())*50 + 50, (x + s.getX())*50 + 50}, new int[] {(y + s.getY())*50, (y + s.getY())*50, (y + s.getY())*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							if (x == s.getWidth() - 1) {
								g.drawLine((x + s.getX())*50 + 50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							}
							if (y == 0) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50);
							}
						}
						if (s.getGridComposition()[x][y].getBotLeft()) {
							g.fillPolygon(new int[] {(x + s.getX())*50, (x + s.getX())*50 + 50, (x + s.getX())*50}, new int[] {(y + s.getY())*50, (y + s.getY())*50 + 50, (y + s.getY())*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							if (x == 0) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50, (x + s.getX())*50, (y + s.getY())*50 + 50);
							}
							if (y == s.getHeight() - 1) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50 + 50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							}
						}
						if (s.getGridComposition()[x][y].getBotRight()) {
							g.fillPolygon(new int[] {(x + s.getX())*50 + 50, (x + s.getX())*50 + 50, (x + s.getX())*50}, new int[] {(y + s.getY())*50, (y + s.getY())*50 + 50, (y + s.getY())*50 + 50}, 3);
							g.setColor(Color.BLACK);
							g.drawLine((x + s.getX())*50, (y + s.getY())*50 + 50, (x + s.getX())*50 + 50, (y + s.getY())*50);
							if (x == s.getWidth() - 1) {
								g.drawLine((x + s.getX())*50 + 50, (y + s.getY())*50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							}
							if (y == s.getHeight() - 1) {
								g.drawLine((x + s.getX())*50, (y + s.getY())*50 + 50, (x + s.getX())*50 + 50, (y + s.getY())*50 + 50);
							}
						}
					}
				}
			}
		}
		g.setColor(new Color(0, 0, 0, 50));
		for (int y = 0; y < disp.getPuzzle().getHeight(); y++) {
			g.drawLine(0, y*50, disp.getPuzzle().getWidth()*50, y*50);
		}
		for (int x = 0; x < disp.getPuzzle().getWidth(); x++) {
			g.drawLine(x*50, 0, x*50, disp.getPuzzle().getHeight()*50);
		}
	}
}
