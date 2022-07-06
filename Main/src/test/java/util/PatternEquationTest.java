package util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import patternRegexp.PatternRegexp;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PatternEquationTest {

    @ParameterizedTest(name = "#{index} - Run test with equation = {0}")
    @MethodSource("equationExample")
    void EquationValidatorTest(String equation) {
        boolean result = equation.matches(PatternRegexp.patternEquation);
        assertTrue(result);
    }
    static Stream<String> equationExample() {
        return Stream.of(
                "4x^2+0x+1=0",
                "-4x^2+2x+1=0",
                "4x^2+2x+1=0",
                "ololo",
                "1111111",
                "111x^2+222x+335g3=0",
                "-4x^2-2x-1=0",
                "44x^2+2x+1=0",
                "111x^2-222x-333=0",
                "111x^2+222x+333=0",
                "5675.3243x^2-8x+12=0",
                "5675.3243x^2-88888.8888x+12=0",
                "5675.3243x^2-88888.8888x+999.9999=0",
                "bad test3"
        );
    }

    @Test
    void getFullEquation() {
    }

    @Test
    void getArgs() {
    }
}