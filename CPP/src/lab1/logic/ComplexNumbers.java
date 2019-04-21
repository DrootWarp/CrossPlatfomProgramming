package lab1.logic;

public final class ComplexNumbers {

	public ComplexNumbers() {
		
	}
	
	public static double countModule(double realNumber,double imaginaryNumber) {
		return Math.sqrt(realNumber*realNumber + imaginaryNumber*imaginaryNumber);
	}
	
	public static double countPhase(double realNumber,double imaginaryNumber) {
		
		return Math.atan(realNumber/imaginaryNumber);
		
	}
}

