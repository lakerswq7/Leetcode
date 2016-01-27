package datastructure.hashmap;
import java.util.HashMap;
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        int max = 0;
        HashMap<Double, Integer> lines;
        for (int i = 0; i < points.length; i++) {
            lines = new HashMap<Double, Integer>();
            int dup = 1;
            double slope;
            for (int j = i + 1; j < points.length; j++) {
                if ((points[i].x == points[j].x) && (points[i].y == points[j].y)) {
                    dup++;
                    continue;
                }
                if (points[i].x == points[j].x) {
                    slope = Double.MAX_VALUE;
                } else if (points[i].y == points[j].y) {
                	//同一条横线上，这里注意 0.0 与 -0.0
                    slope = 0;
                } else {
                    slope = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                }
                if (lines.containsKey(slope)) {
                    lines.put(slope, lines.get(slope) + 1);
                } else {
                    lines.put(slope, 1);
                }
            }
            max = Math.max(dup, max);
            for (int num : lines.values()) {
                max = Math.max(max, dup + num);
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
    	Point[] points = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
    	MaxPointsOnALine solution = new MaxPointsOnALine();
    	int result = solution.maxPoints(points);
    	System.out.println(result);
    }
}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
