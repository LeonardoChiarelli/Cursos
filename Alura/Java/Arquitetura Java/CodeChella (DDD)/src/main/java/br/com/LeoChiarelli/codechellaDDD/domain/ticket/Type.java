package br.com.LeoChiarelli.codechellaDDD.domain.ticket;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Area;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Definition;

public class Type { /// Event aggregate

    private Area area;
    private Definition definition;

    private Double value;
    private int totalAvailable;

    private Type() {}

    public Type(Area area, Definition definition, Double value, int totalAvailable) {
        this.area = area;
        this.definition = definition;
        this.value = value;
        this.totalAvailable = totalAvailable;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double valor) {
        this.value = valor;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }
}
