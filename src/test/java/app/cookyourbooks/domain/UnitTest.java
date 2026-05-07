package app.cookyourbooks.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive tests for the Unit enum.
 *
 * @author Jonathan Bell
 */
class UnitTest {

  /** Provides test data for all units with their expected properties. */
  static Stream<Arguments> allUnitsWithProperties() {
    return Stream.of(
        // Imperial volume units
        Arguments.of(Unit.CUP, UnitSystem.IMPERIAL, UnitDimension.VOLUME, "cup", "cups"),
        Arguments.of(Unit.TABLESPOON, UnitSystem.IMPERIAL, UnitDimension.VOLUME, "tbsp", "tbsp"),
        Arguments.of(Unit.TEASPOON, UnitSystem.IMPERIAL, UnitDimension.VOLUME, "tsp", "tsp"),
        Arguments.of(Unit.FLUID_OUNCE, UnitSystem.IMPERIAL, UnitDimension.VOLUME, "fl oz", "fl oz"),
        // Imperial weight units
        Arguments.of(Unit.OUNCE, UnitSystem.IMPERIAL, UnitDimension.WEIGHT, "oz", "oz"),
        Arguments.of(Unit.POUND, UnitSystem.IMPERIAL, UnitDimension.WEIGHT, "lb", "lb"),
        // Metric volume units
        Arguments.of(Unit.MILLILITER, UnitSystem.METRIC, UnitDimension.VOLUME, "ml", "ml"),
        Arguments.of(Unit.LITER, UnitSystem.METRIC, UnitDimension.VOLUME, "L", "L"),
        // Metric weight units
        Arguments.of(Unit.GRAM, UnitSystem.METRIC, UnitDimension.WEIGHT, "g", "g"),
        Arguments.of(Unit.KILOGRAM, UnitSystem.METRIC, UnitDimension.WEIGHT, "kg", "kg"),
        // Count units
        Arguments.of(Unit.WHOLE, UnitSystem.HOUSE, UnitDimension.COUNT, "whole", "whole"),
        // House units
        Arguments.of(Unit.PINCH, UnitSystem.HOUSE, UnitDimension.OTHER, "pinch", "pinches"),
        Arguments.of(Unit.DASH, UnitSystem.HOUSE, UnitDimension.OTHER, "dash", "dashes"),
        Arguments.of(Unit.HANDFUL, UnitSystem.HOUSE, UnitDimension.OTHER, "handful", "handfuls"),
        Arguments.of(Unit.TO_TASTE, UnitSystem.HOUSE, UnitDimension.OTHER, "to taste", "to taste"));
  }

  @Test
  void testAllUnitsExist() {
    // Ensure all 15 units are defined
    Unit[] units = Unit.values();
    assertEquals(15, units.length, "Should have exactly 15 units defined");
  }

  @ParameterizedTest
  @EnumSource(Unit.class)
  void testGetSystemReturnsNonNull(Unit unit) {
    assertNotNull(unit.getSystem(), "getSystem() should never return null");
  }

  @ParameterizedTest
  @EnumSource(Unit.class)
  void testGetDimensionReturnsNonNull(Unit unit) {
    assertNotNull(unit.getDimension(), "getDimension() should never return null");
  }

  @ParameterizedTest
  @EnumSource(Unit.class)
  void testGetAbbreviationReturnsNonNull(Unit unit) {
    assertNotNull(unit.getAbbreviation(), "getAbbreviation() should never return null");
  }

  @ParameterizedTest
  @EnumSource(Unit.class)
  void testGetPluralAbbreviationReturnsNonNull(Unit unit) {
    assertNotNull(unit.getPluralAbbreviation(), "getPluralAbbreviation() should never return null");
  }

  @ParameterizedTest
  @MethodSource("allUnitsWithProperties")
  void testUnitHasCorrectSystem(
      Unit unit,
      UnitSystem expectedSystem,
      UnitDimension expectedDimension,
      String expectedAbbreviation,
      String expectedPluralAbbreviation) {
    assertEquals(expectedSystem, unit.getSystem(), "Unit " + unit + " has incorrect system");
  }

  @ParameterizedTest
  @MethodSource("allUnitsWithProperties")
  void testUnitHasCorrectDimension(
      Unit unit,
      UnitSystem expectedSystem,
      UnitDimension expectedDimension,
      String expectedAbbreviation,
      String expectedPluralAbbreviation) {
    assertEquals(
        expectedDimension, unit.getDimension(), "Unit " + unit + " has incorrect dimension");
  }

  @ParameterizedTest
  @MethodSource("allUnitsWithProperties")
  void testUnitHasCorrectAbbreviation(
      Unit unit,
      UnitSystem expectedSystem,
      UnitDimension expectedDimension,
      String expectedAbbreviation,
      String expectedPluralAbbreviation) {
    assertEquals(
        expectedAbbreviation,
        unit.getAbbreviation(),
        "Unit " + unit + " has incorrect abbreviation");
  }

  @ParameterizedTest
  @MethodSource("allUnitsWithProperties")
  void testUnitHasCorrectPluralAbbreviation(
      Unit unit,
      UnitSystem expectedSystem,
      UnitDimension expectedDimension,
      String expectedAbbreviation,
      String expectedPluralAbbreviation) {
    assertEquals(
        expectedPluralAbbreviation,
        unit.getPluralAbbreviation(),
        "Unit " + unit + " has incorrect plural abbreviation");
  }

  @Test
  void testImperialSystemHasExpectedUnits() {
    Set<Unit> expectedImperialUnits =
        Set.of(Unit.CUP, Unit.TABLESPOON, Unit.TEASPOON, Unit.FLUID_OUNCE, Unit.OUNCE, Unit.POUND);
    Set<Unit> actualImperialUnits =
        Stream.of(Unit.values())
            .filter(u -> u.getSystem() == UnitSystem.IMPERIAL)
            .collect(Collectors.toSet());
    assertEquals(
        expectedImperialUnits,
        actualImperialUnits,
        "IMPERIAL system should have exactly these units");
  }

  @Test
  void testMetricSystemHasExpectedUnits() {
    Set<Unit> expectedMetricUnits = Set.of(Unit.MILLILITER, Unit.LITER, Unit.GRAM, Unit.KILOGRAM);
    Set<Unit> actualMetricUnits =
        Stream.of(Unit.values())
            .filter(u -> u.getSystem() == UnitSystem.METRIC)
            .collect(Collectors.toSet());
    assertEquals(
        expectedMetricUnits, actualMetricUnits, "METRIC system should have exactly these units");
  }

  @Test
  void testHouseSystemHasExpectedUnits() {
    Set<Unit> expectedHouseUnits =
        Set.of(Unit.PINCH, Unit.DASH, Unit.HANDFUL, Unit.TO_TASTE, Unit.WHOLE);
    Set<Unit> actualHouseUnits =
        Stream.of(Unit.values())
            .filter(u -> u.getSystem() == UnitSystem.HOUSE)
            .collect(Collectors.toSet());
    assertEquals(
        expectedHouseUnits, actualHouseUnits, "HOUSE system should have exactly these units");
  }

  @Test
  void testWeightDimensionHasExpectedUnits() {
    Set<Unit> expectedWeightUnits = Set.of(Unit.OUNCE, Unit.POUND, Unit.GRAM, Unit.KILOGRAM);
    Set<Unit> actualWeightUnits =
        Stream.of(Unit.values())
            .filter(u -> u.getDimension() == UnitDimension.WEIGHT)
            .collect(Collectors.toSet());
    assertEquals(
        expectedWeightUnits, actualWeightUnits, "WEIGHT dimension should have exactly these units");
  }

  @Test
  void testVolumeDimensionHasExpectedUnits() {
    Set<Unit> expectedVolumeUnits =
        Set.of(
            Unit.CUP,
            Unit.TABLESPOON,
            Unit.TEASPOON,
            Unit.FLUID_OUNCE,
            Unit.MILLILITER,
            Unit.LITER);
    Set<Unit> actualVolumeUnits =
        Stream.of(Unit.values())
            .filter(u -> u.getDimension() == UnitDimension.VOLUME)
            .collect(Collectors.toSet());
    assertEquals(
        expectedVolumeUnits, actualVolumeUnits, "VOLUME dimension should have exactly these units");
  }

  @Test
  void testCountDimensionHasExpectedUnits() {
    Set<Unit> expectedCountUnits = Set.of(Unit.WHOLE);
    Set<Unit> actualCountUnits =
        Stream.of(Unit.values())
            .filter(u -> u.getDimension() == UnitDimension.COUNT)
            .collect(Collectors.toSet());
    assertEquals(
        expectedCountUnits, actualCountUnits, "COUNT dimension should have exactly these units");
  }

  @Test
  void testOtherDimensionHasExpectedUnits() {
    Set<Unit> expectedOtherUnits = Set.of(Unit.PINCH, Unit.DASH, Unit.HANDFUL, Unit.TO_TASTE);
    Set<Unit> actualOtherUnits =
        Stream.of(Unit.values())
            .filter(u -> u.getDimension() == UnitDimension.OTHER)
            .collect(Collectors.toSet());
    assertEquals(
        expectedOtherUnits,
        actualOtherUnits,
        "OTHER dimension should have exactly these units (house units)");
  }
}
