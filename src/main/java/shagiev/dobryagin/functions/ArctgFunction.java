package shagiev.dobryagin.functions;

public class ArctgFunction {

    public double calculate(double x, int iterationsCount) {
        if (x > 1 || x < -1) throw new IllegalArgumentException("arctg argument should be in [-1; 1]");
        double sum = 0;
        for (int i = 0; i < iterationsCount; i++) {
            sum += Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / (2 * i + 1);
        }
        return sum;
    }
}
