
public class Shape {

	private GridSquare[][] gridComposition;
	private int width, height, x, y;
	
	Shape(int xSize, int ySize) {
		width = xSize;
		height = ySize;
		gridComposition = new GridSquare[width][height];
		x = -1;
		y = -1;
	}
	
	Shape(Shape copy) {
		width = copy.getWidth();
		height = copy.getHeight();
		gridComposition = new GridSquare[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (copy.getGridComposition()[x][y].getBotLeft() || copy.getGridComposition()[x][y].getBotRight() || copy.getGridComposition()[x][y].getTopLeft() || copy.getGridComposition()[x][y].getTopRight()) {
					gridComposition[x][y] = new GridSquare(copy.getGridComposition()[x][y].getBotRight(), copy.getGridComposition()[x][y].getBotLeft(), copy.getGridComposition()[x][y].getTopRight(), copy.getGridComposition()[x][y].getTopLeft());
				} else {
					gridComposition[x][y] = new GridSquare(copy.getGridComposition()[x][y].getAllFull());
				}
			}
		}
		x = copy.getX();
		y = copy.getY();
	}
	public void setGridComposition(GridSquare[][] newGrid) {
		gridComposition = newGrid;
		width = newGrid.length;
		height = newGrid[0].length;
	}
	
	public GridSquare[][] getGridComposition() {
		return gridComposition;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setX(int input) {
		x = input;
	}
	
	public void setY(int input) {
		y = input;
	}
	
	public void setCoordinate(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
