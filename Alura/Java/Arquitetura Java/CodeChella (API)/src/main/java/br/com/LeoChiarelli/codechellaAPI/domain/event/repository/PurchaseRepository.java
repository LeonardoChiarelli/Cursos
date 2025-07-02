package br.com.LeoChiarelli.codechellaAPI.domain.event.repository;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.User;
import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByUser(User user);

}
