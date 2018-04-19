
public class RightTriangle extends Shape {

	public static final int TOP_RIGHT = 0, BOT_RIGHT = 1, BOT_LEFT = 2, TOP_LEFT = 3;
	
	
	RightTriangle(int direction, int size) {
		super(size, size);
		GridSquare[][] newArray = new GridSquare[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (direction == TOP_RIGHT) {
					if (i == j) {
						newArray[i][j] = new GridSquare(false, false, true, false);
					} else if (i > j) {
						newArray[i][j] = new GridSquare(true);
					} else {
						newArray[i][j] = new GridSquare(false);
					}
				} if (direction == BOT_LEFT) {
					if (i == j) {
						newArray[i][j] = new GridSquare(false, true, false, false);
					} else if (i < j) {
						newArray[i][j] = new GridSquare(true);
					} else {
						newArray[i][j] = new GridSquare(false);
					}
				} if (direction == BOT_RIGHT) {
					 if (i + 1 == size - j) {
						 newArray[i][j] = new GridSquare(true, false, false, false);
					 } else if (i + 1 < size - j) {
						 newArray[i][j] = new GridSquare(true);
					 } else {
						 newArray[i][j] = new GridSquare(false);
					 }
				} if (direction == TOP_LEFT) {
					if (i + 1 == size - j) {
						newArray[i][j] = new GridSquare(false, false, false, true);
					} else if (i + 1 > size - j) {
						newArray[i][j] = new GridSquare(true);
					} else {
						newArray[i][j] = new GridSquare(false);
					}
				}
			}
		}
		setGridComposition(newArray);
	}
	
	public static void main(String[] args) {
		RightTriangle test = new RightTriangle(RightTriangle.TOP_LEFT, 4);
	}
}
