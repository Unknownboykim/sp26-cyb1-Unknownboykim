package app.cookyourbooks.domain;

import java.text.DecimalFormat;

import org.jspecify.annotations.NonNull;

/** Quantity specified as a range. */
public final class RangeQuantity extends Quantity {

  public static final int DECIMAL_PRECISION = 3;
  private final double min;
  private final double max;

  public RangeQuantity(double min, double max, @NonNull Unit unit) {
    super(unit);
    if (min <= 0.0 || max <= min) {
      throw new IllegalArgumentException();
    }
    this.min = min;
    this.max = max;
  }

  public double getMin() {
    return min;
  }

  public double getMax() {
    return max;
  }

  @Override
  public double toDecimal() {
    return (min + max) / 2.0;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(DECIMAL_PRECISION);
    df.setMinimumFractionDigits(0);
    df.setGroupingUsed(false);

    return df.format(min) + "-" + df.format(max) + " " + getUnit().getPluralAbbreviation();
  }
}
