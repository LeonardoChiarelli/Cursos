package br.com.LeoChiarelli.api.tests.memory;

import br.com.LeoChiarelli.api.domain.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.http.HttpClient;

public class JVMTest {
    public static void main(String[] args){
        System.out.println(Patient.class.getClassLoader());// carregador de classes da JVM (Class Loader)
        System.out.println(JpaRepository.class.getClassLoader()); // classe do próprio Spring
        System.out.println(HttpClient.class.getClassLoader()); // classe de biblioteca externa
        System.out.println(String.class.getClassLoader()); // classe do próprio Java (retorna null)
    }
}
