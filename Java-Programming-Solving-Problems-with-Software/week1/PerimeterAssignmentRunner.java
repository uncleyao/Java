import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for (Point currPt : s.getPoints()) {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double average = getPerimeter(s)/getNumPoints(s);
        return average;
    }

    public double getLargestSide(Shape s) {
        double largest = 0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largest) largest = currDist;
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        for (Point currPt : s.getPoints()){
            double currX = currPt.getX();
            if (currX > largestX) largestX = currX;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            double perim = getPerimeter(shape);
            if (perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
                }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            double perim = getPerimeter(shape);
            if (perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
                }
        }
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("datatest4.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        // test num of point
        int numPoints = getNumPoints(s);
        // test average Length
        double avgLens = getAverageLength(s);
        // test largest length
        double lgLens = getLargestSide(s);
        // test largest X
        double lgX = getLargestX(s);
        System.out.println("Number of points = " + numPoints);
        System.out.println("perimeter = " + length);
        System.out.println("Average of length = " + avgLens);
        System.out.println("Largest side = " + lgLens);
        System.out.println("Largest X = " + lgX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " + largest);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest file is: " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
