/**
 * Name: Rishika Gautam
 * Mrs. Kankelborg
 * Period 1
 * Project 2 Recursive Art Project Part 2: Sierpinski 
 * Last Updated: 10/19/22
 * 
 * Class Description:
 * Coded the Sierpinski triangle pattern recursively. Created a height method to calculate the
 * height of the triangles. Created a filledTriangle to create the filled triangles with input 
 * of the bottom x and y coordinates and the length of the triangle. Created the first sierpinski
 * method to create the large outside and unfilled triangle and calling the other sierpinski method
 * to recursively draw all the other triangles. In the recursive sierpinski method calling the 
 * method within itself to create smaller triangles inside of the triangle a specified number of times. 
 */

public class Sierpinski {
    
	/** 
	 * Takes an integer parameter of n and draws the outline of an equilateral 
     * triangle(pointed upwards) of length 1 whose bottom-left vertex is (0,0) and 
     * bottom-right vertex is (1,0) and then calls the overloaded version of sierpinski 
     * of order n that fits snugly inside the outline.
     */
    public static void sierpinski(int n)
    {
    	//create an array with x coordinate values of the large triangle on the outside
    	double[] xVal  = {0, 1, 0.5};
    	//create an array with y coordinate values of the large triangle on outside
    	double[] yVal = {0, 0, height(1)};
    	
    	//drawing the polygon - ensuring that it is not filled as it is a border
    	StdDraw.polygon(xVal, yVal);
    	
    	//calling the other sierpinski method to draw the trianlges inside of the large triangle
    	sierpinski(n, 0.5, 0, 0.5);
    }
    
    /**
     * Draws a Sierpinski triangle of order n, such that the largest filled
     * triangle has bottom vertex (x, y) and sides of the specified length.
     */
    private static void sierpinski(int n, double x, double y, double length)
    {
    	//if n is zero then there should be no triangles inside of the large triangle
    	if(n == 0) {
    		return; 
    	}

    	//alternating between filled and empty triangles
    	filledTriangle(x,y, length);
    	//recursive call to this method to create the triangle towards the top
    	sierpinski(n-1,x , y + height(length) , length/2 );
    	//recursive call to this method to create the triangle towards the right
    	sierpinski(n-1,x + (length/2), y, length/2);
    	//recursive call to this method to create the triangle towards the left
    	sierpinski(n-1, x - (length/2), y, length/2);
    }
    
	/**
	 * Calculates the height of an equilateral triangle whose sides are of the specified
	 * length.
	 */
    private static double height(double length)
    {
    	//calculating the height of the triangle by using the Pythagorean theorem
    	double height = length * (Math.sqrt(3)/2);
    	
    	return height;
    }

    /**
     * Draws a filled equilateral triangle whose bottom vertex is (x, y) and whose sides
     * are of the specified length.
     */
    private static void filledTriangle(double x, double y, double length)
    {
    	//creating new arrays to store the x and y coordinates of the triangle
    	double[] xVal = new double[3];
    	double[] yVal = new double[3];
    	
    	//defining the bottom vertex of the triangle
    	xVal[0] = x;
    	yVal[0] = y;
    	
    	//defining the top right vertex of the triangle
    	xVal[1] = (x+(length/2));
    	yVal[1] = (y+ height(length));
    	
    	//defining the top left vertex of the triangle
    	xVal[2] = (x-(length/2));
    	yVal[2] = (y+height(length));
    	
    	//drawing the polygon
    	StdDraw.filledPolygon(xVal, yVal);
    	 
    } 
}
