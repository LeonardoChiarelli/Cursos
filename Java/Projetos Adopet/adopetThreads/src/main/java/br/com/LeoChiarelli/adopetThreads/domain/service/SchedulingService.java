package br.com.LeoChiarelli.adopetThreads.domain.service;

import br.com.LeoChiarelli.adopetThreads.domain.email.EmailRelatorioGerado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class SchedulingService {

    @Autowired
    private RelatorioService service;

    @Autowired
    private EmailRelatorioGerado relatorio;

    @Scheduled(cron = "0 40 0 * * *") // segundo ; minuto ; hora ; dia ; mês ; ano // * - sem dados específicos
    public void emailsAgendados(){

        var estoqueZerado = service.infoEstoque();
        var faturamento = service.faturamentoObtido();

        try {
            relatorio.enviar(estoqueZerado.get(), faturamento.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("""
                Thread do agendamento:
                %s
                """, Thread.currentThread().getName());
    }
}
