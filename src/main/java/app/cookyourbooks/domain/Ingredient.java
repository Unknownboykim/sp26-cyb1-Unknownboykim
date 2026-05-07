package app.cookyourbooks.domain;

import org.jspecify.annotations.Nullable;

public abstract class Ingredient {

  private final String name;
  private @Nullable String preparation;
  private @Nullable String notes;

  protected Ingredient(String name, @Nullable String preparation, @Nullable String notes) {
    String trimmed = name.trim();
    if (trimmed.isBlank()) {
      throw new IllegalArgumentException();
    }
    this.name = trimmed;
    this.preparation = (preparation != null) ? preparation.trim() : null;
    this.notes = (notes != null) ? notes.trim() : null;
  }

  public String getName() {
    return name;
  }

  public @Nullable String getPreparation() {
    return preparation;
  }

  public @Nullable String getNotes() {
    return notes;
  }

  @Override
  public abstract String toString();
}
