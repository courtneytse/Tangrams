
public class Diamond extends Shape {

	/**
	 * Precondition: size must be an even number
	 * @param size
	 */
	Diamond(int size) {
		super(size, size);
		GridSquare[][] newArray = new GridSquare[size][size];
		RightTriangle copyable = new RightTriangle(RightTriangle.BOT_RIGHT, size/2);
		for (int i = 0; i < size/2; i++) {
			for (int j = 0; j < size/2; j++) {
				newArray[i][j] = copyable.getGridComposition()[i][j];
			}
		}
		copyable = new RightTriangle(RightTriangle.TOP_RIGHT, size/2);
		for (int i = 0; i < size/2; i++) {
			for (int j = 0; j < size/2; j++) {
				newArray[i + size/2][j] = copyable.getGridComposition()[i][j];
			}
		}
		copyable = new RightTriangle(RightTriangle.BOT_LEFT, size/2);
		for (int i = 0; i < size/2; i++) {
			for (int j = 0; j < size/2; j++) {
				newArray[i][j + size/2] = copyable.getGridComposition()[i][j];
			}
		}
		copyable = new RightTriangle(RightTriangle.TOP_LEFT, size/2);
		for (int i = 0; i < size/2; i++) {
			for (int j = 0; j < size/2; j++) {
				newArray[i + size/2][j + size/2] = copyable.getGridComposition()[i][j];
			}
		}
		this.setGridComposition(newArray);
	}
	
	public static void main(String[] args) {
		Diamond test = new Diamond(8);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (test.getGridComposition()[i][j].getAllFull()) {
					System.out.print(" 1  ");
				} else if (test.getGridComposition()[i][j].getBotLeft() || test.getGridComposition()[i][j].getBotRight() || test.getGridComposition()[i][j].getTopLeft() || test.getGridComposition()[i][j].getTopRight()) {
					System.out.print("0.5 ");
				} else {
					System.out.print(" 0  ");
				}
			}System.out.println();
		}
	}
}
