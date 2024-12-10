package aoc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Day02Tests {

  @Test
  void testCheckNumbersForNoMatchingPair() {
    int[] numbers = {1, 2, 3, 4, 5};
    boolean result = Day02.checkNumbersForMatchingPair(numbers);
    assertFalse(result);
  }

  @Test
  void testCheckNumbersForAMatchingPair() {
    int[] numbers = {1, 2, 2, 4, 5};
    boolean result = Day02.checkNumbersForMatchingPair(numbers);
    assertTrue(result);
  }

  @Test
  void testIsAscending() {
    int[] numbers = {1, 2, 3, 4, 5};
    boolean result = Day02.isAscending(numbers);
    assertTrue(result);
  }

  @Test
  void testIsAscendingReturnsFalse() {
    int[] numbers = {1, 2, 3, 1, 5};
    boolean result = Day02.isAscending(numbers);
    assertFalse(result);
  }

  @Test
  void testIsAscendingReturnsFalseIfNumberJumpsMoreThanThree() {
    int[] numbers = {1, 2, 3, 7, 8};
    boolean result = Day02.isAscending(numbers);
    assertFalse(result);
  }

  @Test
  void testIsDescending() {
    int[] numbers = {5, 4, 3, 2, 1};
    boolean result = Day02.isDescending(numbers);
    assertTrue(result);
  }

  @Test
  void testIsDescendingReturnsFalse() {
    int[] numbers = {5, 4, 5, 2, 1};
    boolean result = Day02.isDescending(numbers);
    assertFalse(result);
  }

  @Test
  void testIsDescendingReturnsFalseIfNumberJumpsMoreThanThree() {
    int[] numbers = {5, 4, -3, -4, -5};
    boolean result = Day02.isAscending(numbers);
    assertFalse(result);
  }


}