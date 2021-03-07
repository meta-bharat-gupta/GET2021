package factoryForADT;

import java.util.Date;

public class Triangle implements Shape{
	private Point origin;
	private int width;
	private int height;
	private Date timestamp;
	private final String type = "Trianlge";
	
	public String getType(){
		return this.type;
	}
	
	public Triangle(Point point, int height, int width){
		this.height = height;
		this.width = width;
		this.origin = point;
		this.timestamp = new Date();
	}
	
	public Date getTimestamp(){
		Date ts = new Date(timestamp.getTime());
		return ts;
	}
	
	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getArea(){
		return (this.width * this.height)/2.0;
	}
	
	public double getPerimeter(){
		Point secondPoint = new Point(origin.getX()+width, origin.getY());
		Point thirdPoint = new Point(origin.getX(), origin.getY()+height);
		double perimeter = Point.getDistance(origin, secondPoint) + Point.getDistance(secondPoint, thirdPoint) + Point.getDistance(origin, thirdPoint);
		return perimeter;
	}
	
	private double area(int x1, int y1, int x2, int y2, int x3, int y3){
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
	}
	
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
