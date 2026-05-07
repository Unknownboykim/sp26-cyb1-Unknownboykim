package app.cookyourbooks.domain;

import java.text.DecimalFormat;

import org.jspecify.annotations.NonNull;

public final class ExactQuantity extends Quantity {

  public static final int DECIMAL_PRECISION = 3;
  private final double amount;

  public ExactQuantity(double amount, @NonNull Unit unit) {
    super(unit);
    if (amount <= 0.0) {
      throw new IllegalArgumentException();
    }
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public double toDecimal() {
    return amount;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(DECIMAL_PRECISION);
    df.setMinimumFractionDigits(0);
    df.setGroupingUsed(false);

    String formatted = df.format(amount);
    if (amount == 1.0) {
      return formatted + " " + getUnit().getAbbreviation();
    }
    return formatted + " " + getUnit().getPluralAbbreviation();
  }
}
