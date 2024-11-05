package com.matheushdas.javabank.mapper;

import com.matheushdas.javabank.dto.CreateWalletDTO;
import com.matheushdas.javabank.dto.WalletResponseDTO;
import com.matheushdas.javabank.entity.Wallet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WalletMapper {

    public WalletResponseDTO toResponseDTO(Wallet data) {
        return new WalletResponseDTO(
                data.getId(),
                data.getCpf(),
                data.getEmail(),
                data.getName(),
                data.getBalance()
        );
    }

    public Wallet toCreateEntity(CreateWalletDTO data) {
        return new Wallet(
                data.cpf(),
                data.email(),
                data.name(),
                BigDecimal.ZERO
        );
    }
}
