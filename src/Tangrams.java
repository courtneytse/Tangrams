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
			child.setX(x);
			child.setY(y);
			addShape(puzzle, child);
		} catch (Exception e) {
			e.printStackTrace();
			output = false;
		}
		return output;
	}
	
	private void addShape(Shape parent, Shape child) throws Exception{
		for (int y = 0; y < child.getHeight(); y++) {
			for (int x = 0; x < child.getWidth(); x++) {
				parent.getGridComposition()[x + child.getX()][y + child.getY()].merge(child.getGridComposition()[x][y]);
			}
		}
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public void setShapes(ArrayList<Shape> sh) {
		shapes = sh;
	}
	
	public void moveShape(int index, int newX, int newY) {
		if (legalToPlace(newX, newY, shapes.get(index))) {
			shapes.get(index).setX(newX);
			shapes.get(index).setY(newY);
		} else {
			System.out.println("illegal placement");
		}
	}
	
	public static void showExample1() {
		Shape testShape = new Shape(2, 2);
		GridSquare[][] newArray = new GridSquare[2][2];
		newArray[0][0] = new GridSquare(false, false, false, true);
		newArray[1][0] = new GridSquare(false, false, true, false);
		newArray[0][1] = new GridSquare(false, true, false, false);
		newArray[1][1] = new GridSquare(true, false, false, false);
		testShape.setGridComposition(newArray);
		Tangrams test = new Tangrams(testShape);
		test.getShapes().add(new RightTriangle(RightTriangle.BOT_LEFT, 1));
		test.getShapes().add(new HalfDiamond(HalfDiamond.LEFT, 2));
		test.getShapes().add(new RightTriangle(RightTriangle.TOP_LEFT, 1));
		test.moveShape(0, 1, 0);
		test.moveShape(1, 0, 0);
		test.moveShape(2, 1, 1);
		new TestBedGui(test);
	}
	
	
	public static void showExample2() {
		Shape testShape = new Shape(6, 6);
		GridSquare[][] newArray = new GridSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				newArray[i][j] = new GridSquare(false);
			}
		}
		testShape.setGridComposition(newArray);
		Tangrams test = new Tangrams(testShape);
		test.getShapes().add(new Shape(new Diamond(4)));
		test.moveShape(0, 0, 0);
		test.getShapes().add(new Shape(new RightTriangle(RightTriangle.TOP_LEFT, 2)));
		test.moveShape(1, 0, 0);
		test.getShapes().add(new Rectangle(2, 6));
		test.moveShape(2, 4, 0);
		test.getShapes().add(new Shape(new HalfDiamond(HalfDiamond.LEFT, 2)));
		test.moveShape(3, 3, 2);
		new TestBedGui(test);
	}
	
	public static void main(String[] args) {
		showExample2();
	}
}
