package com.matheushdas.javabank.controller;

import com.matheushdas.javabank.dto.CreateWalletDTO;
import com.matheushdas.javabank.dto.WalletResponseDTO;
import com.matheushdas.javabank.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<?> createWallet(@RequestBody CreateWalletDTO wallet) {
        WalletResponseDTO response = service.create(wallet);
        return ResponseEntity.created(URI.create("/wallet/" + response.id().toString())).build();
    }
}
