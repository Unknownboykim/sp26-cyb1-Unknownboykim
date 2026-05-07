package app.cookyourbooks.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FractionalQuantityTest {

  private static final double DELTA = 1e-6;

  @Test
  void negativeWholeThrows() {
    assertThrows(IllegalArgumentException.class, () -> new FractionalQuantity(-1, 1, 2, Unit.CUP));
  }

  @Test
  void negativeNumeratorThrows() {
    assertThrows(IllegalArgumentException.class, () -> new FractionalQuantity(0, -1, 2, Unit.CUP));
  }

  @Test
  void zeroDenominatorThrows() {
    assertThrows(IllegalArgumentException.class, () -> new FractionalQuantity(1, 1, 0, Unit.CUP));
  }

  @Test
  void zeroWholeAndNumeratorThrows() {
    assertThrows(IllegalArgumentException.class, () -> new FractionalQuantity(0, 0, 3, Unit.CUP));
  }

  @Test
  void toDecimalMixedNumber() {
    FractionalQuantity q = new FractionalQuantity(2, 1, 4, Unit.CUP);
    assertEquals(2.25, q.toDecimal(), DELTA);
  }

  @Test
  void toStringMixedNumber() {
    FractionalQuantity q = new FractionalQuantity(2, 1, 3, Unit.CUP);
    assertEquals("2 1/3 cups", q.toString());
  }

  @Test
  void toStringWholeOne() {
    FractionalQuantity q = new FractionalQuantity(1, 0, 5, Unit.CUP);
    assertEquals("1 cup", q.toString());
  }

  @Test
  void toStringProperFraction() {
    FractionalQuantity q = new FractionalQuantity(0, 1, 2, Unit.CUP);
    assertEquals("1/2 cup", q.toString());
  }
}
