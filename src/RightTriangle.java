
public class RightTriangle extends Shape {

	public final int TOP_RIGHT = 0, BOT_RIGHT = 1, BOT_LEFT = 2, TOP_LEFT = 3;
	
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
				} if (direction == BOT_RIGHT) {
					if ()
				}
			}
		}
	}
}
