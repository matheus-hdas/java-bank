package com.matheushdas.javabank.service;

import com.matheushdas.javabank.entity.Wallet;
import com.matheushdas.javabank.exception.WalletDataAlreadyExistsException;
import com.matheushdas.javabank.repository.WalletRepository;
import com.matheushdas.javabank.dto.CreateWalletDTO;
import com.matheushdas.javabank.dto.WalletResponseDTO;
import com.matheushdas.javabank.mapper.WalletMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {
    private final WalletRepository repository;
    private final WalletMapper mapper;

    public WalletService(WalletRepository repository, WalletMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public WalletResponseDTO create(CreateWalletDTO wallet) {

        Optional<Wallet> anyWallet = repository.findByCpfOrEmail(wallet.cpf(), wallet.email());

        if(anyWallet.isPresent()) {
            throw new WalletDataAlreadyExistsException("Cpf or Email already exists on  our database!");
        }

        return mapper.toResponseDTO(
                repository.save(
                        mapper.toCreateEntity(wallet)));
    }
}
