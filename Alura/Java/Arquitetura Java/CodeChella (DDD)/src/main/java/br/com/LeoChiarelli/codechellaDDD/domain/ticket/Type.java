package br.com.LeoChiarelli.codechellaDDD.domain.ticket;

public class Type {

    private Area area;
    private Definition definition;

    private Double valor;
    private int totalAvailable;

    private Type() {}

    public Type(Area area, Definition definition, Double valor, int totalAvailable) {
        this.area = area;
        this.definition = definition;
        this.valor = valor;
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
        return valor;
    }

    public void setValue(Double valor) {
        this.valor = valor;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }
}
