package app.cookyourbooks.domain;

import org.jspecify.annotations.NonNull;

/** Fractional quantity using mixed numbers. */
public final class FractionalQuantity extends Quantity {

  private final int whole;
  private final int numerator;
  private final int denominator;

  public FractionalQuantity(int whole, int numerator, int denominator, @NonNull Unit unit) {
    super(unit);

    if (whole < 0 || numerator < 0 || denominator <= 0) {
      throw new IllegalArgumentException();
    }
    if (whole == 0 && numerator == 0) {
      throw new IllegalArgumentException();
    }

    this.whole = whole;
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getWhole() {
    return whole;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  @Override
  public double toDecimal() {
    return whole + (numerator / (double) denominator);
  }

  @Override
  public String toString() {
    if (whole > 0 && numerator > 0) {
      return whole + " " + numerator + "/" + denominator + " " + getUnit().getPluralAbbreviation();
    }

    if (whole > 0) {
      if (whole == 1) {
        return "1 " + getUnit().getAbbreviation();
      }
      return whole + " " + getUnit().getPluralAbbreviation();
    }

    if (numerator == 1 && denominator == 1) {
      return "1 " + getUnit().getAbbreviation();
    }

    return numerator + "/" + denominator + " " + getUnit().getAbbreviation();
  }
}
