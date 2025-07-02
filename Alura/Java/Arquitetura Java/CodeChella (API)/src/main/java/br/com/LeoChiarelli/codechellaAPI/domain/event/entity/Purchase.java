package br.com.LeoChiarelli.codechellaAPI.domain.event.entity;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.User;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public Purchase() {}

    public Purchase(User user, PaymentMethod paymentMethod) {
        this.date = LocalDateTime.now();
        this.user = user;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public PaymentMethod getFormaDePagamento() {
        return paymentMethod;
    }

}
