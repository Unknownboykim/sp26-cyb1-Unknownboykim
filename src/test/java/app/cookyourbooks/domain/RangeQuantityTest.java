package app.cookyourbooks.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RangeQuantityTest {

  private static final double DELTA = 1e-6;

  @Test
  void minMustBePositive() {
    assertThrows(IllegalArgumentException.class, () -> new RangeQuantity(0.0, 2.0, Unit.CUP));
  }

  @Test
  void maxMustBeGreaterThanMin() {
    assertThrows(IllegalArgumentException.class, () -> new RangeQuantity(2.0, 2.0, Unit.CUP));
  }

  @Test
  void toDecimalReturnsMidpoint() {
    RangeQuantity q = new RangeQuantity(2.0, 4.0, Unit.CUP);
    assertEquals(3.0, q.toDecimal(), DELTA);
  }

  @Test
  void toStringFormatsRange() {
    RangeQuantity q = new RangeQuantity(2.0, 3.5, Unit.CUP);
    assertEquals("2-3.5 cups", q.toString());
  }
}
