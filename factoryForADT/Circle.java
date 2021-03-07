package factoryForADT;

import java.util.Date;


public class Circle implements Shape{
	private double radius;
	private Point origin;
	private Date timestamp;
	private final String type = "Circle";
	
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
	
	public double getArea(){
		return Math.PI * this.radius * this.radius;
	}
	
	public double getPerimeter(){
		return Math.PI * 2 * this.radius;
	}
	
	public boolean isPointEnclose(Point point){
		double distance = Point.getDistance(origin, point);
		if(distance>this.radius){
			return false;
		}
		return true;
	}
	

}
