package br.com.LeoChiarelli.codechellaTDD.domain;

public class Address { // Value Object is a class where all of its attributes will compose if it's an object was equals other

    private String postalCode;
    private Integer number;
    private String complement;

    public Address() {}

    public Address(String postalCode, Integer number, String complement) {

        if (postalCode == null || !postalCode.matches("\\d{5}\\-\\d{3}")) {
            throw new IllegalArgumentException("Postal Code is null or doesn't match with the pattern");
        }

        this.postalCode = postalCode;
        this.number = number;
        this.complement = complement;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
