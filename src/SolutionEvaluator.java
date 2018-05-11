import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SolutionEvaluator {
	
	public double evaluateSolution(Solution soln, ArrayList<Tangrams> tangrams) {
		double numSolved = 0;
		for (Tangrams t : tangrams) {
			boolean solved = false;
			for (Tangrams tan : soln.solveTangram(t, 0)) {
				solved = solved || checkSoln(tan);
			}
			if (solved) {
				numSolved++;
			}
		}
		return numSolved/tangrams.size();
	}
	
	public static boolean checkSoln(Tangrams soln) {
		boolean match = true;
		for(int i = 0; i < soln.getPuzzle().getHeight(); i++) {
			for (int j = 0; j < soln.getPuzzle().getWidth(); j++) {
				match = match && soln.getFullPuzzle().getGridComposition()[j][i].getAllFull();
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
