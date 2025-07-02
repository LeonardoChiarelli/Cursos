package br.com.LeoChiarelli.codechellaAPI.controller;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.User;
import br.com.LeoChiarelli.codechellaAPI.domain.event.service.PurchaseService;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.PurchaseDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.RegistryPurchaseDataDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDataDTO>> listMyPurchases(@AuthenticationPrincipal User user) {
        var purchases = service.listMyPurchases(user);
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDataDTO> detail(@PathVariable Long id) {
        var purchase = service.detail(id);
        return ResponseEntity.ok(purchase);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PurchaseDataDTO> makePurchase(@RequestBody @Valid RegistryPurchaseDataDTO dto, @AuthenticationPrincipal User user, UriComponentsBuilder uriBuilder) {
        var purchaseData = service.makePurchase(dto, user);
        var uri = uriBuilder.path("/purchases/{id}").buildAndExpand(purchaseData.id()).toUri();
        return ResponseEntity.created(uri).body(purchaseData);
    }

}
