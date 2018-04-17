
public abstract class Shape {

	private GridSquare[][] gridComposition;
	private int width, height;
	
	Shape(int xSize, int ySize) {
		width = xSize;
		height = ySize;
		gridComposition = new GridSquare[width][height];
	}
	
	public void setGridComposition(GridSquare[][] newGrid) {
		gridComposition = newGrid;
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
}
