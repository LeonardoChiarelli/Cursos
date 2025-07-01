package br.com.LeoChiarelli.codechellaDDD.domain.ticket;

import br.com.LeoChiarelli.codechellaDDD.application.ValidationException;

public class Ticket {

    private final Integer code;
    private final Type type;

    private Ticket(int code, Type type) {
        if (code == 0 || type == null) { throw new ValidationException("All core ticket must be provided"); }
        this.code = code;
        this.type = type;
    }

    public static TicketBuilder builder() {
        return new TicketBuilder();
    }

    public int getCode() {
        return code;
    }

    public Type getType() {
        return type;
    }

    public static class TicketBuilder {
        private int code;
        private Type type;

        public TicketBuilder() {}

        public TicketBuilder withCode(Integer code) {
            this.code = code;
            return this;
        }

        public TicketBuilder withType(Type type) {
            this.type = type;
            return this;
        }

        public Ticket build() {
            if (code == 0) { throw new ValidationException("Ticket code must not be 0."); }
            if (type == null) { throw new ValidationException("Ticket type must not be null."); }

            return new Ticket(code, type);
        }
    }

}
