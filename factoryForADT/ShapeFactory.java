package factoryForADT;

import java.util.List;

import factoryForADT.Shape.ShapeType;


public class ShapeFactory {
	
	public static Shape createShape(ShapeType shapeType, Point origin, List<Integer> list){
		if(shapeType == null){
			return null;
		}
		if(shapeType.compareTo(ShapeType.Triangle)==0){
			return new Triangle(origin, list.get(0), list.get(1));
		}else if(shapeType.compareTo(ShapeType.Circle)==0){
			return new Circle(origin, list.get(0));
		}else if(shapeType.compareTo(ShapeType.Rectangle)==0){
			return new Rectangle(origin, list.get(0), list.get(1));
		}else if(shapeType.compareTo(ShapeType.Square)==0){
			return new Square(origin, list.get(0));
		}
		return null;
	}
}
