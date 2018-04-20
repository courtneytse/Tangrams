import java.util.ArrayList;
public class Tangrams {

	ArrayList<Shape> shapes;
	Shape emptyPuzzle, puzzle;
	
	Tangrams(Shape main) {
		emptyPuzzle = main;
		shapes = new ArrayList<Shape>();
	}
	
	public Shape getPuzzle() {
		puzzle = new Shape(emptyPuzzle);
		for (Shape shape : shapes) {
			if (shape.getX() != -1 && shape.getY() != -1) {
				try {
					addShape(puzzle, shape);
				} catch (Exception e) {
					System.out.println("Illegal shape placement");
				}
			}
		}
		return puzzle;
	}
	
	public Shape getEmptyPuzzle() {
		return emptyPuzzle;
	}
	
	public boolean legalToPlace(int x, int y, Shape s) {
		boolean output = true;
		puzzle = new Shape(emptyPuzzle);
		for (Shape shape : shapes) {
			if (shape.getX() != -1 && shape.getY() != -1) {
				try {
					addShape(puzzle, shape);
				} catch (Exception e) {
					System.out.println("Illegal shape placement");
				}
			}
		}
		try {
			Shape child = new Shape(s);
			addShape(puzzle, child);
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
	
	public static void main(String[] args) {
		Shape testShape = new Shape(2, 2);
		GridSquare[][] newArray = new GridSquare[2][2];
		newArray[0][0] = new GridSquare(false, false, false, true);
		newArray[1][0] = new GridSquare(false, false, true, false);
		newArray[0][1] = new GridSquare(false, true, false, false);
		newArray[1][1] = new GridSquare(true, false, false, false);
		testShape.setGridComposition(newArray);
		Tangrams test = new Tangrams(testShape);
		new TestBedGui(test);
	}
}
