package factoryForADT;

import java.util.Date;

public class Rectangle implements Shape{
	private int height;
	private int width;
	private Point origin;
	private Date timestamp;
	private final String type = "Rectangle";
	
	public String getType(){
		return this.type;
	}
	
	public Rectangle(Point point, int height, int width){
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	public double getArea(){
		return this.height * this.width;
	}
	
	public double getPerimeter(){
		return 2 * (this.height + this.width);
	}
	
	public boolean isPointEnclose(Point point){
		if(point.getX()>=origin.getX() && point.getX()<=origin.getX()+width){
			if(point.getY()>=origin.getY() && point.getY()<=origin.getY()+height)
				return true;
		}
		return false;
	}
}
