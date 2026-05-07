package app.cookyourbooks.domain;

import org.jspecify.annotations.NonNull;

public abstract class Quantity {
  private final Unit unit;

  protected Quantity(@NonNull Unit unit) {
    this.unit = unit;
  }

  public Unit getUnit() {
    return unit;
  }

  public abstract double toDecimal();

  @Override
  public abstract String toString();
}
