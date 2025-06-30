package br.com.LeoChiarelli.codechellaDDD.domain.ticket;

public class Ticket {

    private int code;
    private Type type;

    public Ticket() {}

    public Ticket(int code, Type type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
