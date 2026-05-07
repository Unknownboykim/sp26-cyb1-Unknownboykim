package app.cookyourbooks.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VagueIngredientTest {

  @Test
  void blankNameThrows() {
    assertThrows(IllegalArgumentException.class, () -> new VagueIngredient("  ", null, null, null));
  }

  @Test
  void nameOnly() {
    VagueIngredient v = new VagueIngredient("water", null, null, null);
    assertEquals("water", v.toString());
  }

  @Test
  void nameAndDescription() {
    VagueIngredient v = new VagueIngredient("salt", "to taste", null, null);
    assertEquals("salt (to taste)", v.toString());
  }

  @Test
  void nameAndPreparation() {
    VagueIngredient v = new VagueIngredient("tomatoes", null, "diced", null);
    assertEquals("tomatoes, diced", v.toString());
  }

  @Test
  void fullFormatting() {
    VagueIngredient v = new VagueIngredient("pepper", "freshly ground", "coarsely chopped", null);

    assertEquals("pepper (freshly ground), coarsely chopped", v.toString());
  }
}
