package com.matheushdas.javabank.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record WalletResponseDTO(UUID id, String cpf, String email, String name, BigDecimal balance) {
}
