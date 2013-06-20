import java.lang.Double;
import java.util.ArrayList;
import java.util.HashMap;

public class cracking7_6 {
    public static int countEqualLinesHelper (ArrayList<Line> lines, Line line) {
        if(lines == null) return 0;
        int count = 0;
        for(Line l : lines) {
            if(l.isEquivalent(line))
                count++;
        }
        return count;
    }

    public static int countEqualLines (HashMap<Double, ArrayList<Line>> hash,Line line) {
        double key = Line.floorToNearestEpsilon(line.slope);
        double eps = Line.epsilon;
        int count = countEqualLinesHelper(hash.get(line.slope),line) +
                countEqualLinesHelper(hash.get(line.slope+eps),line) +
                countEqualLinesHelper(hash.get(line.slope-eps),line);
        return count;
    }

    public static insertLine(HashMap<Double,ArrayList<Line>> hash, Line line) {
        ArrayList<Line> lines = null;
        double key = Line.floorToNearestEpsilon(line.slope);
        if(!hash.containsKey(key)) {
            lines = new ArrayList<Line>();
            hash.push(key,lines);
        } else {
             lines = hash.get(key);
        }
        lines.add(line);
    }

    public static Line findBestLine(Point[] points) {
        Line bestLine = null;
        int bestCount = 0;
        HashMap<Double, ArrayList<Line>> lineBySlope = new HashMap<Double, ArrayList<Line>>();

        for(int i = 0;i<points.length;i++) {
            for(int j = i+1;j<points.length;j++) {
                Line line = new Line(points[i],points[j]);
                insertLine(lineBySlope,line);
                int count = countEqualLines(lineBySlope,line);
                if(count>bestCount) {
                    bestCount = count;
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }
}