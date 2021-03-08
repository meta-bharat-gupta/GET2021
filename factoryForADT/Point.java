package factoryForADT;

// Point class to store coordinates
public class Point {
	int X;
	int Y;
	
	Point(int x, int y){
		this.X = x;
		this.Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
	public static double getDistance(Point A, Point B){
		double distance;
		distance = Math.pow((A.getX() - B.getX()), 2) + Math.pow((A.getY() - B.getY()), 2);
		distance = Math.pow(distance, 0.5);
		return distance;
	}
}
