
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
				gridComposition[x][y] = new GridSquare(false);
				try {
					gridComposition[x][y].merge(copy.getGridComposition()[x][y]);
				} catch (Exception e) {};
			}
		}
		x = copy.getX();
		y = copy.getY();
	}
	
	public int getArea() {
		int output = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (gridComposition[x][y].getAllFull()) {
					output += 2;
				} else if (gridComposition[x][y].getTopLeft() || gridComposition[x][y].getTopRight() || gridComposition[x][y].getBotLeft() || gridComposition[x][y].getBotRight()) {
					output++;
				}
			}
		}
		return output;
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
