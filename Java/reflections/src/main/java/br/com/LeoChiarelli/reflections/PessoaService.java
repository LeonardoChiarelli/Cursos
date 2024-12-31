package br.com.LeoChiarelli.reflections;

import br.com.LeoChiarelli.reflections.refl.Transformer;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {
    public PessoaDTO listar() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        var pessoa = new PessoaRepository().listar();

        return new Transformer().transform(pessoa); // Retornando uma PessoaDTO
    }
}
