public class GridSquare {

	private boolean allFull, botRight, botLeft, topRight, topLeft;
	
	GridSquare(boolean filled) {
		allFull = filled;
		botRight = false;
		botLeft = false;
		topRight = false;
		topLeft = false;
	}
	
	GridSquare(boolean bottomRight, boolean bottomLeft, boolean upperRight, boolean upperLeft) {
		try {
			setBotRight(bottomRight);
			setBotLeft(bottomLeft);
			setTopRight(upperRight);
			setTopLeft(upperLeft);
		} catch (Exception e) {
			System.out.println("Illegal square");
		}
	}
	
	public boolean getAllFull() {
		return allFull;
	}
	
	public boolean getBotRight() {
		return botRight;
	}
	
	public boolean getBotLeft() {
		return botLeft;
	}
	
	public boolean getTopRight() {
		return topRight;
	}
	
	public boolean getTopLeft() {
		return topLeft;
	}
	
	public void merge(GridSquare sq) throws Exception {
		if (sq.getTopRight()) {
			setTopRight(sq.getTopRight());
		}
		if (sq.getTopLeft()) {
			setTopLeft(sq.getTopLeft());
		}
		if (sq.getBotLeft()) {
			setBotLeft(sq.getBotLeft());
		}
		if (sq.getBotRight()) {
			setBotRight(sq.getBotRight());
		}
		if (sq.getAllFull() && (!(sq.getTopLeft() || sq.getTopRight() || sq.getBotLeft() || sq.getBotRight()))) {
			if (!(this.getBotLeft() || this.getBotRight() || this.getTopLeft() || this.getTopRight() || this.getAllFull())) {
				allFull =  true;
			} else {
				throw new Exception();
			}
		}
	}
	
	public void setBotRight(boolean input) throws Exception {
		if (input && (botRight || botLeft || topRight || allFull)) {
			throw new Exception();
		} else {
			botRight = input;
			if (input) {
				allFull = botRight && topLeft;
			}
		}
	}
	
	public void setBotLeft(boolean input) throws Exception {
		if (input && (botRight || botLeft || topLeft || allFull)) {
			throw new Exception();
		} else {
			botLeft = input;
			if (input) {
				allFull = botLeft && topRight;
			}
		}
	}
	
	public void setTopRight(boolean input) throws Exception {
		if (input && (botRight || topLeft || topRight)) {
			throw new Exception();
		} else {
			topRight = input;
			if (input) {
				allFull = topRight && botLeft;
			}
		}
	}
	
	public void setTopLeft(boolean input) throws Exception {
		if (input && (topLeft || botLeft || topRight)) {
			throw new Exception();
		} else {
			topLeft = input;
			if (input) {
				allFull = topLeft && botRight;
			}
		}
	}
}
