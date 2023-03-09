package shagiev.dobryagin.functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArctgFunctionTest {

    ArctgFunction arctgFunction = new ArctgFunction();

    @ParameterizedTest
    @CsvSource({
            "-0.8, -0.67474",
            "-0.5, -0.46365",
            "-0.1, -0.09966",
            "0, 0",
            "0.5, 0.46365",
            "0.75, 0.64350"
    })
    void correct_calculate_inside_points_correct(double x, double answer) {
        assertTrue(Math.abs(arctgFunction.calculate(x, 100) - answer) < 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "-1, -0.78540",
            "1, 0.78540"
    })
    void calculate_border_points_correct(double x, double answer) {
        assertTrue(Math.abs(arctgFunction.calculate(x, 100) - answer) < 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "-0.99, -0.78037",
            "0.99, 0.78037"
    })
    void calculate_near_border_points_correct(double x, double answer) {
        assertTrue(Math.abs(arctgFunction.calculate(x, 100) - answer) < 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.1, -5, -100, 1.01, 41, 999})
    void calculate_outer_points_exception(double x) {
        assertThrows(IllegalArgumentException.class, () -> arctgFunction.calculate(x, 100));
    }
}