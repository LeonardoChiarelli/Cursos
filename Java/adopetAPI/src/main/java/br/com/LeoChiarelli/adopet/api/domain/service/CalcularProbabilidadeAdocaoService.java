package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.model.ProbabilidadeAdocao;
import br.com.LeoChiarelli.adopet.api.domain.model.TipoPet;
import org.springframework.stereotype.Service;

@Service
public class CalcularProbabilidadeAdocaoService {

    public ProbabilidadeAdocao calcular(Pet pet) {
        int nota = calcularNota(pet);

        if (nota >= 8) { return ProbabilidadeAdocao.ALTA; }
        if (nota >= 5) { return ProbabilidadeAdocao.MEDIA; }
        return ProbabilidadeAdocao.BAIXA;
    }

    private int calcularNota(Pet pet){
        var peso = pet.getPeso().intValue();
        var idade = pet.getIdade();
        var tipo = pet.getTipo();

        int nota = 10;

        //penalizando pelo peso muito alto
        if(tipo == TipoPet.CACHORRO && peso >= 15) { nota -= 2; }
        if(tipo == TipoPet.GATO && peso >= 10) { nota -= 2; }

        // penalizando pela idade avançada
        if(idade >= 15) { nota -= 5; }
        if(idade < 15 && idade >= 10) { nota -= 4; }

        return nota;
    }
}
