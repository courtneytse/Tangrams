import java.util.ArrayList;

public class SquareSolution implements Solution{

	@Override
	public Tangrams solveTangram(Tangrams tangram) {
		
		Diamond outline = new Diamond(16);
		outline.setCoordinate(-8, 8);
		Tangrams test = new Tangrams(outline);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		RightTriangle rt = new RightTriangle(1,8);
		rt.setCoordinate(0, 16);
		
		RightTriangle rt2 = new RightTriangle(2,8);
		rt2.setCoordinate(8, 16);
		RightTriangle rt3 = new RightTriangle(3,4);
		rt3.setCoordinate(4, 0);
		RightTriangle rt4 = new RightTriangle(0,4);
		rt4.setCoordinate(-4, 0);
		Rectangle s = new Rectangle(4,4);
		s.setCoordinate(0, 0);
		HalfDiamond hd = new HalfDiamond(2,8);
		hd.setCoordinate(-4, -4);
		RightTriangle p1 = new RightTriangle(0,4);
		p1.setCoordinate(-8,0);
		RightTriangle p2 = new RightTriangle(2,4);
		p2.setCoordinate(-4,0);
		
		shapes.add(rt);
		shapes.add(rt2);
		shapes.add(rt3);
		shapes.add(rt4);
		shapes.add(s);
		shapes.add(hd);
		shapes.add(p1);
		shapes.add(p2);
		
		test.setShapes(shapes);
		return test;
		
	}

}