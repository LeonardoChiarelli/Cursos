package br.com.LeoChiarelli.codechella.infrastructure.persistence.ticket;

import br.com.LeoChiarelli.codechella.infrastructure.persistence.sale.SaleEntity;
import com.fasterxml.jackson.annotation.
        JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int code;

    @ManyToOne
    private TypeEntity type;

    @ManyToOne
    @JsonIgnore
    private SaleEntity sales;

    public TicketEntity() {}

    public TicketEntity(int code, TypeEntity type) {
        this.code = code;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity typeEntity) {
        this.type = typeEntity;
    }

    public SaleEntity getSale() {
        return sales;
    }

    public void setSale(SaleEntity saleEntity) {
        this.sales = saleEntity;
    }
}
