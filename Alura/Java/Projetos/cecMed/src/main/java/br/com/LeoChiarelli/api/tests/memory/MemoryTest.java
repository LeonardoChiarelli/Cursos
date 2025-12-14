package br.com.LeoChiarelli.api.tests.memory;

import br.com.LeoChiarelli.api.domain.models.Appointment;

import java.util.ArrayList;
import java.util.List;

public class MemoryTest {
    public static void main(String[] args) {
        List<Appointment> consultas = new ArrayList<>();

        var consulta = new Appointment();
        for (int i = 0; i < 1000000000; i++) {
            consultas.add(consulta);
        }
    }
}
