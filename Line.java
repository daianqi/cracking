import java.lang.Math;
import java.lang.Object;

public class Line {
    public static double epsilon = 0.0001;
    public double slope,intercept;
    private boolean infinite_slop = false;

    public Line(Point p, Point q) {
        if(Math.abs(p.x - q.x) > epsilon) {
            slope = (p.y - q.y)/(p.x - q.x);
            intercept = p.y - slope * p.x;
        } else {
            infinite_slop = true;
            intercept = p.x;
        }
    }

    public static double floorToNearestEpsilon(double d) {
        int i = (int)(d/epsilon);
        return ((double)i) * epsilon;
    }

    public boolean isEquivalent(double a, double b) {
        return Math.abs(a - b) < epsilon;
    }

    public boolean isEquivalent(Object o) {
        Line that = (Line) o;
        if(isEquivalent(that.slope,slope) && isEquivalent(that.intercept, intercept) && that.infinite_slop == infinite_slop) {
            return true;
        }
        return false;
    }
}
