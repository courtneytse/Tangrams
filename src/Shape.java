
public class Shape {

	private GridSquare[][] gridComposition;
	private int width, height, x, y;
	
	Shape(int xSize, int ySize) {
		width = xSize;
		height = ySize;
		gridComposition = new GridSquare[width][height];
	}
	
	Shape(Shape copy) {
		width = copy.getWidth();
		height = copy.getHeight();
		gridComposition = new GridSquare[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (copy.getGridComposition()[j][i].getBotLeft() || copy.getGridComposition()[j][i].getBotRight() || copy.getGridComposition()[j][i].getTopLeft() || copy.getGridComposition()[j][i].getTopRight()) {
					gridComposition[j][i] = new GridSquare(copy.getGridComposition()[j][i].getBotRight(), copy.getGridComposition()[j][i].getBotLeft(), copy.getGridComposition()[j][i].getTopRight(), copy.getGridComposition()[j][i].getTopLeft());
				} else {
					gridComposition[j][i] = new GridSquare(copy.getGridComposition()[j][i].getAllFull());
				}
			}
		}
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
