import java.util.ArrayList;
public class Tangrams {

	ArrayList<Shape> shapes;
	Shape puzzle, filledPuzzle;
	
	Tangrams(Shape main) {
		puzzle = main;
	}
	
	public boolean legalToPlace(int x, int y, Shape s) {
		boolean output = true;
		filledPuzzle = new Shape(puzzle);
		for (Shape shape : shapes) {
			if (shape.getX() != -1 && shape.getY() != -1) {
				try {
					addShape(filledPuzzle, shape);
				} catch (Exception e) {
					System.out.println("Illegal shape placement");
				}
			}
		}
		try {
			Shape child = new Shape(s);
			addShape(filledPuzzle, child);
		} catch (Exception e) {
			output = false;
		}
		return output;
	}
	
	public void addShape(Shape parent, Shape child) throws Exception{
		for (int i = 0; i < child.getHeight(); i++) {
			for (int j = 0; j < child.getWidth(); j++) {
				parent.getGridComposition()[j + child.getX()][i + child.getY()].merge(child.getGridComposition()[j][i]);
			}
		}
	}
}
