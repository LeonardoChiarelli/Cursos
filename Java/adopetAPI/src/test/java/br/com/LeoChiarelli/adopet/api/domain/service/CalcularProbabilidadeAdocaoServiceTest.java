package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarAbrigoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarPetDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.model.ProbabilidadeAdocao;
import br.com.LeoChiarelli.adopet.api.domain.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcularProbabilidadeAdocaoServiceTest {
    private Abrigo abrigo = new Abrigo(new CadastrarAbrigoDTO(
            3L,
            "Abrigo Feliz",
            "1194444-4444",
            "abrigofeliz@gmail.com"
    ));

    private CalcularProbabilidadeAdocaoService calculadora = new CalcularProbabilidadeAdocaoService();

    @Test
    @DisplayName("[CACHORRO] Deve devolver Probabilidade ALTA - Idade baixa - Peso baixo")
    void calcularCenario1() {
        // idade 4 anos, peso 4kg


        // PADRÃO TRIPLE A

        // ARRANGE
        var pet = new Pet(new CadastrarPetDTO(
                TipoPet.CACHORRO,
                "Carlos",
                "Pitbull",
                4,
                "Cinza",
                4.0f
        ), abrigo);

        // ACT
        var probabilidade = calculadora.calcular(pet);

        // ASSERT
        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    @DisplayName("[CACHORRO] Deve devolver Probabilidade MÉDIA - Idade alta - Peso baixo")
    void calcularCenario2() {
        // idade 15 anos, peso 4kg

        var pet = new Pet(new CadastrarPetDTO(
                TipoPet.CACHORRO,
                "Antonio",
                "Pastor Alemão",
                15,
                "Preto",
                4.0f
        ), abrigo);

        var probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }

    @Test
    @DisplayName("[CACHORRO] Deve devolver Probabilidade BAIXA - Idade alta - Peso alto")
    void calcularCenario3() {
        // idade 15 anos, peso 15kg

        var pet = new Pet(new CadastrarPetDTO(
                TipoPet.CACHORRO,
                "Manuel",
                "Labrador",
                15,
                "Chocolate",
                15.0f
        ), abrigo);

        var probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.BAIXA, probabilidade);
    }

    @Test
    @DisplayName("[GATO] Deve devolver Probabilidade ALTA - Idade baixa - Peso baixo")
    void calcularCenario4() {
        // idade 4 anos, peso 4kg

        var pet = new Pet(new CadastrarPetDTO(
                TipoPet.GATO,
                "José",
                "Siamês",
                4,
                "Cinza",
                4.0f
        ), abrigo);

        var probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    @DisplayName("[GATO] Deve devolver Probabilidade MÉDIA - Idade alta - Peso baixo")
    void calcularCenario5() {
        // idade 10 anos, peso 4kg

        var pet = new Pet(new CadastrarPetDTO(
                TipoPet.GATO,
                "Faustão",
                "Maine Coon",
                10,
                "Branco",
                4.0f
        ), abrigo);

        var probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }

    @Test
    @DisplayName("[GATO] Deve devolver Probabilidade BAIXA - Idade alta - Peso alto")
    void calcularCenario6() {
        // idade 10 anos, peso 11kg

        var pet = new Pet(new CadastrarPetDTO(
                TipoPet.GATO,
                "Buda",
                "Sphynx",
                10,
                "Rosado",
                11.0f
        ), abrigo);


        var probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.BAIXA, probabilidade);
    }

}