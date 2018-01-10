package org.usfirst.frc.team6995.robot.definitions;

public class Range {

  private Range() {}

  //scaling
  public static double scale(double n, double x1, double x2, double y1, double y2) {
    double a = (y1-y2)/(x1-x2);
    double b = y1 - x1*(y1-y2)/(x1-x2);
    return a*n+b;
  }

  //clipping
  public static double clip(double number, double min, double max) {
    if (number < min) return min;
    if (number > max) return max;
    return number;
  }

  //validation
  public static void throwIfRangeIsInvalid(double number, double min, double max) throws IllegalArgumentException {
    if (number < min || number > max) {
      throw new IllegalArgumentException(
          String.format("number %f is invalid; valid ranges are %f..%f", number, min, max));
    }
  }
}
