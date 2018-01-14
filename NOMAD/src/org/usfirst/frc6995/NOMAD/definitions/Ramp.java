package org.usfirst.frc6995.NOMAD.definitions;

public class Ramp {

	private Ramp() {}
	
	public static double sRamp(double number, double max, double rate) {
		double sinFunc = (Math.abs(max)/2)*(1+Math.sin((((1/Math.abs(rate))*number)*Math.PI)-(Math.PI/2)));
		if (number < 0) {
			return -sinFunc;
		}
		else if (number > 0) {
			return sinFunc;
		}
		return 0;
	}
	
	public static double pRamp(double number, double max, double rate) {
		double parbolaFunc = (rate/2)*Math.pow(number, 2);
		if (number < 0) {
			return -parbolaFunc;
		}
		else if (number > 0) {
			return parbolaFunc;
		}
		return 0;
	}
	
	public static void throwIfRampIsInvalid(double number, double max, double rate) throws IllegalArgumentException {
	    if (number > max || rate == 0) {
	      throw new IllegalArgumentException(String.format("number %f is invalid; valid ranges are %f. number %f is invalid it can not be 0", number, max, rate));
	    }
	}
}