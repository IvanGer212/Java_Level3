package Lesson6_HomeWork.Tests;

import Lesson6_HomeWork.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class Test1 {
    @ParameterizedTest
    @NullAndEmptySource
    void ShouldThrowIllegalArgumentExceptionWhenEmptyArrayPassed(int[] emptyArray){
        Assertions.assertThrows(IllegalArgumentException.class, ()->Main.extractAfterLastFour(emptyArray));
    }

    @ParameterizedTest
    @MethodSource("validArrayParameterProvider")
    void ShouldThrowRuntimeExceptionWhenEmptyArrayPassed(int[] inputArray, int[] expectedArray){
        Assertions.assertArrayEquals(expectedArray, Main.extractAfterLastFour(inputArray));
    }

    private static Stream<Arguments> validArrayParameterProvider(){
        return Stream.of(
                Arguments.of(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[] {1,7}),
                Arguments.of(new int[] {1, 2, 4, 4, 2, 3, 5, 1, 7}, new int[] {2, 3, 5, 1, 7}),
                Arguments.of(new int[] {4, 1}, new int[] {1})
                );
    }

    @Test
    void ShouldThrowRuntimeExceptionWhenInArrayNoFourth(){
        Assertions.assertThrows(RuntimeException.class, ()->Main.extractAfterLastFour(new int[] {2}));
    }
}
