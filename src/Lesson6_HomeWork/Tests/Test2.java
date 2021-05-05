package Lesson6_HomeWork.Tests;

import Lesson6_HomeWork.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test2 {
    @ParameterizedTest
    @NullAndEmptySource
    void ShouldThrowIllegalArgumentExceptionWhenEmptyArrayPassed(int[] emptyArray) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.checkArrayWithDigitsFourAndOne(emptyArray));
    }

    @ParameterizedTest
    @MethodSource("arraysForCheckWithDigitsOneOrFour")
    void ShouldReturnTrueIfInArrayAtLeastOneDigitFourOrDigitOne(int[] array) {
        Assertions.assertEquals(true, Main.checkArrayWithDigitsFourAndOne(array));
    }

    private static Stream<Arguments> arraysForCheckWithDigitsOneOrFour(){
        return Stream.of(Arguments.of(new int[] {1,5,7,9,12}),
                        Arguments.of(new int[] {8,3,4}),
                        Arguments.of(new int[] {1,2,7,9,3,5,4}));
    }



    @ParameterizedTest
    @MethodSource("arraysForCheckWithoutDigitsOneOrFour")
    void ShouldReturnFalseIfInArrayNoOneDigitFourOrDigitOne(int[] array){
        Assertions.assertEquals(false,Main.checkArrayWithDigitsFourAndOne(array));
    }

    private static Stream<Arguments> arraysForCheckWithoutDigitsOneOrFour(){
        return Stream.of(Arguments.of(new int[] {7,3,11,0}),
                Arguments.of(new int[] {9,2,5}),
                Arguments.of(new int[] {3,8,15,23,9}));
    }
}