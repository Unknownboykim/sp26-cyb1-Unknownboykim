package app.cookyourbooks.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MeasuredIngredientTest {

  private static final double DELTA = 1e-6;

  @Test
  @DisplayName("Constructor stores quantity and getter returns it")
  void constructorStoresQuantity() {
    ExactQuantity q = new ExactQuantity(1.5, Unit.CUP);
    MeasuredIngredient m = new MeasuredIngredient("Sugar", q, null, null);
    assertSame(q, m.getQuantity());
  }

  @Test
  @DisplayName("toString without preparation omits comma and preparation")
  void toStringNoPreparation() {
    MeasuredIngredient m =
        new MeasuredIngredient("Flour", new ExactQuantity(2.0, Unit.CUP), null, null);
    assertEquals("2 cups Flour", m.toString());
  }

  @Test
  @DisplayName("toString with preparation includes preparation after comma")
  void toStringWithPreparation() {
    MeasuredIngredient m =
        new MeasuredIngredient("Flour", new ExactQuantity(2.0, Unit.CUP), "sifted", null);
    assertEquals("2 cups Flour, sifted", m.toString());
  }

  @Test
  @DisplayName("equals is case-insensitive on name and considers quantity/prep/notes")
  void equalsAndHashCodeBehavior() {
    ExactQuantity q1 = new ExactQuantity(1.0, Unit.CUP);
    ExactQuantity q2 = new ExactQuantity(2.0, Unit.CUP);

    MeasuredIngredient a = new MeasuredIngredient("Sugar", q1, "diced", "note");
    MeasuredIngredient b = new MeasuredIngredient("sugar", q1, "diced", "note");
    MeasuredIngredient c = new MeasuredIngredient("Sugar", q2, "diced", "note");

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());

    assertNotEquals(a, c);
  }
}
