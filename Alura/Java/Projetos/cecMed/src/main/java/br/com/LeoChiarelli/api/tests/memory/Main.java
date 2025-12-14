package br.com.LeoChiarelli.api.tests.memory;

import br.com.LeoChiarelli.api.domain.models.Patient;

public class Main {
    public static void main(String[] args){
        var paciente = new Patient();
        System.out.println(paciente);

        var paciente2 = new Patient();
        System.out.println(paciente == paciente2);

        paciente2 = paciente;
        System.out.println(paciente == paciente2);


    }
}
