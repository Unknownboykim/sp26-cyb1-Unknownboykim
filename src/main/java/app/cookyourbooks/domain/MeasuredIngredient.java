package app.cookyourbooks.domain;

import java.util.Locale;
import java.util.Objects;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public final class MeasuredIngredient extends Ingredient {

  private final Quantity quantity;

  public MeasuredIngredient(
      @NonNull String name,
      @NonNull Quantity quantity,
      @Nullable String preparation,
      @Nullable String notes) {

    super(name, preparation, notes);
    this.quantity = quantity;
  }

  public Quantity getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    if (getPreparation() == null || getPreparation().isEmpty()) {
      return quantity + " " + getName();
    }
    return quantity + " " + getName() + ", " + getPreparation();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof MeasuredIngredient other)) {
      return false;
    }
    return getName().equalsIgnoreCase(other.getName())
        && Objects.equals(quantity, other.quantity)
        && Objects.equals(getPreparation(), other.getPreparation())
        && Objects.equals(getNotes(), other.getNotes());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName().toLowerCase(Locale.ROOT), quantity, getPreparation(), getNotes());
  }
}
