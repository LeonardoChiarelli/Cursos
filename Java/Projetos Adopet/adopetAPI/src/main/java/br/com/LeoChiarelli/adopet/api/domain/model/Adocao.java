package br.com.LeoChiarelli.adopet.api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Adocao")
@Table(name = "adocoes")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutor tutor;

    @OneToOne(fetch = FetchType.LAZY)
    private Pet pet;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private StatusAdocao status;

    private String justificativaStatus;

    public Adocao(Pet pet, Tutor tutor, @NotBlank String motivo) {
        this.data = LocalDateTime.now();
        this.status = StatusAdocao.AGUARDANDO_AVALIACAO;
        this.pet = pet;
        this.tutor = tutor;
        this.motivo = motivo;
    }

    public Adocao(Tutor tutor, StatusAdocao statusAdocao) {
        this.tutor = tutor;
        this.status = statusAdocao;
    }

    public Adocao(){}

    public void mudarStatusAprovado() {
        this.status = StatusAdocao.APROVADO;
    }

    public void mudarStatusReprovado() {
        this.status = StatusAdocao.REPROVADO;
    }

    public void receberJustificativa(@NotBlank String justificativa) {
        this.justificativaStatus = justificativa;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Pet getPet() {
        return pet;
    }

    public String getMotivo() {
        return motivo;
    }

    public StatusAdocao getStatus() {
        return status;
    }

    public String getJustificativaStatus() {
        return justificativaStatus;
    }
}
