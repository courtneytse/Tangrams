import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SolutionEvaluator {

	public double evaluateSolution(Solution soln, int numOfTangrams) {
		double numSolved = 0;
		for(int i=0; i<numOfTangrams; i++) {
			
		}
		return numSolved/numOfTangrams;
	}
	
	public static ArrayList<Tangram> getTangramsFromFile(String pathname) {
		ArrayList<Tangram> tangramsFromFile = new ArrayList<>();
		List<String> content = new ArrayList<String>();
		try {
			content = Files.readAllLines(Paths.get(pathname));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tangramsFromFile;
	}
	
}
