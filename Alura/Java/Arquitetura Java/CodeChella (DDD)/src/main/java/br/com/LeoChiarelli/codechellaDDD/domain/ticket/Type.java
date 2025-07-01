package br.com.LeoChiarelli.codechellaDDD.domain.ticket;

import br.com.LeoChiarelli.codechellaDDD.application.ValidationException;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Area;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Definition;

public class Type { /// Event aggregate

    private final Area area;
    private final Definition definition;

    private final Double value;
    private int totalAvailable;

    private Type(Area area, Definition definition, Double value, int totalAvailable) {
        if (area == null || definition == null || value.isNaN() || value == 0 || totalAvailable == 0) { throw new ValidationException("All core type must be provided."); }
        this.area = area;
        this.definition = definition;
        this.value = value;
        this.totalAvailable = totalAvailable;
    }

    public static TypeBuilder builder() {
        return new TypeBuilder();
    }

    public Area getArea() {
        return area;
    }

    public Definition getDefinition() {
        return definition;
    }

    public Double getValue() {
        return value;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public static class TypeBuilder {
        private Area area;
        private Definition definition;

        private Double value;
        private int totalAvailable;

        public TypeBuilder() {}

        public TypeBuilder withArea(Area area) {
            this.area = area;
            return this;
        }

        public TypeBuilder withDefinition(Definition definition) {
            this.definition = definition;
            return this;
        }

        public TypeBuilder withValue(Double value) {
            this.value = value;
            return this;
        }

        public TypeBuilder withTotalAvailable(Integer totalAvailable) {
            this.totalAvailable = totalAvailable;
            return this;
        }

        public Type build() {
            if (area == null) { throw new ValidationException("Type area must not be null. "); }
            if (definition == null) { throw new ValidationException("Type area must not be null. "); }
            if (value == null || value.isNaN() || value == 0) { throw new ValidationException("Type area must not be null. "); }
            if (totalAvailable == 0) { throw new ValidationException("Type area must not be null. "); }

            return new Type(area, definition, value, totalAvailable);
        }
    }
}
