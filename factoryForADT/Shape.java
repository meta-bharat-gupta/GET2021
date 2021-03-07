package factoryForADT;

import java.util.Date;


public interface Shape {
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclose(Point point);
	public String getType();
	public Date getTimestamp();
	public enum ShapeType{
		Triangle, Square, Rectangle, Circle, Polygon
	}
}
