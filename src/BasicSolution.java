import java.util.ArrayList;
import java.util.Scanner;
public class BasicSolution implements Solution {

	TestBedGui gui;
	ShapeTrayGui shapeGui;
	int layer;
	
	BasicSolution() {
		layer = 0;
	}
	
	Scanner pause = new Scanner(System.in);
	public ArrayList<Tangrams> solveTangram(Tangrams tangram, int cut) {
		layer++;
		ArrayList<Tangrams> output = new ArrayList<Tangrams>();
		if (layer == 1) {
			gui = new TestBedGui(tangram);
			shapeGui = new ShapeTrayGui(tangram);
		} else {
			gui.update(tangram);
			shapeGui.update(tangram);
			pause.nextLine();
		}
		Shape next = new Shape(0, 0);
		int nextIndex = 0;
		int shapeNum = 0;
		for (Shape s : tangram.getShapes()) {
			if (s.getX() == -1 && s.getY() == -1 && s.getArea() >= next.getArea()) {
				next = s;
				nextIndex = shapeNum;
			}
			shapeNum++;
		}
		for (int y = 0; y <= tangram.getPuzzle().getHeight() - next.getHeight(); y++) {
			for (int x = 0; x <= tangram.getPuzzle().getWidth() - next.getWidth(); x++) {
				if (tangram.legalToPlace(x, y, next)) {
					Tangrams test = new Tangrams(tangram);
					test.moveShape(nextIndex, x, y);
					for (Tangrams t : solveTangram(test, cut)) {
						cut = Math.max(t.getFullPuzzle().getArea(), cut);
						if (t.getFullPuzzle().getArea() >= cut) {
							output.add(t);
						}
					}
				}
			}
		}
		for (Tangrams t : output) {
			if (t.getFullPuzzle().getArea() < cut) {
				output.remove(t);
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		Shape testShape = new Shape(6, 6);
		GridSquare[][] newArray = new GridSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				newArray[i][j] = new GridSquare(false);
			}
		}
		testShape.setGridComposition(newArray);
		Tangrams test = new Tangrams(testShape);
		test.getShapes().add(new Diamond(4));
		test.getShapes().add(new RightTriangle(RightTriangle.TOP_LEFT, 2));
		test.getShapes().add(new Rectangle(2, 6));
		test.getShapes().add(new HalfDiamond(HalfDiamond.LEFT, 2));
		test.getShapes().add(new RightTriangle(RightTriangle.TOP_RIGHT, 2));
		test.getShapes().add(new HalfDiamond(HalfDiamond.RIGHT, 4));
		test.getShapes().add(new Diamond(2));
		test.getShapes().add(new RightTriangle(RightTriangle.BOT_RIGHT, 2));
		test.getShapes().add(new HalfDiamond(HalfDiamond.LEFT, 2));
		test.getShapes().add(new RightTriangle(RightTriangle.BOT_LEFT, 2));
		new BasicSolution().solveTangram(test, 0);
	}
}
