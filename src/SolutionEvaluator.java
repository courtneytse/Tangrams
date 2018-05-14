import java.io.BufferedReader;
import java.io.FileReader;
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
		FileReader reader;
		BufferedReader bufRead;
		String line;
		ArrayList<String> puzContent = new ArrayList<String>();
		Shape puzzle;
		GridSquare[][] shapeGrid;
		ArrayList<String> shapeContent = new ArrayList<String>();
		try {
			reader = new FileReader(pathname);
			bufRead = new BufferedReader(reader);
			while ((line = bufRead.readLine()) != null) {
				if (line.equals("~")) {
					puzContent.clear();
					while (!(line = bufRead.readLine()).equals("~")) {
						puzContent.add(line);
					}
					int lineNum = 0;
					shapeGrid = new GridSquare[puzContent.get(0).length()][puzContent.size()];
					for (String s : puzContent) {
						for (int i = 0; i < s.length(); i++) {
							if (s.substring(i, i+1).equals("X")) {
								shapeGrid[i][lineNum] = new GridSquare(true);
							} else if (s.substring(i, i+1).equals("0")) {
								shapeGrid[i][lineNum] = new GridSquare(false);
							} else if (s.substring(i, i+1).equals("1")) {
								shapeGrid[i][lineNum] = new GridSquare(false, false, false, true);
							} else if (s.substring(i, i+1).equals("2")) {
								shapeGrid[i][lineNum] = new GridSquare(false, false, true, false);
							} else if (s.substring(i, i+1).equals("3")) {
								shapeGrid[i][lineNum] = new GridSquare(false, true, false, false);
							} else if (s.substring(i, i+1).equals("4")) {
								shapeGrid[i][lineNum] = new GridSquare(true, false, false, false);
							}
						}
						lineNum++;
					}
					puzzle = new Shape((puzContent.get(0).length()), puzContent.size());
					puzzle.setGridComposition(shapeGrid);
					new TestBedGui(new Tangrams(puzzle));
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		

		return tangramsFromFile;
	}
	
	public static void main(String args[]) {
		new SolutionEvaluator().getTangramsFromFile("tan");
	}
	
}
