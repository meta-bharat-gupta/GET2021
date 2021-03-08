package factoryForADT;

import java.util.Date;


// Triangle class by implementing Shape interface
public class Triangle implements Shape{
	private Point origin;
	private int width;
	private int height;
	private Date timestamp;
	private final String type = "Trianlge";
	
	/**
	 * Returns the type of the shape
	 */
	public String getType(){
		return this.type;
	}
	
	/**
	 * Constructor for Triangle creation. Assumed as Right Angle triangle.
	 * @param point
	 * 			Point object of origin point for the triangle
	 * @param height
	 * 			integer height of the triangle
	 * @param width
	 * 			integer width of the triangle
	 */
	public Triangle(Point point, int height, int width){
		this.height = height;
		this.width = width;
		this.origin = point;
		this.timestamp = new Date();
	}
	
	/**
	 * To get the time when the object is created.
	 */
	public Date getTimestamp(){
		Date ts = new Date(timestamp.getTime());
		return ts;
	}
	
	/**
	 * To get the Origin of the Shape.
	 */
	public Point getOrigin() {
		return origin;
	}

	/**
	 * To set the origin of the shape.
	 * @param origin
	 * 		Point object as new origin.
	 */
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	/**
	 * To get width of the shape.
	 * @return integer
	 * 		returns the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * To set the width of the shape.
	 * @param width
	 * 		integer width to set new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * To get the height of the shape.
	 * @return integer
	 * 		height of the shape.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set height of the shape.
	 * @param height
	 * 		integer height.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * This function returns the area of the shape.
	 */
	public double getArea(){
		return (this.width * this.height)/2.0;
	}
	
	/**
	 * This function returns the perimeter of the shape.
	 */
	public double getPerimeter(){
		Point secondPoint = new Point(origin.getX()+width, origin.getY());
		Point thirdPoint = new Point(origin.getX(), origin.getY()+height);
		double perimeter = Point.getDistance(origin, secondPoint) + Point.getDistance(secondPoint, thirdPoint) + Point.getDistance(origin, thirdPoint);
		return perimeter;
	}
	

	private double area(int x1, int y1, int x2, int y2, int x3, int y3){
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
	}
	
	/**
	 * This function tells whether the point is enclosed by the shape or not.
	 */
	public boolean isPointEnclose(Point point){
		Point pointA = new Point(origin.getX()+width, origin.getY());
		Point pointB = new Point(origin.getX()+(width/2), origin.getY()+height);
		double totalArea = area(origin.getX(), origin.getY(), pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY());
		double area1 = area(origin.getX(), origin.getY(), pointA.getX(), pointA.getY(), point.getX(), point.getY());
		double area2 = area(origin.getX(), origin.getY(), point.getX(), point.getY(), pointB.getX(), pointB.getY());
		double area3 = area(point.getX(), point.getY(), pointA.getX(), pointB.getY(), pointB.getX(), pointB.getY());
		if((area1 + area2 + area3) == totalArea){
			return true;
		}
		return false;
	}
}
