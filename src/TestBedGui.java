import java.awt.*;
import javax.swing.*;
public class TestBedGui extends JPanel{

	Tangrams disp;
	JFrame frame;
	
	TestBedGui(Tangrams state) {
		disp = state;
		frame = new JFrame("Tangrams");
		frame.setSize(new Dimension(800, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		this.setBackground(Color.WHITE);
		for (int y = 0; y < disp.getPuzzle().getHeight(); y++) {
			for (int x = 0; x < disp.getPuzzle().getWidth(); x++) {
				g.setColor(Color.BLACK);
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getAllFull()) {
					g.fillRect(x * 25, y * 25, 25, 25);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getTopLeft()) {
					g.fillPolygon(new int[] {x*25, x*25 + 25, x*25}, new int[] {y*25, y*25, y*25 + 25}, 3);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getTopRight()) {
					g.fillPolygon(new int[] {x*25, x*25 + 25, x*25 + 25}, new int[] {y*25, y*25, y*25 + 25}, 3);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getBotLeft()) {
					g.fillPolygon(new int[] {x*25, x*25 + 25, x*25}, new int[] {y*25, y*25 + 25, y*25 + 25}, 3);
				}
				if (disp.getEmptyPuzzle().getGridComposition()[x][y].getBotRight()) {
					g.fillPolygon(new int[] {x*25 + 25, x*25 + 25, x*25}, new int[] {y*25, y*25 + 25, y*25 + 25}, 3);
				}
			}
		}
	}
}
