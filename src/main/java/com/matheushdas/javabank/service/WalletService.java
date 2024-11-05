package com.matheushdas.javabank.service;

import com.matheushdas.javabank.repository.WalletRepository;
import com.matheushdas.javabank.dto.CreateWalletDTO;
import com.matheushdas.javabank.dto.WalletResponseDTO;
import com.matheushdas.javabank.mapper.WalletMapper;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository repository;
    private final WalletMapper mapper;

    public WalletService(WalletRepository repository, WalletMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public WalletResponseDTO create(CreateWalletDTO wallet) {
        return mapper.toResponseDTO(
                repository.save(
                        mapper.toCreateEntity(wallet)));
    }
}
