package app.cookyourbooks.domain;

import org.jspecify.annotations.Nullable;

public final class VagueIngredient extends Ingredient {

  private final @Nullable String description;

  public VagueIngredient(
      String name,
      @Nullable String description,
      @Nullable String preparation,
      @Nullable String notes) {

    super(name, preparation, notes);
    this.description = description == null ? null : description.trim();
  }

  public @Nullable String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(getName());

    if (description != null && !description.isEmpty()) {
      sb.append(" (").append(description).append(")");
    }
    if (getPreparation() != null && !getPreparation().isEmpty()) {
      sb.append(", ").append(getPreparation());
    }
    return sb.toString();
  }
}
