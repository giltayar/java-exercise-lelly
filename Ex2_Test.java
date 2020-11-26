import java.util.Arrays;

class Ex2_Test {
    public static void main(String[] args) {
        assert Ex2.f(new double[] { 3, 4 }, 5) == 23;
        assert Ex2.f(new double[] { 3, 4, 2 }, 5) == 73;

        assert Ex2.poly(new double[] { 3, 4 }).equals("3.0 + 4.0x");
        assert Ex2.poly(new double[] { 3, 4, 5 }).equals("3.0 + 4.0x + 5.0x^2");

        assert Math.abs((Ex2.root(new double[] { 3, 4, 1 }, -4, -2.5, 0.01) - -3) / 2) <= 0.001;

        assert Arrays.equals(Ex2.add(new double[] { 1, 2 }, new double[] { 3, 4, 5 }), new double[] { 4, 6, 5 });

        assert Arrays.equals(Ex2.mul(new double[] { 2, 1 }, new double[] { 3, 4, 5 }),
                new double[] { 6, 11, 14, 5 });

        assert Arrays.equals(Ex2.derivative(new double[] {3, 4, 5}), new double[]{4, 10});
    }
}
