package app.cookyourbooks.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExactQuantityTest {

  private static final double DELTA = 1e-6;

  @Test
  @DisplayName("Constructor rejects zero amount")
  void zeroAmountThrows() {
    assertThrows(IllegalArgumentException.class, () -> new ExactQuantity(0.0, Unit.CUP));
  }

  @Test
  @DisplayName("Constructor rejects negative amount")
  void negativeAmountThrows() {
    assertThrows(IllegalArgumentException.class, () -> new ExactQuantity(-2.5, Unit.CUP));
  }

  @Test
  @DisplayName("Constructor accepts positive amount")
  void positiveAmountAllowed() {
    ExactQuantity q = new ExactQuantity(2.5, Unit.CUP);
    assertEquals(2.5, q.getAmount(), DELTA);
  }

  @Test
  @DisplayName("toDecimal returns the exact amount")
  void toDecimalReturnsAmount() {
    ExactQuantity q = new ExactQuantity(3.75, Unit.CUP);
    assertEquals(3.75, q.toDecimal(), DELTA);
  }

  @Test
  @DisplayName("toString uses singular unit when amount is exactly 1.0")
  void toStringSingular() {
    ExactQuantity q = new ExactQuantity(1.0, Unit.CUP);
    assertEquals("1 cup", q.toString());
  }

  @Test
  @DisplayName("toString uses plural unit when amount is not 1.0")
  void toStringPlural() {
    ExactQuantity q = new ExactQuantity(2.0, Unit.CUP);
    assertEquals("2 cups", q.toString());
  }

  @Test
  @DisplayName("toString trims trailing zeros")
  void toStringTrimsZeros() {
    ExactQuantity q = new ExactQuantity(2.50, Unit.CUP);
    assertEquals("2.5 cups", q.toString());
  }

  @Test
  @DisplayName("toString omits decimal point for whole numbers")
  void toStringWholeNumber() {
    ExactQuantity q = new ExactQuantity(4.0, Unit.CUP);
    assertEquals("4 cups", q.toString());
  }

  @Test
  @DisplayName("toString limits decimal places to DECIMAL_PRECISION")
  void toStringLimitsPrecision() {
    ExactQuantity q = new ExactQuantity(1.23456, Unit.CUP);
    assertEquals("1.235 cups", q.toString());
  }
}
