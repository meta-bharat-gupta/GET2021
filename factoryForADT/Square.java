package factoryForADT;

import java.util.Date;

// Square Class implementing Shape interface.
public class Square implements Shape{
	private int side;
	private Point origin;
	private Date timestamp;
	private final String type = "Square";
	
	public String getType(){
		return this.type;
	}
	
	public Square(Point point, int side){
		this.side = side;
		this.origin = point;
		this.timestamp = new Date();
	}
	
	public Date getTimestamp(){
		Date ts = new Date(timestamp.getTime());
		return ts;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public Point getOrigin() {
		return origin;
	}
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	
	/**
	 * Return the double type area of the shape.
	 */
	public double getArea(){
		return this.side * this.side;
	}
	
	/**
	 * Return the double type perimeter of the shape.
	 */
	public double getPerimeter(){
		return 4 * this.side;
	}
	
	/**
	 * Returns boolean value depending on the point is enclose by shape or not.
	 */
	public boolean isPointEnclose(Point point){
		if(point.getX()>=origin.getX() && point.getX()<=origin.getX()+side){
			if(point.getY()>=origin.getY() && point.getY()<=origin.getY()+side)
				return true;
		}
		return false;
	}
}
