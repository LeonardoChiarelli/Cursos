package br.com.LeoChiarelli.codechella.domain.valueObject;

public class Address {

    private String postalCode;
    private Integer number;
    private String complement;

    public Address() {}

    public Address(String postalCode, Integer number, String complement) {
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
