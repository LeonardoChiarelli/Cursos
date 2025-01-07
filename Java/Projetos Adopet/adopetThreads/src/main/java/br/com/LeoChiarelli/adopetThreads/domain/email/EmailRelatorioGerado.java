package br.com.LeoChiarelli.adopetThreads.domain.email;

import br.com.LeoChiarelli.adopetThreads.domain.dto.RelatorioEstoque;
import br.com.LeoChiarelli.adopetThreads.domain.dto.RelatorioFaturamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailRelatorioGerado {

    @Autowired
    private EnviadorEmail enviador;

    public void enviar(RelatorioEstoque estoque, RelatorioFaturamento faturamento){
        enviador.enviarEmail(
                "Relatórios Diários Gerados",
                "admin@email.com",
                """
                        Olá!
                        
                        Seus relatórios foram gerados e seguem abaixo:
                        
                        %s
                        
                        %s
                        """.formatted(estoque, faturamento)
        );
    }
}
