public class GridSquare {

	private boolean allFull, botRight, botLeft, topRight, topLeft;
	
	GridSquare() {
		allFull = false;
		botRight = false;
		botLeft = false;
		topRight = false;
		topLeft = false;
	}
	
	GridSquare(boolean bottomRight, boolean bottomLeft, boolean upperRight, boolean upperLeft) {
		allFull = false;
		botRight = bottomRight;
		botLeft = bottomLeft;
		topRight = upperRight;
		topLeft = upperLeft;
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
	
	public void setBotRight(boolean input) throws Exception {
		if (input && (botRight || botLeft || topRight || allFull)) {
			throw new Exception();
		} else {
			botRight = input;
			allFull = botRight && topLeft;
		}
	}
	
	public void setBotLeft(boolean input) throws Exception {
		if (input && (botRight || botLeft || topLeft || allFull)) {
			throw new Exception();
		} else {
			botLeft = input;
			allFull = botLeft && topRight;
		}
	}
	
	public void setTopRight(boolean input) throws Exception {
		if (input && (botRight || topLeft || topRight)) {
			throw new Exception();
		} else {
			topRight = input;
			allFull = topRight && botLeft;
		}
	}
	
	public void setTopLeft(boolean input) throws Exception {
		if (input && (topLeft || botLeft || topRight)) {
			throw new Exception();
		} else {
			topLeft = input;
			allFull = topLeft && botRight;
		}
	}
}