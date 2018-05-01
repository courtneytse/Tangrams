
public class RightTriangle extends Shape {

	public static final int TOP_RIGHT = 0, BOT_RIGHT = 1, BOT_LEFT = 2, TOP_LEFT = 3;
	int dir;
	
	RightTriangle(int direction, int size) {
		super(size, size);
		dir = direction;
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
					 } else if (i + 1 > size - j) {
						 newArray[i][j] = new GridSquare(true);
					 } else {
						 newArray[i][j] = new GridSquare(false);
					 }
				} if (direction == TOP_LEFT) {
					if (i + 1 == size - j) {
						newArray[i][j] = new GridSquare(false, false, false, true);
					} else if (i + 1 < size - j) {
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
		RightTriangle test = new RightTriangle(RightTriangle.TOP_RIGHT, 4);
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (test.getGridComposition()[x][y].getAllFull()) {
					System.out.print(" 1  ");
				} else if (test.getGridComposition()[x][y].getTopRight()) {
					System.out.print("0.5 ");
				} else {
					System.out.print(" 0  ");
				}
			}System.out.println();
		}
	}
	
	public String toString() {
		String output = "Right_Triangle: [width=" + getWidth() + "][height=" + getHeight()+"]";
		if (dir == TOP_RIGHT) {
			output += "TOP_RIGHT]";
		} else if (dir == TOP_LEFT) {
			output += "TOP_LEFT]";
		} else if (dir == BOT_RIGHT) {
			output += "BOT_RIGHT]";
		} else if (dir == BOT_LEFT) {
			output += "BOT_LEFT]";
		}
		return output;
	}
}
