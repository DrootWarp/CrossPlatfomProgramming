package application.logic.arithmetic;

public class Coordinates {
	
	private double xCoordinate;
	private double yCoordinate;
	
	public Coordinates() {
	
		xCoordinate = 0.0;
		yCoordinate = 0.0;
		
	}
	
	public double getDistance() {
		
		return Math.sqrt(xCoordinate * xCoordinate + yCoordinate * yCoordinate );
		
	}
	
	public double getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public double getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	
	

}
