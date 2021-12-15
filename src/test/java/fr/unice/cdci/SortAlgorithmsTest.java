package fr.unice.cdci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Mireille Blay-Fornarino
 * Inspired by https://junit.org/junit5/docs/current/user-guide/
 * 21 sept. 2019
 */
@ExtendWith(TimingExtension.class)
class SortAlgorithmsTest {

    @BeforeEach
    void setUp() throws Exception {
    }


    @DisplayName("Should sort correctly an empty array")
    @Test
    void isWellSortedEmptyArray() {
        Integer[] arrayToTest = new Integer[0];
        testSortingAlgorithm(arrayToTest);
    }

    @DisplayName("Should sort correctly arrays")
    @Test
    void isWellSorted() {
        Integer[] arrayToTest = new Integer[]{1, 3, 5, -3, 15, Integer.MAX_VALUE};
        testSortingAlgorithm(arrayToTest);
        arrayToTest = new Integer[]{0, 1, 3, 5, -3, 15, 20, -10, 100, 1000, Integer.MAX_VALUE};
        testSortingAlgorithm(arrayToTest);
        arrayToTest = new Integer[]{-1, -3, -5, -7, Integer.MAX_VALUE};
        testSortingAlgorithm(arrayToTest);
    }

    @DisplayName("Should sort correctly large arrays")
    @Test
    void isWellSortedLargeArrays() {
        int maxSize = 50000;
        Integer[] arrayToTest = new Integer[maxSize + 1];
        for (int i = maxSize; i >= 0; i--)
            arrayToTest[maxSize - i] = i;
        testSortingAlgorithm(arrayToTest);
        testSortingAlgorithm(arrayToTest);
    }

    /*@DisplayName("Should fail : to test Continuous Integration")
    @Test
    void badTest() {
        Integer[] input = new Integer[]{1, 3, 5, -3, 15, Integer.MAX_VALUE};
        //Forget to sort the array :
        //SortAlgorithms.bubbleSort(input);
        int valueToTest = input[input.length / 2];
        assertTrue(input[0] <= valueToTest);
        assertTrue(valueToTest <= input[input.length - 1]);
    }*/

    void testSortingAlgorithm(Integer[] input) {
        int length = input.length;
        SortAlgorithms.bubbleSort(input);
        if (length == 0) {
            assertTrue(input.length == 0);
            return;
        }
        int valueToTest = input[input.length / 2];
        assertTrue(input[0] <= valueToTest);
        assertTrue(valueToTest <= input[input.length - 1]);
    }


    @TestFactory
    Stream<DynamicTest> generateTestsForSortingAlgorithms() {
        // Generates random positive integers arrays 
        Iterator<Integer[]> inputGenerator = new Iterator<Integer[]>() {
            static final int MAX_SIZE = 10000;
            int numberOfTests = 5;//10000;
            Random random = new Random();
            Integer[] current;


            @Override
            public boolean hasNext() {
                if (numberOfTests <= 0) return false;
                int arraySize = random.nextInt(MAX_SIZE);
                current = new Integer[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    current[i] = random.nextInt();
                }
                numberOfTests--;
                return true;
            }

            @Override
            public Integer[] next() {
                return current;
            }
        };

        // Generates display names like: input:5 where 5 is the array's length
        Function<Integer[], String> displayNameGenerator = (input) -> "input: " + input.length;

        // Executes tests based on the current input value.
        ThrowingConsumer<Integer[]> testExecutor = (input) -> testSortingAlgorithm(input);

        // Returns a stream of dynamic tests
        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }


}
