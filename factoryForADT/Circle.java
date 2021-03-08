package factoryForADT;

import java.util.Date;

// Circle class implementing Shape Interface
public class Circle implements Shape{
	private double radius;
	private Point origin;
	private Date timestamp;
	private final String type = "Circle";
	
	/**
	 * Constructor for create a Circle Object
	 * @param center
	 * 			Point object of the center of the circle.
	 * @param radius
	 * 			double radius of the circle
	 */
	public Circle(Point center, double radius){
		this.origin = center;
		this.radius = radius;
		this.timestamp = new Date();
	}
	
	public String getType(){
		return this.type;
	}
	
	public Date getTimestamp(){
		Date ts = new Date(timestamp.getTime());
		return ts;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Point getOrigin() {
		return origin;
	}
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	/**
	 * return the area of the circle.
	 */
	public double getArea(){
		return Math.PI * this.radius * this.radius;
	}
	
	/**
	 * return the perimeter of the circle.
	 */
	public double getPerimeter(){
		return Math.PI * 2 * this.radius;
	}
	
	/**
	 * Return boolean depending on the point is enclosed by the circle or not.
	 */
	public boolean isPointEnclose(Point point){
		double distance = Point.getDistance(origin, point);
		if(distance>this.radius){
			return false;
		}
		return true;
	}
	

}
