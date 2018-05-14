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
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		Tangrams toAdd = new Tangrams(new Shape());
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
					toAdd = new Tangrams(puzzle);
				}
				if (line.equals("!")){
					shapes.clear();
					while (!(line = bufRead.readLine()).equals("!")) {
						if (line.substring(0, line.indexOf("(")).equals("RT")) {
							line = line.substring(line.indexOf("(") + 1);
							int dirNum = Integer.parseInt(line.substring(0, line.indexOf(")")));
							line = line.substring(line.indexOf("(") + 1);
							int len = Integer.parseInt(line.substring(0, line.indexOf(")")));
							shapes.add(new RightTriangle(dirNum, len));
						} else if (line.substring(0, line.indexOf("(")).equals("D")) {
							line = line.substring(line.indexOf("(") + 1);
							int len = Integer.parseInt(line.substring(0, line.indexOf(")")));
							shapes.add(new Diamond(len));
						} else if (line.substring(0, line.indexOf("(")).equals("HD")) {
							line = line.substring(line.indexOf("(") + 1);
							int dirNum = Integer.parseInt(line.substring(0, line.indexOf(")")));
							line = line.substring(line.indexOf("(") + 1);
							int len = Integer.parseInt(line.substring(0, line.indexOf(")")));
							shapes.add(new HalfDiamond(dirNum, len));
						} else if (line.substring(0, line.indexOf("(")).equals("R")) {
							line = line.substring(line.indexOf("(") + 1);
							int width = Integer.parseInt(line.substring(0, line.indexOf(")")));
							line = line.substring(line.indexOf("(") + 1);
							int height = Integer.parseInt(line.substring(0, line.indexOf(")")));
							shapes.add(new Rectangle(width, height));
						}
						
					}
					for (Shape s : shapes) {
						toAdd.getShapes().add(s);
					}
					tangramsFromFile.add(toAdd);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return tangramsFromFile;
	}
	
	public static void main(String args[]) {
		SolutionEvaluator tester = new SolutionEvaluator();
		System.out.println(tester.evaluateSolution(new BasicSolution(), SolutionEvaluator.getTangramsFromFile("tan")));
	}
	
}
