import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SolutionEvaluator {
	
	public double evaluateSolution(Solution soln, ArrayList<Tangrams> tangrams) {
		double numSolved = 0;
		for(int i=0; i<tangrams.size(); i++) {
			ArrayList<Shape> solnShapes = soln.solveTangram(tangrams.get(i));
			if(checkSoln(solnShapes))
				numSolved++;
		}
		return numSolved/tangrams.size();
	}
	
	private boolean checkSoln(ArrayList<Shape> soln) {
		boolean match = true;
		for(Shape shape : soln) {
			GridSquare[][] gridSquares = shape.getGridComposition();
			for(int i=0; match && i<gridSquares.length; i++) {
				for(int j=0; match && j<gridSquares[0].length; j++) {
					if(!gridSquares[i][j].getAllFull())
						match = false;
				}
			}
		}
		return match;
	}
	
	public static ArrayList<Tangrams> getTangramsFromFile(String pathname) {
		ArrayList<Tangrams> tangramsFromFile = new ArrayList<>();
		List<String> content = new ArrayList<>();
		try {
			content = Files.readAllLines(Paths.get(pathname));
		} catch(IOException e) {
			e.printStackTrace();
		}
		//TODO

		return tangramsFromFile;
	}
	
	public static void main(String args[]) {
		
	}
	
}
