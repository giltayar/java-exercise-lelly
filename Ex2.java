/**
 * Ex2
 */
public class Ex2 {
  // f(x)
  public static double f(double[] poly, double x) {
    double result = 0;

    for (int i = 0; i < poly.length; ++i) {
      result += poly[i] * Math.pow(x, i);
    }
    return result;
  }

  // returns a String // representing the poly polynom.
  public static String poly(double[] poly) {
    String result = "";

    for (int i = 0; i < poly.length; ++i) {
      if (i > 0) {
        result += " + ";
      }

      result += poly[i];

      if (i == 1) {
        result += "x";
      } else if (i > 1) {
        result += "x^" + i;
      }
    }

    return result;
  }

  // returns a value (x) such that |f(p,x)|<=eps,
  public static double root(double[] p, double a, double b, double eps) {
    int NMAX = 500;

    // limit iterations to prevent infinite loop
    for (int i = 0; i <= NMAX; ++i) {
      // new midpoint
      double c = (a + b) / 2;

      if (Ex2.f(p, c) == 0 || (b - a) / 2 < eps) {
         // solution found
        return c;
      }

      // new interval
      if (Ex2.sign(f(p, c)) == Ex2.sign(f(p, a))) {
        a = c;
      } else {
        b = c;
      }
    }

    throw new Error("could not find root");
  }

  // returns a new array representing the polynom of p1+p2
  public static double[] add(double[] p1, double[] p2) {
    int maxLength = Math.max(p1.length, p2.length);

    double ret[] = new double[maxLength];

    for (int i = 0; i < maxLength; ++i) {
      ret[i] = i < p1.length ? p1[i] : 0;
      ret[i] += i < p2.length ? p2[i] : 0;
    }

    return ret;
  }

  // returns a new array representing the polynom of (p1)*(p2)
  public static double[] mul(double[] p1, double[] p2) {
    double ret[] = new double[p1.length + p2.length - 1];

    for (int i1 = 0; i1 < p1.length; ++i1) {
      for (int i2 = 0; i2 < p2.length; ++i2) {
        int i = i1 + i2;
        ret[i] += (i1 < p1.length ? p1[i1] : 0) * (i2 < p2.length ? p2[i2] : 0);
      }
    }

    return ret;
  }

  public static double[] derivative(double[] po) {
    double ret[] = new double[po.length - 1];

    for (int i = 1; i < po.length; ++i) {
      ret[i - 1] = po[i] * i;
    }

    return ret;
  }

  private static double sign(double x) {
    if (x  > 0) return 1;

    if (x < 0) return -1;

    return 0;
  }
}
