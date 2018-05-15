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
//			pause.nextLine();
		}
		Shape next = new Shape(0, 0);
		int nextIndex = -1;
		int shapeNum = 0;
		for (Shape s : tangram.getShapes()) {
			System.out.println(s.getArea());
			if (s.getX() == -1 && s.getY() == -1 && s.getArea() >= next.getArea()) {
				next = s;
				nextIndex = shapeNum;
			}
			shapeNum++;
		}
		if (nextIndex != -1) {
			for (int y = 0; y <= tangram.getPuzzle().getHeight() - next.getHeight(); y++) {
				for (int x = 0; x <= tangram.getPuzzle().getWidth() - next.getWidth(); x++) {
					if (tangram.legalToPlace(x, y, next)) {
						Tangrams test = new Tangrams(tangram);
						test.moveShape(nextIndex, x, y);
						for (Tangrams t : solveTangram(test, cut)) {
							if (t.getFullPuzzle().getArea() >= cut) {
								output.add(t);
								cut = t.getFullPuzzle().getArea();
							}
						}
					}
				}
			}
		} else {
			output.add(tangram);
			return output;
		}
		for (Tangrams t : output) {
			if (t.getFullPuzzle().getArea() < cut) {
				output.remove(t);
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		ArrayList<Tangrams> grams = SolutionEvaluator.getTangramsFromFile("tan");
		for (Tangrams t : grams) {
			ArrayList<Tangrams> solved = new BasicSolution().solveTangram(t, 0);
			System.out.println("done");
			for (Tangrams s : solved) {
				System.out.println(SolutionEvaluator.checkSoln(s));
				new TestBedGui(s);
			}
		}
	}
}
