
public class Rectangle extends Shape{

	Rectangle (int width, int height) {
		super(width, height);
		GridSquare[][] newArray = new GridSquare[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				newArray[i][j] = new GridSquare(true);
			}
		}
		setGridComposition(newArray);
	}
}
