package assignment06;

import net.jqwik.api.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class JqwikTests {

    @Property
    void factorialOfZeroIsOne() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Property
    void factorialIsAtLeastOne(@ForAll("positiveInts") int n) {
        assertTrue(Factorial.factorial(n) >= 1);
    }

    @Property
    void factorialOfNPlusOneIsGreater(@ForAll("positiveInts") int n) {
        if (n > 0 && n <= 12) {
            assertTrue(Factorial.factorial(n + 1) > Factorial.factorial(n));
        }
    }

    @Property
    void negativeNumberThrowsException(@ForAll int n) {
        if (n < 0) {
            assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(n));
        }
    }

    @Provide
    static Arbitrary<Integer> positiveInts() {
        return Arbitraries.integers().greaterOrEqual(1).lessOrEqual(12);
    }

    /***Question02****/
    @Property
    void nullInputThrows(@ForAll String input) {
        if (input == null) {
            assertThrows(IllegalArgumentException.class, () -> ToUpperCase.toUpperCase(input));
        }
    }

    @Property
    void convertsLowercase(@ForAll("alphabeticStrings") String input) {
        String result = ToUpperCase.toUpperCase(input);
        assertEquals(result, input.toUpperCase());
    }

    @Property
    void doesNotAffectUppercase(@ForAll("alphabeticStrings") String input) {
        String result = ToUpperCase.toUpperCase(input);
        assertTrue(result.equals(input) || result.equals(input.toUpperCase()));
    }

    @Property
    void emptyStringReturnsEmpty() {
        assertEquals("", ToUpperCase.toUpperCase(""));
    }

    @Property
    void outputLengthMatchesInput(@ForAll("alphabeticStrings") String input) {
        assertEquals(input.length(), ToUpperCase.toUpperCase(input).length());
    }

    @Property
    void nonAlphaCharsRemainUnchanged(@ForAll("alphabeticStrings") String input) {
        String result = ToUpperCase.toUpperCase(input);
        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);
            char resultChar = result.charAt(i);
            if (!Character.isAlphabetic(originalChar)) {
                assertEquals(originalChar, resultChar);
            }
        }
    }

    @Provide
    static Arbitrary<String> alphabeticStrings() {
        return Arbitraries.strings()
                .withCharRange('a', 'z')
                .withCharRange('A', 'Z')
                .ofLength(1);
    }
    
}
