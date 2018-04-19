import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SolutionEvaluator {
	
	public double evaluateSolution(Solution soln, ArrayList<Tangram> tangrams) {
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
			for(int i=0; i<gridSquares.length; i++) {
				for(int j=0; j<gridSquares[0].length; j++) {
					if(!gridSquares[i][j].getAllFull())
						match = false;
				}
			}
		}
		return match;
	}
	
	public static ArrayList<Tangram> getTangramsFromFile(String pathname) {
		ArrayList<Tangram> tangramsFromFile = new ArrayList<>();
		List<String> content = new ArrayList<>();
		try {
			content = Files.readAllLines(Paths.get(pathname));
		} catch(IOException e) {
			e.printStackTrace();
		}
		//TODO

		return tangramsFromFile;
	}
	
}
