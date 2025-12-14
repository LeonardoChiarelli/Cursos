package br.com.LeoChiarelli.reflection;

import br.com.LeoChiarelli.Endereco;
import br.com.LeoChiarelli.Pessoa;
import br.com.LeoChiarelli.PessoaDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class TransformerTest {

    Pessoa pessoa = new Pessoa(1L, "Leonardo", "11111111111");
    Pessoa pessoaCampoVazio = new Pessoa(1L, "Leonardo");
    Endereco endereco = new Endereco("Rua", 12);

    @Test
    @DisplayName("Deveria transformar")
    void transformCenario1() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // ARRANGE
        Transformer transformer = new Transformer();
        PessoaDTO pessoaDTO = transformer.transform(pessoa);

        // ASSERT
        assertInstanceOf(PessoaDTO.class, pessoaDTO);
        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    @DisplayName("Não deveria transformar")
    void transformCenario2(){

        // ASSERT + ARRANGE
        assertThrows(ClassNotFoundException.class, () -> {
            Transformer transformer = new Transformer();
            transformer.transform(endereco);
        });
    }

    @Test
    @DisplayName("Deveria transformar quando alguns campos estão vazios")
    void transformCenario3() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // ARRANGE
        Transformer transformer = new Transformer();
        PessoaDTO pessoaDTO = transformer.transform(pessoaCampoVazio);

        // ASSERT
        assertInstanceOf(PessoaDTO.class, pessoaDTO);
        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertNull(pessoaCampoVazio.getCpf());
    }
}