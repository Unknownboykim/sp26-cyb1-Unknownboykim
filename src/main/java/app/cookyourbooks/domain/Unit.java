package app.cookyourbooks.domain;

public enum Unit {
  CUP(UnitSystem.IMPERIAL, UnitDimension.VOLUME, "cup", "cups"),
  TABLESPOON(UnitSystem.IMPERIAL, UnitDimension.VOLUME, "tbsp", "tbsp"),
  TEASPOON(UnitSystem.IMPERIAL, UnitDimension.VOLUME, "tsp", "tsp"),
  FLUID_OUNCE(UnitSystem.IMPERIAL, UnitDimension.VOLUME, "fl oz", "fl oz"),

  OUNCE(UnitSystem.IMPERIAL, UnitDimension.WEIGHT, "oz", "oz"),
  POUND(UnitSystem.IMPERIAL, UnitDimension.WEIGHT, "lb", "lb"),

  MILLILITER(UnitSystem.METRIC, UnitDimension.VOLUME, "ml", "ml"),
  LITER(UnitSystem.METRIC, UnitDimension.VOLUME, "L", "L"),

  GRAM(UnitSystem.METRIC, UnitDimension.WEIGHT, "g", "g"),
  KILOGRAM(UnitSystem.METRIC, UnitDimension.WEIGHT, "kg", "kg"),

  PINCH(UnitSystem.HOUSE, UnitDimension.OTHER, "pinch", "pinches"),
  DASH(UnitSystem.HOUSE, UnitDimension.OTHER, "dash", "dashes"),
  HANDFUL(UnitSystem.HOUSE, UnitDimension.OTHER, "handful", "handfuls"),
  TO_TASTE(UnitSystem.HOUSE, UnitDimension.OTHER, "to taste", "to taste"),

  WHOLE(UnitSystem.HOUSE, UnitDimension.COUNT, "whole", "whole");

  private final UnitSystem system;
  private final UnitDimension dimension;
  private final String abbreviation;
  private final String pluralAbbreviation;

  Unit(UnitSystem system, UnitDimension dimension, String abbreviation, String pluralAbbreviation) {
    this.system = system;
    this.dimension = dimension;
    this.abbreviation = abbreviation;
    this.pluralAbbreviation = pluralAbbreviation;
  }

  public UnitSystem getSystem() {
    return system;
  }

  public UnitDimension getDimension() {
    return dimension;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public String getPluralAbbreviation() {
    return pluralAbbreviation;
  }
}
