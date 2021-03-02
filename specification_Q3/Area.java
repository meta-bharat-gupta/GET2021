package specification_Q3;

public class Area {

	/**
	 * To calculate the area of a triangle.
	 * 
	 * @param width
	 *            double value of width of the triangle greater than zero.
	 * @param height
	 *            double value of height of the triangle greater than zero.
	 * @return double value of the area of the triangle.
	 */
	public static double triangleArea(double width, double height) {
		double triArea = (width * height) / 2;
		return triArea;
	}

	/**
	 * To calculate the area of a Rectangle.
	 * 
	 * @param width
	 *            double value of width of the rectangle greater than zero.
	 * @param height
	 *            double value of height of the rectangle greater than zero.
	 * @return double value of the area of the rectangle.
	 */
	public static double rectangleArea(double width, double height) {
		double rectArea = width * height;
		return rectArea;
	}

	/**
	 * To calculate the area of a square.
	 * 
	 * @param side
	 *            double value of side of the square greater than zero.
	 * @return double value of the area of the square.
	 */
	public static double squareArea(double side) {
		double sqArea = side * side;
		return sqArea;
	}

	/**
	 * To calculate area of the circle.
	 * 
	 * @param radius
	 *            double value of the radius of the circle greater than zero.
	 * @return double value of the area of the circle.
	 */
	public static double circleArea(double radius) {
		double cirArea = Math.PI * radius * radius;
		return cirArea;
	}
}
