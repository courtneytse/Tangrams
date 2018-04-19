
public class HalfDiamond extends Shape{

	public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	
	/**
	 * baseLength must be even
	 * @param direction
	 * @param baseLength
	 */
	HalfDiamond(int direction, int baseLength) {
		super(baseLength, baseLength);
		GridSquare[][] newArray;
		if (direction == UP || direction == DOWN) {
			newArray = new GridSquare[baseLength][baseLength/2];
		} else {
			newArray = new GridSquare[baseLength/2][baseLength];
		}
		RightTriangle copyable;
		if (direction == UP) {
			copyable = new RightTriangle(RightTriangle.BOT_RIGHT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i][j] = copyable.getGridComposition()[i][j];
				}
			}
			copyable = new RightTriangle(RightTriangle.BOT_LEFT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i + baseLength/2][j] = copyable.getGridComposition()[i][j];
				}
			}
		} else if (direction == RIGHT) {
			copyable = new RightTriangle(RightTriangle.BOT_LEFT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i][j] = copyable.getGridComposition()[i][j];
				}
			}
			copyable = new RightTriangle(RightTriangle.TOP_LEFT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i][j + baseLength/2] = copyable.getGridComposition()[i][j];
				}
			}
		} else if (direction == DOWN) {
			copyable = new RightTriangle(RightTriangle.TOP_RIGHT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i][j] = copyable.getGridComposition()[i][j];
				}
			}
			copyable = new RightTriangle(RightTriangle.TOP_LEFT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i + baseLength/2][j] = copyable.getGridComposition()[i][j];
				}
			}
		} else if (direction == LEFT) {
			copyable = new RightTriangle(RightTriangle.BOT_RIGHT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i][j] = copyable.getGridComposition()[i][j];
				}
			}
			copyable = new RightTriangle(RightTriangle.TOP_RIGHT, baseLength/2);
			for (int i = 0; i < baseLength/2; i++) {
				for (int j = 0; j < baseLength/2; j++) {
					newArray[i][j + baseLength/2] = copyable.getGridComposition()[i][j];
				}
			}
		}
		this.setGridComposition(newArray);
	}
	
	public static void main(String[] args) {
		HalfDiamond test = new HalfDiamond(HalfDiamond.LEFT, 8);
		for (int y = 0; y < test.getHeight(); y++) {
			for (int x = 0; x < test.getWidth(); x++) {
				if (test.getGridComposition()[x][y].getAllFull()) {
					System.out.print(" 1  ");
				} else if (test.getGridComposition()[x][y].getBotLeft() || test.getGridComposition()[x][y].getBotRight() || test.getGridComposition()[x][y].getTopLeft() || test.getGridComposition()[x][y].getTopRight()) {
					System.out.print("0.5 ");
				} else {
					System.out.print(" 0  ");
				}
			}System.out.println();
		}
	}
}
